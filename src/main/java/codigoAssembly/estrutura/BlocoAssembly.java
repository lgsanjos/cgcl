package codigoAssembly.estrutura;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BlocoAssembly {
	
	private LinkedList<InstrucaoAssembly> codigo;
	
	public BlocoAssembly() {
		this.codigo = new LinkedList<InstrucaoAssembly>(); 
	}
	
	public List<InstrucaoAssembly> getCodigo() {
		return Collections.unmodifiableList(this.codigo);
	}
	
	public void addInstrucaoCall(String nomeMetodo) {
		addInstrucao("call", "_" + nomeMetodo, "");
	}
	
	public void addInstrucaoNop() {
		addInstrucao("nop", "", "");
	}
	
	public void addDeclaracaoString(String identificador, String texto) {
		//FMT: .ascii "teste %d %s\n\0"
		texto = texto.replaceAll("\'", "");
		texto = "\"" + texto + "\n\0\""; 
		addInstrucao(identificador + ":", ".ascii", texto);
	}
	
	public void addPushl(String valor) {
		addInstrucao("pushl", valor, "");
	}
	
	public void addMovl(String esquerdo, String direito) {
		addInstrucao("movl", esquerdo, direito);
	}
	
	private void addInstrucao(String operacao, String param1, String param2) {
		InstrucaoAssembly instrucao = new InstrucaoAssembly();
		instrucao.setOperacao(operacao);
		instrucao.setParametro1(param1);
		instrucao.setParametro2(param2);
		
		this.codigo.addLast(instrucao);
	}

}
