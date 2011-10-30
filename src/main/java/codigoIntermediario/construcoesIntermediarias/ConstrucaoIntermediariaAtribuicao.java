package codigoIntermediario.construcoesIntermediarias;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class ConstrucaoIntermediariaAtribuicao extends ConstrucaoIntermediaria {

	private static ConstrucaoIntermediariaAtribuicao instancia;
	private ConstrucaoIntermediariaAtribuicao() {
		super();
		instancia = new ConstrucaoIntermediariaAtribuicao(); 
	}
	
	public static ConstrucaoIntermediariaAtribuicao getInstancia() {
		return instancia;
	}
	
	private void extraiVariaveisDeVariableAccessList(ArvoreSintaticaAbstrataNo variableAccessList) {
		
		for (ArvoreSintaticaAbstrataNo no : variableAccessList.getListaDeNos()) {
			if (no.getNome().equalsIgnoreCase("variableAccess")) {
				Token id = no.getListaDeNos().getFirst().getToken();
				if (id != null && id.getTokenType() == GCLTokenTypes.IDENTIFIER) {
					id.getValue();
					// TODO: Verificar como estruturar as variaveis para retorno
				}
			}
		}
	}
	
	private void processaExpressionList(ArvoreSintaticaAbstrataNo expressionList) {
		
		for (ArvoreSintaticaAbstrataNo expression : expressionList.getListaDeNos()) {
			
			if (expression.getNome().equalsIgnoreCase("expression")) {
				ConstrucaoIntermediariaExpression.getInstancia().traduz(expression);
			}
			
		}
	}	
	
	@Override
	public void traduz(ArvoreSintaticaAbstrataNo no) {
		this.extraiVariaveisDeVariableAccessList(no.getListaDeNos().getFirst());
		this.processaExpressionList(no.getListaDeNos().getLast());
	}	
	
	
}
