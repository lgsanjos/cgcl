package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBooleanConstant extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("booleanConstant");

		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("true", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.salvarIndiceTokenAtual();
		
		if (  this.proximoTokenPossuiValorETipoIgualA("false", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("booleanConstant", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("booleanConstant");
		return null;
	}

}
