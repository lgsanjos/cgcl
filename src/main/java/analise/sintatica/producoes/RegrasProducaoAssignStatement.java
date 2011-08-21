package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoAssignStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		//<variableAccessList> ":=" <expressionList>  
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("assignStatement");
		
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo variableAccess;	
		variableAccess = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableAccessList);
		if (variableAccess != null){
			raiz.adicionaNoFilho(variableAccess);
			
			if (this.proximoTokenPossuiValorETipoIgualA(":=", GCLTokenTypes.SYMBOL)){
				raiz.adicionaNoFilho(":=", this.getTokenAtual());
				ArvoreSintaticaAbstrataNo expressionList;
				expressionList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expressionList);
				
				if (expressionList != null){
					raiz.adicionaNoFilho(expressionList);
					this.descartaIndiceSalvo();
					return raiz;
				}
			}
		}
			
		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
