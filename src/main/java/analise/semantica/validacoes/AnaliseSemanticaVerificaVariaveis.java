package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class AnaliseSemanticaVerificaVariaveis extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		if (no.getNome().equalsIgnoreCase("assignStatement")) {
			
			ArvoreSintaticaAbstrataNo variableAccessList = no.getListaDeNos().getFirst();
			
			for (ArvoreSintaticaAbstrataNo variableAccess : variableAccessList.getListaDeNos())
				
				if (variableAccess.getNome().equalsIgnoreCase("variableAccess")) {
					Token identifier = variableAccess.getListaDeNos().getFirst().getToken();
					
					if (identifier.getTokenType() == GCLTokenTypes.IDENTIFIER)
						if (! TabelaDeSimbolos.contains(identifier.getValue()))
							throw new AnaliseSemanticaException("Variavel " + identifier.getValue() + " não foi declarada.");
				}	
			
		}
	}

}
