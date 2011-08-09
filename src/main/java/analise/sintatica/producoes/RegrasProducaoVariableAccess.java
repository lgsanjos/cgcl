package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoVariableAccess extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValida = true;
		this.salvarIndiceTokenAtual();
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("variableAccess");
		
		if (isValida) {
			isValida = false;
			
			if (this.proximoTokenEhUmIdentificador()) {
				
				raiz.adicionaNoFilho("identificador", this.getTokenAtual());
				ArvoreSintaticaAbstrataNo variableMore;
				variableMore = ProducoesFactory.getProducao(ProducoesEnum.variableMore).validaEGeraProducao();
				raiz.adicionaNoFilho(variableMore);
				
				if ( variableMore != null) {
					isValida = true;
				} else {
					this.recuperarIndiceSalvo();
				}
			}
		}
		
		return (isValida) ? raiz : null;
	}

}
