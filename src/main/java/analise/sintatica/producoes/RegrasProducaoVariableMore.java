package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableMore extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <variableMore>      	""  |  "[" <expression> "]"  <indexorcomp> | "." <nextitem>  <indexorcomp>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableMore");
		boolean isCaso1Valido = true;
		boolean isCaso2Valido = true;
		boolean isCaso3Valido = true;
		
		// caso 1 - "[" <expression> "]"  <indexorcomp>
		if (isCaso1Valido) {			
			isCaso1Valido = false;
			
			this.salvarIndiceTokenAtual();
			ArvoreSintaticaAbstrataNo expr;
			ArvoreSintaticaAbstrataNo indexorcomp;
			
			if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho("[", this.getTokenAtual());
				
				expr = ProducoesFactory.getProducao(ProducoesEnum.expression).validaEGeraProducao();
				if (expr != null) {
					raiz.adicionaNoFilho(expr);
				
					if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho("]", this.getTokenAtual());
						indexorcomp = ProducoesFactory.getProducao(ProducoesEnum.indexorcomp).validaEGeraProducao(); 
						if (indexorcomp != null) {
							raiz.adicionaNoFilho(indexorcomp);
							this.descartaIndiceSalvo();
							isCaso1Valido = true;
						}	
					}				
				}
			}
		}			
		
		if (!isCaso1Valido) { 
			this.recuperarIndiceSalvo();
			raiz = new ArvoreSintaticaAbstrataNo("variableMore");
			
			if (isCaso2Valido) { // caso 2 - "." <nextitem>  <indexorcomp>
				isCaso2Valido = false;
				this.salvarIndiceTokenAtual();

				ArvoreSintaticaAbstrataNo next;
				ArvoreSintaticaAbstrataNo indexorcomp;
				
				if (this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho(".", this.getTokenAtual());
					
					next = ProducoesFactory.getProducao(ProducoesEnum.nextitem).validaEGeraProducao();
					if (next != null) {
						raiz.adicionaNoFilho(next);
					
						indexorcomp = ProducoesFactory.getProducao(ProducoesEnum.indexorcomp).validaEGeraProducao(); 
						if (indexorcomp != null) {
							raiz.adicionaNoFilho(indexorcomp);
							isCaso2Valido = true;
						}				
					}
				}		
			}
			
			if (!isCaso2Valido) {
				this.recuperarIndiceSalvo();
				raiz = new ArvoreSintaticaAbstrataNo("variableMore");
			}
		}
		
		isCaso3Valido = (!isCaso1Valido && !isCaso2Valido);

		return (isCaso1Valido || isCaso2Valido || isCaso3Valido) ? raiz : null;
	}

}
