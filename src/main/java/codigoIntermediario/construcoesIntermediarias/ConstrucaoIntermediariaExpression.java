package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;

public class ConstrucaoIntermediariaExpression extends ConstrucaoIntermediaria {
	
	private static ConstrucaoIntermediariaExpression instancia;
	
	private ConstrucaoIntermediariaExpression() {
		super();
		instancia = new ConstrucaoIntermediariaExpression(); 
	}
	
	public static ConstrucaoIntermediariaExpression getInstancia() {
		return instancia;
	}
	
	private String processaFactor(ArvoreSintaticaAbstrataNo factor) {
		
		ArvoreSintaticaAbstrataNo primeiroFilho = factor.getListaDeNos().getFirst();
		
		if (primeiroFilho.getNome().equalsIgnoreCase("NUMBER")) {
			Token numero = primeiroFilho.getToken();
			if (numero != null)
				return numero.getValue();
		}
		
		if (primeiroFilho.getNome().equalsIgnoreCase("variableAccess")) {
			Token id = primeiroFilho.getListaDeNos().getFirst().getToken();
			if (id != null)
				return id.getValue();			
		}
		
		return "";
	}
	
	private boolean factorEhMultiplicacao(ArvoreSintaticaAbstrataNo factor) {
		return factor.getListaDeNos().size() > 1;
	}
	
	private String extraiValorDeUmTerm(ArvoreSintaticaAbstrataNo term) {
		
		if (factorEhMultiplicacao(term)) {
			// gerar um temp
			// processar a multiplicacao
			return "";			
		} else {
			return this.processaFactor(term.getListaDeNos().getFirst());
		}	
	}
	
	private String processaSimpleExpression(ArvoreSintaticaAbstrataNo simpleExpression) {
		
		if (simpleExpression.getListaDeNos().size() != 3) return;
		
		String term1 = this.extraiValorDeUmTerm(simpleExpression.getListaDeNos().get(0));
		String operador = "+";
		String term2 = this.extraiValorDeUmTerm(simpleExpression.getListaDeNos().get(2));
		
		CodigoIntermediario.add(operador, term1, term2, resultado);
		
	}
	
	private void processaRelationalOperator(ArvoreSintaticaAbstrataNo relationalOperator) {
		// TODO: verificar o q deve ser feito com esse operador
	}
	
	private void processaRelationalExpression(ArvoreSintaticaAbstrataNo relationalExpression) {
		
		for (ArvoreSintaticaAbstrataNo no : relationalExpression.getListaDeNos()) {
			if (no.getNome().equalsIgnoreCase("simpleExpression"))
				this.processaSimpleExpression(no);
			
			if (no.getNome().equalsIgnoreCase("relationalOperator"))
				this.processaRelationalOperator(no);			
		}
	}
	
	@Override
	public void traduz(ArvoreSintaticaAbstrataNo expression) {
		
		for (ArvoreSintaticaAbstrataNo no : expression.getListaDeNos()) {
			
			if (no.getNome().equalsIgnoreCase("relationalExpression")) {
				this.processaRelationalExpression(no);
			}
			
			if (no.getNome().equalsIgnoreCase("booleanOperator")) {
				//
			}					
		}

	}

}
