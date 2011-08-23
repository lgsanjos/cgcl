package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoTypeDefTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "typedef" <type> "identifier"
		
		Token tokenTypedef = new Token(GCLTokenTypes.KEYWORD, "Typedef");
		Token tokenInteger = new Token(GCLTokenTypes.KEYWORD, "integer");
		Token tokenArray = new Token(GCLTokenTypes.KEYWORD, "array");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "identificador");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		Token tokenIdentificador = new Token(GCLTokenTypes.IDENTIFIER, "minhaVariavel");
		
		this.pilhaDeToken.add(tokenTypedef);
		this.pilhaDeToken.add(tokenInteger);
		this.pilhaDeToken.add(tokenArray);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenFechaColchete);
		this.pilhaDeToken.add(tokenIdentificador);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.typedef);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTypeDef");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "typeDef");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "Typedef");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "type");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "minhaVariavel");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.IDENTIFIER);		

	}

}
