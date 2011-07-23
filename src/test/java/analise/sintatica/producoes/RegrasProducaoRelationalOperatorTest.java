package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.Token;

public class RegrasProducaoRelationalOperatorTest extends
		RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
			
		Token token = new Token(GCLTokenTypes.SYMBOL, ">");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoSinalDeMenor() {
		
		Token token = new Token(GCLTokenTypes.SYMBOL, "<");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoSinalDeIgualdade() {
		
		Token token = new Token(GCLTokenTypes.SYMBOL, "=");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoSinalDeMenorIgual() {
		
		Token token = new Token(GCLTokenTypes.SYMBOL, "<=");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoSinalDeMaiorIgual() {
		
		Token token = new Token(GCLTokenTypes.SYMBOL, ">=");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoSinalSustenido() {
		
		Token token = new Token(GCLTokenTypes.SYMBOL, "#");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}

}
