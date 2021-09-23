package manager;

import org.openqa.selenium.WebDriver;

import core.BasePage;
import pageFactory.PesquisaProdutoPage;

public class PageObjectManager {

    private WebDriver driver;
    private BasePage basePage;
    private PesquisaProdutoPage pesquisaProdutoPage;

    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getBasePage () {
        return (basePage == null) ? basePage = new BasePage (driver) : basePage;
    }
    public PesquisaProdutoPage getpesquisaProdutoPage () {
    	return (pesquisaProdutoPage == null) ? pesquisaProdutoPage = new PesquisaProdutoPage(driver) : pesquisaProdutoPage;
    }
}