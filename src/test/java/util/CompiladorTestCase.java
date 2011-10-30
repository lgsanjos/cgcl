package util;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import utils.Utils;
import analise.lexica.AnaliseLexica;
import analise.semantica.AnalisadorSemantico;
import analise.sintatica.AnaliseSintatica;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.gcl.GCLTokenTypes;

public class CompiladorTestCase extends TestCase {
	
	protected AnaliseSintatica analisador;
    
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
		analisador.addTokenClassException(GCLTokenTypes.COMMENT);
		analisador.addTokenClassException(GCLTokenTypes.WHITESPACE);
		analisador.addTokenClassException(GCLTokenTypes.ENDOFLINE);
		
		return analisador;
    }
    
    protected AnaliseSintatica buildAnaliseSintatica(String codigoFonte) {
    	return new AnaliseSintatica( this.buildAnaliseLexica(codigoFonte));
    }
    
    protected AnalisadorSemantico buildAnalisadorSemantico(String codigoFonte) {
    	ArvoreSintaticaAbstrataNo no;
    	try {
			no = this.buildAnaliseSintatica(codigoFonte).gerarArvore();
			return new AnalisadorSemantico(no);
		} catch (Exception e) {
			return null;
		}
    	
    }

}
