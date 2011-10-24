package analise.semantica;

public class Parametro {
	
	private String nome;
	private String tipo;
	private String passagem; // ref ou val
	
	public Parametro(String nome, String tipo, String tipoDaPassagem) {
		this.nome = nome;
		this.tipo = tipo;
		this.passagem = tipoDaPassagem;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPassagem() {
		return passagem;
	}
	
}
