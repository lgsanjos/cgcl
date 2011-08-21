package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoTupleTypeTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "[" <typeSymbol> { "," <typeSymbol> } "]"
		
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenBoolean = new Token(GCLTokenTypes.KEYWORD, "Boolean");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenBoolean);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.tupletype);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTupleType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "tupleType");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "typeSymbol");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);			
		
	}
	
	public void testComVariasTuplas() {
		
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenBoolean = new Token(GCLTokenTypes.KEYWORD, "Boolean");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "Integer");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenBoolean);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.tupletype);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTupleType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "tupleType");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 5);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "typeSymbol");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ",");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "typeSymbol");		
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);		
		
	}

}
