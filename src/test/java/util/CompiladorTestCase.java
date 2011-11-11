package util;

import java.io.IOException;
import java.io.InputStream;

import codigoIntermediario.GeradorDeCodigoIntermediario;

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
	
	protected void saveToOutputFile(String content, String filename) {
		filename = System.getProperty("user.dir") + "/output/" + filename;
		System.out.println(filename);
		//Utils.saveToFile(content, filename);
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
    
	protected void gerarCodigoIntermediarioDoArquivo(String nomeArquivo) {
		
		String codigoFonte = this.loadResourceNamed(nomeArquivo);
				
		AnalisadorSemantico semantico = this.buildAnalisadorSemantico(codigoFonte);
		assertTrue(semantico.analisar());
		assertEquals(0, semantico.getListaDeErros().size());
		
		ArvoreSintaticaAbstrataNo noRaiz = null;
		noRaiz = semantico.getArvoreSintaticaAnotada();
		
		GeradorDeCodigoIntermediario.traduz(noRaiz);
	}    

}
