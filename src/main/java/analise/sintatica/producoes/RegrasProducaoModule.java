package analise.sintatica.producoes;

import utils.GCLTokenTypes;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class RegrasProducaoModule extends RegrasProducaoAbstract {

	@Override
	public ArvoreSintaticaAbstrataNo geraArvoreSintaticaAbstrata() {
		ArvoreSintaticaAbstrataNo raiz = new ArvoreSintaticaAbstrataNo("module", null);
		
		return raiz;
	}

	@Override
	public boolean isValida() {
		boolean isValido = true;

		if (isValido) isValido &= this.proximoTokenPossuiValorIgualA("module");
		if (isValido) isValido &= this.proximoTokenEhUmIdentificador();
		if (isValido) isValido &= ProducoesFactory.getProducao(ProducoesEnum.definitionPart).isValida();
		if (isValido && !this.proximoTokenPossuiValorIgualA("private")) {
			this.getIndice().dec();
		}
		if (isValido) ProducoesFactory.getProducao(ProducoesEnum.block).isValida();
		if (isValido) isValido &= this.proximoTokenPossuiValorETipoIgualA(".", GCLTokenTypes.Symbol);

		return isValido;
	}

}
