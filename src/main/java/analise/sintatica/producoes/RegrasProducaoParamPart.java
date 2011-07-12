package analise.sintatica.producoes;

public class RegrasProducaoParamPart extends RegrasProducaoAbstract {

	@Override
	public boolean isValida() {
		// "(" [ <paramDef> { ";" <paramDef> } ] )" 
		return false;
	}

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

}
