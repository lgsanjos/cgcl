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

	private void printNosFilhos(ArvoreSintaticaAbstrataNo no, Integer identacao) {

		printNo(no, identacao);
		for (int i = 0; i < no.quatidadeNosFilhos(); i++) {
			printNosFilhos(no.getListaDeNos().get(i), identacao + 2);
		}
	}

	private void printNo(ArvoreSintaticaAbstrataNo no, Integer identacao) {
		String espaco = "";
		for (int i = 0; i < identacao; i++) {
			espaco = espaco + " ";
		}

		if (no.possueNosFilhos()) {

			printBuffer = printBuffer + espaco + no.getNome();
			printBuffer = (printBuffer + "\n");
		} else {
			if (no.getToken() != null) {
				printBuffer = (printBuffer + espaco
						+ no.getToken().getTokenType() + "." + no.getToken()
						.getValue());
				printBuffer = (printBuffer + "\n");

			}
		}

	}

	public String print() {
		this.printBuffer = "";

		this.printNosFilhos(this, 0);

		return this.printBuffer;
	}

}
