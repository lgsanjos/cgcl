package analise.sintatica.producoes;

import analise.exceptions.ProducaoSintaticaException;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoBlock extends RegrasProducaoAbstract {
	
	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() throws ProducaoSintaticaException {
		boolean isValido = true;
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("block");

		if (isValido) {
			ProducoesFactory.salvaEstado();
			
			ArvoreSintaticaAbstrataNo defPart;
			defPart = ProducoesFactory.getProducao(ProducoesEnum.definitionPart).validaEGeraProducao();
			isValido = (defPart != null);
			if (defPart.possueNosFilhos()) {
				raiz.adicionaNoFilho(defPart);
			} else {
				ProducoesFactory.voltaEstado();
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
