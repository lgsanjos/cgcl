package coretypes;

import utils.Clonavel;

public class IndiceNumerico implements Clonavel {

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
	
   public Object clone() {
       IndiceNumerico novo = new IndiceNumerico();
       novo.setValor( this.getValor());
       return novo;
   }	

}
