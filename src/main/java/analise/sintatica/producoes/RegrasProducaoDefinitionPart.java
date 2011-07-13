package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDefinitionPart extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean producaoDefValido = true;
		boolean pontoEVirgulaValido = true;
		boolean isInvalido = true;
		boolean isValido = true;
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("definitionPart");
		ArvoreSintaticaAbstrataNo definitionPart;
		
		do {
			definitionPart = ProducoesFactory.getProducao(ProducoesEnum.definition).validaEGeraProducao();
			producaoDefValido = (definitionPart != null);
			
			if (producaoDefValido) {				
				pontoEVirgulaValido = this.proximoTokenPossuiValorIgualA(";");
				
				if (pontoEVirgulaValido) {					
					raiz.adicionaNoFilho(definitionPart);
					raiz.adicionaNoFilho(";", this.getTokenAtual());
				}
			}
			
		} while ( producaoDefValido && pontoEVirgulaValido );
		
		isInvalido = producaoDefValido && !pontoEVirgulaValido;
		isValido = ! isInvalido;
		return (isValido) ? raiz : null;
	}
		

}
