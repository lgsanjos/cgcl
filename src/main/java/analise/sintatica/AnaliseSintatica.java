package analise.sintatica;

import analise.sintatica.producoes.ProducoesListBuilder;
import coretypes.Token;
import coretypes.TokenList;

public class AnaliseSintatica {
	
	private TokenList pilhaDeTokens;
	private ProducoesDaLinguagem listaDeProducoes;
	
	private void limpaPilhaDeTokens(){
		this.pilhaDeTokens.clear();
	}
	
	private boolean isParcialmenteValidoParaAlgumaProducao(){
		int i = 0;
		boolean validou = false;
		ProducaoDaLinguagem producao;
		
		while ( (i < this.listaDeProducoes.size()) && ( !validou ) ){
			producao = this.listaDeProducoes.get(i);
			validou = producao.validaParcialmente(this.pilhaDeTokens);
			i++;
		}

		return validou;
	}
	
	private ProducoesDaLinguagem getProducaoValidas(){
		ProducoesDaLinguagem lista = new ProducoesDaLinguagem();
		ProducaoDaLinguagem producao;
		
		for (int i = 0; i < this.listaDeProducoes.size(); i++){
			producao = this.listaDeProducoes.get(i);
			if ( producao.validaTotalmente(this.pilhaDeTokens) ){
				lista.add(producao);
			}
		}

		return lista;
	}

	private ProducaoDaLinguagem getUnicaProducaoValida(){
		ProducaoDaLinguagem producao = null; 
		ProducoesDaLinguagem lista;

		lista = this.getProducaoValidas();	
		if (lista.size() == 1){
			producao = lista.getFirst();
		}

		return producao;
	}

	public AnaliseSintatica(){
		this.pilhaDeTokens = new TokenList();
		this.limpaPilhaDeTokens();

		this.listaDeProducoes = ProducoesListBuilder.producoesGCL();
	}

	public Token desempilhaToken(){
		return this.pilhaDeTokens.removeLast();
	}

	public int empilhaToken(Token token){
		this.pilhaDeTokens.addLast(token);
		return this.pilhaDeTokens.size();
	}

	public boolean isPilhaParcialmenteValida(){
		if ( this.pilhaDeTokens.isEmpty() ){
			return true;
		}

		return isParcialmenteValidoParaAlgumaProducao();
	}
	
	public boolean isPilhaValida(){
		if ( this.pilhaDeTokens.isEmpty() ){
			return true;
		}
		
		return (this.getUnicaProducaoValida() != null);
	}	

}
