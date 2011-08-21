package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoVariableListTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "identifier" {"," "identifier"}
		
		Token tokenIdentificador1 = new Token(GCLTokenTypes.IDENTIFIER, "ident1");
		Token tokenVirgula1 = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenIdentificador2 = new Token(GCLTokenTypes.IDENTIFIER, "ident2");
		Token tokenVirgula2 = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenIdentificador3 = new Token(GCLTokenTypes.IDENTIFIER, "ident3");
		this.pilhaDeToken.add(tokenIdentificador1);
		this.pilhaDeToken.add(tokenVirgula1);
		this.pilhaDeToken.add(tokenIdentificador2);
		this.pilhaDeToken.add(tokenVirgula2);
		this.pilhaDeToken.add(tokenIdentificador3);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.variableList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoVariableList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "variableList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 5);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "ident1");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ",");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "ident2");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ",");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "ident3");

	}

}
