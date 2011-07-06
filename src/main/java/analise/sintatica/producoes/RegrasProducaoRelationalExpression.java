package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoRelationalExpression extends RegrasProducaoAbstract {

	private static RegrasProducaoRelationalExpression instancia = new RegrasProducaoRelationalExpression();
	
	public static RegrasProducaoRelationalExpression getInstancia() {
		return instancia;
	}	
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		return true;
	}
	

}
