package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoConstantDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "const" <constantName> "=" <constant>
		boolean isValida = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("constantDef");
		
		this.salvarIndiceTokenAtual();
		
		if (isValida) {
			isValida &= this.proximoTokenPossuiValorETipoIgualA("const", GCLTokenTypes.KEYWORD);
			raiz.adicionaNoFilho("const",this.getTokenAtual());			
		}	
		
		if (isValida) {
			ArvoreSintaticaAbstrataNo constantName;
			constantName = this.validaEGeraProducaoDadoProducao(ProducoesEnum.constantName);
			isValida &= ( constantName != null);
			raiz.adicionaNoFilho(constantName);
		}	
		
		if (isValida) {
			isValida &= this.proximoTokenPossuiValorETipoIgualA("=", GCLTokenTypes.SYMBOL);
			raiz.adicionaNoFilho("=", this.getTokenAtual());
		}	
		
		if (isValida) {
			ArvoreSintaticaAbstrataNo constant;
			constant = this.validaEGeraProducaoDadoProducao(ProducoesEnum.constant);
			if (constant != null) {
				raiz.adicionaNoFilho(constant);
				this.descartaIndiceSalvo();
				return raiz;
			}	
		}	
		
		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return  null;
	}

}
