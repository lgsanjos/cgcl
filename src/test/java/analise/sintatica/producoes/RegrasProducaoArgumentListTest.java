package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoArgumentListTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "(" [ <expressionList> ] ")" 
		
		Token tokenAbreParenteses = new Token(GCLTokenTypes.SYMBOL, "(");
		Token tokenFechaParenteses = new Token(GCLTokenTypes.SYMBOL, ")");		
		this.pilhaDeToken.add(tokenAbreParenteses);
		this.pilhaDeToken.add(tokenFechaParenteses);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.argumentList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoArgumentList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "argumentList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenAbreParenteses.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenAbreParenteses.getTokenType());

		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenFechaParenteses.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenFechaParenteses.getTokenType());		
	
	}
	
	public void testComExpressionList() {
		Token tokenAbreParenteses = new Token(GCLTokenTypes.SYMBOL, "(");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenTres = new Token(GCLTokenTypes.NUMBER, "3");
		Token tokenMenorIgual = new Token(GCLTokenTypes.SYMBOL, "<=");
		Token tokenZero = new Token(GCLTokenTypes.NUMBER, "0");
		Token tokenFechaParenteses = new Token(GCLTokenTypes.SYMBOL, ")");
		this.pilhaDeToken.add(tokenAbreParenteses);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenTres);
		this.pilhaDeToken.add(tokenMenorIgual);
		this.pilhaDeToken.add(tokenZero);		
		this.pilhaDeToken.add(tokenFechaParenteses);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.argumentList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoArgumentList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "argumentList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenAbreParenteses.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenAbreParenteses.getTokenType());
		
		i++;
		ArvoreSintaticaAbstrataNo expressionList = this.raiz.getListaDeNos().get(i);
		assertNotNull(expressionList);
		assertEquals(expressionList.getNome(), "expressionList");
		assertNull(expressionList.getToken());
		assertEquals(expressionList.possueNosFilhos(), true);
		assertEquals(expressionList.getListaDeNos().size(), 3);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenFechaParenteses.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenFechaParenteses.getTokenType());		
	}

}
