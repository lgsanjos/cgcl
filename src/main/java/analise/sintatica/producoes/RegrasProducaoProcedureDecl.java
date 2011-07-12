package analise.sintatica.producoes;

import utils.GCLTokenTypes;

public class RegrasProducaoProcedureDecl extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida() {
		// "proc" "identifier" [<paramPart>]
		boolean isValida = true;

		if (isValida)
			isValida &= this.proximoTokenPossuiValorETipoIgualA("proc",
					GCLTokenTypes.KEYWORD);

		if (isValida)
			isValida &= this.proximoTokenEhUmIdentificador();

		if (isValida)
			isValida &= this.proximoTokenPossuiValorETipoIgualA("=",
					GCLTokenTypes.SYMBOL);
		
		//Falta ParamPart

		return false;
	}

}
