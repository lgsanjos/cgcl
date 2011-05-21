package analise.sintatica.producoes;

import analise.sintatica.ProducoesList;

public class ProducoesListBuilder {
	
	public static ProducoesList producoesGCL(){
		ProducoesList lista = new ProducoesList();
		
		lista.add(new ProducaoIF());
		
		return lista;
	}

}
