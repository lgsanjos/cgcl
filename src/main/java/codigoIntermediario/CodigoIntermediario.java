package codigoIntermediario;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CodigoIntermediario {
	
	private static CodigoIntermediario instancia = new CodigoIntermediario();
	private LinkedList<ConstrucaoDeQuatroEnderecos> pilha;

	private CodigoIntermediario() {
		this.pilha = new LinkedList<ConstrucaoDeQuatroEnderecos>();
	}

	public static CodigoIntermediario getInstancia() {
		return instancia;
	}

	public static List<ConstrucaoDeQuatroEnderecos> getCodigo() {
		return Collections.unmodifiableList(getInstancia().pilha);
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

	public static void addLabel(String label) {
		add("label", label, "", "");
	}
	
	public static void addLabel(String label, Integer quantidadeDeParametros) {
		add("label", label, quantidadeDeParametros.toString(), "");
	}	
	
	public static String jumpIfFalse(String expression) {
		String label = Labels.geraLabel(); 
		add("jit", expression, "", label);

		return label;
	}
	
	public static void addNoOperation() {
		add("nop","", "", "");
	}
	
	public static String addAssignment(String value) {
		return add(":=", value, "");
	}
	
	public static void addParam(String parametro) {
		add("param",parametro,"","");
	}
	
	public static void addCall(String nomeProcedimento, Integer quantidadeDeParametros) {
       add("call", nomeProcedimento, Integer.toString(quantidadeDeParametros), "");
	}
	
	public static void addWriteStatement(String texto) {
		add("printf", texto, "", "");
	}
	
	public static void limpar() {
		instancia.pilha.clear();
	}
	
	
	public String to_string() {
		String retorno = "";
		
		for (ConstrucaoDeQuatroEnderecos codigo : this.pilha)
			retorno +=  codigo.getOperador() + " " +
						codigo.getElementoAEsquerda() + " " +
						codigo.getElementoADireita() + " " +
						codigo.getResultado() + "\r\n";
		
		return retorno; 
	}

}
