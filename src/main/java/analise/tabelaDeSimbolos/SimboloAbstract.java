package analise.tabelaDeSimbolos;

public abstract class SimboloAbstract {
	
	private String nome;
	
	public SimboloAbstract(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public abstract boolean isFuncao();
	public abstract boolean isVariavel();
	public abstract boolean isFimDeEscopo();
	public abstract boolean isConstante();

}
