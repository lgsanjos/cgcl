package analise.semantica.validacoes;

import java.util.ArrayList;

import analise.exceptions.AnaliseSemanticaException;
import analise.semantica.Parametro;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class AnaliseSemanticaAddProcedures extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		// "proc" "identifier" [<paramPart>]
		if (no.getNome().equalsIgnoreCase("procedureDecl")) {
			String nome = "";
			String referencia = "";
			String tipagem = "";
			ArrayList<Parametro> parametros = new ArrayList<Parametro>();
			
			Token id = no.getListaDeNos().get(1).getToken();
			if (id.getTokenType() == GCLTokenTypes.IDENTIFIER) {
				nome = id.getValue(); 
			}
			
			// verificar paramPart e como passa-los pro Simbolo
			ArvoreSintaticaAbstrataNo paramPartNo = no.getListaDeNos().getLast();
			if (paramPartNo.getNome().equalsIgnoreCase("paramPart")) {
				
				for (ArvoreSintaticaAbstrataNo paramDef : paramPartNo.getListaDeNos()) {
					
					if (paramDef.getNome().equalsIgnoreCase("paramDef")) {
						ArvoreSintaticaAbstrataNo rel = paramDef.getListaDeNos().getFirst();
						ArvoreSintaticaAbstrataNo type = paramDef.getListaDeNos().getLast();
						
						referencia = rel.getNome();
						tipagem = AnaliseSemanticaHelper.procuraTipagemApatirDeUmType(type);
						
						parametros.add(new Parametro(nome, tipagem, referencia));
					}
				}
			}
			
			TabelaDeSimbolos.getInstance().addFuncao(nome, parametros);
		}
	}

}
