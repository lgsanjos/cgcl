package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoVariableDef extends RegrasProducaoAbstract {

	private static RegrasProducaoVariableDef instancia = new RegrasProducaoVariableDef();

	public static RegrasProducaoVariableDef getInstancia() {
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
