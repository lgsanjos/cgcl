package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoIfStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "if" <guardedCommandList> "fi"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("ifStatement");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("if", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			
			ArvoreSintaticaAbstrataNo guardedCommandList;
			guardedCommandList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.guardedCommandList);
			if (guardedCommandList != null) {
				raiz.adicionaNoFilho(guardedCommandList);
				
				if (this.proximoTokenPossuiValorETipoIgualA("fi", GCLTokenTypes.KEYWORD)) {
					raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
					this.descartaIndiceSalvo();
					return raiz;
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("ifStatement");
		return null;
	}

}
