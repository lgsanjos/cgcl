package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoTypeDef extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "typedef" <type> "identifier"
		
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("typeDef");
		
		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("typedef", GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			
			ArvoreSintaticaAbstrataNo type = this.validaEGeraProducaoDadoProducao(ProducoesEnum.type);
			if (type != null) {
				raiz.adicionaNoFilho(type);
				
				if (this.proximoTokenEhUmIdentificador()) {
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
