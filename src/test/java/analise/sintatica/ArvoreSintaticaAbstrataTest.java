package analise.sintatica;

import analise.AnaliseTestCase;
import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class ArvoreSintaticaAbstrataTest extends AnaliseTestCase {

	public void testPrintSimplesPacas() {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD,	"module"));
		raiz.adicionaNoFilho("identificador", new Token(GCLTokenTypes.IDENTIFIER, "simplesPacas"));
		raiz.adicionaNoFilho(".", new Token(GCLTokenTypes.SYMBOL, "."));
		
		String printGerado = raiz.print();
		String printTemplate = this.loadResourceNamed("asa_simplesPacas.txt");
		boolean assertTemplateIgual;
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(printTemplate.trim());
		assertTrue(assertTemplateIgual);
	}

	public void testPrintSimples() {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD,	"module"));
		raiz.adicionaNoFilho("identificador", new Token(GCLTokenTypes.IDENTIFIER, "simples"));
		ArvoreSintaticaAbstrataNo block = new ArvoreSintaticaAbstrataNo("block");
		raiz.adicionaNoFilho(block);
		block.adicionaNoFilho("begin",new Token(GCLTokenTypes.KEYWORD, "begin"));
		block.adicionaNoFilho("end", new Token(GCLTokenTypes.KEYWORD, "end"));
		raiz.adicionaNoFilho(".", new Token(GCLTokenTypes.SYMBOL, "."));

		String printGerado = raiz.print();
		String printTemplate = this.loadResourceNamed("asa_simples.txt");
		boolean assertTemplateIgual;
		
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(printTemplate.trim());
		assertTrue(assertTemplateIgual);

	}

	public void testPrintSimplesIntegracao() {
		String source = this.loadResourceNamed("simples.gcl");

		this.analisador = this.buildAnaliseSintatica(source);
		// ArvoreSintaticaAbstrataNo raiz = this.analisador.gerarArvore();

		try {
			ArvoreSintaticaAbstrataNo raiz = this.analisador.gerarArvore();

			String printGerado = raiz.print();
			String printTemplate = this.loadResourceNamed("asa_simples.txt");
			boolean assertTemplateIgual;
			assertTemplateIgual = printGerado.trim().equalsIgnoreCase(
					printTemplate.trim());
			assertTrue(assertTemplateIgual);

		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		}

	}

	public void testPrintSimplesPacasIntegracao() {
		String source = this.loadResourceNamed("simples_pacas.gcl");

		this.analisador = this.buildAnaliseSintatica(source);

		try {
			ArvoreSintaticaAbstrataNo raiz = this.analisador.gerarArvore();

			String printGerado = raiz.print();
			String printTemplate = this.loadResourceNamed("asa_simplesPacas.txt");
			
			boolean assertTemplateIgual;
			assertTemplateIgual = printGerado.trim().equalsIgnoreCase(printTemplate.trim());
			assertTrue(assertTemplateIgual);

		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		}

	}
	public void testPrintNoSimples() {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD,	"module"));
		raiz.adicionaNoFilho("identificador", new Token(GCLTokenTypes.IDENTIFIER, "simples"));
		ArvoreSintaticaAbstrataNo block = new ArvoreSintaticaAbstrataNo("block");
		raiz.adicionaNoFilho(block);
		block.adicionaNoFilho("begin",new Token(GCLTokenTypes.KEYWORD, "begin"));
		block.adicionaNoFilho("end", new Token(GCLTokenTypes.KEYWORD, "end"));
		raiz.adicionaNoFilho(".", new Token(GCLTokenTypes.SYMBOL, "."));

		String printGerado = raiz.print();
		String printTemplate = this.loadResourceNamed("asa_simples.txt");
		boolean assertTemplateIgual;
		
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(printTemplate.trim());
		assertTrue(assertTemplateIgual);

	}

}
