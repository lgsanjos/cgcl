package analise.sintatica.producoes;

import analise.sintatica.ProducoesDaLinguagem;

public class ProducoesListBuilder {
	
	public static ProducoesDaLinguagem producoesGCL(){
		ProducoesDaLinguagem lista = new ProducoesDaLinguagem();
		
		lista.add(new ProducaoIF());
		
		return lista;
	}

}
