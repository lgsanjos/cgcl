package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoAddingOperator extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "+" | "-"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("addingOperator");
		this.salvarIndiceTokenAtual();
		
		if ((this.proximoTokenPossuiValorETipoIgualA("+", GCLTokenTypes.SYMBOL)) ||
				(this.proximoTokenPossuiValorETipoIgualA("-", GCLTokenTypes.SYMBOL))) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				this.descartaIndiceSalvo();
				return raiz;
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("booleanOperator");
		return null;
	}

}
