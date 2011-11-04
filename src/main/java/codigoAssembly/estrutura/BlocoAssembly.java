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
	
	public void addInstrucao(String operacao, String param1, String param2) {
		InstrucaoAssembly instrucao = new InstrucaoAssembly();
		instrucao.setOperacao(operacao);
		instrucao.setParametro1(param1);
		instrucao.setParametro2(param2);
		
		this.codigo.addLast(instrucao);
	}

}
