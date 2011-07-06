package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoConstantName extends RegrasProducaoAbstract {

	private static RegrasProducaoConstantName instancia = new RegrasProducaoConstantName();
	
	public static RegrasProducaoConstantName getInstancia() {
		return instancia;
	}
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		// "identifier"
		boolean isValida = true;
		isValida = this.isIdentifierToken(pilhaDeToken, apartirDe);
		return isValida;
	}

}
