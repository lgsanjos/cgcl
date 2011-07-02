package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoDefinitionPart extends RegrasProducaoAbstract {

	private static RegrasProducaoDefinitionPart instancia = new RegrasProducaoDefinitionPart();
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}	
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean isValida = true;
		
		//if (isValida) isValida = RegrasProducaoDefinition.getInstancia().isValida(pilhaDeToken, apartirDe);
		//if (isValida) isValida = this.hasLexema(pilhaDeToken, apartirDe, ";");	
		return isValida;
	}
		

}
