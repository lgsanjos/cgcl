package analise.sintatica.producoes;

import java.util.LinkedList;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoFactorTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// Number
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "432");
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenNumero.getTokenType());				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenNumero.getValue());

	}
	
	public void testVariableAccess() {
		// VariableAccess
		
		Token tokenIdentificador = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		this.pilhaDeToken.add(tokenIdentificador);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		LinkedList<ArvoreSintaticaAbstrataNo> nos = this.raiz.getListaDeNos().get(i).getListaDeNos();
		assertEquals(nos.get(i).getToken().getTokenType(), tokenIdentificador.getTokenType());				
		assertEquals(nos.get(i).getToken().getValue(), tokenIdentificador.getValue());
		
	}
	
	public void testBooleanConstant() {
		// booleanConstant
		Token tokenTrue = new Token(GCLTokenTypes.KEYWORD, "true");
		this.pilhaDeToken.add(tokenTrue);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		ArvoreSintaticaAbstrataNo booleanConst = this.raiz.getListaDeNos().getFirst();
		assertEquals(booleanConst.getListaDeNos().getFirst().getToken().getTokenType(), tokenTrue.getTokenType());
		assertEquals(booleanConst.getListaDeNos().getFirst().getToken().getValue(), tokenTrue.getValue());
	}
	
	public void testTilFactor() {
		// "~" <factor>
		Token tokenTil = new Token(GCLTokenTypes.SYMBOL, "~");
		Token tokenTrue = new Token(GCLTokenTypes.KEYWORD, "true");
		this.pilhaDeToken.add(tokenTil);
		this.pilhaDeToken.add(tokenTrue);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;	
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenTil.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenTil.getValue());
		
		i ++;
		ArvoreSintaticaAbstrataNo booleanConstant;
		booleanConstant = this.raiz.getListaDeNos().get(i).getListaDeNos().getFirst();
		assertTrue(booleanConstant.possueNosFilhos());
		assertEquals(booleanConstant.getNome(), "booleanConstant");
		assertEquals(booleanConstant.getListaDeNos().size(), 1);
		
		assertEquals(booleanConstant.getListaDeNos().getFirst().getToken().getTokenType(), tokenTrue.getTokenType());
		assertEquals(booleanConstant.getListaDeNos().getFirst().getToken().getValue(), tokenTrue.getValue());		
	}
	
	public void testComExpression() {
		// "(" <expression> ")"
		Token tokenAbreParenteses = new Token(GCLTokenTypes.SYMBOL, "(");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenFechaParenteses = new Token(GCLTokenTypes.SYMBOL, ")");
		this.pilhaDeToken.add(tokenAbreParenteses);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenFechaParenteses);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenAbreParenteses.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenAbreParenteses.getValue());

		i++;		
		ArvoreSintaticaAbstrataNo expression;
		expression = this.raiz.getListaDeNos().get(i);
		assertNotNull(expression);
		assertEquals(expression.getNome(), "expression");
		assertNull(expression.getToken());
		assertEquals(expression.possueNosFilhos(), true);
		assertEquals(expression.getListaDeNos().size(), 3);
		// Nao valida a expression, pois já há teste para ela
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenFechaParenteses.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenFechaParenteses.getValue());
		
	}

	// "[" <expressionList> "]"
	public void testComExpressionList() {
		// "(" <expression> ")"
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenAbreColchete.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenAbreColchete.getValue());

		i++;		
		ArvoreSintaticaAbstrataNo expressionList;
		expressionList = this.raiz.getListaDeNos().get(i);
		assertNotNull(expressionList);
		assertEquals(expressionList.getNome(), "expressionList");
		assertNull(expressionList.getToken());
		assertEquals(expressionList.possueNosFilhos(), true);
		assertEquals(expressionList.getListaDeNos().size(), 1);
		// Nao valida a expressionList, pois já há teste para ela
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenFechaColchete.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenFechaColchete.getValue());
		
	}	
}
