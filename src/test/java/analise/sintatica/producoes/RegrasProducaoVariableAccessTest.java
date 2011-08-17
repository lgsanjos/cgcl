package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoVariableAccessTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		
		Token tokenIdentificador = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		this.pilhaDeToken.add(tokenIdentificador);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.variableAccess);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoVariableAccess");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "variableAccess");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenIdentificador.getTokenType());				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenIdentificador.getValue());
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken(), null);
		assertEquals(this.raiz.getListaDeNos().get(i).possueNosFilhos(), false);

	}
	
	public void testVariableMoreComplexo() {
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
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
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
