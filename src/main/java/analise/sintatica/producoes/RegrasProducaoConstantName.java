package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstantName extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constantName");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenEhUmIdentificador()) {
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}	
		
		this.descartaIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
