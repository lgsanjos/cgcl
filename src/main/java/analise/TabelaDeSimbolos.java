package analise;

import coretypes.Token;
import coretypes.TokenList;

public final class TabelaDeSimbolos {

	private static TabelaDeSimbolos instance = null;
	private TokenList listaSimbolos;

	private TabelaDeSimbolos() {
		this.listaSimbolos = new TokenList();
	}

	public static TabelaDeSimbolos getInstance() {
		if (instance == null) {
			instance = new TabelaDeSimbolos();
		}

		return instance;
	}

	public int add(Token token) {
		this.listaSimbolos.add(token);
		return this.listaSimbolos.size();
	}

	public boolean contains(Token token) {
		return this.listaSimbolos.possue(token);
	}

}
