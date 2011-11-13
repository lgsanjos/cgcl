package codigoIntermediario;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediariaCallStatement;
import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediariaIfStatement;
import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediariaProcDeclaration;
import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediariaWriteStatement;

public class GeradorDeCodigoIntermediario {
	
	private static GeradorDeCodigoIntermediario instance; 
	
	private GeradorDeCodigoIntermediario() {
		super();
	}
	
	private boolean isBlocoPrincipal(ArvoreSintaticaAbstrataNo bloco) {
		ArvoreSintaticaAbstrataNo block = bloco.getNoPai();
		return bloco.getNome().equalsIgnoreCase("begin") &&
					block.getNome().equalsIgnoreCase("block") &&
					block.getNoPai().getNome().equalsIgnoreCase("module");
	}
	
	private void processaNo(ArvoreSintaticaAbstrataNo no) {
						
		if (isBlocoPrincipal(no)) {
			CodigoIntermediario.addLabel("_main:");
		}
		
		if (no.getNome().equalsIgnoreCase("procedureDecl")) {
			ConstrucaoIntermediariaProcDeclaration.getInstancia().traduz(no);
		}
		
		if (no.getNome().equalsIgnoreCase("callStatement")) {
			ConstrucaoIntermediariaCallStatement.getInstancia().traduz(no);
		}		
		
		if (no.getNome().equalsIgnoreCase("writeStatement")) {
			ConstrucaoIntermediariaWriteStatement.getInstancia().traduz(no);
		}
		
		if (no.getNome().equalsIgnoreCase("ifStatement")) {
			ConstrucaoIntermediariaIfStatement.getInstancia().traduz(no);
		}
		
		if (no.getNome().equalsIgnoreCase("emptyStatement")) {
			CodigoIntermediario.addNoOperation();
		}		
	}
	
	private void percorreAvoreSintatica(ArvoreSintaticaAbstrataNo noInicial) {
		
		this.processaNo(noInicial);
		
		for (ArvoreSintaticaAbstrataNo no : noInicial.getListaDeNos())
			this.percorreAvoreSintatica(no);
	}

	public static void traduz(ArvoreSintaticaAbstrataNo noRaiz) {
		if (instance == null)
			instance = new GeradorDeCodigoIntermediario();
		
		CodigoIntermediario.limpar();
		instance.percorreAvoreSintatica(noRaiz);
	}

}
