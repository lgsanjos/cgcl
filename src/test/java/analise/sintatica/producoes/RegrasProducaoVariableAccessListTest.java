package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoVariableAccessListTest extends
		RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <variableAccess> {"," <variableAccess> } 
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenOutroId = new Token(GCLTokenTypes.IDENTIFIER, "outroId");

		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenOutroId);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.variableAccessList);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoVariableAccessList");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "variableAccessList");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "variableAccess");				
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenVirgula.getValue());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenVirgula.getTokenType());
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "variableAccess");		
	}

}
