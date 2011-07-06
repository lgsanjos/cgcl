package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoTypedef extends RegrasProducaoAbstract {

	private static RegrasProducaoTypedef instancia = new RegrasProducaoTypedef();

	public static RegrasProducaoTypedef getInstancia() {
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
