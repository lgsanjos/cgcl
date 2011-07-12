package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("const");
		
		if (isValida) {
			isValida &= this.proximoTokenEhUmIdentificador();
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
		}
		
		return (isValida) ? raiz : null;
	}

}
