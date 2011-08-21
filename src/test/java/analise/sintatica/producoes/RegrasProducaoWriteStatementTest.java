package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoWriteStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "write" <writeItem> {"," <writeItem> }
		
		Token tokenWrite = new Token(GCLTokenTypes.KEYWORD, "write");
		Token tokenLiteral = new Token(GCLTokenTypes.LITERAL, "uma string literal");
		this.pilhaDeToken.add(tokenWrite);
		this.pilhaDeToken.add(tokenLiteral);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.writeStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoWriteStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "writeStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);

		int i = 0;
		assertNotNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getToken().getValue(), "write");	
		assertEquals(raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getNome(), "writeItem");		

	}
	
	public void testCasoComVariasWriteItem() {
		Token tokenWrite = new Token(GCLTokenTypes.KEYWORD, "write");
		Token tokenLiteral1 = new Token(GCLTokenTypes.LITERAL, "uma string literal");
		Token tokenVirgula1 = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenLiteral2 = new Token(GCLTokenTypes.LITERAL, "outra string literal");
		Token tokenVirgula2 = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenDois = new Token(GCLTokenTypes.LITERAL, "2");
		Token tokenMaior = new Token(GCLTokenTypes.LITERAL, ">");
		Token tokenUm = new Token(GCLTokenTypes.LITERAL, "1");
		
		this.pilhaDeToken.add(tokenWrite);
		this.pilhaDeToken.add(tokenLiteral1);
		this.pilhaDeToken.add(tokenVirgula1);
		this.pilhaDeToken.add(tokenLiteral2);
		this.pilhaDeToken.add(tokenVirgula2);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaior);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.writeStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoWriteStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "writeStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);

		int i = 0;
		assertNotNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getToken().getValue(), "write");	
		assertEquals(raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getNome(), "writeItem");
		
		i++;
		assertNotNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getToken().getValue(), ",");	
		assertEquals(raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getNome(), "writeItem");
		
		i++;
		assertNotNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getToken().getValue(), ",");	
		assertEquals(raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertNull(raiz.getListaDeNos().get(i).getToken());
		assertEquals(raiz.getListaDeNos().get(i).getNome(), "writeItem");		

	}

}
