package analise.semantica;

import util.CompiladorTestCase;

public class AnalisadorSemanticoTest extends CompiladorTestCase {
	
	public void testAddTSConstantName() {
		String codigoFonte = this.loadResourceNamed("semantica/constantName.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testFalhaComConstantNameDuplicado() {
		String codigoFonte = this.loadResourceNamed("semantica/constantName_duplicado.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	
	
	public void testDeclararVariavelInteger() {
		String codigoFonte = this.loadResourceNamed("semantica/variableDec_integer.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testDeclararVariavelString() {
		String codigoFonte = this.loadResourceNamed("semantica/variableDec_string.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}	
	
	public void testDeclararVariavelTupla() {
		String codigoFonte = this.loadResourceNamed("semantica/variableDec_tupla.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testDeclararProcedureSemParametros() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_semParams.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testFalhaAoDeclararProcedureSemParametrosDuplicada() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_semParams_duplicada.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	
	
	public void testDeclararProcedureComParametros() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_comParams.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}
	
	public void testDeclararProcedureComParametrosEVariaveis() {
		String codigoFonte = this.loadResourceNamed("semantica/procedureDec_comParams_comVariaveis.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}	
	
	public void testProcComVariavelDeMesmoNomeEscopoAcima() {
		String codigoFonte = this.loadResourceNamed("semantica/procComVariavelDeMesmoNomeEscopoAcima.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
	}	

	public void testFalhaAssignmentDeVariavelNaoDeclarada() {
		String codigoFonte = this.loadResourceNamed("semantica/assignmentVariavelNaoDeclarada.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}		
	
	public void testFalhaChamadaDeProcedureNaoDeclarada() {
		String codigoFonte = this.loadResourceNamed("semantica/callProcNaoDeclarada.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
	}	
	
	public void testFalhaChamadaDeProcedureComParametrosErrados() {
		String codigoFonte = this.loadResourceNamed("semantica/callProcedureComParamsErrados.gcl");
		AnaliseSemantica analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(1, analisador.getListaDeErros().size());
		assertEquals("Quantidade de parametros inválidos para o procedimento: minhaProcedure", analisador.getListaDeErros().getFirst());
	}	

}
