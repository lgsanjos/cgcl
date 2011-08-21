package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoWriteItemTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "stringconst" | <expression>
		Token tokenLiteral = new Token(GCLTokenTypes.LITERAL, "uma string literal");
		this.pilhaDeToken.add(tokenLiteral);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.writeItem);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoWriteItem");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "writeItem");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);

		int i = 0;
		assertNotNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getToken().getValue(), tokenLiteral.getValue());	
		assertEquals(raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenLiteral.getTokenType());
	}
	
	public void testWriteItemComExpression() {
		// "stringconst" | <expression>
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.writeItem);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoWriteItem");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "writeItem");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);

		ArvoreSintaticaAbstrataNo expression;
		expression = this.raiz.getListaDeNos().getFirst();
		
		assertNotNull(expression);
		assertEquals(expression.getNome(), "expression");
		assertNull(expression.getToken());
		assertEquals(expression.possueNosFilhos(), true);
		
	}

}
