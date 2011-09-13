package analise.exceptions;

import coretypes.StringList;

public class ProducaoSintaticaLoggedException extends Exception {

	private static final long serialVersionUID = 1L;
	private static StringList log = new StringList();
	
	public ProducaoSintaticaLoggedException(String message) {
		super(message);
		ProducaoSintaticaLoggedException.log.add(message); 
	}
	
	public static String getLastException() {
		return ProducaoSintaticaLoggedException.log.getLast();
	}
	
	public static StringList getAllExceptions() {
		return ProducaoSintaticaLoggedException.log;
	}	

}