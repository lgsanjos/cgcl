package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDefinitionPart extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		boolean isValido = true;
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("definitionPart");
		do {
			this.salvarIndiceTokenAtual();
			isValido = false;			
			
			ArvoreSintaticaAbstrataNo definitionPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.definition);
			if (definitionPart != null) {
				
				if (this.proximoTokenPossuiValorIgualA(";")) {
					raiz.adicionaNoFilho(definitionPart);
					raiz.adicionaNoFilho(this.getTokenAtual());
					this.descartaIndiceSalvo();
					isValido = true;
				}
			}
			
			if ( ! isValido) {
				this.recuperarIndiceSalvo();
			}
			
		} while ( isValido );
		
		return raiz;
	}
		

}
