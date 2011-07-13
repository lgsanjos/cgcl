package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import utils.GCLTokenTypes;
import coretypes.IndiceNumerico;
import coretypes.Token;
import coretypes.TokenList;

public abstract class RegrasProducaoAbstract {
	
	private TokenList pilhaDeToken;
	private IndiceNumerico indice;
	
	protected boolean proximoTokenEhUmIdentificador() {
		return isIdentifierToken(this.getPilhaDeToken(),
				                 this.getIndice());
	}
	private boolean isIdentifierToken(TokenList pilhaDeToken, IndiceNumerico indice) {

		if (pilhaDeToken.size() > indice.getValor()) {
			Token tokenIndice = pilhaDeToken.get(indice.getValor());
			
			this.avancaProximoToken();
			return tokenIndice.getTokenType().equals(GCLTokenTypes.IDENTIFIER);			
		}

		return false;

	}
	
	protected Token getTokenAtual() {
		if (pilhaDeToken.size() > indice.getValor()) {
			return pilhaDeToken.get(indice.getValor());
		}		
		return null;
	}
	
	protected void avancaProximoToken() {
		this.getIndice().inc();
	}

	protected boolean proximoTokenPossuiValorETipoIgualA(String compareLexema, GCLTokenTypes compareType ) {
		return hasTokenWithLexemaAndType(this.getPilhaDeToken(),
										 this.getIndice(),
										 compareLexema,
										 compareType);
	}	
	private boolean hasTokenWithLexemaAndType(TokenList pilhaDeToken, IndiceNumerico indice,
			String compareLexema, GCLTokenTypes compareType ) {
		
		if (pilhaDeToken.size() > indice.getValor()) {
			Token tokenIndice = pilhaDeToken.get(indice.getValor());			
			
			this.avancaProximoToken();
			return (tokenIndice.getValue().equalsIgnoreCase(compareLexema))
					&& (tokenIndice.getTokenType().equals(compareType));

			
		}
		
		return false;
	}

	protected boolean proximoTokenPossuiValorIgualA(String compareLexema) {

		return this.hasLexema(this.getPilhaDeToken(),
							  this.getIndice(),
							  compareLexema);		
		
	}	
	private boolean hasLexema(TokenList pilhaDeToken, IndiceNumerico indice,
			String compareLexema) {

		if (pilhaDeToken.size() > indice.getValor()) {			
			Token token = pilhaDeToken.get(indice.getValor());
			
			this.avancaProximoToken();
			return token.getValue().equalsIgnoreCase(compareLexema);			
		}
		
		return false;
	}

	public abstract ArvoreSintaticaAbstrataNo validaEGeraProducao();
	
	public TokenList getPilhaDeToken(){
		return this.pilhaDeToken;
	}
	
	public void setPilhaDeToken(TokenList tokens){
		this.pilhaDeToken = tokens;
	}	
	
	public IndiceNumerico getIndice(){
		return this.indice;
	}
	
	public void setIndice(IndiceNumerico indiceNumerico){
		this.indice = indiceNumerico;
	}	
	
}
