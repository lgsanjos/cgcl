package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoReadStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("readStatement");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("read", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			
			this.descartaIndiceSalvo();
			this.salvarIndiceTokenAtual();
			
			ArvoreSintaticaAbstrataNo variableList;
			variableList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableAccessList);
			
			if (variableList != null) {
				raiz.adicionaNoFilho(variableList);
				this.descartaIndiceSalvo();
				return raiz;
			}
		}

		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
