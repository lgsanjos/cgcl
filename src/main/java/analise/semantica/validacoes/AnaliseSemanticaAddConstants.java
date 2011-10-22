package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import analise.tabelaDeSimbolos.TabelaDeSimbolos;

public class AnaliseSemanticaAddConstants extends AnaliseSemanticaAcaoAbstrata {

	@Override
	public void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException {
		
		// TODO: Avaliar se é necessario o valor da constante, parece ser inviavel
		
		if (no.getNoPai() != null && no.getNoPai().getNome().equalsIgnoreCase("constantName")) {
			TabelaDeSimbolos.getInstance().addVariavel(no.getToken().getValue(), "valor da const");
		}		
		
	}

}
