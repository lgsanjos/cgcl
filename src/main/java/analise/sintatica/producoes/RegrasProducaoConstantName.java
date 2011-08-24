package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstantName extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constantName");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenEhUmIdentificador()) {
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}	
		
		this.descartaIndiceSalvo();
		this.throwProducaoSintaticaException("constantName");
		return null;
	}

}
