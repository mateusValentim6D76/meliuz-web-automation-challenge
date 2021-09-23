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
	
	@FindBy (how = How.CSS, using = "button[name= 'submit_search']")
	private static WebElement botaoPesquisarProduto;
	
	@FindBy (how = How.ID, using = "list")
	private static WebElement listarProdutos;
	
	@FindBy (how = How.LINK_TEXT, using = "Add to cart")
	private static WebElement addCarrinho;
	
		
	public void inputBuscaPorProduto(String buscarProduto) {
		wait.until(ExpectedConditions.visibilityOf(inputBuscaProduto));
		inputBuscaProduto.sendKeys(buscarProduto);
		botaoPesquisarProduto.click();
	}
	
	public void adicionarProdutoAoCarrinho() {
		js.scrollDown();
		listarProdutos.click();
		actions.moveToElement(addCarrinho);	
		addCarrinho.click();
	}
		
//	public boolean loading() {
//		wait.until(ExpectedConditions.visibilityOf(loading));
//		return loading.isDisplayed();
//
//	}
	
	public void buscaProdutoExistenteAction(PesquisaProdutoExistentePojo produtoExistenteData) throws InterruptedException {
		inputBuscaPorProduto(produtoExistenteData.pesquisaBlouse);
		adicionarProdutoAoCarrinho();
	}
	
}
