package analise.lexica;


import java.util.LinkedList;


import analise.TabelaDeSimbolos;
import analise.exceptions.EndOfBufferException;
import analise.exceptions.InvalidTokenException;
import coretypes.*;
import coretypes.gcl.GCLTokenTypes;

public class AnaliseLexica {

	private AnaliseLexicaRules rules;
	private CodigoFonteParser parser;
	private LinkedList<GCLTokenTypes> ignoreTokenClasses;

	public AnaliseLexica(String codigoFonte) {
		this.rules = new AnaliseLexicaRules();
		this.parser = new CodigoFonteParser(codigoFonte);
		this.ignoreTokenClasses = new LinkedList<GCLTokenTypes>();

	}

	private void adicionaTabelaDeSimbolos(Token token) {
		TabelaDeSimbolos.getInstance().add(token);
	}

	
	private Token getNextValidToken() throws InvalidTokenException, EndOfBufferException {
		String buffer = "";
		String lastChar;
		Token token;

		try {
			do {
				lastChar = "";
				lastChar += this.parser.getNextChar();
				buffer += lastChar;
			} while (this.rules.validaLexema(buffer));
			
			buffer = buffer.substring(0, buffer.length() - 1);
			
			if (buffer.length() == 0) {
				throw new InvalidTokenException("Não foi possível reconhecer o token: " + buffer);
			}
			
			this.parser.getLastChar();
			
		} catch (EndOfBufferException e) {
			if (buffer.length() == 0) {
				throw e;
			}
		}
			
		token = this.rules.buildToken(buffer, this.parser.getLastPosicao());
		this.adicionaTabelaDeSimbolos(token);
		return token;
	}

	public void addTokenClassException(GCLTokenTypes tokenClass) {
		this.ignoreTokenClasses.add(tokenClass);
	}

	public void remTokenClassException(GCLTokenTypes tokenClass) {
		this.ignoreTokenClasses.remove(tokenClass);
	}

	public boolean validaLexema(String lexema) {
		return this.rules.validaLexema(lexema);
	}

	public Token buildToken(String lexema) throws InvalidTokenException {
		return this.rules.buildToken(lexema, "");
	}

	public Token buildToken(String lexema, String posicao) throws InvalidTokenException {
		return this.rules.buildToken(lexema, posicao);
	}

	public Token getNextToken() throws InvalidTokenException {
		Token token;
		boolean condicao;

		try {
			do {
		      token = this.getNextValidToken();
			  condicao = this.ignoreTokenClasses.contains(token.getTokenType());
		  } while (condicao);
		} catch (EndOfBufferException e) {
			return null;
		}
		
		return token;
	}

}
