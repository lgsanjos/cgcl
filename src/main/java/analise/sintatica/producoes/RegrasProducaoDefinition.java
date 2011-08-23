package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDefinition extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> |<procedureDecl>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("definition");
		
		this.salvarIndiceTokenAtual();
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.constantDef));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableDef));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.procedureDef));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}

		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.typedef));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.procedureDecl));
		if (raiz.possueNosFilhos()) {
			return raiz;
		}		
		
		
		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
