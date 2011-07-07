package analise.sintatica.producoes;

public class RegrasProducaoDefinitionPart extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}
	
	@Override
	public boolean isValida() {
		boolean producaoDefValido = true;
		boolean pontoEVirgulaValido = true;
		boolean isInvalido = true;
		
		do {
			producaoDefValido = ProducoesFactory.getProducao(ProducoesEnum.definition).isValida();
			if (producaoDefValido) {
				pontoEVirgulaValido = this.proximoTokenPossuiValorIgualA(";");
			}
		} while ( producaoDefValido && pontoEVirgulaValido );
		
		isInvalido = producaoDefValido && !pontoEVirgulaValido; 
		return !isInvalido; 
	}
		

}
