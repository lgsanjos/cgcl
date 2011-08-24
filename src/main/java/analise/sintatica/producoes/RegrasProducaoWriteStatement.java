package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoWriteStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "write" <writeItem> {"," <writeItem> }
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("writeStatement");
		boolean isValida;
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("write", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			
			ArvoreSintaticaAbstrataNo writeItem;
			writeItem = this.validaEGeraProducaoDadoProducao(ProducoesEnum.writeItem);
			if (writeItem != null) {
				raiz.adicionaNoFilho(writeItem);
				this.descartaIndiceSalvo();
			}
		} else {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("writeStatement");
			return null;
		}
		
		
		
		do {
			isValida = false;
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorETipoIgualA(",", GCLTokenTypes.SYMBOL)) {
				Token tokenVirgula = this.getTokenAtual();
				
				ArvoreSintaticaAbstrataNo writeItemAdicional;
				writeItemAdicional = this.validaEGeraProducaoDadoProducao(ProducoesEnum.writeItem);
				if (writeItemAdicional != null) {
					isValida = true;
					raiz.adicionaNoFilho(tokenVirgula.getValue(), tokenVirgula);
					raiz.adicionaNoFilho(writeItemAdicional);
					this.descartaIndiceSalvo();
				}
			}
			
			if (! isValida) {
				this.recuperarIndiceSalvo();
			}
			
		} while(isValida);
		
		return raiz;
	}

}
