package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoRelationalOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		//<relationalOperator>	"<" | "=" | ">" | "<=" | ">=" | "#" 

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("relationalOperator");
		boolean isValida = false;
		
		this.salvarIndiceTokenAtual();
		this.avancaProximoToken();

		// TODO: refatorar esse método		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("<", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("=", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA(">", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("<=", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA(">=", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.voltaToken();
			isValida = this.proximoTokenPossuiValorETipoIgualA("#", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.recuperarIndiceSalvo();
			return null;
		}
		
		this.descartaIndiceSalvo();
		raiz.adicionaNoFilho("relationalOperator", this.getTokenAtual());
		return raiz;
	}

}
