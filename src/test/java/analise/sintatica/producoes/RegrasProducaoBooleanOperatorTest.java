package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.Token;

public class RegrasProducaoBooleanOperatorTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
			
		Token token = new Token(GCLTokenTypes.SYMBOL, "&");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.booleanOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoBooleanOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "booleanOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoSinalOr() {
		
		Token token = new Token(GCLTokenTypes.SYMBOL, "|");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.booleanOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoBooleanOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "booleanOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());
	}	

}
