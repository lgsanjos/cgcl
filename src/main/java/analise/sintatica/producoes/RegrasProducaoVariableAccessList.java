package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableAccessList extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// <variableAccess> {"," <variableAccess> }
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableAccessList");
		boolean isValida;

		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo variableAccess = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableAccess);
		
		if (variableAccess == null) {
			this.recuperarIndiceSalvo();
			this.throwProducaoSintaticaException("variableAccessList");
			return null;
		}
		
		
		raiz.adicionaNoFilho(variableAccess);
		this.descartaIndiceSalvo();
		
		do {
			isValida = false;
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorETipoIgualA(",", GCLTokenTypes.SYMBOL)) {
				Token tokenVirgula = this.getTokenAtual();
				
				ArvoreSintaticaAbstrataNo variableAccessMore = this.validaEGeraProducaoDadoProducao(ProducoesEnum.variableAccess);
				if (variableAccessMore != null) {
					raiz.adicionaNoFilho(tokenVirgula.getValue(), tokenVirgula);
					raiz.adicionaNoFilho(variableAccessMore);
					this.descartaIndiceSalvo();
					isValida = true;
				}
			}
			
			if (! isValida) {
				this.recuperarIndiceSalvo();
			}			
			
		} while (isValida);
			
		return raiz;
	}

}
