package codigoAssembly.estrutura;

import java.util.HashMap;
import java.util.Map.Entry;

public class CodigoAssembly {

	private static CodigoAssembly instancia;
	private HashMap<String, BlocoAssembly> codigo;
	
	private CodigoAssembly() {
		this.codigo = new HashMap<String, BlocoAssembly>();
	}
	
	public static CodigoAssembly getInstancia() {
		if (instancia == null)
			instancia = new CodigoAssembly();
		
		return instancia;
	}
	
	public static void limpar() {
		if (instancia != null)
			instancia.codigo.clear();
	}
	
	private boolean existeBloco(String nomeBloco) {
		return this.codigo.containsKey(nomeBloco);
	}
	private void criaBloco(String nomeBloco) {
		this.codigo.put(nomeBloco, new BlocoAssembly(nomeBloco));
	}
	
	public BlocoAssembly getBloco(String nomeBloco) {
		if (! existeBloco(nomeBloco))
			criaBloco(nomeBloco);
		
		return this.codigo.get(nomeBloco);
	}
	
	public String to_string() {
		String retorno = "";
		
		BlocoAssembly text = getBloco(".text");
		BlocoAssembly data = getBloco(".data");
		
		retorno += text.toString();
		
		for (Entry<String, BlocoAssembly> bloco : codigo.entrySet())
			if (! bloco.getKey().equalsIgnoreCase(".text") && ! bloco.getKey().equalsIgnoreCase(".data"))
				retorno += bloco.getValue().toString();
			
		retorno += data.toString();		
		return retorno;	
	}
	
}
