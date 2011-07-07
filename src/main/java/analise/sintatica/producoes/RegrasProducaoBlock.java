package analise.sintatica.producoes;

public class RegrasProducaoBlock extends RegrasProducaoAbstract {
	
	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		boolean isValido = true;

		// TODO: <definitionPart>
		if ( isValido ) isValido &= this.proximoTokenPossuiValorIgualA("begin");
		// TODO: <statementPart>
		if ( isValido ) isValido &= this.proximoTokenPossuiValorIgualA("end");
	
		return isValido;
	}

}
