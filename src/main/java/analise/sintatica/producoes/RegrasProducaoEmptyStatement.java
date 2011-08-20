package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoEmptyStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {

		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("emptyStatement");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("skip", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("skip", this.getTokenAtual());
			this.descartaIndiceSalvo();
			return raiz;
		}
			
		this.recuperarIndiceSalvo();
		
		// TODO: throw exception (avaliar se precisa)
		return null;
	}

}
