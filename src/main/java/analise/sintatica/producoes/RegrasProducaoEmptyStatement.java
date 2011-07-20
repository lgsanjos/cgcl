package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoEmptyStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("emptyStatement");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("skip", GCLTokenTypes.KEYWORD)) {
				this.getIndice().dec();
				isValida = false;						
			}
			
			raiz.adicionaNoFilho("skip", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}
