package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoParamPart extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		//"(" [ <paramDef> { ";" <paramDef> } ] )" 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("paramPart");
		boolean isValida = false;
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("(", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
				
			try {
				this.descartaIndiceSalvo();
				this.salvarIndiceTokenAtual();
				
				ArvoreSintaticaAbstrataNo paramDef = this.validaEGeraProducaoDadoProducao(ProducoesEnum.paramDef);
				raiz.adicionaNoFilho(paramDef);
				this.descartaIndiceSalvo();
			} catch (ProducaoSintaticaException e) {
				this.recuperarIndiceSalvo();
			}
				
			do {
				
				isValida = false;
				this.salvarIndiceTokenAtual();
				
				if (this.proximoTokenPossuiValorETipoIgualA(";", GCLTokenTypes.SYMBOL)) {
					Token tokenVirgula = this.getTokenAtual();
					
					try {
						ArvoreSintaticaAbstrataNo paramDef2;
						paramDef2 = this.validaEGeraProducaoDadoProducao(ProducoesEnum.paramDef);
						raiz.adicionaNoFilho(tokenVirgula);
						raiz.adicionaNoFilho(paramDef2);
						this.descartaIndiceSalvo();
						isValida = true;						
					} catch( ProducaoSintaticaException e) {
						isValida = false;
					}
				}
				
				if (! isValida) {
					this.recuperarIndiceSalvo();
				}
				
			} while (isValida);
			
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorETipoIgualA(")", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				this.descartaIndiceSalvo();
				return raiz;
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("paramPart");
		return null;
	}

}
