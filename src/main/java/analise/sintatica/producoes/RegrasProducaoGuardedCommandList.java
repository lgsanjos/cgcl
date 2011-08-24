package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoGuardedCommandList extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <guardedCommand> {"[]" <guardedCommand>}  
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("guardedCommandList");
		boolean isValida;
		
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo guardedCommand;
		guardedCommand = this.validaEGeraProducaoDadoProducao(ProducoesEnum.guardedCommand);
		if (guardedCommand == null) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("guardedCommandList");
			return null;
		}
		
		this.descartaIndiceSalvo();
		raiz.adicionaNoFilho(guardedCommand);
		
		do {
			isValida = false;
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorETipoIgualA("[]", GCLTokenTypes.SYMBOL)) {
				Token tokenGuarda = this.getTokenAtual();
				
				ArvoreSintaticaAbstrataNo guardedCommandAdicional;
				guardedCommandAdicional = this.validaEGeraProducaoDadoProducao(ProducoesEnum.guardedCommand);
				if (guardedCommandAdicional != null) {
					raiz.adicionaNoFilho(tokenGuarda.getValue(), tokenGuarda);
					raiz.adicionaNoFilho(guardedCommandAdicional);
					
					this.descartaIndiceSalvo();
					isValida = true;
				}
			}
			
			if (! isValida) {
				this.recuperarIndiceSalvo();
			}
			
		} while (isValida);
		
		return raiz;
	}


}
