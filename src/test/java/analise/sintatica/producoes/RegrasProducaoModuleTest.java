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

}
