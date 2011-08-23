package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoTypeTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <typeSymbol> [ <arraytype> | <rangetype> ] | <tupletype>
		
		Token token = new Token(GCLTokenTypes.KEYWORD, "integer");
		Token tokenArray = new Token(GCLTokenTypes.KEYWORD, "array");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "identificador");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		
		this.pilhaDeToken.add(token);
		this.pilhaDeToken.add(tokenArray);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenFechaColchete);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.type);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "type");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "typeSymbol");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "arrayType");

	}
	
	public void testCasoRangeType() {
		Token token = new Token(GCLTokenTypes.KEYWORD, "integer");
		Token tokenRange = new Token(GCLTokenTypes.KEYWORD, "range");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenDoisPontos = new Token(GCLTokenTypes.SYMBOL, "..");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(token);
		this.pilhaDeToken.add(tokenRange);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenDoisPontos);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.type);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "type");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "typeSymbol");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "rangeType");
	}
	
	public void testCasoTupleType() {
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenBoolean = new Token(GCLTokenTypes.KEYWORD, "Boolean");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenBoolean);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.type);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "type");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "tupleType");
	}	
	
}
