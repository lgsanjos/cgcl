package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstantDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "const" <constantName> "=" <constant>
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constantDef");
		
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("const", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho("const",this.getTokenAtual());
			
			try {
				
				ArvoreSintaticaAbstrataNo constantName = this.validaEGeraProducaoDadoProducao(ProducoesEnum.constantName);
				raiz.adicionaNoFilho(constantName);
				
				if (this.proximoTokenPossuiValorETipoIgualA("=", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho("=", this.getTokenAtual());

					ArvoreSintaticaAbstrataNo constant = this.validaEGeraProducaoDadoProducao(ProducoesEnum.constant);
					raiz.adicionaNoFilho(constant);
					this.descartaIndiceSalvo();
					return raiz;					
				}	
			} catch(ProducaoSintaticaException e) {
				//
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("constantDef");
		return null;
	}

}
