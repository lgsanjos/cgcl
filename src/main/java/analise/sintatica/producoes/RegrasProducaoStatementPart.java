package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoStatementPart extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		boolean isValida = true;
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("statementPart");
		ArvoreSintaticaAbstrataNo statementPart;

		do {
			
			this.salvarIndiceTokenAtual();
			try {
				isValida = false;
				statementPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.statement);
				if (this.proximoTokenPossuiValorIgualA(";")) {
					raiz.adicionaNoFilho(statementPart);
					raiz.adicionaNoFilho(this.getTokenAtual());
					this.descartaIndiceSalvo();
					isValida = true;
				}
			} catch (ProducaoSintaticaException e) {
				//
			}
			
			if (! isValida) {
				this.recuperarIndiceSalvo();
			}
			
		} while ( isValida );	
		
		return raiz;
	}

}
