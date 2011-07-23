package analise.sintatica;

import analise.lexica.AnaliseLexica;
import analise.sintatica.producoes.*;
import coretypes.Token;
import coretypes.TokenList;

public class AnaliseSintatica {
	
	private TokenList pilhaDeTokens;
	private AnaliseLexica analiseLexica;
	private ArvoreSintaticaAbstrataNo raizDaArvoreSintaticaAbstrata;

	public AnaliseSintatica(AnaliseLexica analiseLexica){
		this.pilhaDeTokens = new TokenList();
		this.limpaPilhaDeTokens();

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
			
		ArvoreSintaticaAbstrataNo noRaiz;
		
		ProducoesFactory.setEstado(pilhaDeTokens);
		try {
			noRaiz = ProducoesFactory.getProducao(ProducoesEnum.module).validaEGeraProducao();
			if (noRaiz != null) {
				this.raizDaArvoreSintaticaAbstrata = noRaiz;
				return true;
			}
			
			//noRaiz = ProducoesFactory.getProducao(ProducoesEnum.definition).validaEGeraProducao();
			//if ( RegrasProducaoDefinition.getInstancia().isValida(pilhaDeTokens, i) ) return true;
			//if ( RegrasProducaoDefinitionPart.getInstancia().isValida(pilhaDeTokens, i) ) return true;
		} finally{
			ProducoesFactory.limpaEstado();
		}
		return (noRaiz != null);		
	}
	

	public Token desempilhaToken(){
		return this.pilhaDeTokens.removeLast();
	}
	
	public boolean pilhaDeTokensVazia(){
		return this.pilhaDeTokens.estaVazia();
	}

	public int empilhaToken(Token token){
		this.pilhaDeTokens.addLast(token);
		return this.pilhaDeTokens.size();
	}

	public boolean valida(){

		while ( this.hasTokenParaProcessar() ){
			if ( this.validaSintaxeEGeraASA() ){
				this.limpaPilhaDeTokens();
			}			
		}
		
		return this.pilhaDeTokensVazia();
	  			
	}

}
