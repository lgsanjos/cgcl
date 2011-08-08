package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanConstant");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("true", GCLTokenTypes.KEYWORD)) {
				this.voltaToken();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("false", GCLTokenTypes.KEYWORD)) {
					this.voltaToken();
					isValida = false;
				}
			}
			
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}
