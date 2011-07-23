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
				this.voltaToken();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("/", GCLTokenTypes.SYMBOL)) {
					this.voltaToken();
					
					if ( ! this.proximoTokenPossuiValorETipoIgualA("\"", GCLTokenTypes.SYMBOL)) {
						this.voltaToken();
						isValida = false;						
					}
				}
			}
			
			raiz.adicionaNoFilho("multiplyOperator", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}
