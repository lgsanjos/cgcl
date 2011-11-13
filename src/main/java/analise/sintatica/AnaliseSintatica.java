package analise.sintatica;

import java.util.LinkedList;

import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;
import analise.exceptions.ProducaoSintaticaLoggedException;
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
	
	private boolean empilhaToken() throws InvalidTokenException {
		
		Token token = this.analiseLexica.getNextToken();
		
		if (token == null) {
			return false;
		}
		this.pilhaDeTokens.addLast(token);
		return true;
		
	}
	
	private boolean hasTokenParaProcessar() throws InvalidTokenException{
		return this.empilhaToken();
	}
	
	private boolean validaSintaxeEGeraASA() throws ProducaoSintaticaException {

		ArvoreSintaticaAbstrataNo noRaiz;
			
		ProducoesFactory.setEstado(pilhaDeTokens);
		noRaiz = ProducoesFactory.getProducao(ProducoesEnum.module).validaEGeraProducao();
		if (noRaiz != null) {
			this.raizDaArvoreSintaticaAbstrata = noRaiz;
			return true;
		}
		ProducoesFactory.limpaEstado();
		return false;		
	}
	
	public String getLastException() {
		return ProducaoSintaticaLoggedException.getLastException();
	}
	
	public LinkedList<String> getExceptionLog() {
		return ProducaoSintaticaLoggedException.getAllExceptions();
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

	public boolean valida() throws ProducaoSintaticaException, InvalidTokenException {

		while (this.hasTokenParaProcessar()) {
		}
		if ( this.validaSintaxeEGeraASA() ){
			this.limpaPilhaDeTokens();
		}
		
		return this.pilhaDeTokensVazia();
	}

	public ArvoreSintaticaAbstrataNo analisar() throws ProducaoSintaticaException, InvalidTokenException{
		this.valida();
		return raizDaArvoreSintaticaAbstrata;
	  			
	}

}
