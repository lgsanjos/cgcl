package analise;

import utils.GCLTokenTypes;
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
    
    private AnaliseLexica buildAnaliseLexica(String codigoFonte){
		AnaliseLexica analisador = new AnaliseLexica(codigoFonte);
		analisador.addTokenClassException(GCLTokenTypes.Comment);
		analisador.addTokenClassException(GCLTokenTypes.Whitespace);
		analisador.addTokenClassException(GCLTokenTypes.EndOfLine);
		
		return analisador;
    }
    
    public void testaModuleBasico(){
    	String source = "module oi begin end.";
    	
    	this.analisador = new AnaliseSintatica( this.buildAnaliseLexica(source) );
    	assertTrue( this.analisador.valida() );
    	
    	
    }
   
    

}
