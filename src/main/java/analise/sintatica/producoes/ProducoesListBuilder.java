package analise.sintatica.producoes;

public class ProducoesListBuilder {
	
	public static DicionarioDeRegrasProducao producoesGCL(){
		DicionarioDeRegrasProducao lista = new DicionarioDeRegrasProducao();

		lista.put("program", RegrasProducaoProgram.getInstancia() );
		
		return lista;
	}

}
