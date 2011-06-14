package analise.sintatica;

public class SimboloTerminal extends SimboloGramatical {
	
	@Override
	public boolean isTerminal() {
		return true;
	}
	
	@Override
	public ProducaoGramatical getProducaoParaDerivar(){
		return null;
	}
	
	public SimboloTerminal(String lexema, boolean obrigatorio) {
		super(lexema, obrigatorio);
	}

	public SimboloTerminal(String lexema) {
		super(lexema);
	}

}
