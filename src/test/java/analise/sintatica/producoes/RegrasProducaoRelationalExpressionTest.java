package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoRelationalExpressionTest extends
		RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <simpleExpression> [<relationalOperator> <simpleExpression>]
		
		Token tokenSinal1 = new Token(GCLTokenTypes.SYMBOL, "-");
		Token tokenNumero2 = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenSinalMaior = new Token(GCLTokenTypes.SYMBOL, "<");
		Token tokenSinal2 = new Token(GCLTokenTypes.SYMBOL, "-");
		Token tokenNumero3 = new Token(GCLTokenTypes.NUMBER, "3");
		this.pilhaDeToken.add(tokenSinal1);
		this.pilhaDeToken.add(tokenNumero2);
		this.pilhaDeToken.add(tokenSinalMaior);
		this.pilhaDeToken.add(tokenSinal2);
		this.pilhaDeToken.add(tokenNumero3);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalExpression");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalExpression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		
		ArvoreSintaticaAbstrataNo simple1;
		simple1 = this.raiz.getListaDeNos().get(i);
		assertEquals(simple1.getNome(), "simpleExpression");
		assertEquals(simple1.getListaDeNos().size(), 2);

		i++;
		ArvoreSintaticaAbstrataNo relationalOperator;
		relationalOperator = this.raiz.getListaDeNos().get(i);
		assertEquals(relationalOperator.getNome(), "relationalOperator");
		assertEquals(relationalOperator.getListaDeNos().size(), 1);
		
		i++;
		ArvoreSintaticaAbstrataNo simple2;
		simple2 = this.raiz.getListaDeNos().get(i);
		assertEquals(simple2.getNome(), "simpleExpression");
		assertEquals(simple2.getListaDeNos().size(), 2);

	}
	
	public void testSemOperadorRelacional() {
		// <simpleExpression> [<relationalOperator> <simpleExpression>]
		
		Token tokenSinal1 = new Token(GCLTokenTypes.SYMBOL, "-");
		Token tokenNumero2 = new Token(GCLTokenTypes.NUMBER, "2");
		this.pilhaDeToken.add(tokenSinal1);
		this.pilhaDeToken.add(tokenNumero2);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.relationalExpression);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRelationalExpression");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "relationalExpression");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);

	}	

}
