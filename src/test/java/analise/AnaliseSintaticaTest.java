package analise;

import analise.sintatica.AnaliseSintatica;
import analise.lexica.AnaliseLexica;
import junit.framework.TestCase;

public class AnaliseSintaticaTest extends TestCase {
	
	private	AnaliseSintatica analisador;
    
    
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	
    	this.analisador = new AnaliseSintatica( new AnaliseLexica("") );
    	
    }	
    
    public void testaModuleBasico(){
    	String source = "module oi begin end.";
    	
    	this.analisador = new AnaliseSintatica( new AnaliseLexica(source) );
    	assertTrue( this.analisador.valida() );
    	
    	
    }
   
    

}
