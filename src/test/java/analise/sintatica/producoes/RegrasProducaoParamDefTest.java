package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoParamDefTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
	// ( "val" | "ref" ) <variableDef> 
		
		Token tokenVal = new Token(GCLTokenTypes.KEYWORD, "val");
		Token token = new Token(GCLTokenTypes.KEYWORD, "integer");
		Token tokenArray = new Token(GCLTokenTypes.KEYWORD, "array");
		Token tokenAbreColchete = new Token(GCLTokenTypes.SYMBOL, "[");
		Token tokenId = new Token(GCLTokenTypes.IDENTIFIER, "identificador");
		Token tokenFechaColchete = new Token(GCLTokenTypes.SYMBOL, "]");
		Token tokenIdentificador1 = new Token(GCLTokenTypes.IDENTIFIER, "ident1");
		Token tokenVirgula1 = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenIdentificador2 = new Token(GCLTokenTypes.IDENTIFIER, "ident2");
		Token tokenVirgula2 = new Token(GCLTokenTypes.SYMBOL, ",");
		Token tokenIdentificador3 = new Token(GCLTokenTypes.IDENTIFIER, "ident3");
		
		this.pilhaDeToken.add(tokenVal);
		this.pilhaDeToken.add(token);
		this.pilhaDeToken.add(tokenArray);
		this.pilhaDeToken.add(tokenAbreColchete);
		this.pilhaDeToken.add(tokenId);
		this.pilhaDeToken.add(tokenFechaColchete);
		this.pilhaDeToken.add(tokenIdentificador1);
		this.pilhaDeToken.add(tokenVirgula1);
		this.pilhaDeToken.add(tokenIdentificador2);
		this.pilhaDeToken.add(tokenVirgula2);
		this.pilhaDeToken.add(tokenIdentificador3);		

		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.paramDef);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoParamDef");		
		try {
			this.raiz = this.producao.validaEGeraProducao();
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "paramDef");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken(), tokenVal);
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "variableDef");

	}

}
