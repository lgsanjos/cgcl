package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class AnaliseSemanticaAdicionaTabelaDeSimbolos extends AnaliseSemanticaAcaoAbstrata {

	@Override	
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		Token token = no.getToken();
		if (token != null && token.getTokenType().equals(GCLTokenTypes.IDENTIFIER)) {
			this.identificaNoPai(no);
		}
		
	}
	
	private void identificaNoPai(ArvoreSintaticaAbstrataNo no) {
		
		if (no.getNoPai().getNome().equalsIgnoreCase("constantName")) {
			
		}
		/*
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
			
		}	*/	
	}

}
