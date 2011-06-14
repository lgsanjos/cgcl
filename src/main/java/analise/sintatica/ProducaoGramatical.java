package analise.sintatica;

import java.util.LinkedList;

import coretypes.TokenList;

public class ProducaoGramatical{

	private LinkedList<SimboloGramatical> simbolos;
    private int navegacao = 0;
    
    private int contaSimbolosValidos(TokenList listaDeToken){
		boolean lexemasValidos = true;
		int i = 0;
		
		while ( (lexemasValidos) && (i < this.size() && (i < listaDeToken.size())) ){
			lexemasValidos = this.getIndex(i).getLexema().equalsIgnoreCase( listaDeToken.get(i).getValue() );
			i++;
		}
		
		return i;
    }	
	
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
		
	
	public int getIndice(){
		return this.navegacao;
	}
	
	public boolean validaParcialmente(TokenList listaDeToken){
				
		return (this.contaSimbolosValidos(listaDeToken) == listaDeToken.size());
	}
	
	public boolean validaTotalmente(TokenList listaDeToken){
		
		return (this.contaSimbolosValidos(listaDeToken) == listaDeToken.size());
		
	}
	
	public boolean addTerminal(String lexema, boolean obrigatorio){
		
		return this.simbolos.add( new SimboloTerminal(lexema, obrigatorio) );
		
	}
	
	public boolean addTerminal(String lexema){
		
		return this.simbolos.add( new SimboloTerminal(lexema) );
		
	}
	
	public boolean addNaoTerminal(String lexema, ProducaoGramatical producao){
		
		return this.simbolos.add( new SimboloNaoTerminal(lexema, producao) );
		
	}	
	
	public boolean addNaoTerminal(String lexema, ProducaoGramatical producao, boolean obrigatorio){
		
		return this.simbolos.add( new SimboloNaoTerminal(lexema, producao, obrigatorio) );
		
	}	
	
	

}
