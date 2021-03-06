package aplicacao;

public class Apresentacao {
	
	private static void showAbout(){
		System.out.println("Universidade Estadual de Maringá");
		System.out.println("Trabalho de Compiladores 2011");
		System.out.println("Professor: Anderson Faustino da Silva");
		System.out.println("Aluno: Luiz Guilherme S. Anjos RA: 45220");
		System.out.println("Aluno: Fabrício Noda RA: 39854");
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
			"­\n  -a  About" +
			"\n\nExemplo:" +
			"gclc [­d[ais]] [­s] [­i] [­h] [­o <nome>] <prog.gcl>"
		);
		
	}	
	
	private static String nomeDoArquivoDeEntrada(String[] args) {
		return args[args.length - 1];
	}
	
	private static String nomeDoArquivoDeSaida(String[] args) {
		int i = 0;
		while (i < args.length -2) {
			if (args[i].equalsIgnoreCase("-o"))
				return args[i +1];
			i++;			
		}				
						
		return "";
	}
	
	private static boolean possuiOpcaoNoArray(String opcao, String[] args) {
		for (String item : args)
			if (item.equalsIgnoreCase(opcao))
				return true;
				
		return false;		
	}
	
	private static void verificaNivelDeLog(String[] args) {
		if (possuiOpcaoNoArray("-err", args))
			Log.setNivel(Nivel.ERROR);
		
		if (possuiOpcaoNoArray("-inf", args))
			Log.setNivel(Nivel.INFO);

		if (possuiOpcaoNoArray("-deb", args))
			Log.setNivel(Nivel.DEBBUG);		
	}

	public static void main(String[] args) {
		Log.setNivel(Nivel.INFO);
		
		showWelcome();
		if (args.length == 0) {
			showAbout();
			showHelp();
			return;
		}

		try {
			Compilador cgcl = new Compilador(nomeDoArquivoDeEntrada(args));
		
			verificaNivelDeLog(args);
			
			if (possuiOpcaoNoArray("-a", args)) {
				showWelcome();
				showAbout();
				return;
			}
			
			if (possuiOpcaoNoArray("-h", args)) {
				showWelcome();
				showHelp();
				return;
			}			
			
			if (possuiOpcaoNoArray("-da", args))
				cgcl.emitirArvoreSintatica();

			if (possuiOpcaoNoArray("-di", args))
				cgcl.emitirCodigoIntermediario();

			if (possuiOpcaoNoArray("-s", args))
				cgcl.emitirCodigoAssembly();

			if (possuiOpcaoNoArray("-i", args))
				cgcl.otimizarInline();

			if (! nomeDoArquivoDeSaida(args).isEmpty())
				cgcl.setNomeDoArquivoDeSaida(nomeDoArquivoDeSaida(args));
			
			cgcl.compilar();
			
		} catch(Exception e) {
			Log.error(e.getClass().getName() + ", " + e.getMessage());
		}

	}

}
