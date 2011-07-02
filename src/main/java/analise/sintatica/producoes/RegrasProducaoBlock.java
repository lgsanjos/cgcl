package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoBlock extends RegrasProducaoAbstract {


	private static RegrasProducaoBlock instancia = new RegrasProducaoBlock();
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}
	
	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean isValido = true;

		//<definitionPart>
		if ( isValido ) isValido &= this.hasLexema(pilhaDeToken, apartirDe, "begin");
		//<statementPart>
		if ( isValido ) isValido &= this.hasLexema(pilhaDeToken, apartirDe, "end");
	
		return isValido;
	}

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

}
