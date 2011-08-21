package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoReadStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		//"read" <variableAccessList>
		Token tokenRead = new Token(GCLTokenTypes.KEYWORD, "read");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenOutroId = new Token(GCLTokenTypes.IDENTIFIER, "outroId");

		this.pilhaDeToken.add(tokenRead);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenOutroId);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.readStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoReadStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "readStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenRead.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenRead.getTokenType());
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "variableAccessList");		

	}

}
