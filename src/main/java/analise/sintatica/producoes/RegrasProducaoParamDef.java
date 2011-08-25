package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoParamDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// ( "val" | "ref" ) <variableDef>
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("paramDef");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("val", GCLTokenTypes.KEYWORD) || 
				this.proximoTokenPossuiValorETipoIgualA("ref", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			
			ArvoreSintaticaAbstrataNo variableDef = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableDef);
			if (variableDef != null) {
				raiz.adicionaNoFilho(variableDef);
				this.descartaIndiceSalvo();
				return raiz;
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("paramDef");
		return null;
	}

}
