package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoRelationalOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		//<relationalOperator>	"<" | "=" | ">" | "<=" | ">=" | "#" 

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("relationalOperator");
		String[] simbolosAceitos = {"<","=", ">", "<=", ">=", "#"};
		
		this.salvarIndiceTokenAtual();
		this.avancaProximoToken();
		
		if (this.getTokenAtual() != null) {
			for ( int i = 0; i < simbolosAceitos.length; i++) {
				if ( this.getTokenAtual().getValue().equalsIgnoreCase(simbolosAceitos[i]) ) {
					raiz.adicionaNoFilho(this.getTokenAtual());
					this.descartaIndiceSalvo();
					return raiz;
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("relationalOperator");
		return null;
	}

}
