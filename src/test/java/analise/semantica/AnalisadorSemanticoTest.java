package analise.semantica;

import analise.AnaliseTestCase;

public class AnalisadorSemanticoTest extends AnaliseTestCase {
	
	public void testAddTSConstantName() {
		String codigoFonte = this.loadResourceNamed("semantica/constantName.gcl");
		AnalisadorSemantico analisador = this.buildAnalisadorSemantico(codigoFonte);
		analisador.analisaNo();
		
	}
	
	

}
