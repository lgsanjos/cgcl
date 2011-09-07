package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDoStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "do" <guardedCommandList> "od" 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("doStatement");
		ArvoreSintaticaAbstrataNo guardedCommandList = null;
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("do", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			
			try {
				guardedCommandList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.guardedCommandList);
			} catch (ProducaoSintaticaException e) {
			  	
			}
			if (guardedCommandList != null) {
				raiz.adicionaNoFilho(guardedCommandList);
				
				if (this.proximoTokenPossuiValorETipoIgualA("od", GCLTokenTypes.KEYWORD)) {
					raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
					this.descartaIndiceSalvo();
					return raiz;
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("doStatement");
		return null;
	}

}
