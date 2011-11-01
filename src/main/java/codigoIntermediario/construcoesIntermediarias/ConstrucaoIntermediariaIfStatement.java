package codigoIntermediario.construcoesIntermediarias;

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
		return null;
	}

}
