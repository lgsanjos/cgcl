package analise.tabelaDeSimbolos;

import java.util.ArrayList;
import java.util.List;

import analise.semantica.Parametro;

public class SimboloFuncao extends SimboloAbstract {

	private List<Parametro> parametros;	
	
	public SimboloFuncao(String nome, ArrayList<Parametro> listaDeParametros) {
		super(nome);
		this.parametros = listaDeParametros;
	}
	
	public SimboloFuncao(String nome) {
		super(nome);
	}	

	public List<Parametro> getParametros() {
		return parametros;
	}

	@Override
	public boolean isFuncao() {
		return true;
	}

	@Override
	public boolean isVariavel() {
		return false;
	}

	@Override
	public boolean isFimDeEscopo() {
		return false;
	}
	
	@Override
	public boolean isConstante() {
		return false;
	}	

}
