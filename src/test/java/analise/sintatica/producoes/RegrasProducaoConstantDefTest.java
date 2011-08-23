package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoConstantDefTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "const" <constantName> "=" <constant>
		
		Token tokenConst = new Token(GCLTokenTypes.KEYWORD, "const");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "id");
		Token tokenIgual = new Token(GCLTokenTypes.SYMBOL, "=");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		this.pilhaDeToken.add(tokenConst);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenIgual);
		this.pilhaDeToken.add(tokenDois);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.constantDef);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoConstantDef");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "constantDef");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 4);
		
		int i = 0;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "const");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "constantName");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "=");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "constant");		

	}

}
