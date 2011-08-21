package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoAssignStatementTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <variableAccessList> ":=" <expressionList>  
		
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		Token tokenVirgula = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenOutroId = new Token(GCLTokenTypes.IDENTIFIER, "outroId");
		Token tokenRecebe = new Token(GCLTokenTypes.SYMBOL, ":=");
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");

		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenVirgula);
		this.pilhaDeToken.add(tokenOutroId);
		this.pilhaDeToken.add(tokenRecebe);
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.assignStatement);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoAssignStatement");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "assignStatement");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);
		
		int i = 0;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "variableAccessList");				
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), ":=");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		
		i++;
		assertNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "expressionList");	
		
		

	}

}
