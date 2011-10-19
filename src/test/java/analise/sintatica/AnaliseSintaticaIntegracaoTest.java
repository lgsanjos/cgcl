package analise.sintatica;

import analise.AnaliseTestCase;
import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;

public class AnaliseSintaticaIntegracaoTest extends AnaliseTestCase {
	
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
	
	public void testValidaArquivo_ModuleDoStatement() {
		String source = this.loadResourceNamed("module_doStatement.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_DoStatementComplexo() {
		String source = this.loadResourceNamed("module_doStatementComplexo.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_IfStatementComplexo() {
		String source = this.loadResourceNamed("module_ifStatementComplexo.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_doComplexo2() {
		String source = this.loadResourceNamed("module_doComplexo2.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}

	public void testValidaArquivo_procAninhadaSimples() {
		String source = this.loadResourceNamed("module_procAninhadaSimples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}	
	
	public void testValidaArquivo_procAninhadaComplexa() {
		String source = this.loadResourceNamed("module_procAninhadaComplexo.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_procAninhada_doSimples() {
		String source = this.loadResourceNamed("module_procAninhada_doSimples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
	}
	
	public void testValidaArquivo_procAninhada_doComplexa() {
		String source = this.loadResourceNamed("module_procAninhada_doComplexa.gcl");
		
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
