package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoBooleanOperator extends RegrasProducaoAbstract {

	private static RegrasProducaoBooleanOperator instancia = new RegrasProducaoBooleanOperator();

	public static RegrasProducaoBooleanOperator getInstancia() {
		return instancia;
	}
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		return false;
	}

}
