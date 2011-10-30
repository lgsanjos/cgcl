package codigoIntermediario;

import java.util.LinkedList;

public class CodigoIntermediario {
	
	private static CodigoIntermediario instancia = new CodigoIntermediario();
	private LinkedList<ConstrucaoDeQuatroEnderecos> pilha;
	
	private CodigoIntermediario() {
		this.pilha = new LinkedList<ConstrucaoDeQuatroEnderecos>();
	}
	
	public static CodigoIntermediario getInstancia() {
		return instancia;
	}
	
	public static String add(String operador, String elementoEsquerda, String elementoDireita) {
		String resultado = VariaveisTemporarias.geraVariavelTemporaria();
		CodigoIntermediario.add(operador, elementoEsquerda, elementoDireita, resultado);
		return resultado;
	}
	
	public static void add(String operador, String elementoEsquerda, String elementoDireita, String resultado) {
		ConstrucaoDeQuatroEnderecos linha = new ConstrucaoDeQuatroEnderecos();
		linha.setOperador(operador);
		linha.setElementoAEsquerda(elementoEsquerda);
		linha.setElementoADireita(elementoDireita);
		linha.setResultado(resultado);
		CodigoIntermediario.add(linha);
	}
	
	public static void add(ConstrucaoDeQuatroEnderecos linha) {
		instancia.pilha.add(linha);
	}

}
