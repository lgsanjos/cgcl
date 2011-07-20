package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoAddingOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("addingOperator");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("+", GCLTokenTypes.SYMBOL)) {
				this.getIndice().dec();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("-", GCLTokenTypes.SYMBOL)) {
					this.getIndice().dec();
					isValida = false;						
				}
			}
			
			raiz.adicionaNoFilho("addingOperator", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}