package analise.sintatica.producoes;

import analise.sintatica.ProducaoDaLinguagem;
import analise.sintatica.ProducaoGramatical;

public class ProducaoIF extends ProducaoDaLinguagem {

	public ProducaoIF() {

		ProducaoGramatical producao = new ProducaoGramatical();
		producao.addSimbolo("IF");
		producao.addSimbolo("cond", false);
		producao.addSimbolo("THEN");
		producao.addSimbolo("exp", false);
		this.getListaProducoesAceitas().add (producao);
		
		producao = new ProducaoGramatical();
		producao.addSimbolo("IF");
		producao.addSimbolo("cond", false);
		producao.addSimbolo("THEN");
		producao.addSimbolo("exp", false);
		producao.addSimbolo("ELSE");
		producao.addSimbolo("exp", false);
		this.getListaProducoesAceitas().add(producao);

	}

}
