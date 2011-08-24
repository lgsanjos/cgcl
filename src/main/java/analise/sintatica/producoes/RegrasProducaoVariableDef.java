package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException  {
		// <type> <variableList>  
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableDef");
		
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo type = this.validaEGeraProducaoDadoProducao(ProducoesEnum.type);
		if (type != null) {
			raiz.adicionaNoFilho(type);
		
			ArvoreSintaticaAbstrataNo variableList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableList);
			if (variableList != null) {
				raiz.adicionaNoFilho(variableList);
				this.descartaIndiceSalvo();
				return raiz;
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("variableDef");
		return null;
	}

}
