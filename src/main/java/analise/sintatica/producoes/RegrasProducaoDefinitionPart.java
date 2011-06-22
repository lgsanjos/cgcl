package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoDefinitionPart extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean validaProducao(TokenList pilhaDeToken, IndiceNumerico apartirDe){
		boolean isValida = true;
		
		//if (isValida) isValida = RegrasProducaoDefinition.getInstancia().isValida(pilhaDeToken, apartirDe);
		//if (isValida) isValida = this.hasLexema(pilhaDeToken, apartirDe, ";");		
		
		return isValida;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		// {<definition> ";" }
		
		boolean isValida = true;
		//boolean multiplasOcorrencias = true;
	
		isValida = this.validaProducao(pilhaDeToken, apartirDe); 
		
		
		//while ( isValida ){
		//	isValida = this.validaProducao(pilhaDeToken, i);
		//}
		return isValida;
	}
		
	private static RegrasProducaoModule instancia = new RegrasProducaoModule();
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}	

}
