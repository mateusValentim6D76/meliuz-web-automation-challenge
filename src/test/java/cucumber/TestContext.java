package cucumber;

import manager.PageObjectManager;
import manager.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext () {
        webDriverManager = new manager.WebDriverManager ();
        pageObjectManager = new manager.PageObjectManager (webDriverManager.getDriver ());
    }

    public WebDriverManager getWebDriverManager () {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager () {
        return pageObjectManager;
    }
}