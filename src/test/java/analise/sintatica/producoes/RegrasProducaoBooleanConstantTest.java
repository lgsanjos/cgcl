package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.Token;

public class RegrasProducaoBooleanConstantTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		Token token = new Token(GCLTokenTypes.KEYWORD, "true");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.booleanConstant);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoBooleanConstant");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "booleanConstant");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());		
	}
	
	public void testCasoValorBooleanEhFalse() {
		Token token = new Token(GCLTokenTypes.KEYWORD, "false");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.booleanConstant);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoBooleanConstant");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "booleanConstant");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());		
	}	

}
