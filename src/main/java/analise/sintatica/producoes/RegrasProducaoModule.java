package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoModule extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "module" "identifier" <definitionPart> [ "private" ] [ <block> ] "."  
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("module");

		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("module", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual());

			if (this.proximoTokenEhUmIdentificador()) {
				raiz.adicionaNoFilho(this.getTokenAtual());

				ArvoreSintaticaAbstrataNo definitionPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.definitionPart);
				if (definitionPart != null) {
					raiz.adicionaNoFilho(definitionPart);

					this.descartaIndiceSalvo();
					this.salvarIndiceTokenAtual();

					if (this.proximoTokenPossuiValorETipoIgualA("private", GCLTokenTypes.KEYWORD)) {
						raiz.adicionaNoFilho(this.getTokenAtual());
						this.descartaIndiceSalvo();
					} else {
						this.recuperarIndiceSalvo();
					}
					
					this.salvarIndiceTokenAtual();

					ArvoreSintaticaAbstrataNo block = this.validaEGeraProducaoDadoProducao(ProducoesEnum.block);
					if (block != null) {
						raiz.adicionaNoFilho(block);
						this.descartaIndiceSalvo();
					} else {
						this.recuperarIndiceSalvo();
					}
					
					this.salvarIndiceTokenAtual();
					
					if (this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho(this.getTokenAtual());
						this.descartaIndiceSalvo();
						return raiz;						
					}
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("module");
		return null;
				
	}

}
