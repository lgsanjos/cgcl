package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoExpression extends RegrasProducaoAbstract {

	private static RegrasProducaoDefinitionPart instancia = new RegrasProducaoDefinitionPart();

	public static RegrasProducaoDefinitionPart getInstancia() {
		return instancia;
	}
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		// <relationalExpression> {<booleanOperator> <relationalExpression> }
		boolean isValida = true;
		boolean possuiOperador = true;
		boolean possuiExpressao = true;
		
		isValida &= RegrasProducaoRelationalExpression.getInstancia().isValida(pilhaDeToken, apartirDe);
		
		if (isValida){
			do {
				possuiOperador = RegrasProducaoBooleanOperator.getInstancia().isValida(pilhaDeToken, apartirDe);
				
				if (possuiOperador) {
					possuiExpressao = RegrasProducaoBooleanOperator.getInstancia().isValida(pilhaDeToken, apartirDe);
				}
				
			} while (possuiOperador);
		}
		
		isValida &= ( possuiOperador && (possuiExpressao == false) );
		return isValida;
	}

}
