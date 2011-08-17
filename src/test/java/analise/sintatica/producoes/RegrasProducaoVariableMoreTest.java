package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoVariableMoreTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// ""
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.variableMore);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoVariableMore");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "variableMore");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), false);
		assertEquals(this.raiz.getListaDeNos().size(), 0);
	}
	
	public void testComExpressaoEIndexOrComp() {
		// "[" <expression> "]"
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenDez = new Token(GCLTokenTypes.NUMBER, "10");
		Token tokenMaior = new Token(GCLTokenTypes.SYMBOL, ">");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		// <indexorcomp>
		Token tokenPontoFinal = new Token(GCLTokenTypes.SYMBOL, ".");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "123");
		
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenDez);
		this.pilhaDeToken.add(tokenMaior);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		this.pilhaDeToken.add(tokenPontoFinal);
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.variableMore);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoVariableMore");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "variableMore");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
			
	}
	
	public void testPontoNextItemEIndexOrComp() {
		// "." <nextitem>  <indexorcomp>
		Token tokenPontoFinal1 = new Token(GCLTokenTypes.SYMBOL, ".");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "identify");
		
		Token tokenPontoFinal2 = new Token(GCLTokenTypes.SYMBOL, ".");
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "123");
		
		this.pilhaDeToken.add(tokenPontoFinal1);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenPontoFinal2);
		this.pilhaDeToken.add(tokenNumero);		

		ProducoesFactory.setEstado(this.pilhaDeToken);		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.variableMore);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoVariableMore");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "variableMore");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;		
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenPontoFinal1.getTokenType());				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenPontoFinal1.getValue());
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken(), null);
		assertEquals(this.raiz.getListaDeNos().get(i).possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().getFirst().getToken().getValue(), tokenId.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().getFirst().getToken().getTokenType(), tokenId.getTokenType());
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken(), null);
		assertEquals(this.raiz.getListaDeNos().get(i).possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().size(), 2);
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().getFirst().getToken().getValue(), tokenPontoFinal2.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().getFirst().getToken().getTokenType(), tokenPontoFinal2.getTokenType());
		
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().getLast().getToken().getValue(), tokenNumero.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getListaDeNos().getLast().getToken().getTokenType(), tokenNumero.getTokenType());		
	
	}
	
	

}
