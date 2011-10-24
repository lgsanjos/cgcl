package analise.tabelaDeSimbolos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import analise.exceptions.AnaliseSemanticaException;
import analise.semantica.Parametro;

public final class TabelaDeSimbolos {
	
	private class ListaDeSimbolos extends HashMap<String, SimboloAbstract>{
		private static final long serialVersionUID = 1L;
	};

	private static TabelaDeSimbolos instance = null;
	private ArrayList<ListaDeSimbolos> pilhaDeEscopo;

	private TabelaDeSimbolos() {
		this.pilhaDeEscopo = new ArrayList<ListaDeSimbolos>();
	}
	
	public ListaDeSimbolos listaSimbolos() {
		if (this.pilhaDeEscopo.size() == 0)
			this.pilhaDeEscopo.add(new ListaDeSimbolos());
		
		return this.pilhaDeEscopo.get(this.pilhaDeEscopo.size() -1);
	}
	
	public static void reset() {
		if (instance != null)
			instance.pilhaDeEscopo.clear();
		
		instance = null;
	}

	public static TabelaDeSimbolos getInstance() {
		if (instance == null)
			instance = new TabelaDeSimbolos();

		return instance;
	}
	
	public void add(SimboloAbstract simbolo) throws AnaliseSemanticaException {
		if (this.listaSimbolos().containsKey(simbolo.getNome()))
			throw new AnaliseSemanticaException("O identificador " + simbolo.getNome() + " já foi atribuido.");
			
		this.listaSimbolos().put(simbolo.getNome(), simbolo);
	}

	
	public static SimboloAbstract getSimbolo(String nome) {
		@SuppressWarnings("unchecked")
		ArrayList<ListaDeSimbolos> listaInvertida = (ArrayList<ListaDeSimbolos>) instance.pilhaDeEscopo.clone();
		Collections.reverse(listaInvertida);

		for (ListaDeSimbolos escopo : listaInvertida) {
			if (escopo.containsKey(nome))
				return escopo.get(nome);
		}
		
		return null;
	}
	
	public static boolean contains(String nome) {

		return getSimbolo(nome) != null;
		
	}

	public void addVariavel(String nome, String tipagem) throws AnaliseSemanticaException {
		SimboloAbstract variavel = new SimboloVariavel(nome, tipagem);
		this.add(variavel);
	}

	public void addConstante(String nome, String valor) throws AnaliseSemanticaException {
		SimboloAbstract constante = new SimboloConstante(nome, valor);
		this.add(constante);
	}
	
	public void addFuncao(String nome, ArrayList<Parametro> parametros) throws AnaliseSemanticaException {
		SimboloAbstract funcao = new SimboloFuncao(nome, parametros);
		this.add(funcao);
	}
	
	public void addFuncao(String nome) throws AnaliseSemanticaException {
		SimboloAbstract funcao = new SimboloFuncao(nome);
		this.add(funcao);
	}
	
	public void addMarcadorDeEscopo() {
		this.pilhaDeEscopo.add(new ListaDeSimbolos());
	}	

	public void removeTodosAteUltimoMarcadorDeEscopo() {
		if (this.pilhaDeEscopo.size() > 1)
			this.pilhaDeEscopo.remove(this.pilhaDeEscopo.size() -1);
	}

}
