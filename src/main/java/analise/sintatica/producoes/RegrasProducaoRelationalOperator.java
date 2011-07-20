package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoRelationalOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		//<relationalOperator>	"<" | "=" | ">" | "<=" | ">=" | "#" 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("relationalOperator");
		boolean isValida = false;		
		this.getIndice().inc();
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA("<", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA("=", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA(">", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA("<=", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA(">=", GCLTokenTypes.SYMBOL);
		}
		
		if (! isValida) {
			this.getIndice().dec();
			isValida = this.proximoTokenPossuiValorETipoIgualA("#", GCLTokenTypes.SYMBOL);
		}
		
		raiz.adicionaNoFilho("relationalOperator", this.getTokenAtual());
		return (isValida) ? raiz : null;
	}

}
