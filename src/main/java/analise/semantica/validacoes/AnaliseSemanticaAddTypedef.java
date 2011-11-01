package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class AnaliseSemanticaAddTypedef extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException{
		
		//"typedef" <type> "identifier" 
		if (no.getNome().equalsIgnoreCase("typedef")){
			
		}
		
	}
	
}
