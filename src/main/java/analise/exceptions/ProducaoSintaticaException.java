package analise.exceptions;

public class ProducaoSintaticaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProducaoSintaticaException(String producao) {
		super ("Não foi possível validar a producao: " + producao);
	}
	public ProducaoSintaticaException(String producao, String linha, String coluna) {
		super ("Não foi possível validar a producao: " + producao +", linha " + linha + " coluna " +  coluna);
	}

}
