package analise.semantica;

import analise.AnaliseTestCase;

public class AnalisadorSemanticoTest extends AnaliseTestCase {
	
	public void testAddTSConstantName() {
		String codigoFonte = this.loadResourceNamed("semantica/constantName.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testFalhaComConstantNameDuplicado() {
		String codigoFonte = this.loadResourceNamed("semantica/constantName_duplicado.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	
	
	public void testDeclararVariavelInteger() {
		String codigoFonte = this.loadResourceNamed("semantica/variableDec_integer.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testDeclararVariavelString() {
		String codigoFonte = this.loadResourceNamed("semantica/variableDec_string.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}	
	
	public void testDeclararVariavelTupla() {
		String codigoFonte = this.loadResourceNamed("semantica/variableDec_tupla.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testDeclararProcedureSemParametros() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_semParams.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testFalhaAoDeclararProcedureSemParametrosDuplicada() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_semParams_duplicada.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	
	
	public void testDeclararProcedureComParametros() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_comParams.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testDeclararProcedureComParametrosEVariaveis() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_comParams_comVariaveis.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}	
	
	public void testProcComVariavelDeMesmoNomeEscopoAcima() {
		String codigoFonte = this.loadResourceNamed("semantica/procComVariavelDeMesmoNomeEscopoAcima.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}	

	public void testFalhaAssignmentDeVariavelNaoDeclarada() {
		String codigoFonte = this.loadResourceNamed("semantica/assignmentVariavelNaoDeclarada.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}		
	
	public void testFalhaChamadaDeProcedureNaoDeclarada() {
		String codigoFonte = this.loadResourceNamed("semantica/callProcNaoDeclarada.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	
	
	public void testFalhaChamadaDeProcedureComParametrosErrados() {
		String codigoFonte = this.loadResourceNamed("semantica/callProcedureComParamsErrados.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	

}
