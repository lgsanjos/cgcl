package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoProcedureDefTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		// <procedureDecl> <block>
		Token tokenProc = new Token(GCLTokenTypes.KEYWORD,  "proc");
		Token tokenProcId = new Token(GCLTokenTypes.IDENTIFIER, "minhaProc");
		Token tokenBegin = new Token(GCLTokenTypes.KEYWORD, "begin");
		Token tokenEnd = new Token(GCLTokenTypes.KEYWORD, "end");
		this.pilhaDeToken.add(tokenProc);
		this.pilhaDeToken.add(tokenProcId);
		this.pilhaDeToken.add(tokenBegin);
		this.pilhaDeToken.add(tokenEnd);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.procedureDef);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoProcedureDef");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "procedureDef");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "procedureDecl");
		
		i++;
		assertEquals(this.raiz.getListaDeNos().get(i).getNome(), "block");

	}

}
