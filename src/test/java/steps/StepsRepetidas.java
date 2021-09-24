package steps;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import manager.FileReaderManager;

public class StepsRepetidas {
	
	private WebDriver driver;
	private TestContext testContext;
	//private BasePage basePage;
	
	public StepsRepetidas(TestContext contexto) {
		this.testContext = contexto;
		driver = testContext.getWebDriverManager().getDriver();
		//basePage = testContext.getPageObjectManager().getBasePage();
	}
	
	@Dado("^que estou na tela home$")
	public void que_estou_na_tela_home() throws Throwable {
		driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
	}
	
	@Quando("^busco por um produto$")
	public void busco_por_um_produto() throws Throwable {
	   
	}

}
