package analise.sintatica.producoes;

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
			
			indice.inc();
			return tokenIndice.getTokenType().equals(GCLTokenTypes.IDENTIFIER);			
		}

		return false;

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
			
			indice.inc();
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
			indice.inc();
			return token.getValue().equalsIgnoreCase(compareLexema);			
		}
		
		return false;
	}

	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean resposta = false;
		TokenList estadoInicialPilhaDeToken = getPilhaDeToken();
		IndiceNumerico estadoInicialApartirDe = getIndice();
		
		try {
			this.setPilhaDeToken(pilhaDeToken);
			this.setIndice(apartirDe);		
			resposta = this.isValida();
		} finally {
			this.setPilhaDeToken(estadoInicialPilhaDeToken);
			this.setIndice(estadoInicialApartirDe);		
		}
		return resposta;		
	}
	
	public abstract boolean isValida();

	public abstract Object geraArvoreSintaticaAbstrata();
	
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
