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

		boolean resposta = (pilhaDeToken.size() > indice.getValor())
				&& (pilhaDeToken.get(indice.getValor()).getTokenType()
						.equals(GCLTokenTypes.Identifier));
		indice.inc();
		return resposta;

	}

	protected boolean proximoTokenPossuiValorETipoIgualA(String compareLexema, GCLTokenTypes compareType ) {
		return hasTokenWithLexemaAndType(this.getPilhaDeToken(),
										 this.getIndice(),
										 compareLexema,
										 compareType);
	}	
	private boolean hasTokenWithLexemaAndType(TokenList pilhaDeToken, IndiceNumerico indice,
			String compareLexema, GCLTokenTypes compareType ) {
		
		Token tokenIndice = pilhaDeToken.get(indice.getValor());
		
		boolean resposta = (pilhaDeToken.size() > indice.getValor())
							&& (tokenIndice.getValue().equalsIgnoreCase(compareLexema))
							&& (tokenIndice.getTokenType().equals(compareType));

		indice.inc();		
		return resposta;
		
	}

	protected boolean proximoTokenPossuiValorIgualA(String compareLexema) {

		return this.hasLexema(this.getPilhaDeToken(),
							  this.getIndice(),
							  compareLexema);		
		
	}	
	private boolean hasLexema(TokenList pilhaDeToken, IndiceNumerico indice,
			String compareLexema) {

		Token token = pilhaDeToken.get(indice.getValor());
		boolean resposta = (pilhaDeToken.size() > indice.getValor())
							&& (token.getValue().equalsIgnoreCase(compareLexema));
		indice.inc();
		return resposta;
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
