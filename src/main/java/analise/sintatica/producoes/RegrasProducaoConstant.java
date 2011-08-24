package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <expression>
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constant");
		
		this.salvarIndiceTokenAtual();

		ArvoreSintaticaAbstrataNo expression;
		expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
		if (expression != null) {
			raiz.adicionaNoFilho(expression);
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("constant");
		return null;
	}

}
