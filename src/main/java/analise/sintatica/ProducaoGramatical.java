package analise.sintatica;

import java.util.LinkedList;

public class ProducaoGramatical{

	private LinkedList<SimboloGramatical> simbolos;
    private int navegacao = 0;
	
	public ProducaoGramatical(){
		this.simbolos = new LinkedList<SimboloGramatical>();
	}
	
	public ProducaoGramatical(LinkedList<SimboloGramatical> simbolos){
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
	
	public int size(){
		return this.simbolos.size();
	}
	
	public boolean addSimbolo(String lexema){
		SimboloGramatical nova = new SimboloGramatical(true, lexema);
		return this.simbolos.add(nova);
	}
	
	public boolean addSimbolo(String lexema, boolean terminal){
		SimboloGramatical nova = new SimboloGramatical(terminal, lexema);
		return this.simbolos.add(nova);
	}	
	
	public int getIndice(){
		return this.navegacao;
	}
	
	

}
