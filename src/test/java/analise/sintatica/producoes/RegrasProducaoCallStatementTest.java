package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoCallStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "identifier" ["." "identifier"] <argumentList>
			Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "doSomething");
			Token tokenAbreParenteses = new Token(GCLTokenTypes.SYMBOL, "(");
			Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
			Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
			Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
			Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
			Token tokenTres = new Token(GCLTokenTypes.NUMBER, "3");
			Token tokenMenorIgual = new Token(GCLTokenTypes.SYMBOL, "<=");
			Token tokenZero = new Token(GCLTokenTypes.NUMBER, "0");
			Token tokenFechaParenteses = new Token(GCLTokenTypes.SYMBOL, ")");
			this.pilhaDeToken.add(tokenId);
			this.pilhaDeToken.add(tokenAbreParenteses);
			this.pilhaDeToken.add(tokenDois);
			this.pilhaDeToken.add(tokenMaiorIgual);
			this.pilhaDeToken.add(tokenUm);
			this.pilhaDeToken.add(tokenVirgula);
			this.pilhaDeToken.add(tokenTres);
			this.pilhaDeToken.add(tokenMenorIgual);
			this.pilhaDeToken.add(tokenZero);		
			this.pilhaDeToken.add(tokenFechaParenteses);
			
			ProducoesFactory.setEstado(this.pilhaDeToken);
			
			this.producao = ProducoesFactory.getProducao(ProducoesEnum.callStatement);
			assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoCallStatement");		
			try {
				this.raiz = this.producao.validaEGeraProducao();	
			} catch (ProducaoSintaticaException e) {
				fail(e.getMessage());
			}
			
			assertNotNull(this.raiz);
			assertEquals(this.raiz.getNome(), "callStatement");
			assertNull(this.raiz.getToken());
			assertEquals(this.raiz.possueNosFilhos(), true);
			assertEquals(this.raiz.getListaDeNos().size(), 2);
			
			int i = 0;
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenId.getValue());
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenId.getTokenType());
			
			i++;
			ArvoreSintaticaAbstrataNo expressionList = this.raiz.getListaDeNos().get(i);
			assertNotNull(expressionList);
			assertEquals(expressionList.getNome(), "argumentList");
			assertNull(expressionList.getToken());
			assertEquals(expressionList.possueNosFilhos(), true);
			assertEquals(expressionList.getListaDeNos().size(), 3);

	}
	
	public void testCasoCompleto() {
		// "identifier" ["." "identifier"] <argumentList>
			Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "calculadora");
			Token tokenIdPonto = new Token(GCLTokenTypes.SYMBOL, ".");
			Token tokenIdMetodo = new Token(GCLTokenTypes.IDENTIFIER, "soma");
			Token tokenAbreParenteses = new Token(GCLTokenTypes.SYMBOL, "(");
			Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
			Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
			Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
			Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
			Token tokenTres = new Token(GCLTokenTypes.NUMBER, "3");
			Token tokenMenorIgual = new Token(GCLTokenTypes.SYMBOL, "<=");
			Token tokenZero = new Token(GCLTokenTypes.NUMBER, "0");
			Token tokenFechaParenteses = new Token(GCLTokenTypes.SYMBOL, ")");
			this.pilhaDeToken.add(tokenId);
			this.pilhaDeToken.add(tokenIdPonto);
			this.pilhaDeToken.add(tokenIdMetodo);
			this.pilhaDeToken.add(tokenAbreParenteses);
			this.pilhaDeToken.add(tokenDois);
			this.pilhaDeToken.add(tokenMaiorIgual);
			this.pilhaDeToken.add(tokenUm);
			this.pilhaDeToken.add(tokenVirgula);
			this.pilhaDeToken.add(tokenTres);
			this.pilhaDeToken.add(tokenMenorIgual);
			this.pilhaDeToken.add(tokenZero);		
			this.pilhaDeToken.add(tokenFechaParenteses);
			
			ProducoesFactory.setEstado(this.pilhaDeToken);
			
			this.producao = ProducoesFactory.getProducao(ProducoesEnum.callStatement);
			assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoCallStatement");		
			try {
				this.raiz = this.producao.validaEGeraProducao();	
			} catch (ProducaoSintaticaException e) {
				fail(e.getMessage());
			}
			
			assertNotNull(this.raiz);
			assertEquals(this.raiz.getNome(), "callStatement");
			assertNull(this.raiz.getToken());
			assertEquals(this.raiz.possueNosFilhos(), true);
			assertEquals(this.raiz.getListaDeNos().size(), 4);
			
			int i = 0;
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenId.getValue());
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenId.getTokenType());
			
			i++;
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenIdPonto.getValue());
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenIdPonto.getTokenType());
			
			i++;
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenIdMetodo.getValue());
			assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenIdMetodo.getTokenType());			
			
			i++;
			ArvoreSintaticaAbstrataNo expressionList = this.raiz.getListaDeNos().get(i);
			assertNotNull(expressionList);
			assertEquals(expressionList.getNome(), "argumentList");
			assertNull(expressionList.getToken());
			assertEquals(expressionList.possueNosFilhos(), true);
			assertEquals(expressionList.getListaDeNos().size(), 3);

	}
	
	public void testCasoFaltandoIdentificador() {
			Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "calculadora");
			Token tokenIdPonto = new Token(GCLTokenTypes.SYMBOL, ".");
			Token tokenAbreParenteses = new Token(GCLTokenTypes.SYMBOL, "(");
			Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
			Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
			Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
			Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
			Token tokenTres = new Token(GCLTokenTypes.NUMBER, "3");
			Token tokenMenorIgual = new Token(GCLTokenTypes.SYMBOL, "<=");
			Token tokenZero = new Token(GCLTokenTypes.NUMBER, "0");
			Token tokenFechaParenteses = new Token(GCLTokenTypes.SYMBOL, ")");
			this.pilhaDeToken.add(tokenId);
			this.pilhaDeToken.add(tokenIdPonto);
			this.pilhaDeToken.add(tokenAbreParenteses);
			this.pilhaDeToken.add(tokenDois);
			this.pilhaDeToken.add(tokenMaiorIgual);
			this.pilhaDeToken.add(tokenUm);
			this.pilhaDeToken.add(tokenVirgula);
			this.pilhaDeToken.add(tokenTres);
			this.pilhaDeToken.add(tokenMenorIgual);
			this.pilhaDeToken.add(tokenZero);		
			this.pilhaDeToken.add(tokenFechaParenteses);
			
			ProducoesFactory.setEstado(this.pilhaDeToken);
			
			this.producao = ProducoesFactory.getProducao(ProducoesEnum.callStatement);
			assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoCallStatement");		
			try {
				this.raiz = this.producao.validaEGeraProducao();
				assertNull(this.raiz);
				fail("Deveria ter dado excessao");
			} catch (ProducaoSintaticaException e) {
				assertNull(this.raiz);
			}

	}		

}
