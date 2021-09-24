package steps;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageFactory.HomePage;

public class ProdutoCarrinhoSteps {

	private HomePage homePage;
	private WebDriver driver;
	private TestContext testContext;

	public ProdutoCarrinhoSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Quando("^preencho o campo com um produto$")
	public void preencho_o_campo_com_um_produto(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			homePage.buscaProdutoInserirCarrinhoAction(dado.get("produto"));
		}
	}

	@Quando("^adiciono ele ao carrinho$")
	public void adiciono_ele_ao_carrinho() throws Throwable {
	    homePage.listarProdutosAction();
		homePage.adicionarProdutoAoCarrinhoAction();
	}

	@Entao("^verifico a mensagem da tela de confirmacao$")
	public void verifico_a_mensagem_da_tela_de_confirmacao() throws Throwable {
	    Assert.assertTrue(homePage.assertSummaryIsDisplay());
	}
	
	@Quando("^adiciono ao carrinho$")
	public void adiciono_ao_carrinho() throws Throwable {
		homePage.inserirProdutoEVoltarAction();
	}

	@Quando("^clico em 'Continue shopping'$")
	public void clico_em_Continue_shopping() throws Throwable {
		homePage.btnContinueShoppingAction();
	}

	@Quando("^clico no logo localizado ao canto superior esquerdo$")
	public void clico_no_logo_localizado_ao_canto_superior_esquerdo() throws Throwable {
		homePage.clickHeaderLogoAction();
	}

	@Entao("^clico no carrinho localizado na home$")
	public void clico_no_carrinho_localizado_na_home() throws Throwable {
		 homePage.clicarCarrinhoHomeAction();
	}

	@Entao("^retiro o produto do carrinho$")
	public void retiro_o_produto_do_carrinho() throws Throwable {
		homePage.remoteToCartAction();

	}
	
	@Entao("^verifico a mensagem 'Your shopping cart is empty'$")
	public void verifico_a_mensagem_Your_shopping_cart_is_empty() throws Throwable {
	    assertTrue(homePage.assertCarrinhoVazioIsDisplay());
	}

}
