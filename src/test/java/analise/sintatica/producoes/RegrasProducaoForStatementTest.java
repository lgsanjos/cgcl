package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;


public class RegrasProducaoForStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// "forall" <variableAccess> "->" <statementPart> "llarof"
		
		Token tokenForall = new Token(GCLTokenTypes.KEYWORD, "forall");		
		Token tokenIdentificador = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		Token tokenSetinha = new Token(GCLTokenTypes.SYMBOL, "->");
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ";");		
		Token tokenLlarof = new Token(GCLTokenTypes.KEYWORD, "llarof");
		this.pilhaDeToken.add(tokenForall);
		this.pilhaDeToken.add(tokenIdentificador);
		this.pilhaDeToken.add(tokenSetinha);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenLlarof);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.forStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoForStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "forStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 5);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "forall");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "variableAccess");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "->");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);		
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "statementPart");		
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "llarof");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.KEYWORD);
	}

}
