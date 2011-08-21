package analise.sintatica.producoes;

import java.util.HashMap;

import coretypes.TokenList;

public class ProducoesFactory {

	private static ProducoesFactory instancia = new ProducoesFactory();
	private HashMap<ProducoesEnum, String> listaDeProducoes;
	
	private TokenList pilhaDeToken;
	
	private TokenList pilhaDeTokenSalvo;
	private boolean estadoSalvo;
		
	private ProducoesFactory() {
		
		listaDeProducoes = new HashMap<ProducoesEnum, String>();
		
		listaDeProducoes.put(ProducoesEnum.block, "analise.sintatica.producoes.RegrasProducaoBlock");
		listaDeProducoes.put(ProducoesEnum.booleanOperator, "analise.sintatica.producoes.RegrasProducaoBooleanOperator");
		listaDeProducoes.put(ProducoesEnum.constant, "analise.sintatica.producoes.RegrasProducaoConstant");
		listaDeProducoes.put(ProducoesEnum.constantDef, "analise.sintatica.producoes.RegrasProducaoConstantDef");
		listaDeProducoes.put(ProducoesEnum.constantName, "analise.sintatica.producoes.RegrasProducaoConstantName");
		listaDeProducoes.put(ProducoesEnum.definition, "analise.sintatica.producoes.RegrasProducaoDefinition");
		listaDeProducoes.put(ProducoesEnum.definitionPart, "analise.sintatica.producoes.RegrasProducaoDefinitionPart");
		listaDeProducoes.put(ProducoesEnum.expression, "analise.sintatica.producoes.RegrasProducaoExpression");
		listaDeProducoes.put(ProducoesEnum.module, "analise.sintatica.producoes.RegrasProducaoModule");
		listaDeProducoes.put(ProducoesEnum.procedureDecl, "analise.sintatica.producoes.RegrasProducaoProcedureDecl");
		listaDeProducoes.put(ProducoesEnum.procedureDef, "analise.sintatica.producoes.RegrasProducaoProcedureDef");
		listaDeProducoes.put(ProducoesEnum.relationalExpression, "analise.sintatica.producoes.RegrasProducaoRelationalExpression");
		listaDeProducoes.put(ProducoesEnum.typedef, "analise.sintatica.producoes.RegrasProducaoTypedef");
		listaDeProducoes.put(ProducoesEnum.variableDef, "analise.sintatica.producoes.RegrasProducaoVariableDef");
		listaDeProducoes.put(ProducoesEnum.statement, "analise.sintatica.producoes.RegrasProducaoStatement");
		listaDeProducoes.put(ProducoesEnum.booleanConstant, "analise.sintatica.producoes.RegrasProducaoBooleanConstant");
		listaDeProducoes.put(ProducoesEnum.nextitem, "analise.sintatica.producoes.RegrasProducaoNextItem");
		listaDeProducoes.put(ProducoesEnum.multiplyOperator, "analise.sintatica.producoes.RegrasProducaoMultiplyOperator");
		listaDeProducoes.put(ProducoesEnum.addingOperator, "analise.sintatica.producoes.RegrasProducaoAddingOperator");
		listaDeProducoes.put(ProducoesEnum.emptyStatement, "analise.sintatica.producoes.RegrasProducaoEmptyStatement");
		listaDeProducoes.put(ProducoesEnum.relationalOperator, "analise.sintatica.producoes.RegrasProducaoRelationalOperator");
		listaDeProducoes.put(ProducoesEnum.relationalExpression, "analise.sintatica.producoes.RegrasProducaoRelationalExpression");
		listaDeProducoes.put(ProducoesEnum.typeSymbol, "analise.sintatica.producoes.RegrasProducaoTypeSymbol");
		listaDeProducoes.put(ProducoesEnum.indexorcomp, "analise.sintatica.producoes.RegrasProducaoIndexOrComp");
		listaDeProducoes.put(ProducoesEnum.variableMore, "analise.sintatica.producoes.RegrasProducaoVariableMore");
		listaDeProducoes.put(ProducoesEnum.variableAccess, "analise.sintatica.producoes.RegrasProducaoVariableAccess");
		listaDeProducoes.put(ProducoesEnum.factor, "analise.sintatica.producoes.RegrasProducaoFactor");
		listaDeProducoes.put(ProducoesEnum.expressionList, "analise.sintatica.producoes.RegrasProducaoExpressionList");
		listaDeProducoes.put(ProducoesEnum.term, "analise.sintatica.producoes.RegrasProducaoTerm");
		listaDeProducoes.put(ProducoesEnum.simpleExpression, "analise.sintatica.producoes.RegrasProducaoSimpleExpression");
		listaDeProducoes.put(ProducoesEnum.argumentList, "analise.sintatica.producoes.RegrasProducaoArgumentList");
		listaDeProducoes.put(ProducoesEnum.callStatement, "analise.sintatica.producoes.RegrasProducaoCallStatement");
		listaDeProducoes.put(ProducoesEnum.returnStatement, "analise.sintatica.producoes.RegrasProducaoReturnStatement");
		listaDeProducoes.put(ProducoesEnum.emptyStatement, "analise.sintatica.producoes.RegrasProducaoEmptyStatement");
		listaDeProducoes.put(ProducoesEnum.variableAccessList, "analise.sintatica.producoes.RegrasProducaoVariableAccessList");
		listaDeProducoes.put(ProducoesEnum.readStatement, "analise.sintatica.producoes.RegrasProducaoReadStatement");
		listaDeProducoes.put(ProducoesEnum.writeItem, "analise.sintatica.producoes.RegrasProducaoWriteItem");
		listaDeProducoes.put(ProducoesEnum.writeStatement, "analise.sintatica.producoes.RegrasProducaoWriteStatement");
		listaDeProducoes.put(ProducoesEnum.assignStatement, "analise.sintatica.producoes.RegrasProducaoAssignStatement");
		listaDeProducoes.put(ProducoesEnum.guardedCommand, "analise.sintatica.producoes.RegrasProducaoGuardedCommand");
		listaDeProducoes.put(ProducoesEnum.guardedCommandList, "analise.sintatica.producoes.RegrasProducaoGuardedCommandList");
		listaDeProducoes.put(ProducoesEnum.statementPart, "analise.sintatica.producoes.RegrasProducaoStatementPart");
		listaDeProducoes.put(ProducoesEnum.ifStatement, "analise.sintatica.producoes.RegrasProducaoIfStatement");
		listaDeProducoes.put(ProducoesEnum.doStatement, "analise.sintatica.producoes.RegrasProducaoDoStatement");
		listaDeProducoes.put(ProducoesEnum.forStatement, "analise.sintatica.producoes.RegrasProducaoForStatement");
		listaDeProducoes.put(ProducoesEnum.variableList, "analise.sintatica.producoes.RegrasProducaoVariableList");
		
		
	}
	
