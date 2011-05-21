package analise.sintatica;

import java.util.LinkedList;
import coretypes.TokenList;

public class ProducaoGenerica {
	
	private LinkedList<String> producoesAceitas;
	
	protected LinkedList<String> getListaProducoesAceitas(){
		return this.producoesAceitas;
	}
	
	public ProducaoGenerica(){
		this.producoesAceitas = new LinkedList<String>();
	}

	public boolean validaParcialmente(TokenList listaDeToken){
		int i = 0;
		while ( listaDeToken.get(i).getValue() == producoesAceitas.get(i) ){
			
		}
		
		return true;
	}
	
	public boolean validaTotalmente(TokenList listaDeToken){
		// TODO: Navegar na listade producoes e comparar com tokens de entrada
		return true;
	}

}
