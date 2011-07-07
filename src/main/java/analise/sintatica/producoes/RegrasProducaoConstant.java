package analise.sintatica.producoes;

public class RegrasProducaoConstant extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		boolean isValida = true;
		isValida = this.proximoTokenEhUmIdentificador();
		return isValida;
	}

}
