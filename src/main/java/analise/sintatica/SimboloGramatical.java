package analise.sintatica;

public abstract class SimboloGramatical {
	private String lexema;
	private boolean obrigatorio = true;
	
	public abstract boolean isTerminal();
	public abstract ProducaoGramatical getProducaoParaDerivar();
	
				
	public String getLexema(){
		return this.lexema;
	}
	
	public boolean isObrigatorio(){
		return this.obrigatorio;
	}
	
	public void setObrigatorio(){
		this.obrigatorio = true;
	}
	
	public void setOpcional(){
		this.obrigatorio = false;
	}	
	
	public SimboloGramatical(){
		  	
	}
	
	public SimboloGramatical(String lexema){
		this();
		this.lexema = lexema;
		this.obrigatorio = true;
	}	
	
	public SimboloGramatical(String lexema, boolean obrigatorio ){
		this();
		this.lexema = lexema;
		this.obrigatorio = obrigatorio;
	}
		

}
