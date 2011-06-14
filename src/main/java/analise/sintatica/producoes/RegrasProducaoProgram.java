package analise.sintatica.producoes;

import coretypes.TokenList;


public class RegrasProducaoProgram extends RegrasProducaoAbstract {
	
	private static RegrasProducaoProgram instancia = new RegrasProducaoProgram();
	
	private RegrasProducaoProgram(){
		
	}
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isValida(TokenList pilhaDeToken, int apartirDe) {
		int i = apartirDe;
		boolean isValida = true;
		
		
		
		while ( isValida ){
			if ( isValida ) isValida =  pilhaDeToken.get(i).getValue().equalsIgnoreCase("begin");	
			i++;
		}
		
		return isValida;
	}
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}

}
