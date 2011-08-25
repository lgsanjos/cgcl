package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDefinition extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> |<procedureDecl>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("definition");
		
		this.salvarIndiceTokenAtual();
		try{
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.constantDef));
			this.descartaIndiceSalvo();
			return raiz;
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		this.salvarIndiceTokenAtual();
		try{
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableDef));
			this.descartaIndiceSalvo();
			return raiz;
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		this.salvarIndiceTokenAtual();
		try{
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.procedureDef));
			this.descartaIndiceSalvo();
			return raiz;
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		try{
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.typedef));
			this.descartaIndiceSalvo();
			return raiz;
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}		

		this.salvarIndiceTokenAtual();
		try{
			raiz.adicionaNoFilho(this.validaEGeraProducaoDadoProducao(ProducoesEnum.procedureDecl));
			this.descartaIndiceSalvo();
			return raiz;
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
		}
		
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("definition");
		return null;
	}

}
