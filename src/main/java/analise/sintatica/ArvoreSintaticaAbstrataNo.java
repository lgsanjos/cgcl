package analise.sintatica;

import java.util.LinkedList;
import coretypes.Token;

public class ArvoreSintaticaAbstrataNo {

	private String nome;
	private Token token;
	private ArvoreSintaticaAbstrataNo noPai;
	private LinkedList<ArvoreSintaticaAbstrataNo> listaDeNosFilhos;
	private String printBuffer;

	public ArvoreSintaticaAbstrataNo() {
		this.listaDeNosFilhos = new LinkedList<ArvoreSintaticaAbstrataNo>();
	} 

	public ArvoreSintaticaAbstrataNo(String tipoDoNo) {
		this();
		this.nome = tipoDoNo;
	}

	public ArvoreSintaticaAbstrataNo(String tipoDoNo, Token tokenAtual) {
		this(tipoDoNo);
		this.token = tokenAtual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArvoreSintaticaAbstrataNo getNoPai() {
		return this.noPai;
	}

	public void setNoPai(ArvoreSintaticaAbstrataNo no) {
		this.noPai = no;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public LinkedList<ArvoreSintaticaAbstrataNo> getListaDeNos() {
		return listaDeNosFilhos;
	}

	public void adicionaNoFilho(String tipoDoNo, Token tokenDoNoFilho) {
		if (tokenDoNoFilho != null) {

			ArvoreSintaticaAbstrataNo novoNo;
			novoNo = new ArvoreSintaticaAbstrataNo(tipoDoNo, tokenDoNoFilho);
			this.adicionaNoFilho(novoNo);
		}
	}

	public void adicionaNoFilho(Token tokenDoNoFilho) {
		this.adicionaNoFilho(tokenDoNoFilho.getValue(), tokenDoNoFilho);
	}

	public void adicionaNoFilho(ArvoreSintaticaAbstrataNo noFilho) {
		if (noFilho != null) {
			this.listaDeNosFilhos.addLast(noFilho);
			noFilho.setNoPai(this);
		}
	}

	public boolean possueNosFilhos() {
		return (!this.listaDeNosFilhos.isEmpty());
	}

	public int quatidadeNosFilhos() {
		return (this.listaDeNosFilhos.size());
	}
	
	public String print() {
		return ArvoreSinstaticaAbstrataNoHelper.printNosFilhos(this);
	}


}
