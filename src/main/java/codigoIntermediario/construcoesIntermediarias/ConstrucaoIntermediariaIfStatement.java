package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class ConstrucaoIntermediariaIfStatement extends ConstrucaoIntermediaria {

	private static ConstrucaoIntermediariaIfStatement instancia;
	
	private ConstrucaoIntermediariaIfStatement() {
		super();
	}
	
	public static ConstrucaoIntermediariaIfStatement getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaIfStatement();
		
		return instancia;
	}
	
	@Override
	public String traduz(ArvoreSintaticaAbstrataNo no) {
		
		if (no.getNome().equalsIgnoreCase("ifStatement")) {
			ArvoreSintaticaAbstrataNo guardedCommandList = no.getListaDeNos().get(1);
			
			for (ArvoreSintaticaAbstrataNo guarded : guardedCommandList.getListaDeNos()) {
				if (guarded.getNome().equalsIgnoreCase("guardedCommand")) {
					String expression = ConstrucaoIntermediariaExpression.getInstancia().traduz(guarded.getListaDeNos().getFirst());
					String labelIfFalse = CodigoIntermediario.jumpIfFalse(expression);					
					ConstrucaoIntermediariaStatementPart.getInstancia().traduz(guarded.getListaDeNos().getLast());
					
					CodigoIntermediario.addLabel(labelIfFalse);
				}
			}
		}
			
		return "";
	}

}
