package codigoIntermediario;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediariaAtribuicao;

public class GeradorDeCodigoIntermediario {
	
	private static GeradorDeCodigoIntermediario instance; 
	
	private GeradorDeCodigoIntermediario() {
		super();
	}
	
	private void processaNo(ArvoreSintaticaAbstrataNo no) {
		
		if (no.getNome().equalsIgnoreCase("assignStatement")) {
			ConstrucaoIntermediariaAtribuicao.getInstancia().traduz(no);
		}
		
		if (no.getNome().equalsIgnoreCase("ifStatement")) {
		}
		
		if (no.getNome().equalsIgnoreCase("writeStatement")) {
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
