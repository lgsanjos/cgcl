package analise.sintatica;

public class AnaliseSintaticaIntegracaoTest extends AnaliseSintaticaTest {
	
	public void testValidaArquivoSimples() {
		String source = this.loadResourceNamed("simples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		assertTrue( this.analisador.valida() ); 
	}
	
	public void testValidaArquivoDeDeclaracoesEAtribuicao() {
		String source = this.loadResourceNamed("declaracoesDeTipos.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		assertTrue( this.analisador.valida() ); 
	}

	public void testValidaArquivoSearch() {
		String source = this.loadResourceNamed("search.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		assertTrue( this.analisador.valida() ); 
	}	
	
}
