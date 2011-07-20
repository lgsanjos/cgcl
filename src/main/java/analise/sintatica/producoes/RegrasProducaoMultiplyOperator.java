package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoMultiplyOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("multiplyOperator");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("*", GCLTokenTypes.SYMBOL)) {
				this.getIndice().dec();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("/", GCLTokenTypes.SYMBOL)) {
					this.getIndice().dec();
					
					if ( ! this.proximoTokenPossuiValorETipoIgualA("\"", GCLTokenTypes.SYMBOL)) {
						this.getIndice().dec();
						isValida = false;						
					}
				}
			}
			
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}
