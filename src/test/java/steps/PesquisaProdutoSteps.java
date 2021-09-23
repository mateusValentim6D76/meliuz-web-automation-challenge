package steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import manager.FileReaderManager;
import pageFactory.PesquisaProdutoPage;
import testDataType.PesquisaProdutoExistentePojo;

public class PesquisaProdutoSteps {

	private PesquisaProdutoPage pesquisaProdutoPage;
	private WebDriver driver;
	private TestContext testContext;

	public PesquisaProdutoSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		pesquisaProdutoPage = testContext.getPageObjectManager().getpesquisaProdutoPage();
	}

	@Quando("^preencho o campo com o produto existente \"([^\"]*)\"$")
	public void preencho_o_campo_com_o_produto_existente(String dados) throws Throwable {
		PesquisaProdutoExistentePojo produtoExistenteData = FileReaderManager.getInstance().getJsonReader().getProduto(dados);
		pesquisaProdutoPage.buscaProdutoExistenteAction(produtoExistenteData);
	}

	@Quando("^sera exibido o resultado da pesquisa$")
	public void sera_exibido_o_resultado_da_pesquisa() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^vou adicionar o produto ao carrinho$")
	public void vou_adicionar_o_produto_ao_carrinho() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
