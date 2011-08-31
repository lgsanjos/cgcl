package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTypeSymbol extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "integer" | "Boolean"  | "identifier" 
				
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("typeSymbol");
		String[] simbolos = { "integer", "string", "boolean", "real"};		
		
		this.salvarIndiceTokenAtual();
		this.avancaProximoToken();
		
		if (this.getTokenAtual() != null) {
			for (int i = 0; i < simbolos.length; i++) {
				if (this.getTokenAtual().getValue().equalsIgnoreCase(simbolos[i])) {
					raiz.adicionaNoFilho(this.getTokenAtual());
					this.descartaIndiceSalvo();					
					return raiz;
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenEhUmIdentificador()) {
			this.descartaIndiceSalvo();
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("typeSymbol");
		return null;
		
	}

}
