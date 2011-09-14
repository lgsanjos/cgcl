package analise.sintatica;


public class ArvoreSinstaticaAbstrataNoHelper {
	
	private static ArvoreSinstaticaAbstrataNoHelper instancia = new ArvoreSinstaticaAbstrataNoHelper(); 
	private static String printBuffer;
	
	private void printNosFilhos(ArvoreSintaticaAbstrataNo no, Integer identacao) {

		printNo(no, identacao);
		for (int i = 0; i < no.quatidadeNosFilhos(); i++) {
			printNosFilhos(no.getListaDeNos().get(i), identacao + 2);
		}
	}

	private void printNo(ArvoreSintaticaAbstrataNo no, Integer identacao) {
		String espaco = "";
		for (int i = 0; i < identacao; i++) {
			espaco = espaco + " ";
		}

		if (no.possueNosFilhos()) {

			printBuffer = printBuffer + espaco + no.getNome();
			printBuffer = (printBuffer + "\n");
		} else {
			if (no.getToken() != null) {
				printBuffer = (printBuffer + espaco
						+ no.getToken().getTokenType() + "." + no.getToken().getValue());
				printBuffer = (printBuffer + "\n");

			}
		}

	}	
	
	public static String printNosFilhos(ArvoreSintaticaAbstrataNo raiz) {
		printBuffer = "";
		if (raiz != null) {
			instancia.printNosFilhos(raiz, 0);
		} 
		return printBuffer;		
	}
	
}
