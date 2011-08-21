package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoArrayTypeTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "array" "[" "identifier" "]" {"[" "identifier" "]"}
		
		Token tokenArray = new Token(GCLTokenTypes.KEYWORD, "array");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "identificador");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");		
		this.pilhaDeToken.add(tokenArray);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.arraytype);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoArrayType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "arrayType");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 4);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "array");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "identificador");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);

	}
	
	public void testComArrayBidimensional() {
		Token tokenArray = new Token(GCLTokenTypes.KEYWORD, "array");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenIdDois = new Token(GCLTokenTypes.IDENTIFIER, "id2");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		Token tokenAbreColchete2 = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenIdTres = new Token(GCLTokenTypes.IDENTIFIER, "id3");
		Token tokenFechaColchete2 = new Token(GCLTokenTypes.SYMBOL, "]");		
		this.pilhaDeToken.add(tokenArray);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenIdDois);
		this.pilhaDeToken.add(tokenFechaColchete);
		this.pilhaDeToken.add(tokenAbreColchete2);
		this.pilhaDeToken.add(tokenIdTres);
		this.pilhaDeToken.add(tokenFechaColchete2);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.arraytype);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoArrayType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "arrayType");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 7);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "array");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "id2");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "id3");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);		
	}

}
