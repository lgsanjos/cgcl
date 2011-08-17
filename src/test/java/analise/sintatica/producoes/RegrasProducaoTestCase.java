package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.TokenList;
import junit.framework.TestCase;

public abstract class RegrasProducaoTestCase extends TestCase {

	protected TokenList pilhaDeToken;
	protected ArvoreSintaticaAbstrataNo raiz;
	protected RegrasProducaoAbstract producao;

	@Override
	protected void setUp() throws Exception {
		this.pilhaDeToken = new TokenList();
		
		ProducoesFactory.limpaEstado();
		this.raiz = null;
		this.producao = null;
	}
	
	public abstract void testCasoIdeal();

}