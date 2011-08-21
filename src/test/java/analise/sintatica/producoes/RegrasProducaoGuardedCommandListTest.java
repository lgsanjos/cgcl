package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;

public class RegrasProducaoGuardedCommandListTest extends
		RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <guardedCommand> {"[]" <guardedCommand>}  
		
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenSetinha = new Token(GCLTokenTypes.SYMBOL, "->");
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ";");
		
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenSetinha);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.guardedCommandList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoGuardedCommandList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "guardedCommandList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);

		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "guardedCommand");	


	}
	
	public void testComVaroiasCommandGuarded() {
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenSetinha = new Token(GCLTokenTypes.SYMBOL, "->");
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenGuarda = new Token(GCLTokenTypes.SYMBOL, "[]");
		
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenSetinha);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenPonto);
		this.pilhaDeToken.add(tokenGuarda);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenSetinha);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenPonto);		
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.guardedCommandList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoGuardedCommandList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "guardedCommandList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "guardedCommand");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "guardedCommand");
		
		
	}	

}
