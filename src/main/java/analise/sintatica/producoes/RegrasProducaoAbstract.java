package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;
import coretypes.TokenList;
import coretypes.gcl.GCLTokenTypes;

public abstract class RegrasProducaoAbstract {
	
	private TokenList pilhaDeToken;
	private TokenList pilhaDeTokenSalva;
	
	protected boolean proximoTokenEhUmIdentificador() {
		return isTokenType(this.getPilhaDeToken(), GCLTokenTypes.IDENTIFIER);
	}
	
	protected boolean proximotokenEhUmaString() {
		return isTokenType(this.getPilhaDeToken(), GCLTokenTypes.LITERAL);
	}
	
	protected boolean proximoTokenEhUmNumero() {
		return isTokenType(this.getPilhaDeToken(), GCLTokenTypes.NUMBER);
	}	
	
	protected void salvarIndiceTokenAtual() {
		if (this.pilhaDeTokenSalva != null) {
			throw new RuntimeException("Não se pode salvar o estado duas vezes seguidas.");
		}
		this.pilhaDeTokenSalva = this.pilhaDeToken.clone();
	}
	
	protected void descartaIndiceSalvo() {
		if (this.pilhaDeToken == null) {
			throw new RuntimeException("Nao se pode descartar um estado não salvo.");
		}
		
		this.pilhaDeTokenSalva = null;
		ProducoesFactory.limpaEstado();
		ProducoesFactory.setEstado(this.pilhaDeToken);
	}
	
	protected void recuperarIndiceSalvo() {
		if (this.pilhaDeToken == null) {
			throw new RuntimeException("Nao se pode recuperar um estado não salvo.");
		}
		this.pilhaDeToken = null;
		this.pilhaDeToken = this.pilhaDeTokenSalva;
		this.pilhaDeTokenSalva = null;
		ProducoesFactory.setEstado(this.pilhaDeToken);
	}
	
	private boolean isTokenType(TokenList pilhaDeToken, GCLTokenTypes tipo) {
		Token tokenIndice = this.pilhaDeToken.getProximoToken();
		if (tokenIndice == null) {
			return false;
		}	

		return tokenIndice.getTokenType().equals(tipo);
	}
	
	protected boolean proximoTokenPossuiValorETipoIgualA(String compareLexema, GCLTokenTypes compareType ) {
		
		Token tokenIndice = pilhaDeToken.getProximoToken();
		if (tokenIndice == null) {
			return false;
		}
		
		return (tokenIndice.getValue().equalsIgnoreCase(compareLexema)) &&
				(tokenIndice.getTokenType().equals(compareType));
	}

	protected boolean proximoTokenPossuiValorIgualA(String compareLexema) {

		Token token = pilhaDeToken.getProximoToken();
		if (token == null) {
			return false;
		}
		return token.getValue().equalsIgnoreCase(compareLexema);
	}
	
	protected Token getTokenAtual() {
		if (this.pilhaDeToken == null) {
			this.pilhaDeToken = null;
		}
		if (this.pilhaDeToken.getIndice() == -1 ) {
			return this.pilhaDeToken.get(0);
		}
		 return pilhaDeToken.getTokenAtual();
	}
	
	protected void avancaProximoToken() {
		this.pilhaDeToken.avancaToken();
	}
	
	protected void voltaToken() {
		this.pilhaDeToken.retornaToken();
	}
	
	protected ArvoreSintaticaAbstrataNo validaEGeraProducaoDadoProducao(ProducoesEnum nomeDaProducao) throws ProducaoSintaticaException {
		ArvoreSintaticaAbstrataNo raiz;
		RegrasProducaoAbstract producao = ProducoesFactory.getProducao(nomeDaProducao);
		raiz = producao.validaEGeraProducao();
		this.setPilhaDeToken(ProducoesFactory.getEstado());
		return raiz;
		
	}
	
	protected void throwProducaoSintaticaException(String producao) throws ProducaoSintaticaException {
		if (this.getTokenAtual() != null) {
			throw new ProducaoSintaticaException(producao, this.getTokenAtual().getPosicaoLinha(), this.getTokenAtual().getPosicaoColuna());
		} else {
			notify();
			//throw new ProducaoSintaticaException(producao);
		}
	}

	public abstract ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException;
	
	public TokenList getPilhaDeToken(){
		return this.pilhaDeToken;
	}
	
	public void setPilhaDeToken(TokenList tokens){
		this.pilhaDeToken = tokens;
	}
	
	
}
