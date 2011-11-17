package aplicacao;

enum Nivel {
	DEBBUG,
	INFO,
	ERROR
	
}

public class Log {
	
	private static Nivel nivel = Nivel.INFO;
	
	public static void setNivel(Nivel nivel) {
		Log.nivel = nivel;
	}
	
	public static void debbug(String texto) {
		if (Log.nivel.ordinal() <= Nivel.DEBBUG.ordinal())
			System.out.println("Debbug: " + texto);
	}	
	
	public static void info(String texto) {
		if (Log.nivel.ordinal() <= Nivel.INFO.ordinal())
			System.out.println("Info: " + texto);
	}
	
	public static void error(String texto) {
		System.out.println("Erro: " + texto);
	}	

}
