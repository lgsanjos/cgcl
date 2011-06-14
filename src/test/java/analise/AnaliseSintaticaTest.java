package analise;

import utils.GCLTokenTypes;
import coretypes.Token;
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
    
    public void incMe(Integer incMe){
    	incMe = new Integer(2);
    }
    
    
    public void testaPilhaDeTokens(){

    	Integer testMe = new Integer(0);
    	incMe(testMe);
    	assertTrue( testMe == 1);
    	
    	incMe(testMe);
    	assertTrue( testMe == 2);

    }
   
    

}
