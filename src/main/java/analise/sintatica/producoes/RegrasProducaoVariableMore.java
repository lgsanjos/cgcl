package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableMore extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
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
				raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
				
				expr = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
				if (expr != null) {
					raiz.adicionaNoFilho(expr);

					if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
						
						indexorcomp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.indexorcomp); 
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
					
					next = this.validaEGeraProducaoDadoProducao(ProducoesEnum.nextitem);
					if (next != null) {
						raiz.adicionaNoFilho(next);
						
						indexorcomp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.indexorcomp); 
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
		if (isCaso1Valido || isCaso2Valido || isCaso3Valido) {
			this.descartaIndiceSalvo();
			return raiz;
		}

		this.throwProducaoSintaticaException("variableMore");
		return null;
	}

}
