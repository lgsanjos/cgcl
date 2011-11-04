package codigoAssembly.estrutura;

import java.util.HashMap;

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
		instancia.codigo.clear();
	}
	
	private boolean existeBloco(String nomeBloco) {
		return this.codigo.containsKey(nomeBloco);
	}
	private void criaBloco(String nomeBloco) {
		this.codigo.put(nomeBloco, new BlocoAssembly());
	}
	
	public BlocoAssembly getBloco(String nomeBloco) {
		if (! existeBloco(nomeBloco))
			criaBloco(nomeBloco);
		
		return this.codigo.get(nomeBloco);
	}
	
}
