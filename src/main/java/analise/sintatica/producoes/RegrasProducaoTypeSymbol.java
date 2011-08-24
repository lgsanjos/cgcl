package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTypeSymbol extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <typeSymbol> "integer" | "Boolean"  | "identifier" 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("typeSymbol");
		boolean isValida = false;
		this.salvarIndiceTokenAtual();

		this.avancaProximoToken();
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("integer", GCLTokenTypes.KEYWORD);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("string", GCLTokenTypes.KEYWORD);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("boolean", GCLTokenTypes.KEYWORD);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("real", GCLTokenTypes.KEYWORD);
		}		
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenEhUmIdentificador();
		}
		
		if (isValida) {
			this.descartaIndiceSalvo();
			raiz.adicionaNoFilho("typeSymbol", this.getTokenAtual());
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("typeSymbol");
		return null;
	}

}
