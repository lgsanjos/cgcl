package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class RegrasProducaoConstantDef extends RegrasProducaoAbstract {

	private static RegrasProducaoConstantDef instancia = new RegrasProducaoConstantDef();

	public static RegrasProducaoConstantDef getInstancia() {
		return instancia;
	}

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, IndiceNumerico apartirDe) {
		// "const" <constantName> "=" <constant>
		boolean isValida = true;
		if (isValida)
			isValida &= this.hasTokenWithLexemaAndType(pilhaDeToken, apartirDe, "const", GCLTokenTypes.Keyword);
		
		if (isValida)
			isValida &= RegrasProducaoConstantName.getInstancia().isValida(pilhaDeToken, apartirDe);
		
		if (isValida)
			isValida &= this.hasTokenWithLexemaAndType(pilhaDeToken, apartirDe, "=", GCLTokenTypes.Symbol);
		
		if (isValida)
			isValida &= RegrasProducaoConstant.getInstancia().isValida(pilhaDeToken, apartirDe);
		
		return false;
	}

}
