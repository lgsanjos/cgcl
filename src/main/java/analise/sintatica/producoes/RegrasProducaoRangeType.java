package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoRangeType extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "range" "[" <constant> ".." <constant>  "]"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("rangeType");
		
		this.salvarIndiceTokenAtual();
		
		if (this.proximoTokenPossuiValorETipoIgualA("range", GCLTokenTypes.KEYWORD )) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			
			if (this.proximoTokenPossuiValorETipoIgualA("[", GCLTokenTypes.SYMBOL)) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				
				ArvoreSintaticaAbstrataNo constant;
				constant = this.validaEGeraProducaoDadoProducao(ProducoesEnum.constant);
				
				if (constant != null) {
					raiz.adicionaNoFilho(constant);
					
					if (this.proximoTokenPossuiValorETipoIgualA("..", GCLTokenTypes.SYMBOL)) {
						raiz.adicionaNoFilho(this.getTokenAtual());
						
						ArvoreSintaticaAbstrataNo constant2;
						constant2 = this.validaEGeraProducaoDadoProducao(ProducoesEnum.constant);
						
						if (constant2 != null) {
							raiz.adicionaNoFilho(constant2);
							
							if (this.proximoTokenPossuiValorETipoIgualA("]", GCLTokenTypes.SYMBOL)) {
								raiz.adicionaNoFilho(this.getTokenAtual());
								this.descartaIndiceSalvo();
								return raiz;
								
							}
						}
					}
				}
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("rangeType");
		return null;
	}

}
