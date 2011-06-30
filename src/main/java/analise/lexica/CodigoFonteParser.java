package analise.lexica;

import analise.exceptions.EndOfBufferException;

public class CodigoFonteParser {
	
	private String codigoFonte;
	private int contador = -1;
	
	public CodigoFonteParser(String CodigoFonteFilepath){
		this.codigoFonte = this.preProcessaFonte(CodigoFonteFilepath);
		this.contador = -1;
	}
	
	
	private String preProcessaFonte(String codigoFonte){
		return codigoFonte;
	}
	
	public String getLastPosicao(){
		return new StringBuilder(this.contador).toString();
	}
	
	public char getNextChar() throws Exception{
	    Character res = new Character(' ');
		do{
  		  this.contador++;			

  		  if (this.contador >= this.codigoFonte.length())
		     throw new EndOfBufferException("Fim do arquivo");
		       
		  res = this.codigoFonte.charAt(this.contador);
		    
		}while(res == '\t');
      	return res;
      	
	}
	
	
	public char getLastChar() throws Exception{
	    Character res = new Character(' ');
		do{
  		  this.contador--;			

  		  if (this.contador > this.codigoFonte.length())
		     throw new Exception("Fim do arquivo");
		       
		  res = this.codigoFonte.charAt(this.contador);
		    
		}while(res == '\t');
      	return res;
	}

}
