package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoExpressionList extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <expression> { "," <expression> }
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("expressionList");
		boolean isValido = true;
		ArvoreSintaticaAbstrataNo expression = null;

		this.salvarIndiceTokenAtual();
		expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
		raiz.adicionaNoFilho(expression);
		if (expression == null) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("expressionList");
			return null;
		}
		
		this.descartaIndiceSalvo();

		// { "," <expression> }
		do {
			isValido = false;
			this.salvarIndiceTokenAtual();
			
			if ( this.proximoTokenPossuiValorETipoIgualA(",", GCLTokenTypes.SYMBOL) ) {
				Token virgula = this.getTokenAtual();
				ArvoreSintaticaAbstrataNo novaExpressao = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
				
				if (novaExpressao != null) {				
					raiz.adicionaNoFilho(",", virgula);
					raiz.adicionaNoFilho(novaExpressao);
					this.descartaIndiceSalvo();
					isValido = true;
				}
			}

			if (! isValido) {
				this.recuperarIndiceSalvo();
			}

		} while (isValido);

		return raiz;
	}

}
