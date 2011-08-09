package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanConstant");
		
		if (this.proximoTokenPossuiValorETipoIgualA("true", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
			return raiz;
		}
		
		this.voltaToken();
		
		if (  this.proximoTokenPossuiValorETipoIgualA("false", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
			return raiz;
		}
		
		return null;
	}

}
