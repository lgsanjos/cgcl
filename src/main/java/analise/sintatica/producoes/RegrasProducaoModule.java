package analise.sintatica.producoes;

import coretypes.TokenList;

public class RegrasProducaoModule extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, int apartirDe) {
		// TODO Auto-generated method stub
		return false;
	}

	private static RegrasProducaoModule instancia = new RegrasProducaoModule();
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}
	


}
