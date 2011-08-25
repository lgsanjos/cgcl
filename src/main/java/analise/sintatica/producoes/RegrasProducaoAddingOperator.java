package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoAddingOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "+" | "-"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("addingOperator");
		String[] sinais = { "+", "-"};		
		
		this.salvarIndiceTokenAtual();
		this.avancaProximoToken();
		
		if (this.getTokenAtual() != null) {
			for (int i = 0; i < sinais.length; i++) {
				if (this.getTokenAtual().getValue() == sinais[i]) {
					this.descartaIndiceSalvo();
					raiz.adicionaNoFilho(this.getTokenAtual());
					return raiz;
				}
			}
		}	
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("addingOperator");
		return null;
	}

}
