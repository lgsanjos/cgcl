package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoConstantNameTest extends RegrasProducaoTestCase {
	
	public void testCasoIdeal() {

		Token token = new Token(GCLTokenTypes.IDENTIFIER, "id");
		this.pilhaDeToken.add(token);	

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.constantName);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoConstantName");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		
		// valida ASA
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "constantName");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());
		
		
	}

}
