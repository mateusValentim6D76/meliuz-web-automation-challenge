package steps;

import java.io.FileReader;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import manager.FileReaderManager;

public class Hooks {

	TestContext testContext;
	 
	 public Hooks(TestContext context) {
	 testContext = context;
	 }
	 
	 @Before
	 public void BeforeSteps() {

	 }
	 
	 @After
	 public void AfterSteps() {
	 testContext.getWebDriverManager().closeDriver();
	 }
	 
	}