package analise.sintatica.producoes;

import analise.sintatica.ProducaoGenerica;

public class ProducaoIF extends ProducaoGenerica {

	public ProducaoIF() {

		this.getListaProducoesAceitas().add("IF |cond| THEN |exp|");
		this.getListaProducoesAceitas().add("IF ( |cond| ) THEN |exp|");

		this.getListaProducoesAceitas().add("IF |cond| THEN |exp| ELSE |exp|");
		this.getListaProducoesAceitas().add("IF ( |cond| ) THEN |exp| ELSE |exp|");
	}

}
