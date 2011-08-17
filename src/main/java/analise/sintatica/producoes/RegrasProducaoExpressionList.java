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
		try {
			expression = ProducoesFactory.getProducao(ProducoesEnum.expression).validaEGeraProducao();
			raiz.adicionaNoFilho(expression);
		} finally {
			if (expression == null) {
				this.recuperarIndiceSalvo();
				return null;
			} else {
				this.descartaIndiceSalvo();
			}
		}

		// { "," <expression> }
		do {
			this.salvarIndiceTokenAtual();		
			isValido = false;

			if ( this.proximoTokenPossuiValorETipoIgualA(",", GCLTokenTypes.SYMBOL) ) {
				Token virgula = this.getTokenAtual();
				ArvoreSintaticaAbstrataNo novaExpressao = ProducoesFactory.getProducao(ProducoesEnum.expression).validaEGeraProducao();
				
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
