package analise.lexica;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import analise.lexica.AnaliseLexica;
import coretypes.Token;
import utils.GCLTokenTypes;
import utils.Utils;

public class AnaliseLexicaIntegracaoTest extends TestCase {
	
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	
    }	
	
    
	public void testCarregaSimples() throws IOException, Exception{		
		InputStream input =	getClass().getClassLoader().getResourceAsStream("simples.gcl");
		String content = Utils.convertStreamToString(input);

		AnaliseLexica analisador = new AnaliseLexica(content);
		analisador.addTokenClassException(GCLTokenTypes.COMMENT);
		analisador.addTokenClassException(GCLTokenTypes.WHITESPACE);
		analisador.addTokenClassException(GCLTokenTypes.ENDOFLINE);
		Token tok;		
		
		tok = analisador.getNextToken();
		assertTrue(tok.getValue().equals("module"));
		tok = analisador.getNextToken();
		assertTrue(tok.getValue().equals("simples"));
		tok = analisador.getNextToken();
		assertTrue(tok.getValue().equals("begin"));
		tok = analisador.getNextToken();
		assertTrue(tok.getValue().equals("end"));
		tok = analisador.getNextToken();
		assertTrue(tok.getValue().equals("."));
		
	}
	
	public void testCarregaPrimitivasTipagensEAtribuicoes() throws IOException, Exception{		
		InputStream input =	getClass().getClassLoader().getResourceAsStream("declaracoesDeTipos.gcl");
		String content = Utils.convertStreamToString(input);

		AnaliseLexica analisador = new AnaliseLexica(content);
		analisador.addTokenClassException(GCLTokenTypes.COMMENT);
		analisador.addTokenClassException(GCLTokenTypes.WHITESPACE);
		analisador.addTokenClassException(GCLTokenTypes.ENDOFLINE);
		Token token;	
		
		// TODO: Arrumar o assert para validar o arquivo declaracoesDeTipos.gcl
		token = analisador.getNextToken();
		assertTrue(token.getValue().equals("module"));
		token = analisador.getNextToken();
		assertTrue(token.getValue().equals("simples"));
		token = analisador.getNextToken();
		assertTrue(token.getValue().equals("begin"));
		token = analisador.getNextToken();
		assertTrue(token.getValue().equals("end"));
		token = analisador.getNextToken();
		assertTrue(token.getValue().equals("."));
		
	}	
 
    
	public void testCarregaSearch() throws IOException, Exception{
		InputStream input =	getClass().getClassLoader().getResourceAsStream("search.gcl");
		String content = Utils.convertStreamToString(input);
		
		AnaliseLexica analisador = new AnaliseLexica(content);
		analisador.addTokenClassException(GCLTokenTypes.COMMENT);
		analisador.addTokenClassException(GCLTokenTypes.WHITESPACE);
		analisador.addTokenClassException(GCLTokenTypes.ENDOFLINE);

		assertTrue(analisador.getNextToken().getValue().equals("module"));
		assertTrue(analisador.getNextToken().getValue().equals("search"));
		assertTrue(analisador.getNextToken().getValue().equals("private"));
		
		assertTrue(analisador.getNextToken().getValue().equals("const"));
		assertTrue(analisador.getNextToken().getValue().equals("size"));
		assertTrue(analisador.getNextToken().getValue().equals("="));
		assertTrue(analisador.getNextToken().getValue().equals("10"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("typedef"));
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("range"));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("1"));
		assertTrue(analisador.getNextToken().getValue().equals(".."));
		assertTrue(analisador.getNextToken().getValue().equals("size"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals("sizer"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("typedef"));
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("array"));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("sizer"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals("elements"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));		
		
		assertTrue(analisador.getNextToken().getValue().equals("sizer"));
		assertTrue(analisador.getNextToken().getValue().equals("j"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("elements"));
		assertTrue(analisador.getNextToken().getValue().equals("A"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("Boolean")); // Warning!
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));

		// declarando a função
		assertTrue(analisador.getNextToken().getValue().equals("proc"));
		assertTrue(analisador.getNextToken().getValue().equals("search"));
		assertTrue(analisador.getNextToken().getValue().equals("("));
		assertTrue(analisador.getNextToken().getValue().equals("val"));
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("target"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));	
		assertTrue(analisador.getNextToken().getValue().equals("val"));
		assertTrue(analisador.getNextToken().getValue().equals("elements"));
		assertTrue(analisador.getNextToken().getValue().equals("B"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("ref"));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("Boolean")); // Warning id
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals(")"));
		
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("m"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));	
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("Boolean"));
		assertTrue(analisador.getNextToken().getValue().equals("found"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("integer"));
		assertTrue(analisador.getNextToken().getValue().equals("where"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("begin"));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("1"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("m"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("size"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));		
		assertTrue(analisador.getNextToken().getValue().equals("found"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("false"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("do"));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals("<="));
		assertTrue(analisador.getNextToken().getValue().equals("m"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		
		assertTrue(analisador.getNextToken().getValue().equals("if"));
		assertTrue(analisador.getNextToken().getValue().equals("B"));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals("="));
		assertTrue(analisador.getNextToken().getValue().equals("target"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		assertTrue(analisador.getNextToken().getValue().equals("found"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("true"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("where"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("m"));
		assertTrue(analisador.getNextToken().getValue().equals("+"));
		assertTrue(analisador.getNextToken().getValue().equals("1"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("[]"));
		assertTrue(analisador.getNextToken().getValue().equals("B"));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals("#"));
		assertTrue(analisador.getNextToken().getValue().equals("target"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals(":="));
		assertTrue(analisador.getNextToken().getValue().equals("i"));
		assertTrue(analisador.getNextToken().getValue().equals("+"));
		assertTrue(analisador.getNextToken().getValue().equals("1"));		
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("fi"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("od"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals("="));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("found"));
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("where"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));	
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("end"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("begin"));
		assertTrue(analisador.getNextToken().getValue().equals("forall"));
		assertTrue(analisador.getNextToken().getValue().equals("j"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		assertTrue(analisador.getNextToken().getValue().equals("read"));
		assertTrue(analisador.getNextToken().getValue().equals("A"));
		assertTrue(analisador.getNextToken().getValue().equals("["));
		assertTrue(analisador.getNextToken().getValue().equals("j"));
		assertTrue(analisador.getNextToken().getValue().equals("]"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("llarof"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("read"));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		
		assertTrue(analisador.getNextToken().getValue().equals("do"));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals("#"));
		assertTrue(analisador.getNextToken().getValue().equals("0"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		assertTrue(analisador.getNextToken().getValue().equals("search"));
		assertTrue(analisador.getNextToken().getValue().equals("("));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("A"));
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals(")"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("if"));
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals("."));
		assertTrue(analisador.getNextToken().getValue().equals("1"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		
		assertTrue(analisador.getNextToken().getValue().equals("write"));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("' can be found at '"));
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals("."));
		assertTrue(analisador.getNextToken().getValue().equals("2"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("[]"));
		assertTrue(analisador.getNextToken().getValue().equals("~"));
		assertTrue(analisador.getNextToken().getValue().equals("result"));
		assertTrue(analisador.getNextToken().getValue().equals("."));
		assertTrue(analisador.getNextToken().getValue().equals("1"));
		assertTrue(analisador.getNextToken().getValue().equals("->"));
		assertTrue(analisador.getNextToken().getValue().equals("write"));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals(","));
		assertTrue(analisador.getNextToken().getValue().equals("' not found'"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("fi"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("read"));
		assertTrue(analisador.getNextToken().getValue().equals("x"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("od"));
		assertTrue(analisador.getNextToken().getValue().equals(";"));
		assertTrue(analisador.getNextToken().getValue().equals("end"));
		assertTrue(analisador.getNextToken().getValue().equals("."));
		
		

		
	}	

}
