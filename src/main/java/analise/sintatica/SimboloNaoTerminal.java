package analise.sintatica;

public class SimboloNaoTerminal extends SimboloGramatical {
	
	private ProducaoGramatical producao = null;  
	
	@Override
	public boolean isTerminal() {
		return false;
	}

	@Override
	public ProducaoGramatical getProducaoParaDerivar(){
		return this.producao;
	}
	
	public SimboloNaoTerminal(String lexema, ProducaoGramatical producao, boolean obrigatorio){
		super(lexema, obrigatorio);
		this.setProducaoParaDerivacao(producao);
	}
	
	public SimboloNaoTerminal(String lexema, ProducaoGramatical producao){
		super(lexema);
		this.setProducaoParaDerivacao(producao);
	}	
	
	public void setProducaoParaDerivacao(ProducaoGramatical producao) {
		this.producao = producao;
	}	

}
