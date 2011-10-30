package codigoIntermediario;

import java.util.LinkedList;

import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediaria;
import codigoIntermediario.construcoesIntermediarias.ConstrucaoIntermediariaAtribuicao;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class GeradorDeCodigoIntermediario {
	
	private LinkedList<ConstrucaoIntermediaria> construcoes;
	
	public GeradorDeCodigoIntermediario() {
		super();
		this.construcoes = new LinkedList<ConstrucaoIntermediaria>();
	}
	
	private void processaNo(ArvoreSintaticaAbstrataNo no) {
		
		if (no.getNome().equalsIgnoreCase("assignStatement")) {
			ConstrucaoIntermediariaAtribuicao.getInstancia().traduz(no);
		}
		
		if (no.getNome().equalsIgnoreCase("ifStatement")) {
		}
		
		if (no.getNome().equalsIgnoreCase("writeStatement")) {
		}
		
	}
	
	private void percorreAvoreSintatica(ArvoreSintaticaAbstrataNo noInicial) {
		
		this.processaNo(noInicial);
		
		for (ArvoreSintaticaAbstrataNo no : noInicial.getListaDeNos())
			this.percorreAvoreSintatica(no);
	}

	public String traduz(ArvoreSintaticaAbstrataNo noRaiz) {
		this.percorreAvoreSintatica(noRaiz);
		return "";
	}

}
