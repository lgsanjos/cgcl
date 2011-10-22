package analise.tabelaDeSimbolos;

public class SimboloFimDeEscopo extends SimboloAbstract {

	public SimboloFimDeEscopo() {
		super("");
	}
	
	public SimboloFimDeEscopo(String nome) {
		super(nome);
	}

	@Override
	public boolean isFuncao() {
		return false;
	}

	@Override
	public boolean isVariavel() {
		return false;
	}

	@Override
	public boolean isFimDeEscopo() {
		return true;
	}
	
	@Override
	public boolean isConstante() {
		return false;
	}	

}
