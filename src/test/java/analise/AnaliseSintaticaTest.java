package analise;

import utils.GCLTokenTypes;
import coretypes.Token;
import analise.sintatica.AnaliseSintatica;
import junit.framework.TestCase;

public class AnaliseSintaticaTest extends TestCase {
	
	private	AnaliseSintatica analisador;
    
    
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	
    	this.analisador = new AnaliseSintatica();
    }	
    
    public void testaPilhaDeTokens(){
    	
    	this.analisador.empilhaToken( new Token( GCLTokenTypes.Keyword , "IF"));   	
    	assertTrue("A pilha deve conter apenas o Token IF e uma producao parcial valida.", this.analisador.isPilhaParcialmenteValida());
    	
    	this.analisador.empilhaToken( new Token( GCLTokenTypes.Keyword , "THEN"));
    	assertFalse("A pilha deve conter os Token IF,THEN e NAO e uma producao parcial valida.",this.analisador.isPilhaParcialmenteValida());
    	
    	this.analisador.desempilhaToken();
    	assertTrue("A pilha deve conter apenas o Token IF e uma producao parcial valida.", this.analisador.isPilhaParcialmenteValida());
    }
    

}
