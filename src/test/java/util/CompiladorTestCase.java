package util;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import utils.Utils;
import analise.lexica.AnaliseLexica;
import analise.semantica.AnaliseSemantica;
import analise.sintatica.AnaliseSintatica;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import codigoAssembly.GeradorDeAssembly;
import codigoIntermediario.CodigoIntermediario;
import codigoIntermediario.GeradorDeCodigoIntermediario;
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
		//System.out.println(filename);
		Utils.saveToFile(content, filename);
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
    
    protected AnaliseSemantica buildAnalisadorSemantico(String codigoFonte) {
    	ArvoreSintaticaAbstrataNo no;
    	try {
			no = this.buildAnaliseSintatica(codigoFonte).analisar();
			return new AnaliseSemantica(no);
		} catch (Exception e) {
			return null;
		}
    }
    
	protected void gerarCodigoIntermediarioDoArquivo(String nomeArquivo) {
		
		String codigoFonte = this.loadResourceNamed(nomeArquivo);
				
		AnaliseSemantica semantico = this.buildAnalisadorSemantico(codigoFonte);
		assertTrue(semantico.analisar());
		assertEquals(0, semantico.getListaDeErros().size());
		
		ArvoreSintaticaAbstrataNo noRaiz = null;
		noRaiz = semantico.getArvoreSintaticaAnotada();
		
		GeradorDeCodigoIntermediario.traduz(noRaiz);
	}
	
	protected void gerarCodigoAssemblyDoArquivo(String nomeArquivo) {
		this.gerarCodigoIntermediarioDoArquivo(nomeArquivo);
		GeradorDeAssembly.traduz(CodigoIntermediario.getCodigo());
	}

}
