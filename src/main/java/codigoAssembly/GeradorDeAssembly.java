package codigoAssembly;

import java.util.List;

import codigoAssembly.estrutura.BlocoAssembly;
import codigoAssembly.estrutura.CodigoAssembly;
import codigoIntermediario.CodigoIntermediario;
import codigoIntermediario.ConstrucaoDeQuatroEnderecos;

public class GeradorDeAssembly {
	
	
	public void gerarBlocoPrincipal() {
		BlocoAssembly main =  CodigoAssembly.getInstancia().getBloco("_main");
		
		main.addInstrucao("pushl", "%ebp", "");
		main.addInstrucao("movl", "%esp", "%ebp");
		
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario = CodigoIntermediario.getCodigo();
		
		for (ConstrucaoDeQuatroEnderecos construcao : codigoIntermediario) {
			
		}
	}
}
