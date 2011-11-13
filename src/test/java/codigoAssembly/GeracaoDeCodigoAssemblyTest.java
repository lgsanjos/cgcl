package codigoAssembly;

import util.CompiladorTestCase;
import codigoAssembly.estrutura.CodigoAssembly;
import codigoIntermediario.CodigoIntermediario;

public class GeracaoDeCodigoAssemblyTest extends CompiladorTestCase {
	
	protected void setUp() {
		CodigoAssembly.limpar();
		CodigoIntermediario.limpar();
	}
	
	public void testEstruturaAssemblyBasica() {
		
		gerarCodigoAssemblyDoArquivo("codigoAssembly/estruturaBasicaParaExecutar.gcl");
		
		String codigoIntermediario = CodigoIntermediario.getInstancia().to_string();
		String codigoAssembly = CodigoAssembly.getInstancia().to_string();
		
		saveToOutputFile(codigoIntermediario, "estruturaBasicaParaExecutar_intermediario");
		saveToOutputFile(codigoAssembly, "estruturaBasicaParaExecutar_assembly");
		
		assertEquals(1, CodigoIntermediario.getCodigo().size());
	}
	
	public void testEstruturaAssemblyBasicaComProcedureSemParametro() {
		
		gerarCodigoAssemblyDoArquivo("codigoAssembly/estruturaBasicaComProcedureSemParametro.gcl");
		
		String codigoIntermediario = CodigoIntermediario.getInstancia().to_string();
		String codigoAssembly = CodigoAssembly.getInstancia().to_string();
		
		saveToOutputFile(codigoIntermediario, "estruturaBasicaComProcedureSemParametro_intermediario");
		saveToOutputFile(codigoAssembly, "estruturaBasicaComProcedureSemParametro_assembly");
		
		assertEquals(3, CodigoIntermediario.getCodigo().size());
	}
	
	public void testEstruturaAssemblyBasicaComProcedureComParametro() {
		
		gerarCodigoAssemblyDoArquivo("codigoAssembly/estruturaBasicaComProcedureComParametro.gcl");
		
		String codigoIntermediario = CodigoIntermediario.getInstancia().to_string();
		String codigoAssembly = CodigoAssembly.getInstancia().to_string();
		
		saveToOutputFile(codigoIntermediario, "estruturaBasicaComProcedureComParametro_intermediario");
		saveToOutputFile(codigoAssembly, "estruturaBasicaComProcedureComParametro_assembly");
		
		assertEquals(3, CodigoIntermediario.getCodigo().size());
	}		
	
	public void testGeraCodigoMinimoAssembly() {
	
		gerarCodigoAssemblyDoArquivo("codigoIntermediario/codigoMinimo.gcl");
		saveToOutputFile(CodigoIntermediario.getInstancia().to_string(), "codigoMinimo_Intermediario");
		saveToOutputFile(CodigoAssembly.getInstancia().to_string(), "codigoMinimo_Assembly");
		
		assertEquals(9, CodigoIntermediario.getCodigo().size());
	}	
	
}