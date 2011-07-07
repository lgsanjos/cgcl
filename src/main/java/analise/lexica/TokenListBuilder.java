package analise.lexica;

import coretypes.Token;
import coretypes.TokenList;
import utils.GCLTokenTypes;

public class TokenListBuilder {
	
	public static TokenList keywords(){
         
        TokenList list = new TokenList();
		
		list.add(new Token(GCLTokenTypes.KEYWORD, "module"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "private"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "end"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "const"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "Boolean"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "integer"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "begin"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "typedef"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "array"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "range"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "proc"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "val"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "ref"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "return"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "write"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "read"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "if"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "fi"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "do"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "od"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "true"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "false"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "forall"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "llarof"));
		list.add(new Token(GCLTokenTypes.KEYWORD, "skip"));

		return list;
	}
	
	public static TokenList symbols(){

       	TokenList list = new TokenList();
		
		list.add(new Token(GCLTokenTypes.SYMBOL, "."));
		list.add(new Token(GCLTokenTypes.SYMBOL, "="));
		list.add(new Token(GCLTokenTypes.SYMBOL, ":="));
		list.add(new Token(GCLTokenTypes.SYMBOL, ","));
		list.add(new Token(GCLTokenTypes.SYMBOL, ";"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "("));
		list.add(new Token(GCLTokenTypes.SYMBOL, ")"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "[]"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "["));
		list.add(new Token(GCLTokenTypes.SYMBOL, "]"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "->"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "#"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "<"));
		list.add(new Token(GCLTokenTypes.SYMBOL, ">"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "<="));
		list.add(new Token(GCLTokenTypes.SYMBOL, ">="));		
		list.add(new Token(GCLTokenTypes.SYMBOL, "&"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "|"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "~"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "+"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "-"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "*"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "/"));
		list.add(new Token(GCLTokenTypes.SYMBOL, "\\"));
		list.add(new Token(GCLTokenTypes.SYMBOL, ".."));
		// Considerar
		list.add(new Token(GCLTokenTypes.SYMBOL, "--"));
		list.add(new Token(GCLTokenTypes.SYMBOL, ":"));
		//list.add(new Token(GCLTokenTypes.symbol, "'"));
		
		return list;
		
	}

}
