package coretypes;

import java.util.LinkedList;
import utils.GCLTokenTypes;

public class TokenList extends LinkedList<Token>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GCLTokenTypes tokenType;

	
	public GCLTokenTypes getTokenType() {
		return tokenType;
	}

	public void setTokenType(GCLTokenTypes tokenType) {
		this.tokenType = tokenType;
	}
	
	
	
	
	public TokenList(){
	   super();	
	}
    

	public boolean hasLexema(String lexema){
		Token buscarToken = new Token();
		buscarToken.setValue(lexema);
		buscarToken.setPosicao("");
		buscarToken.setTokenType(this.tokenType);
		
		boolean achou = false;
		int i = 0;
		while (! achou && i < this.size()){
			achou = ((Token) this.get(i)).getValue().equals(buscarToken.getValue()); 
		   i = i + 1;
		}
		
		return achou;				
	}
	

	
	
	
}
