package codigoIntermediario;

import java.util.List;

import util.CompiladorTestCase;

public class GeracaoDeCodigoIntermediarioTest extends CompiladorTestCase {
	
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
		assertEquals(9, codigoIntermediario.size());
		
	}		

}
