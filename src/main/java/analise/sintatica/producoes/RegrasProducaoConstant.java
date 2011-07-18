package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <expression>
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constant");
		
		if (isValida) {
			ArvoreSintaticaAbstrataNo expression;
			expression = ProducoesFactory.getProducao(ProducoesEnum.expression).validaEGeraProducao();
			isValida &= (expression != null);
			raiz.adicionaNoFilho(expression);
		}
		
		return (isValida) ? raiz : null;
	}

}
