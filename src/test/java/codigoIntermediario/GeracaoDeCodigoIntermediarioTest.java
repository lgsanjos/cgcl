package codigoIntermediario;

import java.util.List;
import analise.CompiladorTestCase;
import analise.semantica.AnalisadorSemantico;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class GeracaoDeCodigoIntermediarioTest extends CompiladorTestCase {
	
	private void gerarCodigoIntermediarioDoArquivo(String nomeArquivo) {
		
		String codigoFonte = this.loadResourceNamed(nomeArquivo);
				
		AnalisadorSemantico semantico = this.buildAnalisadorSemantico(codigoFonte);
		assertTrue(semantico.analisar());
		assertEquals(0, semantico.getListaDeErros().size());
		
		ArvoreSintaticaAbstrataNo noRaiz = null;
		noRaiz = semantico.getArvoreSintaticaAnotada();
		
		GeradorDeCodigoIntermediario.traduz(noRaiz);
	}

	public void testSimpleExpression() {
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario;
		gerarCodigoIntermediarioDoArquivo("codigoIntermediario/operacaoMatematica.gcl");
		codigoIntermediario = CodigoIntermediario.getCodigo();
		
		assertEquals(3, codigoIntermediario.size());
		assertEquals("*", codigoIntermediario.get(0).getOperador());
		assertEquals("+", codigoIntermediario.get(1).getOperador());
		assertEquals(":=", codigoIntermediario.get(2).getOperador());
	}
	
	public void testSimpleExpressionComBooleanOperator() {
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario;
		gerarCodigoIntermediarioDoArquivo("codigoIntermediario/booleanOperator.gcl");
		codigoIntermediario = CodigoIntermediario.getCodigo();
		
		assertEquals(2, codigoIntermediario.size());
		assertEquals(">=", codigoIntermediario.get(0).getOperador());
		assertEquals(":=", codigoIntermediario.get(1).getOperador());
	}
	
	public void testCodigoMinimo() {
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario;
		gerarCodigoIntermediarioDoArquivo("codigoIntermediario/codigoMinimo.gcl");
		codigoIntermediario = CodigoIntermediario.getCodigo();
		System.out.print(CodigoIntermediario.getInstancia().to_string());
		assertEquals(2, codigoIntermediario.size());
		
	}		

}
