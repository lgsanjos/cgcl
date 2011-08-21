package analise.sintatica;

import java.io.IOException;
import java.io.InputStream;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

import utils.Utils;
import junit.framework.TestCase;

public class ArvoreSintaticaAbstrataTest extends TestCase{
	
	
	private String loadResourceNamed(String name) {
		InputStream input =	getClass().getClassLoader().getResourceAsStream(name);
		try {
			return Utils.convertStreamToString(input);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}	
	}
	
	public void testPrintSimples() {
		
		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD, "module"));
		raiz.adicionaNoFilho("identificador", new Token(GCLTokenTypes.IDENTIFIER, "simplesPacas"));
		
		ArvoreSintaticaAbstrata arv = new ArvoreSintaticaAbstrata();
		arv.setRaiz(raiz);
		
		String printGerado = arv.print();
		String printTemplate = this.loadResourceNamed("asa_simplesPacas.txt"); 
		assertEquals(printGerado, printTemplate);
	}

}
