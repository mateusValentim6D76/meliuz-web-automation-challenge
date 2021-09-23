package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import testDataType.PesquisaProdutoExistentePojo;

public class PesquisaProdutoPage {

	private WebDriverWait wait;
	private WebDriver driver;

	public PesquisaProdutoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);

	}

	@FindBy(how = How.ID, using = "search_query_top")
	private static WebElement inputBuscaProduto;
		
	public void inputBuscaPorProduto(String buscarProduto) {
		wait.until(ExpectedConditions.visibilityOf(inputBuscaProduto));
		inputBuscaProduto.sendKeys(buscarProduto);
	}
	
//	public boolean loading() {
//		wait.until(ExpectedConditions.visibilityOf(loading));
//		return loading.isDisplayed();
//
//	}

	
	public void buscaProdutoExistenteAction(PesquisaProdutoExistentePojo produtoExistenteData) {
		inputBuscaPorProduto(produtoExistenteData.pesquisaBlouse);
	}
	
}
