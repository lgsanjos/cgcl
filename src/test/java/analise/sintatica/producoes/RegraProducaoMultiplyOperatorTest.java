package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.Token;

public class RegraProducaoMultiplyOperatorTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		Token token = new Token(GCLTokenTypes.SYMBOL, "*");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.multiplyOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoMultiplyOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "multiplyOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());		
	}
	
	public void testCasoDeDivisao() {
		Token token = new Token(GCLTokenTypes.SYMBOL, "/");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.multiplyOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoMultiplyOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "multiplyOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());		
	}
	
	public void testCasoDeDivisaoComBarraInvertida() {
		Token token = new Token(GCLTokenTypes.SYMBOL, "\"");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken, this.indice);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.multiplyOperator);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoMultiplyOperator");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "multiplyOperator");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());		
	}		

}
