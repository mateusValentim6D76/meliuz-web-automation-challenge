package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.PesquisaProdutoPage;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private static Actions actions;
    private PesquisaProdutoPage send;
   

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver,10);
        js = (JavascriptExecutor) this.driver;
        actions = new Actions(driver);
    }

    @FindBy (how = How.ID, using = "nav_automobile")
    private static WebElement linkAutomobile;

    @FindBy (how = How.ID, using = "opendateofmanufacturecalender")
    private static WebElement openCalendar;

    @FindBy (how = How.XPATH, using = "//div[@class='ui-datepicker-title']")
    private static WebElement month;
    
    @FindBy (how = How.ID, using = "nextsendquote")
    private static WebElement buttonNextSendQuote;
    
    @FindBy (how = How.XPATH, using = ".//label[@class='choosePrice ideal-radiocheck-label'][3]")
    private static WebElement radioButtonPlatinum;
    
    
    public void clickAutomobile () {
        wait.until (ExpectedConditions.visibilityOf (linkAutomobile));
        linkAutomobile.click ();
    }
    
    public void clickOpenCalendar () {
        wait.until (ExpectedConditions.visibilityOf (openCalendar));
        openCalendar.click ();
    }
    
    public void nextSendQuote () {
        wait.until (ExpectedConditions.visibilityOf (buttonNextSendQuote));
        buttonNextSendQuote.click ();
    }
    
    public void radioButtonPlatinum() {
    	wait.until(ExpectedConditions.visibilityOf(radioButtonPlatinum));
    	radioButtonPlatinum.click();
    }
    
    protected static void moveToElement(WebElement elemento) {
		try {
			actions.moveToElement(elemento);
		} catch (Exception e) {
			System.out.println("Nao foi possivel mover o mouse para o elemento");
		}
	}
}