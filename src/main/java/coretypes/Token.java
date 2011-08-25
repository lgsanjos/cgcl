package coretypes;

import coretypes.gcl.GCLTokenTypes;


public class Token {

	private GCLTokenTypes tokenType;
	private String value;
	private String posicao;

	public GCLTokenTypes getTokenType() {
		return tokenType;
	}

	public void setTokenType(GCLTokenTypes type) {
		this.tokenType = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPosicao() {
		return posicao;
	}
	
	public String getPosicaoLinha() {
		if (this.posicao.indexOf("x") > 0) {
			//return this.posicao.substring(0, this.posicao.indexOf("x"));
		}
		
		return "";
	}
	
	public String getPosicaoColuna() {
		if (this.posicao.indexOf("x") > 0) {
			//return this.posicao.substring(this.posicao.indexOf("x"), 0);
		}
	
		return "";		
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Token() {

	}

	public Token(GCLTokenTypes tokenType, String posicao, String valorString) {
		this.tokenType = tokenType;
		this.posicao = posicao;
		this.value = valorString;
	}

	public Token(GCLTokenTypes type, String valorString) {
		this.setTokenType(type);
		this.value = valorString;
		this.posicao = "";
	}
	
	public boolean equals(Token token) {
		boolean res = true;
		res = res && (this.getValue() == token.getValue());
		res = res && (this.getTokenType() == token.getTokenType());
		return res;
	}

}
