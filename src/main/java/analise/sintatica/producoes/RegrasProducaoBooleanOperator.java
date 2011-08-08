package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanOperator extends RegrasProducaoAbstract {

	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanOperator");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("&", GCLTokenTypes.SYMBOL)) {
				this.voltaToken();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("|", GCLTokenTypes.SYMBOL)) {
					this.voltaToken();
					isValida = false;						
				}
			}
			
			raiz.adicionaNoFilho("booleanOperator", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}


}
