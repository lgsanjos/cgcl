package analise.sintatica.producoes;

import java.util.HashMap;
import coretypes.TokenList;

public class ProducoesFactory {

	private static ProducoesFactory instancia = new ProducoesFactory();
	private HashMap<ProducoesEnum, RegrasProducaoAbstract> listaDeProducoes;
	
	private TokenList pilhaDeToken;
	
	private TokenList pilhaDeTokenSalvo;
	private boolean estadoSalvo;
		
	private ProducoesFactory() {
		
		listaDeProducoes = new HashMap<ProducoesEnum, RegrasProducaoAbstract>();
		
		listaDeProducoes.put(ProducoesEnum.block, new RegrasProducaoBlock());
		listaDeProducoes.put(ProducoesEnum.booleanOperator, new RegrasProducaoBooleanOperator());
		listaDeProducoes.put(ProducoesEnum.constant, new RegrasProducaoConstant());
		listaDeProducoes.put(ProducoesEnum.constantDef, new RegrasProducaoConstantDef());
		listaDeProducoes.put(ProducoesEnum.constantName, new RegrasProducaoConstantName());
		listaDeProducoes.put(ProducoesEnum.definition, new RegrasProducaoDefinition());
		listaDeProducoes.put(ProducoesEnum.definitionPart, new RegrasProducaoDefinitionPart());
		listaDeProducoes.put(ProducoesEnum.expression, new RegrasProducaoExpression());
		listaDeProducoes.put(ProducoesEnum.module, new RegrasProducaoModule());
		listaDeProducoes.put(ProducoesEnum.procedureDecl, new RegrasProducaoProcedureDecl());
		listaDeProducoes.put(ProducoesEnum.procedureDef, new RegrasProducaoProcedureDef());
		listaDeProducoes.put(ProducoesEnum.relationalExpression, new RegrasProducaoRelationalExpression());
		listaDeProducoes.put(ProducoesEnum.typedef, new RegrasProducaoTypedef());
		listaDeProducoes.put(ProducoesEnum.variableDef, new RegrasProducaoVariableDef());
		listaDeProducoes.put(ProducoesEnum.statementPart, new RegrasProducaoStatementPart());
		listaDeProducoes.put(ProducoesEnum.statement, new RegrasProducaoStatement());
		listaDeProducoes.put(ProducoesEnum.booleanConstant, new RegrasProducaoBooleanConstant());
		listaDeProducoes.put(ProducoesEnum.nextitem, new RegrasProducaoNextItem());
		listaDeProducoes.put(ProducoesEnum.multiplyOperator, new RegrasProducaoMultiplyOperator());
		listaDeProducoes.put(ProducoesEnum.addingOperator, new RegrasProducaoAddingOperator());
		listaDeProducoes.put(ProducoesEnum.emptyStatement, new RegrasProducaoEmptyStatement());
		listaDeProducoes.put(ProducoesEnum.relationalOperator, new RegrasProducaoRelationalOperator());
		listaDeProducoes.put(ProducoesEnum.typeSymbol, new RegrasProducaoTypeSymbol());
		listaDeProducoes.put(ProducoesEnum.indexorcomp, new RegrasProducaoIndexOrComp());
		listaDeProducoes.put(ProducoesEnum.variableMore, new RegrasProducaoVariableMore());
		listaDeProducoes.put(ProducoesEnum.variableAccess, new RegrasProducaoVariableAccess());
		listaDeProducoes.put(ProducoesEnum.factor, new RegrasProducaoFactor());
		
		
		
	}
	
	public static RegrasProducaoAbstract getProducao(ProducoesEnum nomeDaProducao) {
		RegrasProducaoAbstract producao;
		producao = instancia.listaDeProducoes.get(nomeDaProducao);
		if (! instancia.listaDeProducoes.containsKey(nomeDaProducao)) {
			throw new RuntimeException("Não foi localizado '" + nomeDaProducao.toString() + "' na fabrica ProducaoFactory.");
		}
		if (instancia.pilhaDeToken != null) {
			producao.setPilhaDeToken(instancia.pilhaDeToken);
		}
		producao.descartaIndiceSalvo();
		return producao; 
	}
	
	public static void setEstado(TokenList pilhaDeToken){
		instancia.pilhaDeToken = pilhaDeToken;
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
