package analise.sintatica.producoes;

import java.util.HashMap;
import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class ProducoesFactory {

	private static ProducoesFactory instancia = new ProducoesFactory();
	private HashMap<ProducoesEnum, RegrasProducaoAbstract> listaDeProducoes;
	
	private TokenList pilhaDeToken;
	private IndiceNumerico indice;
	
	private TokenList pilhaDeTokenSalvo;
	private IndiceNumerico indiceSalvo;	
		
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
		
	}
	
	public static RegrasProducaoAbstract getProducao(ProducoesEnum nomeDaProducao) {
		RegrasProducaoAbstract producao;
		producao = instancia.listaDeProducoes.get(nomeDaProducao);
		if (! instancia.listaDeProducoes.containsKey(nomeDaProducao)) {
			throw new RuntimeException("Não foi localizado '" + nomeDaProducao.toString() + "' na fabrica ProducaoFactory.");
		}
		if (instancia.pilhaDeToken != null && instancia.indice != null) {
			producao.setPilhaDeToken(instancia.pilhaDeToken);
			producao.setIndice(instancia.indice);
		}
		return producao; 
	}
	
	public static void setEstado(TokenList pilhaDeToken, IndiceNumerico indice){
		instancia.indice = indice;
		instancia.pilhaDeToken = pilhaDeToken;
	}
	
	public static void salvaEstado() {
		instancia.indiceSalvo = (IndiceNumerico)instancia.indice.clone();
		instancia.pilhaDeTokenSalvo = new TokenList();
		
		for (int i = 0; i < instancia.pilhaDeToken.size(); i++) {
			instancia.pilhaDeTokenSalvo.add(instancia.pilhaDeToken.get(i));
		}
	}
	
	public static void voltaEstado() {
		instancia.indice = instancia.indiceSalvo;
		instancia.pilhaDeToken = instancia.pilhaDeTokenSalvo;
	}
	
	public static void limpaEstado(){
		instancia.indice = null;
		instancia.pilhaDeToken = null;		
	}
	
}
