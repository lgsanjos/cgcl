package analise.sintatica.producoes;

import coretypes.gcl.GCLTokenTypes;
import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoProcedureDecl extends RegrasProducaoAbstract {

	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		// "proc" "identifier" [<paramPart>]
	
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("procedureDecl");

		this.salvarIndiceTokenAtual();
		if (this.proximoTokenPossuiValorETipoIgualA("proc",	GCLTokenTypes.KEYWORD)) {
			raiz.adicionaNoFilho(this.getTokenAtual());
			
			if (this.proximoTokenEhUmIdentificador()) {
				raiz.adicionaNoFilho(this.getTokenAtual());
				this.descartaIndiceSalvo();
				
				try {
					this.salvarIndiceTokenAtual();
					ArvoreSintaticaAbstrataNo paramPart = this.validaEGeraProducaoDadoProducao(ProducoesEnum.paramPart);
					raiz.adicionaNoFilho(paramPart);
					this.descartaIndiceSalvo();
					return raiz;
				} catch (ProducaoSintaticaException e) {
					this.recuperarIndiceSalvo();
				}
				return raiz;				
			}
		}
		
		this.recuperarIndiceSalvo();
		this.throwProducaoSintaticaException("procedureDecl");
		return null;
	}

}
