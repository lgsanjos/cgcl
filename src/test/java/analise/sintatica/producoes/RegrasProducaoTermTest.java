package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoTermTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <factor> {<multiplyOperator> <factor>} 

		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "432");
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.term);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTerm");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "term");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		ArvoreSintaticaAbstrataNo factor;
		factor = this.raiz.getListaDeNos().getFirst();
		
		assertEquals(factor.getNome(), "factor");
		assertNull(factor.getToken());
		assertEquals(factor.possueNosFilhos(), true);
		assertEquals(factor.getListaDeNos().size(), 1);
	}
	
	public void testCasoDeMultiplicacao() {
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "432");
		Token tokenMultiplicacao = new Token(GCLTokenTypes.SYMBOL, "*");
		Token tokenNumeroDois = new Token(GCLTokenTypes.NUMBER, "2");
		this.pilhaDeToken.add(tokenNumero);
		this.pilhaDeToken.add(tokenMultiplicacao);
		this.pilhaDeToken.add(tokenNumeroDois);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.term);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTerm");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "term");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "factor");
		assertEquals(this.raiz.getListaDeNos().get(i).possueNosFilhos(), true);
		
		i ++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "multiplyOperator");
		assertEquals(this.raiz.getListaDeNos().get(i).possueNosFilhos(), true);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "factor");
		assertEquals(this.raiz.getListaDeNos().get(i).possueNosFilhos(), true);
	}
	
}
