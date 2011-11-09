package codigoAssembly.estrutura;

import java.util.HashMap;

public class StringAssembly {

	private static StringAssembly instancia;
	private HashMap<String, String> lista;
	
	private static StringAssembly getInstancia() {
		if (instancia == null)
			instancia = new StringAssembly();
		
		return instancia;
	}
	
	private String geraNovoIdentificador() {
		return "str" + lista.size();
	}
	
	public static String novaString(String texto) {
		String novoId = getInstancia().geraNovoIdentificador();
		getInstancia().lista.put(novoId, texto);
		
		CodigoAssembly.getInstancia().getBloco(".data").addDeclaracaoString(novoId, texto);
		return novoId;
	}
	
	public static boolean stringDeclarada(String texto) {
		return getInstancia().lista.containsValue(texto);		
	}
	
}
