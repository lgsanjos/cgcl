package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTypeSymbol extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		// <typeSymbol> "integer" | "Boolean"  | "identifier" 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("typeSymbol");
		boolean isValida = false;		
		this.getIndice().inc();
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA("integer", GCLTokenTypes.KEYWORD);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA("string", GCLTokenTypes.KEYWORD);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenEhUmIdentificador();
		}
				
		raiz.adicionaNoFilho("typeSymbol", this.getTokenAtual());
		return (isValida) ? raiz : null;
	}

}
