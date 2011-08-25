package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanOperator extends RegrasProducaoAbstract {

	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "&" | "|"
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanOperator");
		String[] sinais = { "&", "|" };
		
		this.salvarIndiceTokenAtual();
		this.avancaProximoToken();
		
		if (this.getTokenAtual() != null) {
			
			for (int i = 0; i < sinais.length; i++) {
				if (this.getTokenAtual().getValue() == sinais[i]) {
					raiz.adicionaNoFilho(this.getTokenAtual());
					this.descartaIndiceSalvo();
					return raiz;					
				}
			}
		}

		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("booleanOperator");
		return null;
	}


}
