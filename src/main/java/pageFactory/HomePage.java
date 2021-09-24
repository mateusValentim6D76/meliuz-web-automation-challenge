package pageFactory;

import org.openqa.selenium.By;
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

public class HomePage {

	private WebDriverWait wait;
	private WebDriver driver;
	private JsScroll js;
	private static Actions actions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);
		//js = new JsScroll(driver);
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

	@FindBy(how = How.XPATH, using = ".//a/span[contains(.,'Proceed to')]")
	private static WebElement buttonProceedToCart;

	@FindBy(how = How.CSS, using = "ul#order_step li.step_current.first")
	private static WebElement assertStepSummary;
	
	@FindBy(how = How.CSS, using = "div#block_top_menu li a[title='Women']")
	private static WebElement womenCategory;

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

	private void inputBuscaPorProdutoInserirCarrinho(String buscarProduto) {
		wait.until(ExpectedConditions.visibilityOf(inputBuscaProduto));
		inputBuscaProduto.sendKeys(buscarProduto);
		botaoPesquisarProduto.click();
	}

	private void inserirProdAoCarrinho() {
		actions.moveToElement(addCarrinho);
		addCarrinho.click();
		buttonProceedToCart.click();
	}

	private void listarProdutos() {
		actions.moveToElement(listarProdutos);
		listarProdutos.click();
	}
	
	private void categoriaWomen() {
		actions.moveToElement(womenCategory).perform();	
	}

	////// Actions //////

	public boolean assertBlouseIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(assertBlouse));
		return assertBlouse.isDisplayed();
	}

	public boolean assertSummaryIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(assertStepSummary));
		return assertStepSummary.isDisplayed();
	}

	public boolean assertProdutoNaoExistente() {
		wait.until(ExpectedConditions.visibilityOf(assertProdutoNaoExistente));
		return assertProdutoNaoExistente.isDisplayed();
	}

	public void adicionarProdutoAoCarrinhoAction() {
		inserirProdAoCarrinho();
	}

	public void buscaProdutoExistenteAction(PesquisaProdutoExistentePojo produtoExistenteData)
			throws InterruptedException {
		inputBuscaPorProduto(produtoExistenteData.pesquisaBlouse);

	}

	public void buscaProdutoInexistenteAction(String busca) throws InterruptedException {
		inputBuscaPorProdutoInexistente(busca);
	}

	public void buscaProdutoInserirCarrinhoAction(String busca) throws InterruptedException {
		inputBuscaPorProdutoInserirCarrinho(busca);
	}

	public void listarProdutosAction() {
		listarProdutos();
	}
	
	public void categoryWomenAction() {
		categoriaWomen();
	}
	
	public void subCategoriasHome(String subCategory) {
		//String subCat = "ul.submenu-container.clearfix.first-in-line-xs li ul li a[title='Summer Dresses']";
		WebElement elemento = driver.findElement(By.cssSelector("ul.submenu-container.clearfix.first-in-line-xs li ul li a[title='"+subCategory+"']"));
		elemento.click();
	}
	
	

}
