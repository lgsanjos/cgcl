package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		/* <emptyStatement> | <readStatement> | <writeStatement> | <assignStatement> | <returnStatement> | <callStatement>
		 | <ifStatement> | <doStatement> | <forStatement>
		 */
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("statement");
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.emptyStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.readStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.writeStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.assignStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.returnStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}

		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.callStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.ifStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}

		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.doStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try {
			this.salvarIndiceTokenAtual();
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.forStatement));
			return raiz;
		} catch (ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}	
		
		this.throwProducaoSintaticaException("statement");
		return null;
	}

}
