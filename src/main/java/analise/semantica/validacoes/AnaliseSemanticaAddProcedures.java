package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class AnaliseSemanticaAddProcedures extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		// "proc" "identifier" [<paramPart>]
		if (no.getNome().equalsIgnoreCase("procedureDecl")) {
			String nome = "";
			
			Token id = no.getListaDeNos().get(1).getToken();
			if (id.getTokenType() == GCLTokenTypes.IDENTIFIER) {
				nome = id.getValue(); 
			}
			
			// verificar paramPart e como passa-los pro Simbolo
		}
	}

}
