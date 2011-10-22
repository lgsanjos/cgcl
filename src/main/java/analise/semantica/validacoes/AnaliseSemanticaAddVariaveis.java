package analise.semantica.validacoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;

public class AnaliseSemanticaAddVariaveis extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		if (no.getNome().equalsIgnoreCase("variableDef")) {
			String tipagem = "";			
			String nome = "";
		
			for (ArvoreSintaticaAbstrataNo filho : no.getListaDeNos()) {			

				if (filho.getNome().equalsIgnoreCase("type"));
					tipagem = getTipagem(filho);
					
				this.procuraEAdicionaVariaveis(filho, tipagem);
			}
			
			TabelaDeSimbolos.getInstance().addVariavel(nome, tipagem);			
		}	
	}
	
	private void procuraEAdicionaVariaveis(ArvoreSintaticaAbstrataNo variableListNo, String tipo) {

		if (variableListNo.getNome().equalsIgnoreCase("variableList")) {
			for (ArvoreSintaticaAbstrataNo no : variableListNo.getListaDeNos()) {
				if (no.getToken().getTokenType() == GCLTokenTypes.IDENTIFIER)
					TabelaDeSimbolos.getInstance().addVariavel(no.getToken().getValue(), tipo);
			}
		}		
	}
	
	private String getTipagem(ArvoreSintaticaAbstrataNo noType) {
		
		ArvoreSintaticaAbstrataNo primeiroNoFilho = noType.getListaDeNos().getFirst();
		
		// caso 1: <typeSymbol> [ <arraytype> | <rangetype> ] 
		if (primeiroNoFilho.getNome().equalsIgnoreCase("typeSymbol")) {
			return primeiroNoFilho.getListaDeNos().getFirst().getToken().getValue();
		}
		
		String retorno = "";
		
		// caso 2: <tupletype> -> "[" <typeSymbol> { "," <typeSymbol> } "]"
		if (primeiroNoFilho.getNome().equalsIgnoreCase("tupleType")) {
			for (ArvoreSintaticaAbstrataNo tuplas : primeiroNoFilho.getListaDeNos()) {

				if (tuplas.getNome().equalsIgnoreCase("typeSymbol")) {
					retorno += tuplas.getListaDeNos().getFirst().getToken().getValue() + ",";
				}
			}
		}
		
		return retorno;
	}

}
