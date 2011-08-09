package analise.sintatica.producoes;

import java.util.LinkedList;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

import coretypes.Token;
import coretypes.TokenList;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoFactorTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// Number
		Token tokenNumero = new Token(GCLTokenTypes.NUMBER, "432");
		this.pilhaDeToken.add(tokenNumero);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenNumero.getTokenType());				
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenNumero.getValue());

	}
	
	public void testVariableAccess() {
		// VariableAccess
		
		Token tokenIdentificador = new Token(GCLTokenTypes.IDENTIFIER, "ident");
		this.pilhaDeToken.add(tokenIdentificador);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		int i = 0;
		LinkedList<ArvoreSintaticaAbstrataNo> nos = this.raiz.getListaDeNos().get(i).getListaDeNos();
		assertEquals(nos.get(i).getToken().getTokenType(), tokenIdentificador.getTokenType());				
		assertEquals(nos.get(i).getToken().getValue(), tokenIdentificador.getValue());
		
	}
	
	public void testBooleanConstant() {
		// booleanConstant
		Token tokenTrue = new Token(GCLTokenTypes.KEYWORD, "true");
		this.pilhaDeToken.add(tokenTrue);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 1);
		
		ArvoreSintaticaAbstrataNo booleanConst = this.raiz.getListaDeNos().getFirst();
		assertEquals(booleanConst.getListaDeNos().getFirst().getToken().getTokenType(), tokenTrue.getTokenType());
		assertEquals(booleanConst.getListaDeNos().getFirst().getToken().getValue(), tokenTrue.getValue());
	}
	
	public void testTilFactor() {
		// "~" <factor>
		Token tokenTil = new Token(GCLTokenTypes.SYMBOL, "~");
		Token tokenTrue = new Token(GCLTokenTypes.KEYWORD, "true");
		this.pilhaDeToken.add(tokenTil);
		this.pilhaDeToken.add(tokenTrue);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.factor);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoFactor");		
		this.raiz = this.producao.validaEGeraProducao();
		
		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "factor");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;	
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenTil.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenTil.getValue());
		
		i ++;
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getTokenType(), tokenTrue.getTokenType());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken().getValue(), tokenTrue.getValue());		
	}	

}
