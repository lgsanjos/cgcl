package analise.sintatica.producoes;

public class RegrasProducaoType extends RegrasProducaoAbstract {

	@Override
	public boolean isValida() {
		// <typeSymbol> [ <arraytype> | <rangetype> ] | <tupletype>
		return false;
	}

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

}
