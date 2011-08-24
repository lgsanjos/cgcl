package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoType extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		//<typeSymbol> [ <arraytype> | <rangetype> ] | <tupletype>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("type");
		
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo tupleType = this.validaEGeraProducaoDadoProducao(ProducoesEnum.tupletype);
		if (tupleType != null) {
			raiz.adicionaNoFilho(tupleType);
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.recuperarIndiceSalvo();		
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo typeSymbol = this.validaEGeraProducaoDadoProducao(ProducoesEnum.typeSymbol);
		if (typeSymbol == null) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("type");
			return null;
		}			

		raiz.adicionaNoFilho(typeSymbol);
		this.descartaIndiceSalvo();		
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo arrayType = this.validaEGeraProducaoDadoProducao(ProducoesEnum.arraytype);
		if (arrayType != null) {
			raiz.adicionaNoFilho(arrayType);
			this.descartaIndiceSalvo();
			return raiz;	
		} 		
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
				
		ArvoreSintaticaAbstrataNo rangeType = this.validaEGeraProducaoDadoProducao(ProducoesEnum.rangetype);
		if (rangeType != null) {
			raiz.adicionaNoFilho(rangeType);
			this.descartaIndiceSalvo();
			return raiz;				
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("type");
		return null;
	}

}
