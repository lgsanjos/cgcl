package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class AnaliseSemanticaAdicionaTabelaDeSimbolos extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		if (no.getNome().equalsIgnoreCase("constantDef")) {
			
		}
		
		if (no.getNome().equalsIgnoreCase("typeDef")) {
			
		}
		
		if (no.getNome().equalsIgnoreCase("variableDef")) {
			
		}
		
		if (no.getNome().equalsIgnoreCase("procedureDef")) {
			
		}
		
		if (no.getNome().equalsIgnoreCase("paramDef")) {
			
		}		
		
	}

}
