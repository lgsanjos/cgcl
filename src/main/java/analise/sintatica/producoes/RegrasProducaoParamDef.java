package analise.sintatica.producoes;

public class RegrasProducaoParamDef extends RegrasProducaoAbstract {

	@Override
	public boolean isValida() {
		// ( "val" | "ref" ) <variableDef> 
		return false;
	}

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

}
