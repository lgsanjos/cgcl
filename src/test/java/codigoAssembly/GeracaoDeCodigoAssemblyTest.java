package codigoAssembly;

import java.util.List;

import util.CompiladorTestCase;
import codigoAssembly.estrutura.CodigoAssembly;
import codigoIntermediario.CodigoIntermediario;
import codigoIntermediario.ConstrucaoDeQuatroEnderecos;

public class GeracaoDeCodigoAssemblyTest extends CompiladorTestCase {
	
	protected void setUp() {
		CodigoAssembly.limpar();
		CodigoIntermediario.limpar();
	}
	
	public void testGeraCodigoMinimoAssembly() {
	
		super.gerarCodigoIntermediarioDoArquivo("codigoIntermediario/codigoMinimo.gcl");
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario = CodigoIntermediario.getCodigo();
		//System.out.print(CodigoIntermediario.getInstancia().to_string());
		saveToOutputFile(CodigoIntermediario.getInstancia().to_string(), "codigoMinimo_Intermediario");
		//saveToOutputFile(CodigoAssembly.getInstancia().to_string(), "codigoMinimo_Assembly");
		assertEquals(9, codigoIntermediario.size());
	}	
	
}