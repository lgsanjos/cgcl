package analise.sintatica.producoes;

public class RegrasProducaoConstantName extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		// "identifier"
		boolean isValida = true;
		isValida = this.proximoTokenEhUmIdentificador();
		return isValida;
	}

}
