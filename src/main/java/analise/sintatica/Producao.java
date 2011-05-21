package analise.sintatica;

import java.util.LinkedList;

public class Producao{

	private LinkedList<SimboloGramatical> simbolos;
    private int navegacao = 0;
	
	public Producao(){
		this.simbolos = new LinkedList<SimboloGramatical>();
	}
	
	public Producao(LinkedList<SimboloGramatical> simbolos){
		this.simbolos = simbolos;
	}
	
	
	public SimboloGramatical getFirst(){
		this.navegacao = 1;
		return this.simbolos.getFirst();
	}
	
	public SimboloGramatical getLast(){
		this.navegacao = this.simbolos.size();
		return this.simbolos.getLast();
	}
	
	public SimboloGramatical getIndex(int index){
		return this.simbolos.get(index);
	}
	
	public SimboloGramatical getNext(){
		this.navegacao ++;
		return this.simbolos.get(this.navegacao);
	}
	
	public SimboloGramatical getPrevious(){
	    this.navegacao --;
	    return this.simbolos.get(this.navegacao);
	}
	
	public int getIndice(){
		return this.navegacao;
	}
	
	

}
