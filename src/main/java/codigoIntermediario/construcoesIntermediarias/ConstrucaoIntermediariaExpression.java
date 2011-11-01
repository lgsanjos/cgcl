package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import coretypes.Token;

public class ConstrucaoIntermediariaExpression extends ConstrucaoIntermediaria {
	
	private static ConstrucaoIntermediariaExpression instancia;
	
	private ConstrucaoIntermediariaExpression() {
		super();
	}
	
	public static ConstrucaoIntermediariaExpression getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaExpression();
		
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
		for (ArvoreSintaticaAbstrataNo no : factor.getListaDeNos()) 
			if (no.getNome().equalsIgnoreCase("multiplyOperator"))
				return true;
				
		return false;		
	}
	
	private String processaMultiplicacao(ArvoreSintaticaAbstrataNo term) {
		String term1 = this.processaFactor(term.getListaDeNos().get(0));
		String operador = term.getListaDeNos().get(1).getListaDeNos().getFirst().getToken().getValue();
		String term2 = this.processaFactor(term.getListaDeNos().get(2));
		return CodigoIntermediario.add(operador, term1, term2);
	}
	
	private String extraiValorDeUmTerm(ArvoreSintaticaAbstrataNo term) {
		
		if (factorEhMultiplicacao(term)) {
			return this.processaMultiplicacao(term);
		} else {
			return this.processaFactor(term.getListaDeNos().getFirst());
		}	
	}
	
	private String extraiOperadorDeAddingOperator(ArvoreSintaticaAbstrataNo addingOperator) {
		
		if (! addingOperator.getNome().equalsIgnoreCase("addingOperator"))
			return ""; //TODO: throw exception
		
		return addingOperator.getListaDeNos().getFirst().getToken().getValue();
	}
	
	private String processaSimpleExpression(ArvoreSintaticaAbstrataNo simpleExpression) {
		
		if (simpleExpression.getListaDeNos().size() != 3)
			return "";
		
		String term1 = this.extraiValorDeUmTerm(simpleExpression.getListaDeNos().get(0));
		String operador = this.extraiOperadorDeAddingOperator(simpleExpression.getListaDeNos().get(1));
		String term2 = this.extraiValorDeUmTerm(simpleExpression.getListaDeNos().get(2));
		
		return CodigoIntermediario.add(operador, term1, term2);
		
	}
	
	private String processaRelationalOperator(ArvoreSintaticaAbstrataNo relationalOperator) {
		
		if (relationalOperator.getNome().equalsIgnoreCase("relationalOperator"))
			return relationalOperator.getListaDeNos().getFirst().getToken().getValue();
		
		return "";
	}
	
	private String processaRelationalExpression(ArvoreSintaticaAbstrataNo relationalExpression) {
		
		String exp1 = "";
		String exp2 = "";
		String operador = "";
		ArvoreSintaticaAbstrataNo no;
		
		no = relationalExpression.getListaDeNos().get(0);
		if (no.getNome().equalsIgnoreCase("simpleExpression"))
			exp1 = this.processaSimpleExpression(no);

		if (relationalExpression.getListaDeNos().size() >= 3) {
			
			no = relationalExpression.getListaDeNos().get(1);	
			if (no.getNome().equalsIgnoreCase("relationalOperator"))
				operador = this.processaRelationalOperator(no);
		
			no = relationalExpression.getListaDeNos().get(2);
			if (no.getNome().equalsIgnoreCase("simpleExpression"))
				exp2 = this.processaSimpleExpression(no);
			
			return CodigoIntermediario.add(operador, exp1, exp2);
		
		}
		
		return exp1;
		
	}
	
	private String processaBooleanOperator(ArvoreSintaticaAbstrataNo booleanOperator) {
		
		if (booleanOperator.getNome().equalsIgnoreCase("booleanOperator"))
			return booleanOperator.getListaDeNos().getFirst().getToken().getValue();
		
		return "";
	}
	
	@Override
	public String traduz(ArvoreSintaticaAbstrataNo expression) {

		int i = 0;
		ArvoreSintaticaAbstrataNo no;
		String exp1 = "";
		String exp2 = "";
		String operador = "";
		String ultimoTemporario = "";

		no = expression.getListaDeNos().get(i);
		if (no != null && no.getNome().equalsIgnoreCase("relationalExpression"))
			exp1 = this.processaRelationalExpression(no);
		
		do {
			i++;
			if (expression.getListaDeNos().size() <= i) break;
				
			no = expression.getListaDeNos().get(i);
			if (no != null && no.getNome().equalsIgnoreCase("booleanOperator"))
				operador = this.processaBooleanOperator(no);
			
			i++;
			if (expression.getListaDeNos().size() <= i) break;
			no = expression.getListaDeNos().get(i);
			if (no != null && no.getNome().equalsIgnoreCase("relationalExpression"))
				exp2 = this.processaRelationalExpression(no);			
			
			ultimoTemporario = CodigoIntermediario.add(operador, exp1, exp2);
			exp1 = ultimoTemporario;
			exp2 = "";
			operador = "";			
			
		} while ( i < expression.getListaDeNos().size());
		
		if (! ultimoTemporario.isEmpty())
			return ultimoTemporario;
		
		return exp1;
		
	}

}
