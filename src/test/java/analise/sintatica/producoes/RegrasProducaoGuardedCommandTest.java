package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoGuardedCommandTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <expression> "->" <statementPart>
		
		Token tokenDois = new Token(GCLTokenTypes.NUMBER, "2");
		Token tokenMaiorIgual = new Token(GCLTokenTypes.SYMBOL, ">=");
		Token tokenUm = new Token(GCLTokenTypes.NUMBER, "1");
		Token tokenSetinha = new Token(GCLTokenTypes.SYMBOL, "->");
		Token tokenSkip = new Token(GCLTokenTypes.KEYWORD, "skip");
		Token tokenPonto = new Token(GCLTokenTypes.SYMBOL, ";");
		
		this.pilhaDeToken.add(tokenDois);
		this.pilhaDeToken.add(tokenMaiorIgual);
		this.pilhaDeToken.add(tokenUm);
		this.pilhaDeToken.add(tokenSetinha);
		this.pilhaDeToken.add(tokenSkip);
		this.pilhaDeToken.add(tokenPonto);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.guardedCommand);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoGuardedCommand");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "guardedCommand");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 3);

		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "expression");	
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), "->");
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), GCLTokenTypes.SYMBOL);
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "statementPart");		

	}

}
