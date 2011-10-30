package codigoIntermediario;

import java.util.HashMap;

public class VariaveisTemporarias {
	
	private static VariaveisTemporarias instance;
	private HashMap<Integer, String> variaveisTemporarias;

	private VariaveisTemporarias() {
		this.variaveisTemporarias = new HashMap<Integer, String>();
	}

	public static VariaveisTemporarias getInstancia() {
		if (instance == null)
			instance = new VariaveisTemporarias();

		return instance;
	}

	public static String geraVariavelTemporaria() {
		int size = getInstancia().variaveisTemporarias.size() + 1;
		String variavel = "_temp" + size;
		getInstancia().variaveisTemporarias.put(size, variavel);
		
		return variavel;
	}

}
