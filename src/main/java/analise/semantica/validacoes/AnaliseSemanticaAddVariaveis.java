package analise.semantica.validacoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;

public class AnaliseSemanticaAddVariaveis extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		if (no.getNome().equalsIgnoreCase("variableDef") && ! no.getNoPai().getNome().equalsIgnoreCase("paramDef")) {
			String tipagem = "";			
		
			for (ArvoreSintaticaAbstrataNo filho : no.getListaDeNos()) {			

				if (filho.getNome().equalsIgnoreCase("type"));
					tipagem = AnaliseSemanticaHelper.procuraTipagemApatirDeUmType(filho);
					
				this.procuraEAdicionaVariaveis(filho, tipagem);
			}
		}	
	}
	
	private void procuraEAdicionaVariaveis(ArvoreSintaticaAbstrataNo variableListNo, String tipo) throws AnaliseSemanticaException {

		if (variableListNo.getNome().equalsIgnoreCase("variableList")) {
			for (ArvoreSintaticaAbstrataNo no : variableListNo.getListaDeNos()) {
				if (no.getToken().getTokenType() == GCLTokenTypes.IDENTIFIER)
					TabelaDeSimbolos.getInstance().addVariavel(no.getToken().getValue(), tipo);
			}
		}		
	}

}
