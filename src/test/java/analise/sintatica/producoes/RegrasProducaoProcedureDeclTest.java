package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class RegrasProducaoProcedureDeclTest extends RegrasProducaoTestCase {

	@Override
	public void testCasoIdeal() {
		Token tokenProc = new Token(GCLTokenTypes.KEYWORD,  "proc");
		Token tokenProcId = new Token(GCLTokenTypes.IDENTIFIER, "minhaProc");
		this.pilhaDeToken.add(tokenProc);
		this.pilhaDeToken.add(tokenProcId);
		
		ProducoesFactory.setEstado(this.pilhaDeToken);
		
		this.producao = ProducoesFactory.getProducao(ProducoesEnum.procedureDecl);
		assertEquals(this.producao.getClass().getName(), "analise.sintatica.producoes.RegrasProducaoProcedureDecl");		
		try {
			this.raiz = this.producao.validaEGeraProducao();	
		} catch (ProducaoSintaticaException e) {
			fail(e.getMessage());
		}

		assertNotNull(this.raiz);
		assertEquals(this.raiz.getNome(), "procedureDecl");
		assertNull(this.raiz.getToken());
		assertEquals(this.raiz.possueNosFilhos(), true);		
		assertEquals(this.raiz.getListaDeNos().size(), 2);
		
		int i = 0;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken(), tokenProc);
		
		i++;
		assertNotNull(this.raiz.getListaDeNos().get(i).getToken());
		assertEquals(this.raiz.getListaDeNos().get(i).getToken(), tokenProcId);
	}

}
