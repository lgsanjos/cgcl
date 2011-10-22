package analise.semantica;

import java.util.LinkedList;

import analise.exceptions.AnaliseSemanticaException;
import analise.semantica.validacoes.*;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.StringList;

public class AnalisadorSemantico {
	
	private final ArvoreSintaticaAbstrataNo no;
	private StringList ListaDeErros;
	private LinkedList<AnaliseSemanticaAcaoAbstrata> acoes;
	
	public AnalisadorSemantico(ArvoreSintaticaAbstrataNo no) {
		
		this.ListaDeErros = new StringList();

		this.acoes = new LinkedList<AnaliseSemanticaAcaoAbstrata>();
		this.acoes.add(new AnaliseSemanticaControlaEscopo());
		this.acoes.add(new AnaliseSemanticaAddConstants());
		
		this.no = no;
	}
	
	public AnalisadorSemantico() {
		this(null);
	}
	
	public StringList getListaDeErros() {
		return this.ListaDeErros;
	}
		
	private void analisarArvoreDadoNo(ArvoreSintaticaAbstrataNo no) {

		for (AnaliseSemanticaAcaoAbstrata acao : this.acoes) {
			try {
				acao.executa(no);
			} catch (AnaliseSemanticaException e) {
				this.ListaDeErros.add(e.getMessage());
			}
		}
		
		for (ArvoreSintaticaAbstrataNo noFilho : no.getListaDeNos()) {
			this.analisarArvoreDadoNo(noFilho);
		}		
	}
		
	public boolean analisarArvoreApartirDaRaiz(ArvoreSintaticaAbstrataNo raiz) {
		this.ListaDeErros.clear();
		this.analisarArvoreDadoNo(raiz);
		
		return this.ListaDeErros.isEmpty();
	}
	
	public boolean analisar() {
		if (this.no != null)
			return this.analisarArvoreApartirDaRaiz(this.no);
		
		return false;
	}	

}
