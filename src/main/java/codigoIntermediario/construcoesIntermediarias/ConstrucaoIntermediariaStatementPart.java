package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class ConstrucaoIntermediariaStatementPart extends ConstrucaoIntermediaria {

	private static ConstrucaoIntermediaria instancia;
	private ConstrucaoIntermediariaStatementPart() {
		super();
	}
	
	public static ConstrucaoIntermediariaStatementPart getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaStatementPart();
		
		return (ConstrucaoIntermediariaStatementPart) instancia;
	}
	
	@Override
	public String traduz(ArvoreSintaticaAbstrataNo no) {
		
		for (ArvoreSintaticaAbstrataNo statement : no.getListaDeNos()) {
			if (statement.getNome().equalsIgnoreCase("statement")) {
				
				ArvoreSintaticaAbstrataNo statementFilho = statement.getListaDeNos().getFirst();
				
				if (statementFilho.getNome().equalsIgnoreCase("emptyStatement")) {
					CodigoIntermediario.addNoOperation();
				}
				
				if (statementFilho.getNome().equalsIgnoreCase("ifStatement")) {
					ConstrucaoIntermediariaIfStatement.getInstancia().traduz(statementFilho);
				}
				
				if (statementFilho.getNome().equalsIgnoreCase("callStatement")) {
					ConstrucaoIntermediariaCallStatement.getInstancia().traduz(statementFilho);
				}
				
				if (statementFilho.getNome().equalsIgnoreCase("writeStatement")) {
					ConstrucaoIntermediariaWriteStatement.getInstancia().traduz(statementFilho);
				}
				
			}
		}
		
		return "";
	}

}
