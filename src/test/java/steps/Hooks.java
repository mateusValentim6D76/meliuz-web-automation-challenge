package steps;


import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	 
	 public Hooks(TestContext context) {
	 testContext = context;
	 }
	 
	 @Before
	 public void BeforeSteps() {
		 String msg = "Iniciando cenário";
		 System.out.println(msg);
	 }
	 
	 @After
	 public void AfterSteps() {
	 testContext.getWebDriverManager().closeDriver();
	 }
	 
	}