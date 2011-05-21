package analise.lexica;

import coretypes.Token;
import coretypes.TokenList;
import utils.GCLTokenTypes;

public class TokenListBuilder {
	
	public static TokenList keywords(){
         
        TokenList list = new TokenList();
		
		list.add(new Token(GCLTokenTypes.Keyword, "module"));
		list.add(new Token(GCLTokenTypes.Keyword, "private"));
		list.add(new Token(GCLTokenTypes.Keyword, "end"));
		list.add(new Token(GCLTokenTypes.Keyword, "const"));
		list.add(new Token(GCLTokenTypes.Keyword, "Boolean"));
		list.add(new Token(GCLTokenTypes.Keyword, "integer"));
		list.add(new Token(GCLTokenTypes.Keyword, "begin"));
		list.add(new Token(GCLTokenTypes.Keyword, "typedef"));
		list.add(new Token(GCLTokenTypes.Keyword, "array"));
		list.add(new Token(GCLTokenTypes.Keyword, "range"));
		list.add(new Token(GCLTokenTypes.Keyword, "proc"));
		list.add(new Token(GCLTokenTypes.Keyword, "val"));
		list.add(new Token(GCLTokenTypes.Keyword, "ref"));
		list.add(new Token(GCLTokenTypes.Keyword, "return"));
		list.add(new Token(GCLTokenTypes.Keyword, "write"));
		list.add(new Token(GCLTokenTypes.Keyword, "read"));
		list.add(new Token(GCLTokenTypes.Keyword, "if"));
		list.add(new Token(GCLTokenTypes.Keyword, "fi"));
		list.add(new Token(GCLTokenTypes.Keyword, "do"));
		list.add(new Token(GCLTokenTypes.Keyword, "od"));
		list.add(new Token(GCLTokenTypes.Keyword, "true"));
		list.add(new Token(GCLTokenTypes.Keyword, "false"));
		list.add(new Token(GCLTokenTypes.Keyword, "forall"));
		list.add(new Token(GCLTokenTypes.Keyword, "llarof"));
		list.add(new Token(GCLTokenTypes.Keyword, "skip"));

		return list;
	}
	
	public static TokenList symbols(){

       	TokenList list = new TokenList();
		
		list.add(new Token(GCLTokenTypes.Symbol, "."));
		list.add(new Token(GCLTokenTypes.Symbol, "="));
		list.add(new Token(GCLTokenTypes.Symbol, ":="));
		list.add(new Token(GCLTokenTypes.Symbol, ","));
		list.add(new Token(GCLTokenTypes.Symbol, ";"));
		list.add(new Token(GCLTokenTypes.Symbol, "("));
		list.add(new Token(GCLTokenTypes.Symbol, ")"));
		list.add(new Token(GCLTokenTypes.Symbol, "[]"));
		list.add(new Token(GCLTokenTypes.Symbol, "["));
		list.add(new Token(GCLTokenTypes.Symbol, "]"));
		list.add(new Token(GCLTokenTypes.Symbol, "->"));
		list.add(new Token(GCLTokenTypes.Symbol, "#"));
		list.add(new Token(GCLTokenTypes.Symbol, "<"));
		list.add(new Token(GCLTokenTypes.Symbol, ">"));
		list.add(new Token(GCLTokenTypes.Symbol, "<="));
		list.add(new Token(GCLTokenTypes.Symbol, ">="));		
		list.add(new Token(GCLTokenTypes.Symbol, "&"));
		list.add(new Token(GCLTokenTypes.Symbol, "|"));
		list.add(new Token(GCLTokenTypes.Symbol, "~"));
		list.add(new Token(GCLTokenTypes.Symbol, "+"));
		list.add(new Token(GCLTokenTypes.Symbol, "-"));
		list.add(new Token(GCLTokenTypes.Symbol, "*"));
		list.add(new Token(GCLTokenTypes.Symbol, "/"));
		list.add(new Token(GCLTokenTypes.Symbol, "\\"));
		list.add(new Token(GCLTokenTypes.Symbol, ".."));
		// Considerar
		list.add(new Token(GCLTokenTypes.Symbol, "--"));
		list.add(new Token(GCLTokenTypes.Symbol, ":"));
		//list.add(new Token(GCLTokenTypes.symbol, "'"));
		
		return list;
		
	}

}
