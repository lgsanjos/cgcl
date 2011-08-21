package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoIfStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		
		Token tokenIf = new Token(GCLTokenTypes.KEYWORD, "if");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenSetinha = new Token(GCLTokenTypes.SYMBOL, "->");
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenFi = new Token(GCLTokenTypes.KEYWORD, "fi");
		
		this.pilhaDeToken.add(tokenIf);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenSetinha);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenPonto);
		this.pilhaDeToken.add(tokenFi);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.ifStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoIfStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "ifStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);

		int i = 0;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "if");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "guardedCommandList");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "fi");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);		

	}

}
