package analise.sintatica.producoes;

public class RegrasProducaoDefinition extends RegrasProducaoAbstract {
	

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> |<procedureDecl>
		return false;
	}

}
