package analise.sintatica;

import analise.lexica.AnaliseLexica;
import analise.sintatica.producoes.*;
import coretypes.IndiceNumerico;
import coretypes.Token;
import coretypes.TokenList;

public class AnaliseSintatica {
	
	private TokenList pilhaDeTokens;
	//private DicionarioDeRegrasProducao listaDeProducoes;
	private AnaliseLexica analiseLexica;
	

	public AnaliseSintatica(AnaliseLexica analiseLexica){
		this.pilhaDeTokens = new TokenList();
		this.limpaPilhaDeTokens();

		//this.listaDeProducoes = ProducoesListBuilder.producoesGCL();
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
	
	private boolean validaSintaxeEGeraASA() {
			
		IndiceNumerico i = new IndiceNumerico();
		// Deve tentar validar com todas as producoes possiveis.
		if ( RegrasProducaoModule.getInstancia().isValida(pilhaDeTokens, i) ) return true;
		//if ( RegrasProducaoDefinition.getInstancia().isValida(pilhaDeTokens, i) ) return true;
		//if ( RegrasProducaoDefinitionPart.getInstancia().isValida(pilhaDeTokens, i) ) return true;
				
		return false;		
	}
	

	public Token desempilhaToken(){
		return this.pilhaDeTokens.removeLast();
	}
	
	public boolean pilhaDeTokensVazia(){
		return this.pilhaDeTokens.isEmpty();
	}

	public int empilhaToken(Token token){
		this.pilhaDeTokens.addLast(token);
		return this.pilhaDeTokens.size();
	}

	public boolean valida(){

		try{
			while ( this.hasTokenParaProcessar() ){
				if ( this.validaSintaxeEGeraASA() ){
					this.limpaPilhaDeTokens();
				}			
			}
			
			return this.pilhaDeTokensVazia();
		}catch(Exception e){
			return false;
		}
	  			
	}

}
