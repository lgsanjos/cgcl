package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoReturnStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		Token tokenReturn = new Token(GCLTokenTypes.KEYWORD, "return");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		this.pilhaDeToken.add(tokenReturn);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.returnStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoReturnStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "returnStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenReturn.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenReturn.getTokenType());
		
		i++;
		
		ArvoreSintaticaAbstrataNo expression = this.raiz.getListaDeNos().get(i);
		assertNotNull(expression);
		assertEquals(expression.getNome(), "expression");
		assertEquals(expression.possueNosFilhos(), true);
		assertEquals(expression.getListaDeNos().size(), 1);
		
	}
	
	public void testReturnSemExpression() {
		Token tokenReturn = new Token(GCLTokenTypes.KEYWORD, "return");
		this.pilhaDeToken.add(tokenReturn);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.returnStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoReturnStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
			assertNull(this.raiz);
			fail("Deveria ter disparado excessao");
		} catch (ProducaoSintaticaException e) {
			assertNull(this.raiz);
		}
		
	}	

}
