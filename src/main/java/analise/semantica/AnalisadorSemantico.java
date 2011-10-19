package analise.semantica;

import java.util.LinkedList;
import coretypes.StringList;
import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.semantica.validacoes.*;

public class AnalisadorSemantico {
	
	private final ArvoreSintaticaAbstrataNo no;
	private StringList ListaDeErros;
	private LinkedList<AnaliseSemanticaAcaoAbstrata> acoes;
	
	public AnalisadorSemantico(ArvoreSintaticaAbstrataNo no) {
		this.ListaDeErros = new StringList();

		this.acoes = new LinkedList<AnaliseSemanticaAcaoAbstrata>();
		this.acoes.add(new AnaliseSemanticaAdicionaTabelaDeSimbolos());
		
		this.no = no;
	}
	
	public AnalisadorSemantico() {
		this(null);
	}
	
	
	public void analisaNo() {
		if (this.no != null)
			this.analisaNo(this.no);
	}
	
	private void analisaNo(ArvoreSintaticaAbstrataNo no) {
		for (AnaliseSemanticaAcaoAbstrata acao : this.acoes) {
			try {
				acao.executa(no);
			} catch (AnaliseSemanticaException e) {
				this.ListaDeErros.add(e.getMessage());
			}
		}
		
		for (ArvoreSintaticaAbstrataNo noFilho : no.getListaDeNos()) {
			this.analisaNo(noFilho);
		}		
	}
	
	private void navegaNaArvore(ArvoreSintaticaAbstrataNo raiz) {
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
