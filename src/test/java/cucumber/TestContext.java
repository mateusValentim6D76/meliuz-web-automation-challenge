package cucumber;

public class TestContext {
    private manager.WebDriverManager webDriverManager;
    private manager.PageObjectManager pageObjectManager;

    public TestContext () {
        webDriverManager = new manager.WebDriverManager ();
        pageObjectManager = new manager.PageObjectManager (webDriverManager.getDriver ());
    }

    public manager.WebDriverManager getWebDriverManager () {
        return webDriverManager;
    }

    public manager.PageObjectManager getPageObjectManager () {
        return pageObjectManager;
    }
}