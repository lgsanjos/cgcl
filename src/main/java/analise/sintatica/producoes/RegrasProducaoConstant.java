package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoConstant extends RegrasProducaoAbstract {

	private static RegrasProducaoConstant instancia = new RegrasProducaoConstant();

	public static RegrasProducaoConstant getInstancia() {
		return instancia;
	}

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean isValida = true;
		isValida = this.isIdentifierToken(pilhaDeToken, apartirDe);
		return isValida;
	}

}
