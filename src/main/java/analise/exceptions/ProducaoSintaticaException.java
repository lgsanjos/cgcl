package analise.exceptions;

public class ProducaoSintaticaException extends ProducaoSintaticaLoggedException {
	
	private static final long serialVersionUID = 1L;

	public ProducaoSintaticaException(String producao) {
		super ("Nao foi possivel validar a producao: " + producao);
	}
	public ProducaoSintaticaException(String producao, String linha, String coluna) {
		super ("Nao foi possivel validar a producao: " + producao +", linha: " + linha + " coluna: " +  coluna);
	}
	
	public ProducaoSintaticaException(String producao, String linha, String coluna, String lexema) {
		super ("Nao foi possivel validar a producao: " + producao +", linha: " + linha + " coluna: " +  coluna + ", token: '" + lexema + "'");
	}	

}
