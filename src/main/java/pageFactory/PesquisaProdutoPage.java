package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testDataType.PesquisaProdutoExistentePojo;
import util.JsScroll;

public class PesquisaProdutoPage {

	private WebDriverWait wait;
	private WebDriver driver;
	private JsScroll js;
	private static Actions actions;

	public PesquisaProdutoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);
		js = new JsScroll(driver);
		actions = new Actions(driver);
	}

	@FindBy(how = How.ID, using = "search_query_top")
	private static WebElement inputBuscaProduto;

	@FindBy(how = How.CSS, using = "button[name= 'submit_search']")
	private static WebElement botaoPesquisarProduto;

	@FindBy(how = How.ID, using = "list")
	private static WebElement listarProdutos;

	@FindBy(how = How.LINK_TEXT, using = "Add to cart")
	private static WebElement addCarrinho;

	@FindBy(how = How.XPATH, using = ".//p[@class='product-desc'][contains(.,'Short sleeved blouse with feminine')]")
	private static WebElement assertBlouse;
	
	@FindBy(how = How.XPATH, using = ".//div[@id='center_column']/*/span[contains(.,'0 results')]")
	private static WebElement assertProdutoNaoExistente;

	private void inputBuscaPorProduto(String buscarProduto) {
		wait.until(ExpectedConditions.visibilityOf(inputBuscaProduto));
		inputBuscaProduto.sendKeys(buscarProduto);
		botaoPesquisarProduto.click();
		listarProdutos.click();
	}

	private void inputBuscaPorProdutoInexistente(String buscarProduto) {
		wait.until(ExpectedConditions.visibilityOf(inputBuscaProduto));
		inputBuscaProduto.sendKeys(buscarProduto);
		botaoPesquisarProduto.click();
	}

	public boolean assertBlouseIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(assertBlouse));
		return assertBlouse.isDisplayed();
	}
	
	public boolean assertProdutoNaoExistente() {
		wait.until(ExpectedConditions.visibilityOf(assertProdutoNaoExistente));
		return assertProdutoNaoExistente.isDisplayed();

	}


	private void adicionarProdutoAoCarrinho() {
		actions.moveToElement(addCarrinho);
		addCarrinho.click();
	}

	public void buscaProdutoExistenteAction(PesquisaProdutoExistentePojo produtoExistenteData)
			throws InterruptedException {
		inputBuscaPorProduto(produtoExistenteData.pesquisaBlouse);

	}

	public void buscaProdutoInexistenteAction(String busca) throws InterruptedException {
		inputBuscaPorProdutoInexistente(busca);		
	}

	public void adicionaOProdutoAoCarrinhoAction() throws InterruptedException {
		adicionarProdutoAoCarrinho();

	}

}
