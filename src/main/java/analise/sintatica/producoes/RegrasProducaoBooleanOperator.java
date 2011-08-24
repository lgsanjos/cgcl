package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanOperator extends RegrasProducaoAbstract {

	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "&" | "|"
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanOperator");
		
		this.salvarIndiceTokenAtual();

		if (this.proximoTokenPossuiValorETipoIgualA("&", GCLTokenTypes.SYMBOL)) {

			if (this.proximoTokenPossuiValorETipoIgualA("|", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho("booleanOperator", this.getTokenAtual());
				this.descartaIndiceSalvo();
				return raiz;
			}
		}
			
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("booleanOperator");
		return null;
	}


}
