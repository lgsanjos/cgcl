package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class ConstrucaoIntermediariaWriteStatement extends ConstrucaoIntermediaria {

	private static ConstrucaoIntermediaria instancia;
	private ConstrucaoIntermediariaWriteStatement() {
		super();
	}

	public static ConstrucaoIntermediariaWriteStatement getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaWriteStatement();

		return (ConstrucaoIntermediariaWriteStatement) instancia;
	}

	@Override
	public String traduz(ArvoreSintaticaAbstrataNo no) {
		if (no.getNome().equalsIgnoreCase("writeStatement")) {
			String parametroImpressao = "";
			for (ArvoreSintaticaAbstrataNo write : no.getListaDeNos()) {
				if (write.getNome().equalsIgnoreCase("writeItem")) {
					
					ArvoreSintaticaAbstrataNo writeItemFilho = write.getListaDeNos().getFirst();
					if (writeItemFilho.getNome().equalsIgnoreCase("expression")) {
						// id ou numero
						String var = ConstrucaoIntermediariaExpression.getInstancia().traduz(writeItemFilho);
						CodigoIntermediario.addParam(var);
						parametroImpressao += "%d";
					} else {
						// string
						parametroImpressao += writeItemFilho.getToken().getValue();
					}
				}
			}
			CodigoIntermediario.addWriteStatement(parametroImpressao);
		}
		
		return "";
	}

}
