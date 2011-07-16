package analise.sintatica.producoes;

import java.util.HashMap;
import coretypes.IndiceNumerico;
import coretypes.TokenList;

public class ProducoesFactory {

	private static ProducoesFactory instancia = new ProducoesFactory();
	private HashMap<ProducoesEnum, RegrasProducaoAbstract> listaDeProducoes;
	
	private TokenList pilhaDeToken;
	private IndiceNumerico indice;
		
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
		listaDeProducoes.put(ProducoesEnum.procedureDecl, new RegrasProducaoConstant());
		listaDeProducoes.put(ProducoesEnum.procedureDef, new RegrasProducaoConstant());
		listaDeProducoes.put(ProducoesEnum.relationalExpression, new RegrasProducaoConstant());
		listaDeProducoes.put(ProducoesEnum.typedef, new RegrasProducaoConstant());
		listaDeProducoes.put(ProducoesEnum.variableDef, new RegrasProducaoConstant());
		
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
	
	public static void limpaEstado(){
		instancia.indice = null;
		instancia.pilhaDeToken = null;		
	}
	
}
