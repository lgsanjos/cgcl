package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import coretypes.Token;

public class RegrasProducaoTypeSymbolTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
			
		Token token = new Token(GCLTokenTypes.KEYWORD, "integer");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.typeSymbol);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTypeSymbol");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "typeSymbol");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoString() {
			
		Token token = new Token(GCLTokenTypes.KEYWORD, "string");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.typeSymbol);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTypeSymbol");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "typeSymbol");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}
	
	public void testCasoIdentificador() {
			
		Token token = new Token(GCLTokenTypes.IDENTIFIER, "meuTipoCriadoPorMim");
		this.pilhaDeToken.add(token);

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.typeSymbol);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoTypeSymbol");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "typeSymbol");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getTokenType(), token.getTokenType());
		assertEquals(this.raiz.getListaDeNos().getFirst().getToken().getValue(), token.getValue());	
	}	

}
