package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import manager.FileReaderManager;
import testDataType.CadastroPojo;
import testDataType.PesquisaProdutoExistentePojo;

public class JsonDataReader {


	private final String produtoExistenteFilePath  = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "BuscaPorProduto.json";
	private final String cadastroFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Cadastro.json";

	
	private List<PesquisaProdutoExistentePojo> produtoList;
	private List<CadastroPojo> cadastroList;

	
	public JsonDataReader(){
		produtoList = getBuscaPorProdutoData();
		cadastroList = getCadastroData();
	}
	
	private List<CadastroPojo> getCadastroData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(cadastroFilePath));
			CadastroPojo[] cadastro = gson.fromJson(bufferReader, CadastroPojo[].class);
			return Arrays.asList(cadastro);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo Json não encontrado em : " + cadastroFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {

			}
		}
	}

	private List<PesquisaProdutoExistentePojo> getBuscaPorProdutoData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(produtoExistenteFilePath));
			PesquisaProdutoExistentePojo[] pesquisaProduto = gson.fromJson(bufferReader, PesquisaProdutoExistentePojo[].class);
			return Arrays.asList(pesquisaProduto);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo Json não encontrado em : " + produtoExistenteFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {

			}
		}
	}
	
	public final PesquisaProdutoExistentePojo getProduto(String buscaProduto){
		for(PesquisaProdutoExistentePojo pesquisaProdutoPojo : produtoList) {
			if(pesquisaProdutoPojo.pesquisaBlouse.equalsIgnoreCase(buscaProduto)) return pesquisaProdutoPojo;
		}
		return null;
	}
	
	public final CadastroPojo getCadastro (String cadastro) {
		for(CadastroPojo cadastroPojo : cadastroList) {
			if(cadastroPojo.sobrenome.equalsIgnoreCase(cadastro))return cadastroPojo;
		}
		return null;
	}
}