package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.SimboloAbstract;
import analise.tabelaDeSimbolos.SimboloFuncao;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;
import coretypes.Token;

public class AnaliseSemanticaVerificaProcedures extends	AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		if (no.getNome().equalsIgnoreCase("callStatement")) {
			SimboloAbstract proc = null;
			Token procIdentifier = no.getListaDeNos().getFirst().getToken();
			
			if (procIdentifier != null) {
				proc = TabelaDeSimbolos.getSimbolo(procIdentifier.getValue());
				if (proc == null || ! proc.isFuncao())
					throw new AnaliseSemanticaException("O procedimento " +  procIdentifier.getValue() + " não foi declarado.");
			}
		
			ArvoreSintaticaAbstrataNo argumentLists = no.getListaDeNos().getLast();
			if (argumentLists.getNome().equalsIgnoreCase("argumentList")) {
				if (argumentLists.getListaDeNos().size() == 3) {
					ArvoreSintaticaAbstrataNo expressionLists = argumentLists.getListaDeNos().get(1);
					
					int contadorDeParametros = 0;
					for (ArvoreSintaticaAbstrataNo expression : expressionLists.getListaDeNos()) {
						if (expression.getNome().equalsIgnoreCase("expression"))
							contadorDeParametros ++;
					}
					
					if (((SimboloFuncao) proc).getParametros().size() == contadorDeParametros)
						throw new AnaliseSemanticaException("Quantidade de parametros inválidos para o procedimento: " +  procIdentifier.getValue());	
				}	
			}
		}	
	}

}
