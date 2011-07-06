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
		return null;
	}
	
	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean producaoDefValido = true;
		boolean pontoEVirgulaValido = true;
		boolean isInvalido = true;
		
		do {
			producaoDefValido = RegrasProducaoDefinition.getInstancia().isValida(pilhaDeToken, apartirDe);
			if (producaoDefValido) {
				pontoEVirgulaValido = this.hasLexema(pilhaDeToken, apartirDe, ";");
			}
			
		} while ( producaoDefValido && pontoEVirgulaValido );
		
		isInvalido = producaoDefValido && !pontoEVirgulaValido; 
		
		return !isInvalido; 

	}
		

}
