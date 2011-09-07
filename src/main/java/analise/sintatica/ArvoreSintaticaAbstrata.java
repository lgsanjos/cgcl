package analise.sintatica;

public class ArvoreSintaticaAbstrata {

	private ArvoreSintaticaAbstrataNo raiz;

	public ArvoreSintaticaAbstrataNo getRaiz() {
		return raiz;
	}

	public void setRaiz(ArvoreSintaticaAbstrataNo raiz) {
		this.raiz = raiz;
	}

	public String print() {

		if (this.raiz != null) {
			return this.raiz.print();
		}

		return "";

	}
}
