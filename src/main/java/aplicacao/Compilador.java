package aplicacao;

public class Compilador {
	
	
	private static void showAbout(){
	  System.out.println("**** Guarded Command Language Compiler ****");
	  System.out.println("Universidade Estadual de Maringá");
	  System.out.println("Trabalho de Compiladores 2011");
	  System.out.println("Professor: Anderson Faustino da Silva");
	  System.out.println("Aluno: Luiz Guilherme S. Anjos RA: 45220");
	  System.out.println("");
	  System.out.println("*******************************************");
	}
	
	private static void showWelcome(){
      System.out.println("**** Guarded Command Language Compiler ****");
	}
	
	private static void showHelp(){
		System.out.println(
			"\n\nComandos:" +
			"­\n  -da Emitir árvore sintática abstrata" +
			"­\n  -di Emitir código intermediário" +
			"­\n  -ds Emitir código após seleção de instruções" +
			"­\n  -s  Emitir código assembly" +
			"­\n  -i  Ativa a otimização inline" +
			"­\n  -o  Nome do arquivo de saída" +
			"­\n  -h  Help" +
			"\n\nExemplo:" +
			"gclc [­d[ais]] [­s] [­i] [­h] [­o <nome>] <prog.gcl>"
		);
		
	}
		
	public static void main(String Args[]){
	  Compilador.showAbout();
	  Compilador.showWelcome();
	  Compilador.showHelp();
		
	}

}
