package codigoIntermediario;

public class VariaveisTemporarias {
	
	private static VariaveisTemporarias instance;
	
	private VariaveisTemporarias() {
		instance = new VariaveisTemporarias();
	}
	
	public static VariaveisTemporarias getInstancia() {
		return instance;
	}

}
