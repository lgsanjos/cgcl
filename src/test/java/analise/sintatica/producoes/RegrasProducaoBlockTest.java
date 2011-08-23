package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoBlockTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <definitionPart> "begin" <statementPart> "end" 
		
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenEnd);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.block);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoBlock");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "block");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 4);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "begin");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "statementPart");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "end");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);			

	}
	
	public void testCasoStatementPart() {
		// <definitionPart> "begin" <statementPart> "end" 
		
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ";");		
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenEnd);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.block);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoBlock");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "block");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 4);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "definitionPart");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "begin");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "statementPart");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "end");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);			

	}

}
