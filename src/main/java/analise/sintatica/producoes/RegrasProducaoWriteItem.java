package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoWriteItem extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "stringconst" | <expression> 
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("writeItem");
		
		this.salvarIndiceTokenAtual();
		if (this.proximotokenEhUmaString()) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			this.descartaIndiceSalvo();			
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		
		try {
			ArvoreSintaticaAbstrataNo expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
			this.descartaIndiceSalvo();
			raiz.adicionaNoFilho(expression);
			return raiz;
		} catch(ProducaoSintaticaException e) {
			//
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("writeItem");
		return null;
	}

}
