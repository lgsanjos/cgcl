package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoArgumentList extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "(" [ <expressionList> ] ")"		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("argumentList");
		boolean isValida;
		
		isValida = false;
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("(", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			
			this.descartaIndiceSalvo();
			this.salvarIndiceTokenAtual();
			
			ArvoreSintaticaAbstrataNo expressionList;
			expressionList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expressionList);
			if (expressionList != null) {
				raiz.adicionaNoFilho(expressionList);
				this.descartaIndiceSalvo();
			} else {
				this.recuperarIndiceSalvo();
			}
			
			this.salvarIndiceTokenAtual();
			if (this.proximoTokenPossuiValorETipoIgualA(")", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
				
				this.descartaIndiceSalvo();
				isValida = true;
			}
			
			
		}
		
		if (! isValida) {
			this.recuperarIndiceSalvo();
			// disparar excecao
			return null;
		}
		 
		return raiz;
	}

}
