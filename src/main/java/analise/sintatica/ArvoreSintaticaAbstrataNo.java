package analise.sintatica;

import java.util.LinkedList;
import coretypes.Token;

public class ArvoreSintaticaAbstrataNo {
	
	private String nome;
	private Token token;
	private ArvoreSintaticaAbstrataNo noPai;
	private LinkedList<ArvoreSintaticaAbstrataNo> listaDeNosFilhos;
	
	public ArvoreSintaticaAbstrataNo(String tipoDoNo, ArvoreSintaticaAbstrataNo noPai){
		this.nome = tipoDoNo;
		this.noPai = noPai;
		this.listaDeNosFilhos = new LinkedList<ArvoreSintaticaAbstrataNo>();
	}

	public String getNome() {
		return nome;
	}
	
	public ArvoreSintaticaAbstrataNo getNoPai(){
		return this.noPai;
	}
	
	public void setNoPai(ArvoreSintaticaAbstrataNo no){
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
	
	
	
		

}
