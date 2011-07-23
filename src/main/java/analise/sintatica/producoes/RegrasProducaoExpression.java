package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoExpression extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <relationalExpression> {<booleanOperator> <relationalExpression> }
		boolean isValida = true;
		boolean possuiOperador = true;
		boolean possuiExpressao = true;
		/*
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("expression");
				
		if (isValida) {
			ArvoreSintaticaAbstrataNo relational = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression).validaEGeraProducao();
			isValida &= (relational != null);
			raiz.adicionaNoFilho(relational);
		}
		
		if (isValida){
			do {
				ArvoreSintaticaAbstrataNo booleanOperator = ProducoesFactory.getProducao(ProducoesEnum.booleanOperator).validaEGeraProducao();
				possuiOperador = (booleanOperator != null);
				
				if (possuiOperador) {
					ArvoreSintaticaAbstrataNo relationalExp = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression).validaEGeraProducao();
					possuiExpressao = (relationalExp != null);
					
					if (possuiExpressao) {
						raiz.adicionaNoFilho(booleanOperator);
						raiz.adicionaNoFilho(relationalExp);
					}
				}
				
			} while (possuiOperador);
		}
		
		isValida &= ( possuiOperador && (possuiExpressao == false) ); 
		return (isValida) ? raiz : null;*/
		return new ArvoreSintaticaAbstrataNo("expression");
	}

}
