package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableAccess extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "identifier" <variableMore>
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableAccess");
		
		this.salvarIndiceTokenAtual();			
		if (this.proximoTokenEhUmIdentificador()) {		
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
			
			ArvoreSintaticaAbstrataNo variableMore;
			variableMore = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableMore);
			
			if ( variableMore != null) {
				raiz.adicionaNoFilho(variableMore);
				this.descartaIndiceSalvo();
				return raiz;
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("variableAccess");
		return null;		
	}

}
