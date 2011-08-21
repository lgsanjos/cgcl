package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		/* <emptyStatement> | <readStatement> | <writeStatement> | <assignStatement> | <returnStatement> | <callStatement>
			| <ifStatement> | <doStatement> | <forStatement> */
		
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		this.pilhaDeToken.add(tokenSkip);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.statement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "statement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "emptyStatement");
		
	}
	
	public void testCasoReadStatement() {
		Token tokenRead = new Token(GCLTokenTypes.KEYWORD, "read");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenOutroId = new Token(GCLTokenTypes.IDENTIFIER, "outroId");

		this.pilhaDeToken.add(tokenRead);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenOutroId);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.statement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "statement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "readStatement");			
	}
	
	public void testCasoWriteStatement() {
		Token tokenWrite = new Token(GCLTokenTypes.KEYWORD, "write");
		Token tokenLiteral = new Token(GCLTokenTypes.LITERAL, "uma string literal");
		this.pilhaDeToken.add(tokenWrite);
		this.pilhaDeToken.add(tokenLiteral);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.statement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "statement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "writeStatement");		
	}
	
	public void testCasoAssignStatement() {
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenOutroId = new Token(GCLTokenTypes.IDENTIFIER, "outroId");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");

		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenOutroId);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.statement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "statement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "assignStatement");				
		
	}
	
	public void testCasoReturnStatement(){
		Token tokenReturn = new Token(GCLTokenTypes.KEYWORD, "return");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		this.pilhaDeToken.add(tokenReturn);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.statement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "statement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "returnStatement");		

	}
	
	// TODO: implementar testes para os demais casos.

}
