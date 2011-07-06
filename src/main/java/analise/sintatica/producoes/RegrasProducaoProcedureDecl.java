package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoProcedureDecl extends RegrasProducaoAbstract {

	private static RegrasProducaoProcedureDecl instancia = new RegrasProducaoProcedureDecl();

	public static RegrasProducaoProcedureDecl getInstancia() {
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
