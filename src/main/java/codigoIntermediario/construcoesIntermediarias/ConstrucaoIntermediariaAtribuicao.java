package codigoIntermediario.construcoesIntermediarias;

import java.util.LinkedList;
import java.util.List;

import codigoIntermediario.CodigoIntermediario;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class ConstrucaoIntermediariaAtribuicao extends ConstrucaoIntermediaria {

	private static ConstrucaoIntermediariaAtribuicao instancia;
	private ConstrucaoIntermediariaAtribuicao() {
		super();
	}
	
	public static ConstrucaoIntermediariaAtribuicao getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaAtribuicao();
		
		return instancia;
	}
	
	private List<String> extraiVariaveisDeVariableAccessList(ArvoreSintaticaAbstrataNo variableAccessList) {
		
		List<String> variaveisTemp = new LinkedList<String>();
		
		for (ArvoreSintaticaAbstrataNo no : variableAccessList.getListaDeNos()) {
			if (no.getNome().equalsIgnoreCase("variableAccess")) {
				Token id = no.getListaDeNos().getFirst().getToken();
				if (id != null && id.getTokenType() == GCLTokenTypes.IDENTIFIER)
					variaveisTemp.add(id.getValue());					
			}
		}
		return variaveisTemp;
	}
	
	private List<String> processaExpressionList(ArvoreSintaticaAbstrataNo expressionList) {
		
		List<String> variaveisTemporarias = new LinkedList<String>();
		
		for (ArvoreSintaticaAbstrataNo expression : expressionList.getListaDeNos()) {
			if (expression.getNome().equalsIgnoreCase("expression")) 
				variaveisTemporarias.add(ConstrucaoIntermediariaExpression.getInstancia().traduz(expression));
		}
		
		return variaveisTemporarias;
	}	
	
	@Override
	public String traduz(ArvoreSintaticaAbstrataNo no) {
		List<String> listaVariaveis, listaExpressoes;

		listaVariaveis = this.extraiVariaveisDeVariableAccessList(no.getListaDeNos().getFirst());
		listaExpressoes = this.processaExpressionList(no.getListaDeNos().getLast());
		
		for (int i = 0; i < listaVariaveis.size() && i < listaExpressoes.size(); i++) {
			CodigoIntermediario.add(":=", listaExpressoes.get(i), "", listaVariaveis.get(i));
		}
		
		return "";
	}	
	
	
}
