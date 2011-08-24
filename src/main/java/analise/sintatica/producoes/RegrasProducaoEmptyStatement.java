package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoEmptyStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("emptyStatement");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("skip", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("skip", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}
			
		this.recuperarIndiceSalvo();
		
		this.throwProducaoSintaticaException("emptyStatement");
		return null;
	}

}
