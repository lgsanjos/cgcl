package analise.sintatica;

public class ArvoreSintaticaAbstrata {

	private ArvoreSintaticaAbstrataNo raiz;
	private String printBuffer;

	public ArvoreSintaticaAbstrataNo getRaiz() {
		return raiz;
	}

	public void setRaiz(ArvoreSintaticaAbstrataNo raiz) {
		this.raiz = raiz;
	}

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

	public String print() {
		this.printBuffer = "";
		if (this.raiz != null) {
			this.printNosFilhos(this.raiz, 0);
		} 

		return this.printBuffer;

	}

}
