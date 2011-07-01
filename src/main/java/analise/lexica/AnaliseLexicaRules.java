package analise.lexica;

import utils.GCLTokenTypes;
import utils.Utils;
import coretypes.Token;
import coretypes.TokenList;
import analise.exceptions.InvalidTokenException;

public class AnaliseLexicaRules {
	
	private TokenList keywords;
	private TokenList symbols;

	
	public AnaliseLexicaRules(){  	  
	  this.keywords = TokenListBuilder.keywords();
	  this.symbols = TokenListBuilder.symbols();
	  
	}
	
	private boolean lexemaIsKeyword(String lexema){
 	   return this.keywords.hasLexema(lexema);
	}
	
	private boolean lexemaIsSymbol(String lexema){
	    return this.symbols.hasLexema(lexema);
	}
	
	private boolean lexemaIsEndOfLine(String lexema){
		return lexema.matches("[\r\n]");
	}
	
	private boolean lexemaIsIdentifier(String lexema){
 	   return lexema.matches("([_]|[a-z]|[A-Z])([_]|[a-z]|[A-Z]|[0-9])*");
	}
	
	private boolean lexemaIsLiteralString(String lexema){
		boolean res;
		res = lexema.startsWith("'");		

		if ( lexema.length() > 1 ){
			if ( Utils.countLetters(lexema, '\'') > 1){
			  res = res && (lexema.indexOf("'", 1) == lexema.length() -1); 
			}		
		}
		return  res;		
	}
	
	private boolean lexemaIsComment(String lexema){
		return lexema.matches("(\\-\\-)(.)*");
	}
	
	private boolean lexemaIsWhitespace(String lexema){
		return lexema.matches("[ ]*");
	}	
	
	private boolean lexemaIsNumeric(String lexema){
		return lexema.matches("([0-9])*|([0-9])*[,]([0-9])*");
	}	
	
	
	public Token buildToken(String lexema, String posicao) throws InvalidTokenException{
		Token gen = new Token();
		gen.setValue(lexema);
		gen.setPosicao(posicao);
				
		if (this.lexemaIsWhitespace(lexema)){
			gen.setTokenType(GCLTokenTypes.Whitespace);
			return gen;
		}
		
		if (this.lexemaIsEndOfLine(lexema)){
			gen.setTokenType(GCLTokenTypes.EndOfLine);
			return gen;
		}
			
		if (this.lexemaIsKeyword(lexema)){
			gen.setTokenType(GCLTokenTypes.Keyword);
			return gen;
		}
				
		if (this.lexemaIsSymbol(lexema)){
			gen.setTokenType(GCLTokenTypes.Symbol);
			return gen;
		}
		
		if (this.lexemaIsNumeric(lexema)){
			gen.setTokenType(GCLTokenTypes.Number);
			return gen;
		}
		
		if (this.lexemaIsIdentifier(lexema)){
			gen.setTokenType(GCLTokenTypes.Identifier);
			return gen;			
		}
		
    	if (this.lexemaIsLiteralString(lexema)){
			gen.setTokenType(GCLTokenTypes.Literal);
			return gen;
		}
    	
		if (this.lexemaIsComment(lexema)){
			gen.setTokenType(GCLTokenTypes.Comment);
			return gen;
		}    	

		throw new InvalidTokenException("Token invalido: ".concat(lexema));
	}
	
	
	public boolean validaLexema(String lexema){
		Token valida = null;
		
		try{
		  valida = this.buildToken(lexema, "");
		}catch(Exception e){
		  return false;	
		}
						
	    return (valida != null);
		
	}		

}
