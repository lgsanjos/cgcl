package analise.semantica;

import analise.AnaliseTestCase;

public class AnalisadorSemanticoTest extends AnaliseTestCase {
	
	public void testAddTSConstantName() {
		String codigoFonte = this.loadResourceNamed("semantica/constantName.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisar();
		
		assertEquals(0, analisador.getListaDeErros().size());
		
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
	
	

}
