package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoNextItem extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("nextItem");

		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenEhUmIdentificador()) {
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		if (this.proximoTokenEhUmNumero()) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}		
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("nextItem");
		return null;
	}

}
