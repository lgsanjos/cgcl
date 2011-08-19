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
		ArvoreSintaticaAbstrataNo relational = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression).validaEGeraProducao();
		raiz.adicionaNoFilho(relational);
		if (relational == null) {
			this.recuperarIndiceSalvo();
			throw new ProducaoSintaticaException("Erro sintatico em ");
		}
		
		this.descartaIndiceSalvo();
		
		
		do {
			this.salvarIndiceTokenAtual();
			isValida = false;
			
			ArvoreSintaticaAbstrataNo booleanOperator = ProducoesFactory.getProducao(ProducoesEnum.booleanOperator).validaEGeraProducao();
			if (booleanOperator != null) {
				
				ArvoreSintaticaAbstrataNo relationalExp = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression).validaEGeraProducao();
				if (relationalExp != null) {
					raiz.adicionaNoFilho(booleanOperator);
					raiz.adicionaNoFilho(relationalExp);
					isValida = true;
					this.descartaIndiceSalvo();
				}				
				
			}
			
			if (! isValida) {
				this.recuperarIndiceSalvo();
			}
			
		} while (isValida);
		
		return raiz;
	}

}
