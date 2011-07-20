package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanOperator extends RegrasProducaoAbstract {

	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanOperator");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("&", GCLTokenTypes.SYMBOL)) {
				this.getIndice().dec();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("|", GCLTokenTypes.SYMBOL)) {
					this.getIndice().dec();
					isValida = false;						
				}
			}
			
			raiz.adicionaNoFilho("booleanOperator", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}


}
