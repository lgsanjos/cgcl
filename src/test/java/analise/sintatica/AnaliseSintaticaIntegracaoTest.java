package analise.sintatica;

import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;

public class AnaliseSintaticaIntegracaoTest extends AnaliseSintaticaTest {
	
	public void testValidaArquivo_Simples() {
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
	
	public void testValidaArquivo_DeclaracoesEAtribuicao() {
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

	public void testValidaArquivo_Search() {
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
	
	public void testValidaArquivo_AtribuicaoSimples() {
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
	
	public void testValidaArquivo_ModuleAssignmentSimples() {
		String source = this.loadResourceNamed("module_assignmentSimples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_ModuleAssignment() {
		String source = this.loadResourceNamed("module_assignment.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_ModuleAtribuicaoGuarded() {
		String source = this.loadResourceNamed("module_atribuicaoGuarded.gcl");
		
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