	public static RegrasProducaoAbstract getProducao(ProducoesEnum nomeDaProducao) {
		RegrasProducaoAbstract producao;
		String nomeClasseProducao;
		Class<?> classeProducao;
		
		try {
			
			if (! instancia.listaDeProducoes.containsKey(nomeDaProducao)) {
				throw new RuntimeException("Não foi localizado '" + nomeDaProducao.toString() + "' na fabrica ProducaoFactory.");
			}

			nomeClasseProducao = instancia.listaDeProducoes.get(nomeDaProducao).toString();
			classeProducao = Class.forName(nomeClasseProducao);
			producao = (RegrasProducaoAbstract) classeProducao.newInstance();

			if (instancia.pilhaDeToken != null) {
				producao.setPilhaDeToken(instancia.pilhaDeToken);
			}
			
			return producao;
						
		} catch (Exception e) {
			return null;
		}	
		
	}
	
	public static void setEstado(TokenList pilhaDeToken){
		instancia.pilhaDeToken = pilhaDeToken;
	}
	
	public static TokenList getEstado() {
		return instancia.pilhaDeToken;
	}
	
	public static void salvaEstado() {
		if (instancia.estadoSalvo) {
			throw new RuntimeException("O estado da RegrasProducao já está salvo.");
		}
		
		instancia.pilhaDeTokenSalvo = instancia.pilhaDeToken.clone();
	}
	
	public static void voltaEstado() {
		instancia.estadoSalvo = false;
		instancia.pilhaDeToken = instancia.pilhaDeTokenSalvo;
	}
	
	public static void limpaEstado(){
		instancia.pilhaDeToken = null;
		instancia.estadoSalvo = false;
	}
	
}
