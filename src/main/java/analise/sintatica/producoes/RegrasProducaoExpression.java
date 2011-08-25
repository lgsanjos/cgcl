package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoExpression extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {

		// <relationalExpression> {<booleanOperator> <relationalExpression> }
		boolean isValida;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("expression");
			
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo relational = this.validaEGeraProducaoDadoProducao(ProducoesEnum.relationalExpression);
		raiz.adicionaNoFilho(relational);
		if (relational == null) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("expression");
			return null;
		}
		
		this.descartaIndiceSalvo();
		
		
		do {
			this.salvarIndiceTokenAtual();
			isValida = false;
			
			try {
				ArvoreSintaticaAbstrataNo booleanOperator = this.validaEGeraProducaoDadoProducao(ProducoesEnum.booleanOperator);
				ArvoreSintaticaAbstrataNo relationalExp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.relationalExpression);
				raiz.adicionaNoFilho(booleanOperator);
				raiz.adicionaNoFilho(relationalExp);
				this.descartaIndiceSalvo();
				isValida = true;					
			} catch (ProducaoSintaticaException e) {
				this.recuperarIndiceSalvo();
			}
			
		} while (isValida);
		
		return raiz;
	}

}
