package analise.tabelaDeSimbolos;

public class SimboloFuncao extends SimboloAbstract {

	public SimboloFuncao(String nome) {
		super(nome);
	}

	@Override
	public boolean isFuncao() {
		return true;
	}

	@Override
	public boolean isVariavel() {
		return false;
	}

	@Override
	public boolean isFimDeEscopo() {
		return false;
	}
	
	@Override
	public boolean isConstante() {
		return false;
	}	

}
