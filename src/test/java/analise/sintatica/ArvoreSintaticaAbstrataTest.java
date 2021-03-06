package analise.sintatica;

import util.CompiladorTestCase;
import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;
import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class ArvoreSintaticaAbstrataTest extends CompiladorTestCase {

	public void testPrintSimplesPacas() {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD,	"module"));
		raiz.adicionaNoFilho("identificador", new Token(GCLTokenTypes.IDENTIFIER, "simplesPacas"));
		raiz.adicionaNoFilho(".", new Token(GCLTokenTypes.SYMBOL, "."));
		
		String printGerado = raiz.toString();
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

		String printGerado = raiz.toString();
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
			ArvoreSintaticaAbstrataNo raiz = this.analisador.analisar();

			String printGerado = raiz.toString();
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
		String source = this.loadResourceNamed("semantica/simples_pacas.gcl");

		this.analisador = this.buildAnaliseSintatica(source);

		try {
			ArvoreSintaticaAbstrataNo raiz = this.analisador.analisar();

			String printGerado = raiz.toString();
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

		String printGerado = raiz.toString();
		String printTemplate = this.loadResourceNamed("asa_simples.txt");
		boolean assertTemplateIgual;
		
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(printTemplate.trim());
		assertTrue(assertTemplateIgual);

	}
	
	public void testPrintOperacaoMatematicaIntegracao() {
		String source = this.loadResourceNamed("semantica/operacaoMatematica.gcl");

		this.analisador = this.buildAnaliseSintatica(source);

		try {
			ArvoreSintaticaAbstrataNo raiz = this.analisador.analisar();

			String printGerado = raiz.toString();
			System.out.println(printGerado);
			
		} catch (InvalidTokenException et) {
			fail(et.getMessage());
		} catch (ProducaoSintaticaException ep) {
			fail(ep.getMessage());
		}

	}

}
