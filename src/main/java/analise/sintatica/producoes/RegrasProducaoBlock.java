package analise.sintatica.producoes;

import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBlock extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValido = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("block");

		if (isValido) {
			ArvoreSintaticaAbstrataNo defPart;
			defPart = ProducoesFactory.getProducao(ProducoesEnum.definitionPart).validaEGeraProducao();
			isValido = (defPart != null);
			if (defPart.possueNosFilhos()) {
				raiz.adicionaNoFilho(defPart);
			}	
		}
		
		if (isValido) {
			isValido &= this.proximoTokenPossuiValorIgualA("begin");
			raiz.adicionaNoFilho("begin", this.getTokenAtual());
		}

		if (isValido) {
			ArvoreSintaticaAbstrataNo statement;
			statement = ProducoesFactory.getProducao(ProducoesEnum.statementPart).validaEGeraProducao();
			raiz.adicionaNoFilho(statement);
		}
		
		if (isValido) {		
			isValido &= this.proximoTokenPossuiValorIgualA("end");
			raiz.adicionaNoFilho("end", this.getTokenAtual());
		}
	
		return (isValido) ? raiz : null;
	}

}
