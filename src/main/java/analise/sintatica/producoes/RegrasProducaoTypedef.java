package analise.sintatica.producoes;


public class RegrasProducaoTypedef extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// "typedef" <type> "identifier" 
		return null;
	}

	@Override
	public boolean isValida() {
		return false;
	}

}
