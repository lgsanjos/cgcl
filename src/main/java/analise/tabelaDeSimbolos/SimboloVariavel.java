package analise.tabelaDeSimbolos;

public class SimboloVariavel extends SimboloAbstract {

	private String tipagem;
	
	public SimboloVariavel(String nome, String tipagem) {
		super(nome);
		this.tipagem = tipagem;
	}
	
	public String getTipagem() {
		return tipagem;
	}	

	@Override
	public boolean isFuncao() {
		return false;
	}

	@Override
	public boolean isVariavel() {
		return true;
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
