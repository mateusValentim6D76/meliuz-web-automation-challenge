package steps;


import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import manager.FileReaderManager;
import pageFactory.HomePage;
import testDataType.PesquisaProdutoExistentePojo;

public class PesquisaProdutoSteps {

	private HomePage homePage;
	private WebDriver driver;
	private TestContext testContext;

	public PesquisaProdutoSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Quando("^preencho o campo com o produto existente \"([^\"]*)\"$")
	public void preencho_o_campo_com_o_produto_existente(String dados) throws Throwable {
		PesquisaProdutoExistentePojo produtoExistenteData = FileReaderManager.getInstance().getJsonReader()
				.getProduto(dados);
		homePage.buscaProdutoExistenteAction(produtoExistenteData);

	}

	@Quando("^sera exibido o resultado da pesquisa$")
	public void sera_exibido_o_resultado_da_pesquisa() throws Throwable {
		Assert.assertTrue(homePage.assertBlouseIsDisplay());

	}

	@Entao("^vou adicionar o produto ao carrinho$")
	public void vou_adicionar_o_produto_ao_carrinho() throws Throwable {
		homePage.adicionarProdutoAoCarrinhoAction();
	}

	@Quando("^preencho o campo com produto inexistente$")
	public void preencho_o_campo_com_produto_inexistente(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			homePage.buscaProdutoInexistenteAction(dado.get("produto"));

		}
	}

	@Entao("^verifico a mensagem que o produto nao existe$")
	public void verifico_a_mensagem_que_o_produto_nao_existe() throws Throwable {
		Assert.assertTrue(homePage.assertProdutoNaoExistente());
	}
}
