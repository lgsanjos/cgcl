package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoGuardedCommand extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <expression> "->" <statementPart>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("guardedCommand");
		
		this.salvarIndiceTokenAtual();
		
		ArvoreSintaticaAbstrataNo expression;
		expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
		if (expression != null) {
			raiz.adicionaNoFilho(expression);
			
			if (this.proximoTokenPossuiValorETipoIgualA("->", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho("->", this.getTokenAtual());
				
				ArvoreSintaticaAbstrataNo statementPart;
				statementPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.statementPart);
				if (statementPart != null) {
					raiz.adicionaNoFilho(statementPart);
					this.descartaIndiceSalvo();
					return raiz;
				}
			}
		}

		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
