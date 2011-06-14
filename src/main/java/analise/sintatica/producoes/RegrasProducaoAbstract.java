package analise.sintatica.producoes;

import coretypes.TokenList;

public abstract class RegrasProducaoAbstract {

	public static RegrasProducaoAbstract getInstancia(){
		return null;
	}
	
	public abstract boolean isValida(TokenList pilhaDeToken, int apartirDe);

	public abstract  Object geraArvoreSintaticaAbstrata();

}
