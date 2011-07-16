package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		/* <emptyStatement> | <readStatement> | <writeStatement> 
		 | <assignStatement> | <returnStatement> | <callStatement>
		 | <ifStatement> | <doStatement> | <forStatement>
		 */
		return null;
	}

}
