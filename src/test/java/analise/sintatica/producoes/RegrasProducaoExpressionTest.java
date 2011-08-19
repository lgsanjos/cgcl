package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoExpressionTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.expression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "expression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);

		ArvoreSintaticaAbstrataNo relationalExpression;
		relationalExpression = this.raiz.getListaDeNos().getFirst();
		
		assertNotNull(relationalExpression);
		assertEquals(relationalExpression.getNome(), "relationalExpression");
		assertNull(relationalExpression.getToken());
		assertEquals(relationalExpression.possueNosFilhos(), true);
		assertEquals(relationalExpression.getListaDeNos().size(), 3);		
		
		int i = 0;
		assertEquals(relationalExpression.getListaDeNos().get(i).getNome(), "simpleExpression");	
		i++;
		assertEquals(relationalExpression.getListaDeNos().get(i).getNome(), "relationalOperator");	
		i++;
		assertEquals(relationalExpression.getListaDeNos().get(i).getNome(), "simpleExpression");	
	}
	
	public void testRelationalOperatorFaltandoUmaSimpleExpression() {
		
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.expression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
			fail("Deveria ter disparado excecao ProducaoSintaticaException");
		} catch (ProducaoSintaticaException e) {
			assertNull(this.raiz);
		}
		

	}
	
	public void testExpressaoCompletaComUmaBooleanOperator() {
		
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenOr = new Token(GCLTokenTypes.SYMBOL, "|");
		Token tokenFalse = new Token(GCLTokenTypes.KEYWORD, "false");
		
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenOr);
		this.pilhaDeToken.add(tokenFalse);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.expression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "expression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);

		int j = 0;
		ArvoreSintaticaAbstrataNo relationalExpression;
		relationalExpression = this.raiz.getListaDeNos().get(j);
		assertNotNull(relationalExpression);
		assertEquals(relationalExpression.getNome(), "relationalExpression");
		assertNull(relationalExpression.getToken());
		assertEquals(relationalExpression.possueNosFilhos(), true);
		assertEquals(relationalExpression.getListaDeNos().size(), 3);		
		
		int i = 0;
		assertEquals(relationalExpression.getListaDeNos().get(i).getNome(), "simpleExpression");	
		i++;
		assertEquals(relationalExpression.getListaDeNos().get(i).getNome(), "relationalOperator");	
		i++;
		assertEquals(relationalExpression.getListaDeNos().get(i).getNome(), "simpleExpression");	assertNotNull(this.raiz);
		
		
		j ++;
		ArvoreSintaticaAbstrataNo booleanOperator;
		booleanOperator = this.raiz.getListaDeNos().get(j);
		assertNotNull(booleanOperator);
		assertEquals(booleanOperator.getNome(), "booleanOperator");
		assertNull(booleanOperator.getToken());
		assertEquals(booleanOperator.possueNosFilhos(), true);
		assertEquals(booleanOperator.getListaDeNos().size(), 1);
		
		j ++;
		ArvoreSintaticaAbstrataNo relationalExpression2;
		relationalExpression2 = this.raiz.getListaDeNos().get(j);
		assertNotNull(relationalExpression2);
		assertEquals(relationalExpression2.getNome(), "relationalExpression");
		assertNull(relationalExpression2.getToken());
		assertEquals(relationalExpression2.possueNosFilhos(), true);
		assertEquals(relationalExpression2.getListaDeNos().size(), 1);			
		
		
		}
		
}
