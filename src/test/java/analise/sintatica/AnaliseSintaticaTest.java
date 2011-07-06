package analise.sintatica;

import java.io.IOException;
import java.io.InputStream;

import utils.GCLTokenTypes;
import utils.Utils;
import analise.sintatica.AnaliseSintatica;
import analise.lexica.AnaliseLexica;
import junit.framework.TestCase;

public class AnaliseSintaticaTest extends TestCase {
	
	protected	AnaliseSintatica analisador;
    
    
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	
    	this.analisador = new AnaliseSintatica( new AnaliseLexica("") );
    	
    }
    
	protected String loadResourceNamed(String name) {
		InputStream input =	getClass().getClassLoader().getResourceAsStream(name);
		try {
			return Utils.convertStreamToString(input);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}		
	}    
    
    protected AnaliseLexica buildAnaliseLexica(String codigoFonte){
		AnaliseLexica analisador = new AnaliseLexica(codigoFonte);
		analisador.addTokenClassException(GCLTokenTypes.Comment);
		analisador.addTokenClassException(GCLTokenTypes.Whitespace);
		analisador.addTokenClassException(GCLTokenTypes.EndOfLine);
		
		return analisador;
    }
    
    protected AnaliseSintatica buildAnaliseSintatica(String codigoFonte) {
    	return new AnaliseSintatica( this.buildAnaliseLexica(codigoFonte));
    }
    

}
