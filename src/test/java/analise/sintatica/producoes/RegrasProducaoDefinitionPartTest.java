package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoDefinitionPartTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// {<definition> ";"}
		
		Token tokenConst = new Token(GCLTokenTypes.KEYWORD, "const");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "id");
		Token tokenIgual = new Token(GCLTokenTypes.SYMBOL, "=");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenPontoVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		this.pilhaDeToken.add(tokenConst);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenIgual);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenPontoVirgula);
		
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.definitionPart);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoDefinitionPart");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "definitionPart");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definition");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ";");		

	}
	
	public void testCasoComDuasDefinition() {

		Token tokenConst = new Token(GCLTokenTypes.KEYWORD, "const");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "id");
		Token tokenIgual = new Token(GCLTokenTypes.SYMBOL, "=");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenPontoVirgula = new Token(GCLTokenTypes.SYMBOL, ";");
		this.pilhaDeToken.add(tokenConst);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenIgual);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenPontoVirgula);
		this.pilhaDeToken.add(tokenConst);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenIgual);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenPontoVirgula);	
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.definitionPart);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoDefinitionPart");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "definitionPart");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 4);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definition");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ";");
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definition");
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ";");		
	}

}
