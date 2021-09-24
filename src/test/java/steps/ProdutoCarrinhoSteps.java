package steps;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageFactory.PesquisaProdutoPage;

public class ProdutoCarrinhoSteps {

	private PesquisaProdutoPage pesquisaProdutoPage;
	private WebDriver driver;
	private TestContext testContext;

	public ProdutoCarrinhoSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		pesquisaProdutoPage = testContext.getPageObjectManager().getpesquisaProdutoPage();
	}
	
	@Quando("^preencho o campo com um produto$")
	public void preencho_o_campo_com_um_produto(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			pesquisaProdutoPage.buscaProdutoInserirCarrinhoAction(dado.get("produto"));
		}
	}

	@Quando("^adiciono ele ao carrinho$")
	public void adiciono_ele_ao_carrinho() throws Throwable {
	    pesquisaProdutoPage.listarProdutosAction();
		pesquisaProdutoPage.adicionarProdutoAoCarrinhoAction();
	}

	@Entao("^verifico a mensagem da tela de confirmacao$")
	public void verifico_a_mensagem_da_tela_de_confirmacao() throws Throwable {
	    Assert.assertTrue(pesquisaProdutoPage.assertSummaryIsDisplay());
	}

}
