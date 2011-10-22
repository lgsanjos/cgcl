package analise.tabelaDeSimbolos;

public class SimboloConstante extends SimboloAbstract {

	private String valor;
	
	public SimboloConstante(String nome, String valor) {
		super(nome);
		this.valor = valor;
	}

	public String getValor() {
		return valor;
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
		return false;
	}

	@Override
	public boolean isConstante() {
		return true;
	}

}
