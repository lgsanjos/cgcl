package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.Token;

public class RegrasProducaoConstantNameTest extends RegrasProducaoTestCase {
	
	public void testCasoIdeal() {

		// Prepara lista de tokens
		Token token = new Token(GCLTokenTypes.IDENTIFIER, "id");
		this.pilhaDeToken.add(token);	

		// define o estado na factory
		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		// valida retorno da factory e gera ASA
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.constantName);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoConstantName");		
		this.raiz = this.producao.validaEGeraProducao();
		
		
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
