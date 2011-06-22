package analise.sintatica.producoes;

import coretypes.TokenList;
import coretypes.IndiceNumerico;


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
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean isValida = true;
			
		
		//while ( isValida ){
		//	if ( isValida ) isValida = this.hasLexema(pilhaDeToken, apartirDe, "begin");			
		//}
		
		return isValida;
	}
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}

}
