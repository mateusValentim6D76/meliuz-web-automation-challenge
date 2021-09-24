package steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageFactory.HomePage;

public class ListarProdutoSteps {

	private HomePage homePage;
	private WebDriver driver;
	private TestContext testContext;
	
	 public ListarProdutoSteps(TestContext context) {
		testContext = context;
		this.driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	@Quando("^abro a lista dentro da categoria Women$")
	public void abro_a_lista_dentro_da_categoria_Women() throws Throwable {
	 homePage.categoryWomenAction();
	}

	@Quando("^clico no tipo de subproduto$")
	public void clico_no_tipo_de_subproduto(DataTable dados) throws Throwable {
		 for(Map<String, String> dado: dados.asMaps(String.class, String.class)) {
			  	homePage.subCategoriasHome(dado.get("subCategoria"));
		  }
	}

	@Entao("^verifico se estou na tela referente aquele produto$")
	public void verifico_se_estou_na_tela_referente_aquele_produto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
