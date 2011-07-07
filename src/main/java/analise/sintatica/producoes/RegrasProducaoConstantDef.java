package analise.sintatica.producoes;

import utils.GCLTokenTypes;

public class RegrasProducaoConstantDef extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		// "const" <constantName> "=" <constant>
		boolean isValida = true;
		if (isValida)
			isValida &= this.proximoTokenPossuiValorETipoIgualA("const", GCLTokenTypes.Keyword);
		
		if (isValida)
			isValida &= ProducoesFactory.getProducao(ProducoesEnum.constantName).isValida();
		
		if (isValida)
			isValida &= this.proximoTokenPossuiValorETipoIgualA("=", GCLTokenTypes.Symbol);
		
		if (isValida)
			isValida &= ProducoesFactory.getProducao(ProducoesEnum.constant).isValida();
		
		return false;
	}

}
