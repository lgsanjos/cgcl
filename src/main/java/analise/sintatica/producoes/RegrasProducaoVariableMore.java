package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableMore extends RegrasProducaoAbstract {

	private boolean checkCaso1(ArvoreSintaticaAbstrataNo raiz) {

		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			try {
				this.descartaIndiceSalvo();
				this.salvarIndiceTokenAtual();
				ArvoreSintaticaAbstrataNo nextItem = this.validaEGeraProducaoDadoProducao(ProducoesEnum.nextitem);
				raiz.adicionaNoFilho(nextItem);
				
				this.descartaIndiceSalvo();
				this.salvarIndiceTokenAtual();				
				ArvoreSintaticaAbstrataNo indexorcomp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.indexorcomp);
				raiz.adicionaNoFilho(indexorcomp);
				
				this.descartaIndiceSalvo();
				return true;
			} catch (ProducaoSintaticaException e) {
				//
			}
		}
		
		this.recuperarIndiceSalvo();
		return false;
	}
	
	private boolean checkCaso2(ArvoreSintaticaAbstrataNo raiz) {

		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			try {
				this.descartaIndiceSalvo();
				this.salvarIndiceTokenAtual();				
				ArvoreSintaticaAbstrataNo expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
				raiz.adicionaNoFilho(expression);
				
				if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho(this.getTokenAtual());
					
					this.descartaIndiceSalvo();
					this.salvarIndiceTokenAtual();					
					ArvoreSintaticaAbstrataNo indexorcomp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.indexorcomp);
					raiz.adicionaNoFilho(indexorcomp);					
				}
				
				this.descartaIndiceSalvo();
				return true;
			} catch (ProducaoSintaticaException e) {
				//
			}
		}
		
		this.recuperarIndiceSalvo();
		return false;
	}	
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// 	"." <nextitem>  <indexorcomp> | "[" <expression> "]"  <indexorcomp> | ""
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableMore");
		
		if ( this.checkCaso1(raiz)) {
			return raiz;
		}
		
		raiz = null;
		raiz = new ArvoreSintaticaAbstrataNo("variableMore");

		if ( this.checkCaso2(raiz)) {
			return raiz;
		}
		
		raiz = new ArvoreSintaticaAbstrataNo("variableMore");

		return raiz;
	}	
		
}
