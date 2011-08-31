package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoModuleTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "module" "identifier" <definitionPart> [ "private" ] [ <block> ] "."
		
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "testModule");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 5);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "testModule");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");
	
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			

	}
	
	public void testComPrivate() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "testModule");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "testModule");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "private");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}
	
	public void testSimplesPacas() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "simplesPacas");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 5);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "simplesPacas");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}
	
	public void testAtribuicaoSimples() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "atribuicaoSimples");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");
		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "integer");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenId2 = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenTres = new Token(GCLTokenTypes.NUMBER, "3");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenPontoEVirgula);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenId2);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenTres);
		this.pilhaDeToken.add(tokenPontoEVirgula);		
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "atribuicaoSimples");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "private");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}
	
	public void testAtribuicaoSimplesDeString() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "atribuicaoSimples");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");
		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "string");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenId2 = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenString = new Token(GCLTokenTypes.LITERAL, "'uma string'");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenPontoEVirgula);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenId2);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenString);
		this.pilhaDeToken.add(tokenPontoEVirgula);		
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "atribuicaoSimples");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "private");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}
	
	public void testAtribuicaoSimplesDeReal() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "atribuicaoSimples");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");
		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "real");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenId2 = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "34,4");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenPontoEVirgula);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenId2);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenNumero);
		this.pilhaDeToken.add(tokenPontoEVirgula);		
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "atribuicaoSimples");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "private");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}

	public void testAtribuicaoSimplesDeRealNegativo() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "atribuicaoSimples");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");
		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "real");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenId2 = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenMenos = new Token(GCLTokenTypes.SYMBOL, "-");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "34,4");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenPontoEVirgula);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenId2);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenMenos);
		this.pilhaDeToken.add(tokenNumero);
		this.pilhaDeToken.add(tokenPontoEVirgula);		
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "atribuicaoSimples");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "private");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}
	
	public void testAtribuicaoSimplesDeBoolean() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "atribuicaoSimples");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");
		Token tokenTipo = new Token(GCLTokenTypes.KEYWORD, "boolean");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenId2 = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenTrue = new Token(GCLTokenTypes.NUMBER, "true");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenTipo);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenPontoEVirgula);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenId2);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenTrue);
		this.pilhaDeToken.add(tokenPontoEVirgula);		
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "atribuicaoSimples");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "private");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}		
	
	
	public void testAtribuicaoIntegerEString() {
		Token tokenModule = new Token(GCLTokenTypes.KEYWORD, "module");
		Token tokenIdModule = new Token(GCLTokenTypes.IDENTIFIER, "atribuicaoSimples");
		Token tokenPrivate = new Token(GCLTokenTypes.KEYWORD, "private");

		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "integer");
		Token tokenIntegerId = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenIntegerPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		
		Token tokenString = new Token(GCLTokenTypes.KEYWORD, "string");
		Token tokenStringId = new Token(GCLTokenTypes.IDENTIFIER, "b");
		Token tokenStringPontoEVirgula = new Token(GCLTokenTypes.SYMBOL, ";");		
		
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		
		Token tokenStringId2 = new Token(GCLTokenTypes.IDENTIFIER, "b");
		Token tokenStringRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenStringLiteral = new Token(GCLTokenTypes.LITERAL, "'uma string'");
		
		Token tokenIntegerId2 = new Token(GCLTokenTypes.IDENTIFIER, "a");
		Token tokenIntegerRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenIntegerTres = new Token(GCLTokenTypes.NUMBER, "3");
		
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ".");
		this.pilhaDeToken.add(tokenModule);
		this.pilhaDeToken.add(tokenIdModule);
		this.pilhaDeToken.add(tokenPrivate);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenIntegerId);
		this.pilhaDeToken.add(tokenIntegerPontoEVirgula);
		this.pilhaDeToken.add(tokenString);
		this.pilhaDeToken.add(tokenStringId);
		this.pilhaDeToken.add(tokenStringPontoEVirgula);
		this.pilhaDeToken.add(tokenBegin);
		
		this.pilhaDeToken.add(tokenStringId2);
		this.pilhaDeToken.add(tokenStringRecebe);
		this.pilhaDeToken.add(tokenStringLiteral);
		this.pilhaDeToken.add(tokenStringPontoEVirgula);
		
		this.pilhaDeToken.add(tokenIntegerId2);
		this.pilhaDeToken.add(tokenIntegerRecebe);
		this.pilhaDeToken.add(tokenIntegerTres);
		this.pilhaDeToken.add(tokenIntegerPontoEVirgula);
		
		this.pilhaDeToken.add(tokenEnd);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.module);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoModule");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "module");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "module");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "atribuicaoSimples");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "private");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ".");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
	}	

}
