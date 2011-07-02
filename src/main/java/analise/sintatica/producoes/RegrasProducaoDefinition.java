package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoDefinition extends RegrasProducaoAbstract {
	
	private static RegrasProducaoDefinition instancia = new RegrasProducaoDefinition();
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}	

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> |<procedureDecl>
		
		
		return true;
	}

}
