package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoSimpleExpression extends RegrasProducaoAbstract {
	
	private boolean reconheceProducaoTermAddTerm(ArvoreSintaticaAbstrataNo raiz) throws ProducaoSintaticaException {
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo term;
		term = ProducoesFactory.getProducao(ProducoesEnum.term).validaEGeraProducao();
		if (term == null) {
			this.recuperarIndiceSalvo();
			return false;
		}
		this.descartaIndiceSalvo();
		raiz.adicionaNoFilho(term);
		
		boolean isValido;
		do {
			this.salvarIndiceTokenAtual();
			isValido = false;

			ArvoreSintaticaAbstrataNo addOperator;
			addOperator = ProducoesFactory.getProducao(ProducoesEnum.addingOperator).validaEGeraProducao();
			if ( addOperator != null ) {
				ArvoreSintaticaAbstrataNo novoTerm;	
				novoTerm = ProducoesFactory.getProducao(ProducoesEnum.term).validaEGeraProducao();
				if ( novoTerm != null ) {
					isValido = true;
					raiz.adicionaNoFilho(addOperator);
					raiz.adicionaNoFilho(novoTerm);
					this.descartaIndiceSalvo();
				}
			}
			
			if (! isValido ) {
				this.recuperarIndiceSalvo();
			}
			
		} while (isValido);
		
		return true;
	}

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// ( "+" | "-" )  <term> { <addingOperator> <term>} | <term> { <addingOperator> <term>}

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("simpleExpression");
		boolean isValida;

		this.salvarIndiceTokenAtual();

		this.avancaProximoToken();
		if (this.getTokenAtual() == null) {
			return null;
			// TODO: Adicionar throw exception
		}
		
		if ( (this.getTokenAtual().getValue() == "+") || (this.getTokenAtual().getValue() == "-") ) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			this.descartaIndiceSalvo();
		} else {
			this.recuperarIndiceSalvo();
		}
		
		isValida = this.reconheceProducaoTermAddTerm(raiz);
		
		if (! isValida) {
			this.recuperarIndiceSalvo();
			return null;
		} else {
			this.descartaIndiceSalvo();
			// TODO: add throw exception
		}
		
		return raiz;
	}

}
