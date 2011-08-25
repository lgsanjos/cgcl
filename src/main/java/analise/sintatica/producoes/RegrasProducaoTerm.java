package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTerm extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <factor> {<multiplyOperator> <factor>}
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("term");
		ArvoreSintaticaAbstrataNo factor = null;
		
		this.salvarIndiceTokenAtual();
		try {
			factor = this.validaEGeraProducaoDadoProducao(ProducoesEnum.factor);
			raiz.adicionaNoFilho(factor);
			this.descartaIndiceSalvo();			
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("term");
		}
			
		boolean isValida;
		do {
			isValida = false;
			
			try {
				this.salvarIndiceTokenAtual();
				ArvoreSintaticaAbstrataNo mult = this.validaEGeraProducaoDadoProducao(ProducoesEnum.multiplyOperator);
				ArvoreSintaticaAbstrataNo novoFactor = this.validaEGeraProducaoDadoProducao(ProducoesEnum.factor);
				raiz.adicionaNoFilho(mult);
				raiz.adicionaNoFilho(novoFactor);
				this.descartaIndiceSalvo();
				isValida = true;					
			} catch (ProducaoSintaticaException e) {
				this.recuperarIndiceSalvo();				
			}
			
			
		} while (isValida);
		
		return raiz;
	}

}
