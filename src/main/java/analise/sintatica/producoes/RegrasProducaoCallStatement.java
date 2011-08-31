package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoCallStatement extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "identifier" ["." "identifier"] <argumentList> 
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("callStatement");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenEhUmIdentificador()) {
			
			raiz.adicionaNoFilho("identificador", this.getTokenAtual());
			this.descartaIndiceSalvo();
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL)) {
				Token tokenPonto = this.getTokenAtual();
				if (this.proximoTokenEhUmIdentificador()) {
					raiz.adicionaNoFilho(tokenPonto.getValue(), tokenPonto);
					raiz.adicionaNoFilho("identificador", this.getTokenAtual());
					this.descartaIndiceSalvo();
				} else {
					this.recuperarIndiceSalvo();
					this.throwProducaoSintaticaException("callStatement");
					return null;
				}
			} else {
				this.recuperarIndiceSalvo();
			}
			
			this.salvarIndiceTokenAtual();
			ArvoreSintaticaAbstrataNo argumentList;
			argumentList = this.validaEGeraProducaoDadoProducao(ProducoesEnum.argumentList);
			if (argumentList != null) {
				raiz.adicionaNoFilho(argumentList);
				this.descartaIndiceSalvo();
				return raiz;
			}			
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("callStatement");
		return null;
	}

}
