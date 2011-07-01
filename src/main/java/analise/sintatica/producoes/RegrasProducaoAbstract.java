package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.IndiceNumerico;
import coretypes.TokenList;

public abstract class RegrasProducaoAbstract {

	public static RegrasProducaoAbstract getInstancia(){
		return null;
	}
	
	protected boolean isAnIdToken(TokenList pilhaDeToken, IndiceNumerico indice){		
		
		boolean resposta = (pilhaDeToken.size() > indice.getValor()) &&
				   (pilhaDeToken.get(indice.getValor()).getTokenType().equals(GCLTokenTypes.Identifier));
		indice.inc();
		return resposta;
		
	}
	
	protected boolean hasLexema(TokenList pilhaDeToken, IndiceNumerico indice, String compareLexema){

		boolean resposta = (pilhaDeToken.size() > indice.getValor()) &&
						   (pilhaDeToken.get(indice.getValor()).getValue().equalsIgnoreCase(compareLexema));
		indice.inc();
		return resposta;		
	}	
	
	public abstract boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe);

	public abstract  Object geraArvoreSintaticaAbstrata();

}
