package analise.tabelaDeSimbolos;

import java.util.LinkedList;

public final class TabelaDeSimbolos {

	private static TabelaDeSimbolos instance = null;
	private LinkedList<SimboloAbstract> listaSimbolos;

	private TabelaDeSimbolos() {
		this.listaSimbolos = new LinkedList<SimboloAbstract>();
	}
	
	public static void reset() {
		if (instance != null)
			instance.listaSimbolos.clear();
		
		instance = null;
	}

	public static TabelaDeSimbolos getInstance() {
		if (instance == null) {
			instance = new TabelaDeSimbolos();
		}

		return instance;
	}
	
	public boolean add(SimboloAbstract simbolo) {
		return this.listaSimbolos.add(simbolo);
	}
	
	public boolean contains(SimboloAbstract simbolo) {
		return this.listaSimbolos.contains(simbolo);
	}
	

	public boolean addVariavel(String nome, String tipagem) {
		SimboloAbstract variavel = new SimboloVariavel(nome, tipagem);
		return this.add(variavel);
	}
	
	public boolean addConstante(String nome, String valor) {
		SimboloAbstract constante = new SimboloConstante(nome, valor);
		return this.add(constante);
	}
	
	public boolean addMarcadorDeEscopo()  {
		return this.add(new SimboloFimDeEscopo());
	}
	
	public void removeTodosAteUltimoMarcadorDeEscopo() {
		
		while( ! instance.listaSimbolos.getLast().isFimDeEscopo() ) {
			instance.listaSimbolos.removeLast();			
		}
		
	}

}
