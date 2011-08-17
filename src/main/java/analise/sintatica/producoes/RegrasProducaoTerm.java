package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTerm extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <factor> {<multiplyOperator> <factor>}
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("term");
		ArvoreSintaticaAbstrataNo factor;
		
		this.salvarIndiceTokenAtual();
		factor = ProducoesFactory.getProducao(ProducoesEnum.factor).validaEGeraProducao();
		
		if (factor == null) {
			this.recuperarIndiceSalvo();
			return null;
		}
		
		raiz.adicionaNoFilho(factor);
		this.descartaIndiceSalvo();
		
		boolean isValida;
		do {
			isValida = false;
			
			ArvoreSintaticaAbstrataNo mult;
			mult = ProducoesFactory.getProducao(ProducoesEnum.multiplyOperator).validaEGeraProducao();
			if (mult != null) {
				ArvoreSintaticaAbstrataNo novoFactor;
				novoFactor = ProducoesFactory.getProducao(ProducoesEnum.factor).validaEGeraProducao();
				if (novoFactor != null) {
					isValida = true;
					raiz.adicionaNoFilho(mult);
					raiz.adicionaNoFilho(novoFactor);
					this.descartaIndiceSalvo();
				} else {
					this.recuperarIndiceSalvo();
				}
			}
			
			
		} while (isValida);
		
		return raiz;
	}

}
