package analise.sintatica;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;

public class ArvoreSintaticaAbstrataTest extends AnaliseSintaticaTest {

	public void testPrintSimplesPacas() {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD,"module"));
		raiz.adicionaNoFilho("identificador", new Token(
				GCLTokenTypes.IDENTIFIER, "simplesPacas"));

		ArvoreSintaticaAbstrata arv = new ArvoreSintaticaAbstrata();
		arv.setRaiz(raiz);

		String printGerado = arv.print();
		String printTemplate = this.loadResourceNamed("asa_simplesPacas.txt");
		boolean assertTemplateIgual;
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(
				printTemplate.trim());
		assertTrue(assertTemplateIgual);
		// assertTemplateIgual = printGerado.
		// assertEquals(printGerado, printTemplate);
	}

	public void testPrintSimples() {

		ArvoreSintaticaAbstrataNo raiz;
		raiz = new ArvoreSintaticaAbstrataNo("module");
		raiz.adicionaNoFilho("module", new Token(GCLTokenTypes.KEYWORD,
				"module"));
		raiz.adicionaNoFilho("identificador", new Token(
				GCLTokenTypes.IDENTIFIER, "simples"));
		ArvoreSintaticaAbstrataNo block = new ArvoreSintaticaAbstrataNo("block");
		raiz.adicionaNoFilho(block);
		block.adicionaNoFilho("begin",
				new Token(GCLTokenTypes.KEYWORD, "begin"));
		block.adicionaNoFilho("end", new Token(GCLTokenTypes.KEYWORD, "end"));
		raiz.adicionaNoFilho(".", new Token(GCLTokenTypes.SYMBOL, "."));

		ArvoreSintaticaAbstrata arv = new ArvoreSintaticaAbstrata();
		arv.setRaiz(raiz);

		String printGerado = arv.print();
		String printTemplate = this.loadResourceNamed("asa_simples.txt");
		boolean assertTemplateIgual;
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(
				printTemplate.trim());
		assertTrue(assertTemplateIgual);

	}

	public void testPrintSimplesIntegracao() {
		String source = this.loadResourceNamed("simples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		ArvoreSintaticaAbstrataNo raiz =  this.analisador.gerarArvore();

		ArvoreSintaticaAbstrata arv = new ArvoreSintaticaAbstrata();
		arv.setRaiz(raiz);

		String printGerado = arv.print();
		String printTemplate = this.loadResourceNamed("asa_simples.txt");
		boolean assertTemplateIgual;
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(
				printTemplate.trim());
		assertTrue(assertTemplateIgual);
	}
	
	public void testPrintSimplesPacasIntegracao() {
		String source = this.loadResourceNamed("simples.gcl");
		
		this.analisador = this.buildAnaliseSintatica(source);
		ArvoreSintaticaAbstrataNo raiz =  this.analisador.gerarArvore();

		ArvoreSintaticaAbstrata arv = new ArvoreSintaticaAbstrata();
		arv.setRaiz(raiz);

		String printGerado = arv.print();
		String printTemplate = this.loadResourceNamed("asa_simples.txt");
		boolean assertTemplateIgual;
		assertTemplateIgual = printGerado.trim().equalsIgnoreCase(
				printTemplate.trim());
		assertTrue(assertTemplateIgual);
	}

}
