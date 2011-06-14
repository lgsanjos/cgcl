package analise.sintatica.producoes;

import coretypes.TokenList;

public class RegrasProducaoDefinitionPart extends RegrasProducaoAbstract {

	@Override
	public Object geraArvoreSintaticaAbstrata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValida(TokenList pilhaDeToken, int apartirDe) {
		int i = apartirDe;
		boolean isValida = true;
		
		
		while ( isValida ){
			if (isValida) isValida = RegrasProducaoDefinition.getInstancia().isValida(pilhaDeToken, i);
			if (isValida) isValida = pilhaDeToken.get(i).getValue().equals(";");
			i++;	
		}
		return isValida;
	}
		
	private static RegrasProducaoModule instancia = new RegrasProducaoModule();
	
	public static RegrasProducaoAbstract getInstancia() {
		return instancia;
	}	

}
