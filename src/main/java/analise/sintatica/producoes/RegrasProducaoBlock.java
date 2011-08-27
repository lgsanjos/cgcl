package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBlock extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <definitionPart> "begin" <statementPart> "end" 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("block");

		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo defintionPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.definitionPart);
		if (defintionPart != null) {

			raiz.adicionaNoFilho(defintionPart);
			if (this.proximoTokenPossuiValorIgualA("begin")) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				
				this.descartaIndiceSalvo();
				this.salvarIndiceTokenAtual();
				
				ArvoreSintaticaAbstrataNo statementPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.statementPart);
				if (statementPart != null) {
					raiz.adicionaNoFilho(statementPart);
					
					if (this.proximoTokenPossuiValorIgualA("end")) {
						raiz.adicionaNoFilho(this.getTokenAtual());
						this.descartaIndiceSalvo();
						return raiz;
					}
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("block");
		return null;
	}

}
