package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoModule extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo validaEGeraProducao() {
		boolean isValido = true;
		ArvoreSintaticaAbstrataNo raiz = null;

		if (isValido) {
			isValido &= this.proximoTokenPossuiValorIgualA("module");
			raiz = new ArvoreSintaticaAbstrataNo("module", this.getTokenAtual());	
		}
		
		if (isValido){
			isValido &= this.proximoTokenEhUmIdentificador();
			raiz.adicionaNoFilho("identificador", this.getTokenAtual() );
		}
		
		if (isValido){
			ProducoesFactory.salvaEstado();
			
			ArvoreSintaticaAbstrataNo defPart;
			defPart = ProducoesFactory.getProducao(ProducoesEnum.definitionPart).validaEGeraProducao();
			isValido &= ( defPart != null );
			// Particularidade do definitionPart
			if (defPart.possueNosFilhos()) {
				raiz.adicionaNoFilho(defPart);
			} else {
				ProducoesFactory.voltaEstado();				
			}
		}
		
		if (isValido) {
			if (this.proximoTokenPossuiValorIgualA("private")) {
				raiz.adicionaNoFilho("private", this.getTokenAtual());
			}else{
				this.voltaToken();
			}
		}
		
		if (isValido) {
			ArvoreSintaticaAbstrataNo block;
			block = ProducoesFactory.getProducao(ProducoesEnum.block).validaEGeraProducao();
			raiz.adicionaNoFilho(block);
		}
		
		if (isValido) {
			isValido &= this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.SYMBOL);
			raiz.adicionaNoFilho("simbolo", this.getTokenAtual());
		}

		raiz = (isValido) ? raiz : null;
		return raiz;
				
	}

}
