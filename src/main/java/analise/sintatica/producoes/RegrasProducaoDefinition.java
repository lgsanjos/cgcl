package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDefinition extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> |<procedureDecl>
		return null;
	}

}
