package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoNextItem extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("nextItem");
		
		if (isValida) {
			
			if ( ! this.proximoTokenEhUmIdentificador()) {
				this.voltaToken();
				
				if ( ! this.proximoTokenEhUmNumero()) {
					this.voltaToken();
					isValida = false;
				}
			}
			
			raiz.adicionaNoFilho("nextItem", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}	

}
