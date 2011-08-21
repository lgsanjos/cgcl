package analise.sintatica.producoes;

import coretypes.Token;
import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTupleType extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "[" <typeSymbol> { "," <typeSymbol> } "]"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("tupleType");
		boolean isValida = false;
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
				
			ArvoreSintaticaAbstrataNo typeSymbol1;
			typeSymbol1 = this.validaEGeraProducaoDadoProducao(ProducoesEnum.typeSymbol);
			if ( typeSymbol1 != null) {
				raiz.adicionaNoFilho(typeSymbol1);
				this.descartaIndiceSalvo();
				
				do {
					
					isValida = false;
					this.salvarIndiceTokenAtual();
					
					if (this.proximoTokenPossuiValorETipoIgualA(",", GCLTokenTypes.SYMBOL)) {
						Token tokenVirgula = this.getTokenAtual();
						
						ArvoreSintaticaAbstrataNo typeSymbol2;
						typeSymbol2 = this.validaEGeraProducaoDadoProducao(ProducoesEnum.typeSymbol);
						if ( typeSymbol2 != null) {
							raiz.adicionaNoFilho(tokenVirgula);
							raiz.adicionaNoFilho(typeSymbol2);
							this.descartaIndiceSalvo();
							isValida = true;
						}
					}
					
					if (! isValida) {
						this.recuperarIndiceSalvo();
					}
					
				} while (isValida);
				
				if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
					raiz.adicionaNoFilho(this.getTokenAtual());
					this.descartaIndiceSalvo();
					return raiz;
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		// TODO: throw exception
		return null;
	}

}
