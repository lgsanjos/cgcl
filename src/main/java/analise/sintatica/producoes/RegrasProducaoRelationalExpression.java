package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;


public class RegrasProducaoRelationalExpression extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <simpleExpression> [<relationalOperator> <simpleExpression>]
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("relationalExpression");
		
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo simpleExpression;
		simpleExpression = ProducoesFactory.getProducao(ProducoesEnum.simpleExpression).validaEGeraProducao();
		if ( simpleExpression == null) {
			this.recuperarIndiceSalvo();
			return null;
		}
		
		this.descartaIndiceSalvo();
		raiz.adicionaNoFilho(simpleExpression);
		
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo relationalOperator;
		relationalOperator = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator).validaEGeraProducao();
		if (relationalOperator != null) {
			ArvoreSintaticaAbstrataNo novaSimpleExpression;
			novaSimpleExpression = ProducoesFactory.getProducao(ProducoesEnum.simpleExpression).validaEGeraProducao();
			if (novaSimpleExpression != null) {
				raiz.adicionaNoFilho(relationalOperator);
				raiz.adicionaNoFilho(novaSimpleExpression);
				this.descartaIndiceSalvo();
			} else {
				this.recuperarIndiceSalvo();
			}
			
		}
		
		return raiz;
	}
	

}
