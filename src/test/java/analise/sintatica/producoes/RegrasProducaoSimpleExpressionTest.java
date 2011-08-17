package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoSimpleExpressionTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// ( "+" | "-" )  <term> { <addingOperator> <term>} | <term> { <addingOperator> <term>}
		
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "432");
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.simpleExpression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoSimpleExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "simpleExpression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		ArvoreSintaticaAbstrataNo term = this.raiz.getListaDeNos().getFirst();
		assertEquals(term.getNome(), "term");
		assertEquals(term.possueNosFilhos(), true);

	}
	
	public void testSinalMaisETerm() {
		Token tokenMais = new Token(GCLTokenTypes.SYMBOL, "+");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "432");
		this.pilhaDeToken.add(tokenMais);
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.simpleExpression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoSimpleExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "simpleExpression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenMais.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenMais.getTokenType());
		
		i ++;
		ArvoreSintaticaAbstrataNo term = this.raiz.getListaDeNos().get(i);
		assertEquals(term.getNome(), "term");
		assertEquals(term.possueNosFilhos(), true);
	}
	
	public void testSinalMenosETerm() {
		Token tokenMenos = new Token(GCLTokenTypes.SYMBOL, "-");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "2");
		this.pilhaDeToken.add(tokenMenos);
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.simpleExpression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoSimpleExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "simpleExpression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenMenos.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenMenos.getTokenType());
		
		i ++;
		ArvoreSintaticaAbstrataNo term = this.raiz.getListaDeNos().get(i);
		assertEquals(term.getNome(), "term");
		assertEquals(term.possueNosFilhos(), true);

	}
	
	public void testSequenciaDeSinaisETerm() {
		Token tokenSinal1 = new Token(GCLTokenTypes.SYMBOL, "+");
		Token tokenNumero2 = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenSinal2 = new Token(GCLTokenTypes.SYMBOL, "-");
		Token tokenNumero3 = new Token(GCLTokenTypes.NUMBER, "3");
		Token tokenSinal3 = new Token(GCLTokenTypes.SYMBOL, "+");
		Token tokenNumero4 = new Token(GCLTokenTypes.NUMBER, "4");		
		this.pilhaDeToken.add(tokenSinal1);
		this.pilhaDeToken.add(tokenNumero2);
		this.pilhaDeToken.add(tokenSinal2);
		this.pilhaDeToken.add(tokenNumero3);
		this.pilhaDeToken.add(tokenSinal3);
		this.pilhaDeToken.add(tokenNumero4);		
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.simpleExpression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoSimpleExpression");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "simpleExpression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		

	}	

}
