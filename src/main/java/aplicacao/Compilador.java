package aplicacao;

import java.io.IOException;
import java.util.List;

import utils.Utils;
import analise.exceptions.AnaliseSemanticaException;
import analise.exceptions.InvalidTokenException;
import analise.exceptions.ProducaoSintaticaException;
import analise.lexica.AnaliseLexica;
import analise.semantica.AnaliseSemantica;
import analise.sintatica.AnaliseSintatica;
import analise.sintatica.ArvoreSintaticaAbstrataNo;
import codigoAssembly.GeradorDeAssembly;
import codigoAssembly.estrutura.CodigoAssembly;
import codigoIntermediario.CodigoIntermediario;
import codigoIntermediario.ConstrucaoDeQuatroEnderecos;
import codigoIntermediario.GeradorDeCodigoIntermediario;
import coretypes.gcl.GCLTokenTypes;

public class Compilador {
	
	private String nomeArquivoEntrada = "";
	private String nomeArquivoSaida = "";
	private Boolean emitirArvoreSintatica = false;
	private Boolean emitirCodigoIntermediario = false;
	private Boolean emitirCodigoAssembly = false;
	//private Boolean otimizacaoInline = false;
	
	public Compilador(String nomeArquivoGcl) {
		this.nomeArquivoEntrada = nomeArquivoGcl;
	}

	public void emitirArvoreSintatica() {
		this.emitirArvoreSintatica = true;
	}

	public void emitirCodigoIntermediario() {
		this.emitirCodigoIntermediario = true;
	}

	public void emitirCodigoAssembly() {
		this.emitirCodigoAssembly = true;
	}

	public void otimizarInline() {
		//this.otimizacaoInline = true;
	}

	public void setNomeDoArquivoDeSaida(String nomeDoArquivoDeSaida) {
		this.nomeArquivoSaida = nomeDoArquivoDeSaida;
	}
	
	private String nomeArquivoSaida() {
		if (this.nomeArquivoSaida.isEmpty()) {
			this.nomeArquivoSaida = this.nomeArquivoEntrada.replaceFirst(".gcl", "");
		}
		
		return "./" + this.nomeArquivoSaida;
	}
	
	private String carregaArquivoDeEntrada() throws IOException {
		if (this.nomeArquivoEntrada.isEmpty()) 
			throw new IOException("Não foi informado o nome do arquivo a ser compilado");
		
		return Utils.loadFromFile(this.nomeArquivoEntrada);
	}
	
	private void disparaErrosSemanticos(AnaliseSemantica analisadorSemantico) throws AnaliseSemanticaException {
		String erros = "";
		for (String erro : analisadorSemantico.getListaDeErros())
			erros = erro + "\n\r";

		if (! erros.isEmpty())		
			throw new AnaliseSemanticaException(erros);		
	}
	
	private ArvoreSintaticaAbstrataNo gerarArvoreSintaticaAbstrata(String codigoFonte) throws ProducaoSintaticaException, InvalidTokenException {
		AnaliseLexica analisadorLexico = new AnaliseLexica(codigoFonte);
		analisadorLexico.addTokenClassException(GCLTokenTypes.COMMENT);
		analisadorLexico.addTokenClassException(GCLTokenTypes.ENDOFLINE);
		analisadorLexico.addTokenClassException(GCLTokenTypes.WHITESPACE);
		AnaliseSintatica analisadorSintatico = new AnaliseSintatica(analisadorLexico);
		
		return analisadorSintatico.analisar();
	}
	
	private void executaAnaliseSemantica(ArvoreSintaticaAbstrataNo raizArvoreSintaticaAbstrata) throws AnaliseSemanticaException {
		AnaliseSemantica analisadorSemantico;				
		analisadorSemantico = new AnaliseSemantica(raizArvoreSintaticaAbstrata);
		analisadorSemantico.analisar();		
		this.disparaErrosSemanticos(analisadorSemantico);		
	}
	
	private void gerarSaidaArvoreSintatica(ArvoreSintaticaAbstrataNo raizArvoreSintaticaAbstrata) {
		if (this.emitirArvoreSintatica)
			Utils.saveToFile(raizArvoreSintaticaAbstrata.toString(), this.nomeArquivoSaida() + "_asa");
	}
	
	private void gerarSaidaCodigoIntermediario() {
		if (this.emitirCodigoIntermediario)
			Utils.saveToFile(CodigoIntermediario.getInstancia().to_string(), this.nomeArquivoSaida() + "_ci");		
	}
	
	private void gerarSaidaCodigoAssembly() {
		if (this.emitirCodigoAssembly)
			Utils.saveToFile(CodigoAssembly.getInstancia().to_string(), this.nomeArquivoSaida() + "_asm");		
	}
	
	private ArvoreSintaticaAbstrataNo executaAnaliseLexicaESintatica() throws IOException, ProducaoSintaticaException, InvalidTokenException {
		Log.debbug("carregando arquivo de entrada...");
		String codigoFonte = carregaArquivoDeEntrada();
		Log.debbug("arquivo de entrada carregado com sucesso");
		
		ArvoreSintaticaAbstrataNo raizArvoreSintaticaAbstrata = this.gerarArvoreSintaticaAbstrata(codigoFonte);
		return raizArvoreSintaticaAbstrata;
	}
	
	public void compilar() throws ProducaoSintaticaException, InvalidTokenException, IOException, AnaliseSemanticaException {
		Log.debbug("Inciando compilacao");
		
		Log.debbug("executando analise sintatica...");
		ArvoreSintaticaAbstrataNo raizArvoreSintaticaAbstrata = this.executaAnaliseLexicaESintatica();
		this.gerarSaidaArvoreSintatica(raizArvoreSintaticaAbstrata);
		Log.debbug("analise sintatica executada com sucesso");
		
		
		Log.debbug("executando analise semantica...");
		this.executaAnaliseSemantica(raizArvoreSintaticaAbstrata);
		Log.debbug("analise semantica executada com sucesso");
		
		
		Log.debbug("gerando codigo intermediario...");
		GeradorDeCodigoIntermediario.traduz(raizArvoreSintaticaAbstrata);
		List<ConstrucaoDeQuatroEnderecos> codigoIntermediario = CodigoIntermediario.getCodigo();
		this.gerarSaidaCodigoIntermediario();
		Log.debbug("codigo intermediario executado com sucesso");
		
		
		Log.debbug("gerando codigo assembly...");
		GeradorDeAssembly.traduz(codigoIntermediario);
		this.gerarSaidaCodigoAssembly();
		Log.debbug("codigo assembly executado com sucesso");

	}
		

}
