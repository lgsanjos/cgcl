package analise.exceptions;

import java.util.LinkedList;

public class ProducaoSintaticaLoggedException extends Exception {

	private static final long serialVersionUID = 1L;
	private static LinkedList<String> log = new LinkedList<String>();
	
	public ProducaoSintaticaLoggedException(String message) {
		super(message);
		System.out.println(message);
		ProducaoSintaticaLoggedException.log.add(message); 
	}
	
	public static String getLastException() {
		return ProducaoSintaticaLoggedException.log.getLast();
	}
	
	public static LinkedList<String> getAllExceptions() {
		return ProducaoSintaticaLoggedException.log;
	}	

}