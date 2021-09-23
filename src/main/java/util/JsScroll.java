package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsScroll {

	private WebDriver driver;
	private JavascriptExecutor js;

	public JsScroll(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}

	public void scrollDown() {
		js.executeScript("scrollBy(0,200)", "");
	}

	public void scrollUp() {
		js.executeScript("scrollBy(0,-500)", "");
	}

	public void clickJs(WebElement element) {
		js.executeScript("document.getElementById("+element+").click()");

	}
}