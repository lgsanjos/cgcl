package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoDefinitionTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <constantDef> | <variableDef> | <procedureDef> | <typedef> | <procedureDecl>
		
		Token tokenConst = new Token(GCLTokenTypes.KEYWORD, "const");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "id");
		Token tokenIgual = new Token(GCLTokenTypes.SYMBOL, "=");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		this.pilhaDeToken.add(tokenConst);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenIgual);
		this.pilhaDeToken.add(tokenDois);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.definition);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoDefinition");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "definition");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "constantDef");		
	}

}
