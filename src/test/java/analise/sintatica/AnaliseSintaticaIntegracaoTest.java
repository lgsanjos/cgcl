package analise.sintatica;

import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;

public class AnaliseSintaticaIntegracaoTest extends AnaliseSintaticaTest {
	
	public void testValidaArquivoSimples() {
		String source = this.loadResourceNamed("simples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		}
	}
	
	public void testValidaArquivoDeDeclaracoesEAtribuicao() {
		String source = this.loadResourceNamed("declaracoesDeTipos.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}

	public void testValidaArquivoSearch() {
		String source = this.loadResourceNamed("search.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivoAtribuicaoSimples() {
		String source = this.loadResourceNamed("module_testaAtribuicaoSimples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}	
	
}
