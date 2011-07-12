package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import utils.GCLTokenTypes;

public class RegrasProducaoConstantDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// "const" <constantName> "=" <constant>
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constantDef");
		
		if (isValida) {
			isValida &= this.proximoTokenPossuiValorETipoIgualA("const", GCLTokenTypes.KEYWORD);
			raiz.adicionaNoFilho("const",this.getTokenAtual());			
		}	
		
		if (isValida) {
			ArvoreSintaticaAbstrataNo constantName;
			constantName = ProducoesFactory.getProducao(ProducoesEnum.constantName).validaEGeraProducao();
			isValida &= ( constantName != null);
			raiz.adicionaNoFilho(constantName);
		}	
		
		if (isValida) {
			isValida &= this.proximoTokenPossuiValorETipoIgualA("=", GCLTokenTypes.SYMBOL);
			raiz.adicionaNoFilho("=", this.getTokenAtual());
		}	
		
		if (isValida) {
			ArvoreSintaticaAbstrataNo constant;
			constant = ProducoesFactory.getProducao(ProducoesEnum.constant).validaEGeraProducao();
			isValida &= (constant != null);
			raiz.adicionaNoFilho(constant);
		}	
		
		return (isValida) ? raiz : null;
	}

}
