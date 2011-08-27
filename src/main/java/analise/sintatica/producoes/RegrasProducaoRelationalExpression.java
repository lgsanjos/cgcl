package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;


public class RegrasProducaoRelationalExpression extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <simpleExpression> [<relationalOperator> <simpleExpression>]
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("relationalExpression");
		
		this.salvarIndiceTokenAtual();
		try {
			ArvoreSintaticaAbstrataNo simpleExpression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.simpleExpression);
			this.descartaIndiceSalvo();
			raiz.adicionaNoFilho(simpleExpression);
		} catch (ProducaoSintaticaException e) {	
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("relationalExpression");
		}
		
	
		this.salvarIndiceTokenAtual();
		try {
			ArvoreSintaticaAbstrataNo relationalOperator = this.validaEGeraProducaoDadoProducao(ProducoesEnum.relationalOperator);
			raiz.adicionaNoFilho(relationalOperator);
		} catch(ProducaoSintaticaException e) {
			this.recuperarIndiceSalvo();
			return raiz;
		}
			
			
		try {
			ArvoreSintaticaAbstrataNo novaSimpleExpression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.simpleExpression);
			raiz.adicionaNoFilho(novaSimpleExpression);
			this.descartaIndiceSalvo();
		} catch (ProducaoSintaticaException exp) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("relationalExpression");
		}
		
		return raiz;
	}

}
