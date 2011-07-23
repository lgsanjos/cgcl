package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import utils.GCLTokenTypes;
import coretypes.Token;
import coretypes.TokenList;

public abstract class RegrasProducaoAbstract {
	
	private TokenList pilhaDeToken;
	private int indiceSalvo = -1;
	
	protected boolean proximoTokenEhUmIdentificador() {
		return isTokenType(this.getPilhaDeToken(), GCLTokenTypes.IDENTIFIER);
	}
	
	protected boolean proximoTokenEhUmNumero() {
		return isTokenType(this.getPilhaDeToken(), GCLTokenTypes.NUMBER);
	}	
	
	protected void salvarIndice() {
		if (this.indiceSalvo != -1) {
			throw new RuntimeException("Não se pode salvar o estado duas vezes seguidas.");
		}
		this.indiceSalvo = this.pilhaDeToken.getIndice();
	}
	
	protected void recuperarIndice() {
		this.pilhaDeToken.setIndice(this.indiceSalvo);
		this.indiceSalvo = -1;
	}
	
	private boolean isTokenType(TokenList pilhaDeToken, GCLTokenTypes tipo) {
		Token tokenIndice = this.pilhaDeToken.getProximoToken();
		if (tokenIndice == null) {
			return false;
		}	

		return tokenIndice.getTokenType().equals(tipo);
	}
	
	protected boolean proximoTokenPossuiValorETipoIgualA(String compareLexema, GCLTokenTypes compareType ) {
		
		Token tokenIndice = pilhaDeToken.getProximoToken();
		if (tokenIndice == null) {
			return false;
		}
		
		return (tokenIndice.getValue().equalsIgnoreCase(compareLexema)) &&
			   (tokenIndice.getTokenType().equals(compareType));
	}

	protected boolean proximoTokenPossuiValorIgualA(String compareLexema) {

		Token token = pilhaDeToken.getProximoToken();
		if (token == null) {
			return false;
		}
		return token.getValue().equalsIgnoreCase(compareLexema);
	}
	
	protected Token getTokenAtual() {
		 return pilhaDeToken.getTokenAtual();
	}
	
	protected void avancaProximoToken() {
		this.pilhaDeToken.avancaToken();
	}
	
	protected void voltaToken() {
		this.pilhaDeToken.retornaToken();
	}	

	public abstract ArvoreSintaticaAbstrataNo validaEGeraProducao();
	
	public TokenList getPilhaDeToken(){
		return this.pilhaDeToken;
	}
	
	public void setPilhaDeToken(TokenList tokens){
		this.pilhaDeToken = tokens;
	}	
	
}
