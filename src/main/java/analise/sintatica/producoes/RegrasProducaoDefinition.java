package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoDefinition extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> |<procedureDecl>
		boolean isValido = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("definition");
		if (isValido) {
			ArvoreSintaticaAbstrataNo definition;
			definition = ProducoesFactory.getProducao(ProducoesEnum.constantDef).validaEGeraProducao();
			isValido = (definition != null);
			raiz.adicionaNoFilho(definition);
		}
		
		return (isValido) ? raiz : null;
	}

}
