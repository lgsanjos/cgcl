package analise.sintatica;

public class SimboloGramatical {
	private boolean terminal;
	private String lexema;	
	
	public boolean isTerminal(){
		return this.terminal;
	}
	
	public String getLexema(){
		return this.lexema;
	}
	
	public SimboloGramatical(){
		  	
	}	
	
	public SimboloGramatical(boolean terminal, String lexema){
		this.lexema = lexema;
		this.terminal = terminal;		
	}
		

}
