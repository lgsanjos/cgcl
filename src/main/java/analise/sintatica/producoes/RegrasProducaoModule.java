package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoModule extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// TODO Auto-generated method stub
		return null;
	}

	private static RegrasProducaoModule instancia = new RegrasProducaoModule();
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		// "module" "identifier" <definitionPart> [ "private"  <block> ] "."
		boolean isValido = true;
		
		if ( isValido ) isValido &= this.hasLexema(pilhaDeToken, apartirDe, "module"); 
		if ( isValido ) isValido &= this.isAnIdToken(pilhaDeToken, apartirDe); 
		if ( isValido ) isValido &= RegrasProducaoDefinitionPart.getInstancia().isValida(pilhaDeToken, apartirDe);
		
		// [ "private" <block> ]
		if ( isValido ) isValido &= this.hasLexema(pilhaDeToken, apartirDe, "."); 

		return isValido;
	}
	


}
