package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoMultiplyOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("multiplyOperator");
		
		if (isValida) {
			
			if ( ! this.proximoTokenPossuiValorETipoIgualA("*", GCLTokenTypes.SYMBOL)) {
				this.voltaToken();
				
				if ( ! this.proximoTokenPossuiValorETipoIgualA("/", GCLTokenTypes.SYMBOL)) {
					this.voltaToken();
					
					if ( ! this.proximoTokenPossuiValorETipoIgualA("\"", GCLTokenTypes.SYMBOL)) {
						this.voltaToken();
						isValida = false;						
					}
				}
			}
			
			raiz.adicionaNoFilho("multiplyOperator", this.getTokenAtual());
		}
		
		if (isValida) {
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("multiplyOperator");
		return null;
	}

}
