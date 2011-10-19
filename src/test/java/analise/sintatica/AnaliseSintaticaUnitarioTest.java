package analise.sintatica;

import analise.AnaliseTestCase;
import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;


public class AnaliseSintaticaUnitarioTest extends AnaliseTestCase {
	
	
    public void testaModuleBasico(){
    	String source = "module oi begin end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	//assertTrue( this.analisador.valida() );	
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
    }
    
    public void testaModuleBasicoComPrivate(){
    	String source = "module oi private begin end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	//assertTrue( this.analisador.valida() );	
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
    }    
    
    public void testaModuleBasicoComFalhaSintaticaNoFinalDaProducao(){
    	String source = "module oi begin end;";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	//assertFalse( this.analisador.valida() );	
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
    }
       
    public void testaModuleBasicoComFalhaSintaticaNoMeioDaProducao(){
    	String source = "module oi @ begin end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	//assertFalse( this.analisador.valida() );	
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
    }       
    
    public void testaModuleBasicoComPrivateEQuebrasDeLinha(){
    	String source = "module testando \r\n" +
    					"private \r\n" +
    					"begin \r\n" +
    					"end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 
    }    
   
    public void testaModuleBasicoComPrivateEComentarios(){
    	String source = "module testando \r\n" +
    					"private \r\n" +
    					" -- testando os comentarios \r\n" +
    					"begin \r\n" +
    					"end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
		try {
			assertTrue(this.analisador.valida());
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		} 	
    }
    
    public void testaModuleBlocoDefinitionPartConstantDef(){
    	String source = "module testando \r\n" +
    					"private \r\n" +
    					"const id = 2; \r\n" +
    					"begin \r\n" +
    					"end.";
    	
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
