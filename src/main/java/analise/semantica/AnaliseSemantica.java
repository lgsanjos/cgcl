package analise.semantica;

import java.util.LinkedList;
import coretypes.StringList;
import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.semantica.validacoes.*;

public class AnaliseSemantica {
	
	private StringList ListaDeErros;
	private LinkedList<AnaliseSemanticaAcaoAbstrata> acoes;
	
	public AnaliseSemantica() {
		this.ListaDeErros = new StringList();
	}
	
	private void analisaNo(ArvoreSintaticaAbstrataNo no) {
		
		for (int i = 0; i <= this.acoes.size(); i++) {
			try {
				this.acoes.get(i).executa(no);
			} catch (AnaliseSemanticaException e) {
				this.ListaDeErros.add(e.getMessage());
			}
		}
	}
	
	private void navegaNaArvore(ArvoreSintaticaAbstrataNo raiz) {

		ArvoreSintaticaAbstrataNo no = raiz;
		this.analisaNo(no);
		
		for (int i = 0; i <= no.quatidadeNosFilhos(); i++ ) {
			this.navegaNaArvore(no.getListaDeNos().get(i));
		}
	}
		
	public boolean analisarASA(ArvoreSintaticaAbstrataNo raiz) {
		
		this.ListaDeErros.clear();
		this.navegaNaArvore(raiz);
		
		return this.ListaDeErros.isEmpty();
	}

}
