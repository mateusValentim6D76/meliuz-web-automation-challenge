package manager;

import org.openqa.selenium.WebDriver;

import pageFactory.CadastroPage;
import pageFactory.HomePage;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private CadastroPage cadastroPage;

    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }

    
    public HomePage getHomePage () {
    	return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public CadastroPage getCadastroPage () {
    	return (cadastroPage == null) ? cadastroPage = new CadastroPage(driver) : cadastroPage;
    }
}