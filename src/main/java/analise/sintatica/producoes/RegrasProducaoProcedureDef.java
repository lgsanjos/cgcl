package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoProcedureDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		//<procedureDecl> <block>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("procedureDef");
		
		try {
			this.salvarIndiceTokenAtual();
			ArvoreSintaticaAbstrataNo procedureDecl = this.validaEGeraProducaoDadoProducao(ProducoesEnum.procedureDecl);
			raiz.adicionaNoFilho(procedureDecl);
			this.descartaIndiceSalvo();
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("procedureDecl");
		}
		
		try {
			this.salvarIndiceTokenAtual();
			ArvoreSintaticaAbstrataNo block = this.validaEGeraProducaoDadoProducao(ProducoesEnum.block);
			raiz.adicionaNoFilho(block);
			this.descartaIndiceSalvo();
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		this.throwProducaoSintaticaException("procedureDef");
		return null;
	}

}
