package analise.sintatica;


public class AnaliseSintaticaUnitarioTest extends AnaliseSintaticaTest {
	
	
    public void testaModuleBasico(){
    	String source = "module oi begin end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	assertTrue( this.analisador.valida() );	
    }
    
    public void testaModuleBasicoComFalhaSintaticaNoFinalDaProducao(){
    	String source = "module oi begin end;";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	assertFalse( this.analisador.valida() );	
    }
    
    public void testaModuleBasicoComFalhaSintaticaNoMeioDaProducao(){
    	String source = "module oi @ begin end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	assertFalse( this.analisador.valida() );	
    }       
    
    public void testaModuleBasicoComPrivateEQuebrasDeLinha(){
    	String source = "module testando \r\n" +
    					"private \r\n" +
    					"begin \r\n" +
    					"end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	assertTrue( this.analisador.valida() );	
    }    
   
    public void testaModuleBasicoComPrivateEComentarios(){
    	String source = "module testando \r\n" +
    					"private \r\n" +
    					" -- testando os comentarios \r\n" +
    					"begin \r\n" +
    					"end.";
    	
    	this.analisador = this.buildAnaliseSintatica(source);
    	assertTrue( this.analisador.valida() );	
    }    
	

}
