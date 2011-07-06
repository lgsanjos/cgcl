package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoProcedureDef extends RegrasProducaoAbstract {

	private static RegrasProducaoProcedureDef instancia = new RegrasProducaoProcedureDef();

	public static RegrasProducaoProcedureDef getInstancia() {
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
