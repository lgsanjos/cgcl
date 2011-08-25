package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoFactor extends RegrasProducaoAbstract {

	private ArvoreSintaticaAbstrataNo checkVariableAccess() throws ProducaoSintaticaException {
		
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("factor");
		
		ArvoreSintaticaAbstrataNo varAccess;
		try{
			varAccess = ProducoesFactory.getProducao(ProducoesEnum.variableAccess).validaEGeraProducao();
			raiz.adicionaNoFilho(varAccess);
			return raiz;
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}	
		return null;
	}
	
	private ArvoreSintaticaAbstrataNo checkNumber() {

		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("factor");
		
		if ( this.proximoTokenEhUmNumero() ) {
			raiz.adicionaNoFilho("number", this.getTokenAtual());
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		return null;
	}
	
	private ArvoreSintaticaAbstrataNo checkBooleanConstant() throws ProducaoSintaticaException {
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("factor");
		
		ArvoreSintaticaAbstrataNo booleanConstant;
		try {
			booleanConstant = ProducoesFactory.getProducao(ProducoesEnum.booleanConstant).validaEGeraProducao();
			raiz.adicionaNoFilho(booleanConstant);
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}	
		return null;
	}
	
	private ArvoreSintaticaAbstrataNo checkExpressionList() throws ProducaoSintaticaException {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("factor");
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho("[", this.getTokenAtual());
			
			try {
				ArvoreSintaticaAbstrataNo expressionList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expressionList);
				raiz.adicionaNoFilho(expressionList);
				
				if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho("]", this.getTokenAtual());
					this.descartaIndiceSalvo();
					return raiz;
				}				
			} catch (ProducaoSintaticaException e) {
				//
			}

		}
			
		this.recuperarIndiceSalvo();
		return null;		
	}
	
	private ArvoreSintaticaAbstrataNo checkExpression() throws ProducaoSintaticaException {

		this.salvarIndiceTokenAtual(); 
		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("factor");
		
		if (this.proximoTokenPossuiValorETipoIgualA("(", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho("(", this.getTokenAtual());
			
			try {
				ArvoreSintaticaAbstrataNo expression = ProducoesFactory.getProducao(ProducoesEnum.expression).validaEGeraProducao();
				raiz.adicionaNoFilho(expression);
				if (this.proximoTokenPossuiValorETipoIgualA(")", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho(")", this.getTokenAtual());
					return raiz;
				}				
			} catch (ProducaoSintaticaException e) {
				//
			}

		}
			
		this.recuperarIndiceSalvo();
		return null;		
	}
	
	private ArvoreSintaticaAbstrataNo checkTilFactor() throws ProducaoSintaticaException {
		this.salvarIndiceTokenAtual(); 
		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("factor");
		
		if (this.proximoTokenPossuiValorETipoIgualA("~", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho("~", this.getTokenAtual());
			
			try {
				ArvoreSintaticaAbstrataNo factor = ProducoesFactory.getProducao(ProducoesEnum.factor).validaEGeraProducao();
				raiz.adicionaNoFilho(factor);
				return raiz;
			} catch (ProducaoSintaticaException e) {
				//
			}

		}
			
		this.recuperarIndiceSalvo();
		return null;		
	}
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {

		ArvoreSintaticaAbstrataNo raiz;
		
		// <variableAccess>
		raiz = this.checkVariableAccess(); 
		if ( raiz != null) {
			return raiz;
		}
			
		// Number
		raiz = this.checkNumber(); 
		if ( raiz != null) {
			return raiz;
		}		

		// <booleanConstant>
		raiz = this.checkBooleanConstant(); 
		if ( raiz != null) {
			return raiz;
		}
		
		// "[" <expressionList> "]"
		raiz = this.checkExpressionList(); 
		if ( raiz != null) {
			return raiz;
		}
		
		// "(" <expression> ")"
		raiz = this.checkExpression(); 
		if ( raiz != null) {
			return raiz;
		}
		
		// "~" <factor>
		raiz = this.checkTilFactor(); 
		if ( raiz != null) {
			return raiz;
		}

		this.throwProducaoSintaticaException("factor");
		return null;
	}

}
