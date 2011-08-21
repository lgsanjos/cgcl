package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoArrayType extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "array" "[" "identifier" "]" {"[" "identifier" "]"}
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("arrayType");
		boolean isValida = false;
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("array", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			
			if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				
				if (this.proximoTokenEhUmIdentificador()) {
					raiz.adicionaNoFilho("identificador", this.getTokenAtual());
					
					if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho(this.getTokenAtual());
						this.descartaIndiceSalvo();
						isValida = true;
					}
				}
			}
		}
		
		if (! isValida) {
			this.recuperarIndiceSalvo();
			// TODO: throw exception
			return null;
		}
		
		do {
			isValida = false;
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				
				if (this.proximoTokenEhUmIdentificador()) {
					raiz.adicionaNoFilho("identificador", this.getTokenAtual());
					
					if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho(this.getTokenAtual());
						this.descartaIndiceSalvo();
						isValida = true;
					}
				}
			}
			
			if (! isValida) {
				this.recuperarIndiceSalvo();
			}
			
		} while (isValida);
		
		return raiz;
	}

}
