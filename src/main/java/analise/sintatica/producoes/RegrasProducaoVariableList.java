package analise.sintatica.producoes;

import coretypes.Token;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableList extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "identifier" {"," "identifier"}
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableList");
		boolean isValida;
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenEhUmIdentificador()) {
			raiz.adicionaNoFilho("identificador", getTokenAtual());
			this.descartaIndiceSalvo();
		} else {
			this.recuperarIndiceSalvo();
			// TODO: throw exception
			return null;
		}
		
		
		do {
			isValida = false;
			this.salvarIndiceTokenAtual();
			
			if (this.proximoTokenPossuiValorIgualA(",")) {
				Token tokenVirgula = this.getTokenAtual();
				
				if (this.proximoTokenEhUmIdentificador()) {
					raiz.adicionaNoFilho(tokenVirgula);
					raiz.adicionaNoFilho("identificador", getTokenAtual());
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
