package steps;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import manager.FileReaderManager;
import pageFactory.CadastroPage;
import testDataType.CadastroPojo;

public class CadastroSteps {

	private WebDriver driver;
	private TestContext testContext;
	private CadastroPage cadastro;
	
	public CadastroSteps(TestContext contexto) {
		testContext = contexto;
		driver = testContext.getWebDriverManager().getDriver();
		cadastro = testContext.getPageObjectManager().getCadastroPage();		
	}
	
	
	@Quando("^clico em 'Signin'$")
	public void clico_em_Signin() throws Throwable {
	   cadastro.signAction();
	}

	@Quando("^preencho os campos com os dados \"([^\"]*)\"$")
	public void preencho_os_campos_com_os_dados(String dadosCadastro) throws Throwable {
	    CadastroPojo cadastroPojo = FileReaderManager.getInstance().getJsonReader().getCadastro(dadosCadastro);
	    cadastro.preencherCadastro(cadastroPojo);
	}

	@Entao("^clico em 'Register' para finalizar o cadastro$")
	public void clico_em_Register_para_finalizar_o_cadastro() throws Throwable {
	    cadastro.btnRegistrarAction();
	}
}
