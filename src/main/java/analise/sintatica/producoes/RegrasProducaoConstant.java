package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <expression>
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constant");
		
		try {
			this.salvarIndiceTokenAtual();
			ArvoreSintaticaAbstrataNo expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
			raiz.adicionaNoFilho(expression);
			this.descartaIndiceSalvo();
			return raiz;
		} catch (ProducaoSintaticaException e) {
			
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("constant");
		return null;
	}

}
