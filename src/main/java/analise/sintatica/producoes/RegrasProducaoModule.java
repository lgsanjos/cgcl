package analise.sintatica.producoes;

import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoModule extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	private static RegrasProducaoModule instancia = new RegrasProducaoModule();
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		boolean isValido = true;
		
		if ( isValido ) isValido &= this.hasLexema(pilhaDeToken, apartirDe, "module"); 
		if ( isValido ) isValido &= this.isAnIdToken(pilhaDeToken, apartirDe); 
		if ( isValido ) isValido &= RegrasProducaoDefinitionPart.getInstancia().isValida(pilhaDeToken, apartirDe);
		/* Opcional */ if ( isValido && !this.hasLexema(pilhaDeToken, apartirDe, "private")) { apartirDe.dec(); }
		/* Opcional */ if ( isValido) { RegrasProducaoBlock.getInstancia().isValida(pilhaDeToken, apartirDe); } 
		if ( isValido ) isValido &= this.hasLexema(pilhaDeToken, apartirDe, "."); 

		return isValido;
	}
	


}
