package analise.sintatica;

import coretypes.TokenList;

public class ProducaoDaLinguagem {
	
	private ProducoesGramaticais producoesAceitas;
	
	protected ProducoesGramaticais getListaProducoesAceitas(){
		return this.producoesAceitas;
	}
	
	public ProducaoDaLinguagem(){
		this.producoesAceitas = new ProducoesGramaticais();
	}

	public boolean validaParcialmente(TokenList listaDeToken){
		boolean encontrouProducao = false;
		boolean lexemasValidos = true;
		int i = 0;
		int j = 0;


		while ( (! encontrouProducao) && (j < this.producoesAceitas.size()) ){

			i = 0;
			while ( (lexemasValidos) && (i < this.producoesAceitas.get(j).size() && (i < listaDeToken.size())) ){
				lexemasValidos = this.producoesAceitas.get(j).getIndex(i).getLexema() == listaDeToken.get(i).getValue();
				i++;
			}
			
			if ( i == this.producoesAceitas.get(j).size() ){
				encontrouProducao = true;
			}
			j++;
		}
				
		return encontrouProducao;
	}
	
	public boolean validaTotalmente(TokenList listaDeToken){
		// TODO: Navegar na listade producoes e comparar com tokens de entrada
		return true;
	}

}
