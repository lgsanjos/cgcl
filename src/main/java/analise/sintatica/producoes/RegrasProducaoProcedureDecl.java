package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoProcedureDecl extends RegrasProducaoAbstract {

	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// "proc" "identifier" [<paramPart>]
		/*
		boolean isValida = true;

		if (isValida)
			isValida &= this.proximoTokenPossuiValorETipoIgualA("proc",	GCLTokenTypes.KEYWORD);

		if (isValida)
			isValida &= this.proximoTokenEhUmIdentificador();

		if (isValida)
			isValida &= this.proximoTokenPossuiValorETipoIgualA("=",GCLTokenTypes.SYMBOL);
		*/
		//Falta ParamPart
		return null;
	}

}
