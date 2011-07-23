package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoIndexOrComp extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <indexorcomp> { "."  "number" | "[" <expression> "]" }
		
		boolean isValido = true;
		boolean possuiContrucaoCompletaValida = false;
		ArvoreSintaticaAbstrataNo expression;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("indexorcomp");
		
		do {

			// caso 1
				ProducoesFactory.salvaEstado();				
				isValido &= this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL); 
				if (isValido) {
					raiz.adicionaNoFilho(".", this.getTokenAtual());
				
					isValido &= this.proximoTokenEhUmNumero();
					raiz.adicionaNoFilho("number", this.getTokenAtual());
					
					possuiContrucaoCompletaValida = true;
				} else {
					ProducoesFactory.voltaEstado();
				}
	
			
			// caso 2
				ProducoesFactory.salvaEstado();
				isValido &= this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL);
				if (isValido) {
					raiz.adicionaNoFilho("[", this.getTokenAtual());
					
					expression = ProducoesFactory.getProducao(ProducoesEnum.expression).validaEGeraProducao();
					raiz.adicionaNoFilho(expression);
					isValido &= (expression != null);
					
					if (isValido) {
						isValido &= this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL);
						raiz.adicionaNoFilho("]", this.getTokenAtual());
						
						possuiContrucaoCompletaValida = true;
					}
				} else {
					ProducoesFactory.voltaEstado();
				}
				
		} while (isValido);	
						
		return (possuiContrucaoCompletaValida) ? raiz : null;
	}
}
