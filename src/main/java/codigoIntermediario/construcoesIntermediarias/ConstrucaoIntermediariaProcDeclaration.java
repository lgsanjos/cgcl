package codigoIntermediario.construcoesIntermediarias;

import codigoIntermediario.CodigoIntermediario;
import analise.sintatica.ArvoreSintaticaAbstrataNo;

public class ConstrucaoIntermediariaProcDeclaration extends	ConstrucaoIntermediaria {
	
	private static ConstrucaoIntermediariaProcDeclaration instancia;
	
	private ConstrucaoIntermediariaProcDeclaration() {
		super();
	}
	
	public static ConstrucaoIntermediariaProcDeclaration getInstancia() {
		if (instancia == null)
			instancia = new ConstrucaoIntermediariaProcDeclaration();
		
		return instancia;
	}
		

	@Override
	public String traduz(ArvoreSintaticaAbstrataNo no) {
		
		if (no.getNome().equalsIgnoreCase("procedureDecl")) {
			String nome = no.getListaDeNos().get(1).getToken().getValue();
			CodigoIntermediario.addLabel(nome);
		}
		
		return "";
	}

}
