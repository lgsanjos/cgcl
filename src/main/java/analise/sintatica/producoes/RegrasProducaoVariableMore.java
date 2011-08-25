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
				
				try {
					expr = this.validaEGeraProducaoDadoProducao(ProducoesEnum.expression);
					raiz.adicionaNoFilho(expr);

					if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
						
						try {
							indexorcomp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.indexorcomp); 
							raiz.adicionaNoFilho(indexorcomp);
							this.descartaIndiceSalvo();
							isCaso1Valido = true;
						} catch (ProducaoSintaticaException e) {
							//
						}
					}				
				} catch (ProducaoSintaticaException e) {
					//
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
					try {
						next = this.validaEGeraProducaoDadoProducao(ProducoesEnum.nextitem);
						raiz.adicionaNoFilho(next);
						
						indexorcomp = this.validaEGeraProducaoDadoProducao(ProducoesEnum.indexorcomp); 
						raiz.adicionaNoFilho(indexorcomp);
						isCaso2Valido = true;
					} catch (ProducaoSintaticaException e) {
						//
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
