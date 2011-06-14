package analise.sintatica;

import java.util.HashMap;

import utils.GCLTokenTypes;

import analise.lexica.AnaliseLexica;
import analise.sintatica.producoes.DicionarioDeRegrasProducao;
import analise.sintatica.producoes.ProducoesListBuilder;
import analise.sintatica.producoes.RegrasProducaoAbstract;
import analise.sintatica.producoes.RegrasProducaoDefinitionPart;
import analise.sintatica.producoes.RegrasProducaoModule;
import coretypes.Token;
import coretypes.TokenList;

public class AnaliseSintatica {
	
	private TokenList pilhaDeTokens;
	private DicionarioDeRegrasProducao listaDeProducoes;
	private AnaliseLexica analiseLexica;
	

	public AnaliseSintatica(AnaliseLexica analiseLexica){
		this.pilhaDeTokens = new TokenList();
		this.limpaPilhaDeTokens();

		this.listaDeProducoes = ProducoesListBuilder.producoesGCL();
		this.analiseLexica = analiseLexica;
	}
	
	private void limpaPilhaDeTokens(){
		this.pilhaDeTokens.clear();
	}
	
	private boolean empilhaToken(){
		
		try {
			Token token = this.analiseLexica.getNextToken();
			this.pilhaDeTokens.addLast(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean hasTokenParaProcessar(){
		return this.empilhaToken();
	}
	
	private RegrasProducaoAbstract getProducaoQueValida(TokenList pilha){
		HashMap<String, Integer> listaDeTokens = new HashMap<String, Integer>();
		listaDeTokens.put("program", 1);
		listaDeTokens.put("module", 2);
		
		int i = 0;
		
		switch ( listaDeTokens.get(pilha.getFirst().getValue()) ){

			case 1: // program
			
				if ( RegrasProducaoModule.getInstancia().isValida(pilha, 0) ){
					return RegrasProducaoModule.getInstancia();
 				}
										
				break;
				
			case 2: // module
				// TODO: VALIDACAO TOTALMENTE ERRADA
				while ( pilha.isEmpty() ){
					if ( pilha.get(i).getValue().equalsIgnoreCase("module") ) {
						if ( pilha.get(i).getTokenType() == GCLTokenTypes.Identifier ) {
							if ( RegrasProducaoDefinitionPart.getInstancia().isValida(pilha, i) ) {
								
							}
						}
					}
					
				}
				
				// "module" "identifier" <definitionPart> [ "private"  <block> ] "."
				
				break;
				
			default: //identifier
				
				break;
		
		}		
			
		return null;
		
	}
	
	private boolean isPilhaValidaParaUmaUnicaProducao(){		
		return ( getProducaoQueValida(pilhaDeTokens) != null );
	}
	

	public Token desempilhaToken(){
		return this.pilhaDeTokens.removeLast();
	}

	public int empilhaToken(Token token){
		this.pilhaDeTokens.addLast(token);
		return this.pilhaDeTokens.size();
	}


	
	public void valida(){
		try{
			
			while ( hasTokenParaProcessar() ){
				if ( isPilhaValidaParaUmaUnicaProducao() ){
					//getProducaoValida();
					//geraArvore();
					this.limpaPilhaDeTokens();
				}
				
			}
			
		}catch(Exception e){
			
		}
	  			
	}

}
