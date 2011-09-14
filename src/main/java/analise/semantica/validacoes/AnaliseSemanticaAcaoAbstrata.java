package analise.semantica.validacoes;

import analise.exceptions.AnaliseSemanticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public abstract class AnaliseSemanticaAcaoAbstrata {
	
	public abstract void executa(ArvoreSintaticaAbstrataNo no) throws AnaliseSemanticaException;

}
