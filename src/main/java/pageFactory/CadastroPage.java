package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testDataType.CadastroPojo;
import util.JsScroll;

public class CadastroPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private JsScroll js;

	private static Actions actions;
	private Select select;

	public CadastroPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(this.driver, 10);
		js = new JsScroll(driver);
		
	}

	@FindBy(how = How.CSS, using = "a.login")
	private static WebElement sign;

	@FindBy(how = How.ID, using = "email_create")
	private static WebElement emailCreateAccount;

	@FindBy(how = How.ID, using = "SubmitCreate")
	private static WebElement submitCreateAccount;

	@FindBy(how = How.ID, using = "customer_firstname")
	private static WebElement primeiroNome;

	@FindBy(how = How.ID, using = "customer_lastname")
	private static WebElement sobrenome;

	@FindBy(how = How.ID, using = "passwd")
	private static WebElement senha;

	@FindBy(how = How.ID, using = "days")
	private static WebElement selectDiaNiver;

	@FindBy(how = How.ID, using = "months")
	private static WebElement selectMesNiver;

	@FindBy(how = How.ID, using = "years")
	private static WebElement selectAnoNiver;

	@FindBy(how = How.ID, using = "firstname")
	private static WebElement primeiroNome_Etapa2;

	@FindBy(how = How.ID, using = "lastname")
	private static WebElement sobrenome_Etapa2;

	@FindBy(how = How.ID, using = "company")
	private static WebElement empresa;

	@FindBy(how = How.ID, using = "address1")
	private static WebElement endereco1;

	@FindBy(how = How.ID, using = "address2")
	private static WebElement endereco2;

	@FindBy(how = How.ID, using = "city")
	private static WebElement cidade;

	@FindBy(how = How.ID, using = "uniform-id_state")
	private static WebElement selectEstado;

	@FindBy(how = How.ID, using = "postcode")
	private static WebElement cep;

	@FindBy(how = How.ID, using = "id_country")
	private static WebElement selectPais;

	@FindBy(how = How.ID, using = "other")
	private static WebElement infoAdicionais;

	@FindBy(how = How.ID, using = "phone")
	private static WebElement telefone;

	@FindBy(how = How.ID, using = "phone_mobile")
	private static WebElement celular;

	@FindBy(how = How.ID, using = "alias")
	private static WebElement referencia;

	@FindBy(how = How.ID, using = "submitAccount")
	private static WebElement btnRegistrar;

	@FindBy(how = How.ID, using = "id_gender1")
	private static WebElement sexoM;

	private void sign() {
		sign.click();
	}

	public void signAction() {
		sign();
	}
	private void emailSignIn(String emailCadastro) {
		emailCreateAccount.sendKeys(emailCadastro);
	}
	
	private void btnCreateAccount() {
		submitCreateAccount.click();
	}
	private void selecionarSexoMasculino() {
		sexoM.click();
	}

	private void inputNome(String nome) {
		wait.until(ExpectedConditions.visibilityOf(primeiroNome));
		primeiroNome.sendKeys(nome);
	}

	private void inputSobreNome(String sobreNome) {
		wait.until(ExpectedConditions.visibilityOf(sobrenome));
		sobrenome.sendKeys(sobreNome);
	}

	private void inputSenha(String senha_) {
		wait.until(ExpectedConditions.visibilityOf(senha));
		senha.sendKeys(senha_);
	}

	private void selectDiaNiver(int dia) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(selectDiaNiver));
		select = new Select(selectDiaNiver);
		select.selectByIndex(dia);
		Thread.sleep(2000);
	}

	private void selectMesNiver(String mes) {
		wait.until(ExpectedConditions.visibilityOf(selectMesNiver));
		select = new Select(selectMesNiver);
		select.selectByVisibleText(mes);
		
	}

	private void selectAnoNiver(String ano) {
		wait.until(ExpectedConditions.visibilityOf(selectAnoNiver));
		select = new Select(selectAnoNiver);
		select.selectByVisibleText(ano);
		
	}

	private void inputNome2(String nome2) {
		primeiroNome_Etapa2.sendKeys(nome2);
	}

	private void inputSobreNome2(String sobrenome2) {
		sobrenome_Etapa2.sendKeys(sobrenome2);
	}

	private void inputEmpresa(String empresa__) {
		empresa.sendKeys(empresa__);
	}

	private void inputEndereco(String endereco) {
		endereco1.sendKeys(endereco);
	}

	private void inputEndereco2(String endereco__) {
		actions.moveToElement(endereco2).perform();
		endereco2.sendKeys(endereco__);
	}

	private void inputCidade(String cidadeI) {
		js.scrollDown();
		actions.moveToElement(cidade).perform();
		cidade.sendKeys(cidadeI);
		js.scrollDown();
	}

	private void selectEstado(String estado) {
		select = new Select(selectEstado);
		select.selectByValue(estado);
	}

	private void inputCep(String iCep) {
		cep.sendKeys(iCep);
	}

	private void selectPais(String pais) {
		actions.moveToElement(selectPais);
		wait.until(ExpectedConditions.visibilityOf(selectPais));
		select.selectByVisibleText(pais);
	}

	private void inputInfoAdicional(String inf) {
		infoAdicionais.sendKeys(inf);
	}

	private void inputTelefone(String tel) {
		telefone.sendKeys(tel);
	}

	private void inputCelular(String cel) {
		celular.sendKeys(cel);
	}

	private void inputReferencia(String ref) {
		celular.sendKeys(ref);
	}

	private void btnRegistrar_() {
		btnRegistrar.click();
	}
	
	public void btnRegistrarAction() {
		btnRegistrar_();
	}

	public void preencherCadastro(CadastroPojo cadastroPojo) throws InterruptedException {
		emailSignIn(cadastroPojo.email);
		btnCreateAccount();
		selecionarSexoMasculino();
		inputNome(cadastroPojo.primeiroNome);
		inputSobreNome(cadastroPojo.sobrenome);
		inputSenha(cadastroPojo.senha);
//		selectDiaNiver(cadastroPojo.diaNiver);
//		selectMesNiver(cadastroPojo.mesNiver);
//		selectAnoNiver(cadastroPojo.anoNiver);
//		inputNome2(cadastroPojo.primeiroNomeEtapa2);
//		inputSobreNome2(cadastroPojo.sobrenomeEtapa2);
		inputEmpresa(cadastroPojo.empresa);
		inputEndereco(cadastroPojo.endereco);
		inputEndereco2(cadastroPojo.endereco2);
		inputCidade(cadastroPojo.cidade);
		selectPais(cadastroPojo.pais);
		inputCep(cadastroPojo.cep);
		selectEstado(cadastroPojo.estado);
		inputInfoAdicional(cadastroPojo.infoAdicional);
		inputTelefone(cadastroPojo.telefone);
		inputCelular(cadastroPojo.celular);
		inputReferencia(cadastroPojo.referencia);
	}
}
