package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoRelationalOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		//<relationalOperator>	"<" | "=" | ">" | "<=" | ">=" | "#" 

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("relationalOperator");
		boolean isValida = false;		
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
		
		raiz.adicionaNoFilho("relationalOperator", this.getTokenAtual());
		return (isValida) ? raiz : null;
	}

}
