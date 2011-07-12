package analise.lexica;

import analise.exceptions.EndOfBufferException;
import analise.exceptions.InvalidTokenException;
import analise.lexica.AnaliseLexica;
import utils.GCLTokenTypes;
import coretypes.Token;
import junit.framework.TestCase;

public class AnaliseLexicaTest extends TestCase {

	private AnaliseLexica analisador;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.analisador = new AnaliseLexica("");
	}

	public void testValidaTokenKeywordBegin() {
		assertTrue(analisador.validaLexema("begin"));
	}

	public void testValidaTokenKeywordBeginCaseInsensitive() throws Exception {
		Token token = analisador.buildToken("BeGiN");
		GCLTokenTypes id = GCLTokenTypes.KEYWORD;

		assertEquals(token.getTokenType(), id);

	}

	public void testValidaTokenKeywordBeginCaseInsensitiveNaoEhIdentificador()
			throws Exception {
		Token token = analisador.buildToken("BeGiN");
		GCLTokenTypes id = GCLTokenTypes.IDENTIFIER;

		assertNotSame(token.getTokenType(), id);

	}

	public void testValidaUnknownTokenKeywordBejin() throws Exception {
		assertTrue(analisador.buildToken("BeJiN").getTokenType() == GCLTokenTypes.IDENTIFIER);
	}

	public void testValidaIdentifierToken() {
		try {
			Token id = analisador.buildToken("minhavariavel", "");
			assertEquals(GCLTokenTypes.IDENTIFIER, id.getTokenType());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void testValidaIdentifierTokenInvalid() {
		try {

			Token id = analisador.buildToken("minhavariavel@", "");
			assertEquals(null, id);
			fail("Token invalido.");
		} catch (Exception e) {

		}
	}

	public void testValidaLiteralStringSimples() {
		try {
			Token id = analisador.buildToken("'oi'", "");
			assertEquals(GCLTokenTypes.LITERAL, id.getTokenType());
			assertEquals("'oi'", id.getValue());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void testValorInteiro() {
		assertTrue(this.analisador.validaLexema("1234567890"));
	}

	public void testValorReal() {
		assertTrue(this.analisador.validaLexema("12,34567890"));
	}

	public void testValorRealComDuasVirgulas() {
		assertFalse(this.analisador.validaLexema("1,345678,90"));
	}

	public void testValorRealComPonto() {
		assertFalse(this.analisador.validaLexema("1345678.90"));
	}

	public void testValorInteiroNegativo() {

		this.analisador = new AnaliseLexica("-123");
		Token token;

		try {
			token = this.analisador.getNextToken();
			assertEquals("-", token.getValue());
			assertEquals(GCLTokenTypes.SYMBOL, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals("123", token.getValue());
			assertEquals(GCLTokenTypes.NUMBER, token.getTokenType());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void testValidaLiteralStringLonga() {
		try {
			String texto = "' sdf sedf -- sdfdf @ dsf @! ! __ 33456  '";
			Token id = analisador.buildToken(texto, "");
			assertEquals(GCLTokenTypes.LITERAL, id.getTokenType());
			assertEquals(texto, id.getValue());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void testValidaTokenInvalidoArroba() throws EndOfBufferException {
		assertFalse(analisador.validaLexema("begin@"));

		this.analisador = new AnaliseLexica("begin@ end.");
		try {
			Token token = analisador.getNextToken();
			assertTrue(token.getValue().equalsIgnoreCase("begin"));
		} catch (Exception e) {
			fail(e.getMessage());
		}

		// must fail
		try {
			analisador.getNextToken();
		} catch (InvalidTokenException e) {
			assertTrue(true);
		}
	}

	public void testValidaTokenInvalido() throws EndOfBufferException {
		this.analisador = new AnaliseLexica("@");

		// must fail
		try {
			this.analisador.getNextToken();
			fail();
		} catch (InvalidTokenException e) {
			assertTrue(true);
		}

	}
	
	public void testValorComDuasVirgulas2(){
		this.analisador = new AnaliseLexica("4,32,4");
		Token token;
		//Implementar testValorComDuasVirgulas novamente para testar
	}

	public void testValorComDuasVirgulas() throws EndOfBufferException {
		this.analisador = new AnaliseLexica("4,32,4");

		Token token;

		try {
			token = this.analisador.getNextToken();

			assertEquals("4,32", token.getValue());
			assertEquals(GCLTokenTypes.NUMBER, token.getTokenType());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		try {
			token = this.analisador.getNextToken();
			fail();
		} catch (InvalidTokenException e) {
			assertTrue(true);
		}		

	}

	public void testTokenAll() {

		this.analisador = new AnaliseLexica("begin 123 'teste' -4,32,4");
		// / this.analisador.addTokenClassException(GCLTokenTypes.WHITESPACE);
		Token token;

		try {
			token = this.analisador.getNextToken();
			assertEquals("begin", token.getValue());
			assertEquals(GCLTokenTypes.KEYWORD, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals(" ", token.getValue());
			assertEquals(GCLTokenTypes.WHITESPACE, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals("123", token.getValue());
			assertEquals(GCLTokenTypes.NUMBER, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals(" ", token.getValue());
			assertEquals(GCLTokenTypes.WHITESPACE, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals("'teste'", token.getValue());
			assertEquals(GCLTokenTypes.LITERAL, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals(" ", token.getValue());
			assertEquals(GCLTokenTypes.WHITESPACE, token.getTokenType());

			token = this.analisador.getNextToken();
			assertEquals("-", token.getValue());
			assertEquals(GCLTokenTypes.SYMBOL, token.getTokenType());

			token = this.analisador.getNextToken();

			assertEquals("4,32,4", token.getValue());
			assertEquals(GCLTokenTypes.NUMBER, token.getTokenType());

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
}
