package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoStatementPartTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// { <statement> ";"} 
		Token tokenSkip1 = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenVirgula1 = new Token(GCLTokenTypes.SYMBOL, ";");
		Token tokenSkip2 = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenVirgula2 = new Token(GCLTokenTypes.SYMBOL, ";");		
		this.pilhaDeToken.add(tokenSkip1);
		this.pilhaDeToken.add(tokenVirgula1);
		this.pilhaDeToken.add(tokenSkip2);
		this.pilhaDeToken.add(tokenVirgula2);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.statementPart);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoStatementPart");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "statementPart");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 4);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "statement");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ";");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "statement");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ";");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);		

	}

}
