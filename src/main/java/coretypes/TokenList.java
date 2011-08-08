package coretypes;


import java.util.LinkedList;

import utils.Clonavel;

import coretypes.gcl.GCLTokenTypes;

public class TokenList implements Clonavel {

	private static final long serialVersionUID = 1L;

	private GCLTokenTypes tokenType;
	private int indice = -1;
	private LinkedList<Token> lista; 
	
	public TokenList() {
		super();
		lista = new LinkedList<Token>();
	}	

	public GCLTokenTypes getTokenType() {
		return tokenType;
	}

	public void setTokenType(GCLTokenTypes tokenType) {
		this.tokenType = tokenType;
	}
	
	public void setIndice(int valor) {
		this.indice = valor;
	}
	
	public int getIndice() {
		return this.indice;
	}
	
	public void avancaToken() {
		this.indice++;
	}
	
	public void retornaToken() {
		this.indice--;
	}	
	
	public Token getTokenAtual() {
		if (this.indice >= this.size()) {
			return null;
		}
			
		return (Token)this.lista.get(indice);
	}
	
	public Token getProximoToken () {
		this.avancaToken();
		return this.getTokenAtual();
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public Token get(int indice) {
		if (indice >= this.size()) {
			return null;
		}		
		return this.lista.get(indice);
	}
	
	public void add(Token novoToken) {
		this.lista.add(novoToken);
	}
	
	public void clear() {
		this.lista.clear();
	}
	
	public void addLast(Token token) {
		this.lista.addLast(token);
	}
	
	public Token removeLast() {
		return this.lista.removeLast();
	}
	
	public Token removeFirst() {
		return this.lista.removeFirst();
	}	
	
	public boolean estaVazia() {
		return this.lista.isEmpty();
	}	
	
	public boolean possue(Token token) {
		return this.lista.contains(token);
	}
	
	public boolean hasLexema(String lexema) {
		Token buscarToken = new Token();
		buscarToken.setValue(lexema);
		buscarToken.setPosicao("");
		buscarToken.setTokenType(this.tokenType);

		boolean achou = false;
		int i = 0;
		while (!achou && i < this.size()) {
			achou = ((Token) this.lista.get(i)).getValue().equalsIgnoreCase(
					buscarToken.getValue());
			i = i + 1;
		}

		return achou;
	}
	
	public TokenList clone() {
		TokenList list = new TokenList();
		list.setIndice(this.indice);
		
		for (int i = 0; i < this.size(); i++) {
			list.add(this.get(i));
		}
		
		return list;
	}

}
