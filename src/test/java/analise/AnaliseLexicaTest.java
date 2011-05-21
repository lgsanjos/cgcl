package analise;

import analise.lexica.AnaliseLexica;
import utils.GCLTokenTypes;
import coretypes.Token;
import junit.framework.TestCase;

public class AnaliseLexicaTest extends TestCase {

	private	AnaliseLexica analisador;
    
    
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	
    	this.analisador = new AnaliseLexica("");
    }

    
	public void testValidaTokenKeywordBegin() {
        assertTrue( analisador.validaLexema("begin") );    
	}
	

	public void testValidaTokenKeywordBeginCaseInsensitive() throws Exception{
		assertTrue( analisador.buildToken("BeGiN").getTokenType() == GCLTokenTypes.Identifier);
            
	}

	public void testValidaUnknownTokenKeywordBejin() throws Exception {
		assertTrue( analisador.buildToken("BeJiN").getTokenType() == GCLTokenTypes.Identifier);
	}

	public void testValidaIdentifierToken() {
		try{
		  Token id = analisador.buildToken("minhavariavel","");
          assertEquals( GCLTokenTypes.Identifier, id.getTokenType());
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	public void testValidaIdentifierTokenInvalid() {
		try{
			
		  Token id = analisador.buildToken("minhavariavel@","");
          assertEquals( null, id );
          fail("Token inválido.");
		}catch(Exception e){
			
		}
	}

	public void testValidaLiteralStringSimples(){
		try{
			  Token id = analisador.buildToken("'oi'","");
	          assertEquals( GCLTokenTypes.Literal, id.getTokenType());
	          assertEquals( "'oi'", id.getValue() );
			}catch(Exception e){
				fail(e.getMessage());
			}
	}

	public void testValidaLiteralStringLonga(){
		try{
			  String texto = "' sdf sedf -- sdfdf @ dsf @! ! __ 33456  '";
			  Token id = analisador.buildToken(texto,"");
	          assertEquals( GCLTokenTypes.Literal, id.getTokenType());
	          assertEquals( texto, id.getValue() );
			}catch(Exception e){
				fail(e.getMessage());
			}
	}
	

}
