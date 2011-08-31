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
		this.avancaProximoToken();
		if (this.getTokenAtual() == null) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("paramDef");			
		}
		
		if (this.getTokenAtual().getValue().equals("val") || this.getTokenAtual().getValue().equals("ref")) {
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
