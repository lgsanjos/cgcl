package analise.lexica;


import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import analise.lexica.AnaliseLexica;
import coretypes.Token;
import coretypes.gcl.GCLDataTypes;
import coretypes.gcl.GCLTokenTypes;
import utils.Utils;

public class AnaliseLexicaIntegracaoTest extends TestCase {
	
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	
    }	
	
    protected void assertToken(Token token, String lexema, GCLTokenTypes tokenType){
    	assertEquals(lexema, token.getValue());
    	assertEquals(tokenType, token.getTokenType());
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
		
		assertToken(analisador.getNextToken(), "module", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), "testandoDeclaracoesEValores", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), "private", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), "integer", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), "varInteira", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "real", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), "varReal", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "Boolean", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), "varBoolean", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		
		assertToken(analisador.getNextToken(), "string", GCLTokenTypes.IDENTIFIER); // avaliar se string é keyword
		assertToken(analisador.getNextToken(), "varString", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "begin", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), "varInteira", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "123", GCLTokenTypes.NUMBER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varInteira", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "-", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "123", GCLTokenTypes.NUMBER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varReal", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "23434", GCLTokenTypes.NUMBER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varReal", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "-", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "23434", GCLTokenTypes.NUMBER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varReal", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "234,34", GCLTokenTypes.NUMBER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varReal", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "-", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "4,34", GCLTokenTypes.NUMBER);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varBoolean", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "true", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varBoolean", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "false", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "varString", GCLTokenTypes.IDENTIFIER);
		assertToken(analisador.getNextToken(), ":=", GCLTokenTypes.SYMBOL);
		assertToken(analisador.getNextToken(), "'qualquer coisa'", GCLTokenTypes.LITERAL);
		assertToken(analisador.getNextToken(), ";", GCLTokenTypes.SYMBOL);
		
		assertToken(analisador.getNextToken(), "end", GCLTokenTypes.KEYWORD);
		assertToken(analisador.getNextToken(), ".", GCLTokenTypes.SYMBOL);

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
