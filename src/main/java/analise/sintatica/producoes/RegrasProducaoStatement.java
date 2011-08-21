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
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.emptyStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.readStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.writeStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.assignStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.returnStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.callStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.ifStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}

		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.doStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.forStatement));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}		
		
		// TODO: throw exception
		return null;
	}

}
