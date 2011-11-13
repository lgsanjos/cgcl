package codigoAssembly;

import java.util.List;

import codigoAssembly.estrutura.BlocoAssembly;
import codigoAssembly.estrutura.CodigoAssembly;
import codigoAssembly.estrutura.StringAssembly;
import codigoIntermediario.ConstrucaoDeQuatroEnderecos;

public class GeradorDeAssembly {
	
	private static GeradorDeAssembly instancia = new GeradorDeAssembly();  
	
	private List<ConstrucaoDeQuatroEnderecos> codigoIntermediario;
	private int contadorDeInstrucao;
	private BlocoAssembly blocoAtual;
	
	private GeradorDeAssembly() {
		codigoIntermediario = null;
		this.reseta();
	}
	
	private boolean nomeDoOperadorAtualEh(String nome) {
		if (this.codigoIntermediario != null && this.codigoIntermediario.get(contadorDeInstrucao) != null)
			return this.codigoIntermediario.get(contadorDeInstrucao).getOperador().equalsIgnoreCase(nome);
		
		return false;
	}
	
	public void carregaInstrucoes(List<ConstrucaoDeQuatroEnderecos> codigoIntermediario) {
		this.reseta();
		this.codigoIntermediario = codigoIntermediario;
	}
	
	private ConstrucaoDeQuatroEnderecos instrucaoAtual() {
		if (this.codigoIntermediario.size() <= this.contadorDeInstrucao)
			return null;
		
		ConstrucaoDeQuatroEnderecos proximo;
		proximo = this.codigoIntermediario.get(contadorDeInstrucao);
		return proximo;
	}
	
	private ConstrucaoDeQuatroEnderecos proximaInstrucao() {
		ConstrucaoDeQuatroEnderecos proximo = this.instrucaoAtual();
		this.contadorDeInstrucao ++;
		return proximo;
	}
	
	private void reseta() {
		this.contadorDeInstrucao = 0;
		this.codigoIntermediario = null;
		this.blocoAtual = null;
	}
	
	private void traduzLabel() {
		String nomeDoLabel = this.instrucaoAtual().getElementoAEsquerda();

		if (! nomeDoLabel.endsWith(":")) 
			nomeDoLabel += ":";
		
		if (blocoAtual != null)
			blocoAtual.addRet();
		
		blocoAtual = CodigoAssembly.getInstancia().getBloco(nomeDoLabel);
		blocoAtual.addPushl("%ebp");
		blocoAtual.addMovl("%esp", "%ebp");
	}
	
	private void traduzCall() {
		String nomeMetodo = instrucaoAtual().getElementoAEsquerda();
		blocoAtual.addInstrucaoCall(nomeMetodo);
	}
	
	private void traduzNoOperation() {
		blocoAtual.addInstrucaoNop();
	}
	
	private void traduzPrintf() {
		String conteudo = instrucaoAtual().getElementoAEsquerda();
		String id = StringAssembly.novaString(conteudo);
		blocoAtual.addDeclaracaoString(id, conteudo);
		
		blocoAtual.addPushl(id);
		blocoAtual.addInstrucaoCall("printf");
	}
	
	private void traduzParam() {
		
	}
	
	private void posExecuta() {
		// SEMPRE todo código deverá ter uma _main
		CodigoAssembly.getInstancia().getBloco(".text").addGlobal("_main");
		
		// SEMPRE no final do último bloco deverá existir um ret
		blocoAtual.addRet();		
	}
	
	public void traduzir() {
		CodigoAssembly.limpar();

		while (instrucaoAtual() != null) {

			if (nomeDoOperadorAtualEh("label"))
				this.traduzLabel();

			if (nomeDoOperadorAtualEh("call"))
				this.traduzCall();

			if (nomeDoOperadorAtualEh("nop"))
				this.traduzNoOperation();

			if (nomeDoOperadorAtualEh("printf"))
				this.traduzPrintf();

			if (nomeDoOperadorAtualEh("param"))
				this.traduzParam();

			this.proximaInstrucao();
		}
		
		posExecuta();
	}
	
	public static void traduz(List<ConstrucaoDeQuatroEnderecos> codigoIntermediario) {
		instancia.carregaInstrucoes(codigoIntermediario);
		instancia.traduzir();
	}

}
