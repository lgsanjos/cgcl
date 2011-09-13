package analise.semantica;

import coretypes.StringList;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class AnaliseSemantica {
	
	private StringList ListaDeErros;  
	
	public AnaliseSemantica() {
		this.ListaDeErros = new StringList();
	}
	
	private void analisaNo(ArvoreSintaticaAbstrataNo no) {
		
	}
	
	private void navegaNaArvore(ArvoreSintaticaAbstrataNo raiz) {

		ArvoreSintaticaAbstrataNo no = raiz;
		this.analisaNo(no);
		
		for (int i = 0; i <= no.quatidadeNosFilhos(); i++ ) {
			this.navegaNaArvore(no.getListaDeNos().get(i));
		}
	}
		
	public boolean analisarASA(ArvoreSintaticaAbstrataNo raiz) {
		
		this.navegaNaArvore(raiz);
		
		return this.ListaDeErros.isEmpty();
	}

}
