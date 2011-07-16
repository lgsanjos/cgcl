package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoStatementPart extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean statementValido = true;
		boolean pontoEVirgulaValido = true;
		boolean isInvalido = true;
		boolean isValido = true;
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("statementPart");
		ArvoreSintaticaAbstrataNo statementPart;

		do {
			statementPart = ProducoesFactory.getProducao(ProducoesEnum.statement).validaEGeraProducao();
			statementValido = (statementPart != null);
			
			if (statementValido) {				
				pontoEVirgulaValido = this.proximoTokenPossuiValorIgualA(";");
				
				if (pontoEVirgulaValido) {					
					raiz.adicionaNoFilho(statementPart);
					raiz.adicionaNoFilho(";", this.getTokenAtual());
				}
			}
			
		} while ( statementValido && pontoEVirgulaValido );
		
		// statementPart só é invalido quando não tiver o par completo de token.
		isInvalido = statementValido && !pontoEVirgulaValido;
		isValido = ! isInvalido;
		return (isValido) ? raiz : null;
	}

}
