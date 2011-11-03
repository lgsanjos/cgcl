package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class ConstrucaoIntermediariaCallStatement extends
		ConstrucaoIntermediaria {

	private static ConstrucaoIntermediaria instancia;
	private ConstrucaoIntermediariaCallStatement() {
		super();
	}
	
	public static ConstrucaoIntermediariaCallStatement getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaCallStatement();
		
		return (ConstrucaoIntermediariaCallStatement) instancia;
	}
	
	@Override
	public String traduz(ArvoreSintaticaAbstrataNo no) {
		if (no.getNome().equalsIgnoreCase("callStatement")) {
			int contadorDeParametros = 0;
			
			ArvoreSintaticaAbstrataNo argumentList = no.getListaDeNos().getLast();
			if (argumentList.getListaDeNos().size() == 3) {
				ArvoreSintaticaAbstrataNo expressionList = argumentList.getListaDeNos().get(1);
				
				String expressionResult = "";
				for (ArvoreSintaticaAbstrataNo expression : expressionList.getListaDeNos()) {
					if (expression.getNome().equalsIgnoreCase("expression"))
						expressionResult = ConstrucaoIntermediariaExpression.getInstancia().traduz(expression);
						CodigoIntermediario.addParam(expressionResult);
						contadorDeParametros++;
				}
				
			}
			String nomeDoProcedure = no.getListaDeNos().getFirst().getToken().getValue();
			CodigoIntermediario.addCall(nomeDoProcedure, contadorDeParametros);
		}
		return "";
	}

}
