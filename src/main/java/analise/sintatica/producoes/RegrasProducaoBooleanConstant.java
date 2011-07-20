package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanConstant");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("true", GCLTokenTypes.KEYWORD)) {
				this.getIndice().dec();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("false", GCLTokenTypes.KEYWORD)) {
					this.getIndice().dec();
					isValida = false;
				}
			}
			
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}
