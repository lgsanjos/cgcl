package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoIndexOrComp extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// { "."  "number" | "[" <expression> "]" }
		
		boolean isValido = true;
		boolean caso1_valido = false;
		boolean caso2_valido = false;
		boolean possuiContrucaoCompletaValida = false;
		ArvoreSintaticaAbstrataNo expression;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("indexorcomp");
		
		do {

			// caso 1
			this.salvarIndiceTokenAtual();
			caso1_valido = false;
			isValido &= this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL); 
			if (isValido) {
				raiz.adicionaNoFilho(".", this.getTokenAtual());
			
				isValido &= this.proximoTokenEhUmNumero();
				raiz.adicionaNoFilho("number", this.getTokenAtual());
				
				if (isValido) {
					possuiContrucaoCompletaValida = true;
					caso1_valido = true;
				}	
			}
			
			if (caso1_valido) {
				this.descartaIndiceSalvo();
			} else {
				this.recuperarIndiceSalvo();
			}

			this.salvarIndiceTokenAtual();
			caso2_valido = false;
			isValido = this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL);
			if (isValido) {
				raiz.adicionaNoFilho("[", this.getTokenAtual());
				
				try {
					expression = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
					raiz.adicionaNoFilho(expression);
					isValido &= (expression != null);
				} catch (ProducaoSintaticaException e) {
					isValido = false;
				}
			
				if (isValido) {
					isValido &= this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL);
					raiz.adicionaNoFilho("]", this.getTokenAtual());
					
					if (isValido) {
						possuiContrucaoCompletaValida = true;
						caso2_valido = true;
					}	
				}
			}
			
			if (caso2_valido) {
				this.descartaIndiceSalvo();
			} else {
				this.recuperarIndiceSalvo();
			}			
				
		} while (caso1_valido || caso2_valido);	
						
		if (possuiContrucaoCompletaValida) {
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.throwProducaoSintaticaException("indexorcomp");
		return null;
		
	}
}
