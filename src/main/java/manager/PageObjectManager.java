package manager;

import org.openqa.selenium.WebDriver;

import pageFactory.HomePage;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage pesquisaProdutoPage;

    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }

    
    public HomePage getHomePage () {
    	return (pesquisaProdutoPage == null) ? pesquisaProdutoPage = new HomePage(driver) : pesquisaProdutoPage;
    }
}