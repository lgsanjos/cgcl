package analise.sintatica.producoes;

public class RegrasProducaoExpression extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		// <relationalExpression> {<booleanOperator> <relationalExpression> }
		boolean isValida = true;
		boolean possuiOperador = true;
		boolean possuiExpressao = true;
		
		isValida &= ProducoesFactory.getProducao(ProducoesEnum.relationalExpression).isValida();
		
		if (isValida){
			do {
				possuiOperador = ProducoesFactory.getProducao(ProducoesEnum.booleanOperator).isValida();
				
				if (possuiOperador) {
					possuiExpressao = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression).isValida();
				}
				
			} while (possuiOperador);
		}
		
		isValida &= ( possuiOperador && (possuiExpressao == false) );
		return isValida;
	}

}
