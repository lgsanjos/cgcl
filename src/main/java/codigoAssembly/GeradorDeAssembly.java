package codigoAssembly;

import java.util.List;

import codigoAssembly.estrutura.BlocoAssembly;
import codigoAssembly.estrutura.CodigoAssembly;
import codigoIntermediario.CodigoIntermediario;
import codigoIntermediario.ConstrucaoDeQuatroEnderecos;

public class GeradorDeAssembly {
	
	private List<ConstrucaoDeQuatroEnderecos> codigoIntermediario;
	private int contadorDeInstrucao;
	private BlocoAssembly blocoAtual;
	
	
	private GeradorDeAssembly() {
		this.carregaInstrucoes();
		this.reseta();
	}
	
	private boolean nomeDoOperadorAtualEh(String nome) {
		if (this.codigoIntermediario != null && this.codigoIntermediario.get(contadorDeInstrucao) != null)
			return this.codigoIntermediario.get(contadorDeInstrucao).getOperador().equalsIgnoreCase("label");
		
		return false;
	}
	
	public void carregaInstrucoes() {
		this.codigoIntermediario = CodigoIntermediario.getCodigo();
		this.reseta();
	}
	
	private ConstrucaoDeQuatroEnderecos instrucaoAtual() {
		if (this.codigoIntermediario.size() > this.contadorDeInstrucao)
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
		blocoAtual = CodigoAssembly.getInstancia().getBloco(nomeDoLabel);
	}
	
	private void traduzCall() {
		String nomeMetodo = instrucaoAtual().getElementoAEsquerda();
		int quantidadeParametros = Integer.parseInt(instrucaoAtual().getElementoADireita());
		blocoAtual.addInstrucao("call", nomeMetodo, "");
	}
	
	public void traduzir() {
		CodigoAssembly.limpar();
		
		while (instrucaoAtual() != null) {
			
			if (nomeDoOperadorAtualEh("label"))
				this.traduzLabel();
			
			if (nomeDoOperadorAtualEh("call"))
				this.traduzCall();
				
				
			
			this.proximaInstrucao();
		}
			
	}
	
	public void gerarBlocoPrincipal() {
		BlocoAssembly main =  CodigoAssembly.getInstancia().getBloco("_main");
		
		main.addInstrucao("pushl", "%ebp", "");
		main.addInstrucao("movl", "%esp", "%ebp");
		
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario = CodigoIntermediario.getCodigo();
		
		for (ConstrucaoDeQuatroEnderecos construcao : codigoIntermediario) {
			
			if (construcao.getOperador().equalsIgnoreCase("call")) {
				
			}
			
		}
	}
}
