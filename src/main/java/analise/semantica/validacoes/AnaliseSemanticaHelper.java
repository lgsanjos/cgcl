package analise.semantica.validacoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class AnaliseSemanticaHelper {
	
	private AnaliseSemanticaHelper() {
	}
	
	public static String procuraTipagemApatirDeUmType(ArvoreSintaticaAbstrataNo noType) {
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
