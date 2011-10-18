package analise.semantica.validacoes;

import analise.TabelaDeSimbolos;
import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class AnaliseSemanticaAdicionaTabelaDeSimbolos extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		
		if (no.getNome().equalsIgnoreCase("constantName")) {
			ArvoreSintaticaAbstrataNo constante = no.getListaDeNos().get(0);
			TabelaDeSimbolos.getInstance().add(constante.getToken());
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
