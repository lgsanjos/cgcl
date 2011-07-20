package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.IndiceNumerico;
import coretypes.TokenList;
import junit.framework.TestCase;

public abstract class RegrasProducaoTestCase extends TestCase {

	protected IndiceNumerico indice;
	protected TokenList pilhaDeToken;
	protected ArvoreSintaticaAbstrataNo raiz;
	protected RegrasProducaoAbstract producao;

	@Override
	protected void setUp() throws Exception {
		this.indice = new IndiceNumerico(0);
		this.pilhaDeToken = new TokenList();
		
		ProducoesFactory.limpaEstado();
		this.raiz = null;
		this.producao = null;
	}
	
	public abstract void testCasoIdeal();

}