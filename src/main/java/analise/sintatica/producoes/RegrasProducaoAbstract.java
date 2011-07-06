package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.IndiceNumerico;
import coretypes.Token;
import coretypes.TokenList;

public abstract class RegrasProducaoAbstract {

	public static RegrasProducaoAbstract getInstancia() {
		return null;
	}
	
	protected boolean isIdentifierToken(TokenList pilhaDeToken, IndiceNumerico indice) {

		boolean resposta = (pilhaDeToken.size() > indice.getValor())
				&& (pilhaDeToken.get(indice.getValor()).getTokenType()
						.equals(GCLTokenTypes.Identifier));
		indice.inc();
		return resposta;

	}
	
	protected boolean hasTokenWithLexemaAndType(TokenList pilhaDeToken, IndiceNumerico indice,
			String compareLexema, GCLTokenTypes compareType ) {
		
		Token tokenIndice = pilhaDeToken.get(indice.getValor());
		
		boolean resposta = (pilhaDeToken.size() > indice.getValor())
							&& (tokenIndice.getValue().equalsIgnoreCase(compareLexema))
							&& (tokenIndice.getTokenType().equals(compareType));

		indice.inc();		
		return resposta;
		
	}

	protected boolean hasLexema(TokenList pilhaDeToken, IndiceNumerico indice,
			String compareLexema) {

		Token token = pilhaDeToken.get(indice.getValor());
		boolean resposta = (pilhaDeToken.size() > indice.getValor())
							&& (token.getValue().equalsIgnoreCase(compareLexema));
		indice.inc();
		return resposta;
	}

	public abstract boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe);

	public abstract Object geraArvoreSintaticaAbstrata();

}
