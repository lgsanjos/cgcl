package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoForStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "forall" <variableAccess> "->" <statementPart> "llarof"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("forStatement");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("forall", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
			
			ArvoreSintaticaAbstrataNo variableAccess;
			variableAccess = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableAccess);
			if (variableAccess != null) {
				raiz.adicionaNoFilho(variableAccess);
				
				if (this.proximoTokenPossuiValorETipoIgualA("->", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
					
					ArvoreSintaticaAbstrataNo statementPart;
					statementPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.statementPart);
					if (statementPart != null) {
						raiz.adicionaNoFilho(statementPart);
						
						if (this.proximoTokenPossuiValorETipoIgualA("llarof", GCLTokenTypes.KEYWORD)) {
							raiz.adicionaNoFilho(this.getTokenAtual().getValue(), this.getTokenAtual());
							this.descartaIndiceSalvo();
							return raiz;
						}						
					}
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
