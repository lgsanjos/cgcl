package coretypes;

public class IndiceNumerico {

	private int valor;
	
	@Override
	public boolean equals(Object obj) {
		return ( (Integer) obj == this.valor );
	}	
	
	public IndiceNumerico(int valor) {
		this.valor = valor;
	}
	
	public IndiceNumerico() {
		this.valor = 0;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void inc() {
		this.valor ++;
	}
	
	public void dec() {
		this.valor --;
	}

}
