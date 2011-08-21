package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoRangeTypeTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "range" "[" <constant> ".." <constant>  "]"
		
		Token tokenRange = new Token(GCLTokenTypes.KEYWORD, "range");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenDoisPontos = new Token(GCLTokenTypes.SYMBOL, "..");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		this.pilhaDeToken.add(tokenRange);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenDoisPontos);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenFechaColchete);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.rangetype);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoRangeType");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "rangeType");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 6);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "range");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "[");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "constant");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "..");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "constant");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "]");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);		

	}

}
