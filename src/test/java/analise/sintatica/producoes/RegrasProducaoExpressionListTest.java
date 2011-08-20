package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;


public class RegrasProducaoExpressionListTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.expressionList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoExpressionList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "expressionList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		ArvoreSintaticaAbstrataNo expression;
		expression = this.raiz.getListaDeNos().getFirst();
		assertNotNull(expression);
		assertEquals(expression.getNome(), "expression");
		assertNull(expression.getToken());
		assertEquals(expression.possueNosFilhos(), true);
		assertEquals(expression.getListaDeNos().size(), 1);
		
	}
	
	public void testCasoComVariasExpressions() {
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenTres = new Token(GCLTokenTypes.NUMBER, "3");
		Token tokenMenorIgual = new Token(GCLTokenTypes.SYMBOL, "<=");
		Token tokenZero = new Token(GCLTokenTypes.NUMBER, "0");		
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenTres);
		this.pilhaDeToken.add(tokenMenorIgual);
		this.pilhaDeToken.add(tokenZero);		
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.expressionList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoExpressionList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "expressionList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		ArvoreSintaticaAbstrataNo expression = this.raiz.getListaDeNos().get(i);
		assertNotNull(expression);
		assertEquals(expression.getNome(), "expression");
		assertNull(expression.getToken());
		assertEquals(expression.possueNosFilhos(), true);
		assertEquals(expression.getListaDeNos().size(), 1);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenVirgula.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenVirgula.getTokenType());
		
		i++;
		expression = this.raiz.getListaDeNos().get(i);
		assertNotNull(expression);
		assertEquals(expression.getNome(), "expression");
		assertNull(expression.getToken());
		assertEquals(expression.possueNosFilhos(), true);
		assertEquals(expression.getListaDeNos().size(), 1);		
		
	}
	
	public void testCasoComUmaExpressionEUmaVirgula() {
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenVirgula);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.expressionList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoExpressionList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
			fail("Deveria ter dado excecao");
		} catch (ProducaoSintaticaException e) {
			assertNull(this.raiz);
		}
	}
	

}
