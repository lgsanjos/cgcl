package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;

public class AnaliseSemanticaControlaEscopo extends
		AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {

		// procedureDef
		if (no.getNome().equalsIgnoreCase("block")) {
			TabelaDeSimbolos.getInstance().addMarcadorDeEscopo();
		}
		
		if (no.getNome().equalsIgnoreCase("end")) {
			TabelaDeSimbolos.getInstance().removeTodosAteUltimoMarcadorDeEscopo();
		}		
		
	}

}
