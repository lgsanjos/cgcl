package codigoAssembly.estrutura;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BlocoAssembly {
	
	private LinkedList<InstrucaoAssembly> codigo;
	private String nome;
	
	public BlocoAssembly(String nome) {
		this.codigo = new LinkedList<InstrucaoAssembly>();
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public List<InstrucaoAssembly> getCodigo() {
		return Collections.unmodifiableList(this.codigo);
	}
	
	public void addInstrucaoCall(String nomeMetodo) {
		addInstrucao("call", nomeMetodo, "");
	}
	
	public void addInstrucaoNop() {
		addInstrucao("nop", "", "");
	}
	
	public void addGlobal(String nome) {
		addInstrucao(".global", nome, "");
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
	
	public void addRet() {
		addInstrucao("ret", "", "");
	}
	
	private void addInstrucao(String operacao, String param1, String param2) {
		InstrucaoAssembly instrucao = new InstrucaoAssembly();
		instrucao.setOperacao(operacao);
		instrucao.setParametro1(param1);
		instrucao.setParametro2(param2);
		
		this.codigo.addLast(instrucao);
	}
	
	@Override
	public String toString() {
		String retorno = this.getNome() + "\r\n";
		
		for (InstrucaoAssembly linha : codigo) {

			retorno += "\t"  + linha.getOperacao();
			if (! linha.getParametro1().isEmpty()) 
				retorno += " " + linha.getParametro1();
			
			if (! linha.getParametro2().isEmpty()) 
				retorno += ", " + linha.getParametro2();
			
			retorno += "\r\n";
		}	
				
		return retorno + "\r\n";
	}

}
