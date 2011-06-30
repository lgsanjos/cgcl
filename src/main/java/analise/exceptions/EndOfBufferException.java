package analise.exceptions;

public class EndOfBufferException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EndOfBufferException(String message){
		super(message);
	}

}
