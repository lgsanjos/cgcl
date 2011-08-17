package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoIndexOrCompTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {

		Token tokenPontoFinal = new Token(GCLTokenTypes.SYMBOL, ".");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "123");
		this.pilhaDeToken.add(tokenPontoFinal);
		this.pilhaDeToken.add(tokenNumero);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.indexorcomp);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoIndexOrComp");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "indexorcomp");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), tokenPontoFinal.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), tokenPontoFinal.getValue());
		assertEquals(this.raiz.getListaDeNos().getLast().getToken().getTokenType(), tokenNumero.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getLast().getToken().getValue(), tokenNumero.getValue());		
	}
	
	public void testCasoIdealComRepeticao() {
		int i = 0;
		Token tokenPontoFinal = new Token(GCLTokenTypes.SYMBOL, ".");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "123");
		Token tokenPontoFinalRepetido = new Token(GCLTokenTypes.SYMBOL, ".");
		Token tokenNumeroRepetido = new Token(GCLTokenTypes.NUMBER, "123");
		
		this.pilhaDeToken.add(tokenPontoFinal);
		this.pilhaDeToken.add(tokenNumero);
		this.pilhaDeToken.add(tokenPontoFinalRepetido);
		this.pilhaDeToken.add(tokenNumeroRepetido);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.indexorcomp);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoIndexOrComp");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "indexorcomp");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenPontoFinal.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenPontoFinal.getValue());
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenNumero.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenNumero.getValue());	
	}	
	
	public void testCasoComExpressaoVazia() {
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");		
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.indexorcomp);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoIndexOrComp");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNull(this.raiz);
	}	
	
	public void testCasoComExpressaoSimples() {
		int i = 0;
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenDez = new Token(GCLTokenTypes.NUMBER, "10");
		Token tokenMaior = new Token(GCLTokenTypes.SYMBOL, ">");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenDez);
		this.pilhaDeToken.add(tokenMaior);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.indexorcomp);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoIndexOrComp");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "indexorcomp");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 3);

		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenAbreColchete.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenAbreColchete.getValue());
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenDez.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenDez.getValue());
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenMaior.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenMaior.getValue());
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenUm.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenUm.getValue());
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenFechaColchete.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenFechaColchete.getValue());		
	}
}
