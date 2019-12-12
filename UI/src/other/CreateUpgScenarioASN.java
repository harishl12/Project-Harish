package other;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUpgScenarioASN {
	public CreateUpgScenarioASN(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-home fa-3x']")
	private WebElement home;

	@FindBy(xpath = "//input[@placeholder='Scenario Name']")
	private WebElement scenarioName;

	@FindBy(xpath = "//a[@class='btn btn-default dropdown-toggle']")
	private WebElement sizingDropdown;

	@FindBy(xpath = "//h6[contains(text(),'Upgrade')]")
	private WebElement upgrade;

	@FindBy(xpath = "//textarea[@placeholder='Scenario Description']")
	private WebElement scenarioDEscription;

	@FindBy(xpath = "//div[@class='form-control btn btn-projectName ng-binding']")
	private WebElement projectDropdown;

	@FindBy(xpath = "//input[@placeholder='Search Projects...']")
	private WebElement searchProjects;

	@FindBy(xpath = "//input[@placeholder='Enter Array SN']")
	private WebElement arraySN;

	@FindBy(xpath = "//label[contains(text(),'BIN File')]")
	private WebElement binFile;

	@FindBy(xpath = "//div[@class='input-group']//i[@class='fa fa-plus']")
	private WebElement addFiles;

	@FindBy(xpath = "//span[contains(text(),'Browse')]")
	private WebElement browse;

	/*
	 * @FindBy(id = "fileToUpload") private WebElement browse;
	 */

	@FindBy(xpath = "//button[@class='btn upload-file-btn ng-binding']")
	private WebElement uploadFiles;

	@FindBy(xpath = "//button[@id='btnCreateScenarrio']")
	private WebElement createScenario;

	@FindBy(xpath = "//td//a[contains(text(),'ASNUpg')] ")
	private WebElement selectProject;

	public void upgradeScenario(WebDriver driver, String scenarioName1, String projectName)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		waitTillElementClickable(wait, home);
		home.click();

		waitTillElementClickable(wait, sizingDropdown);
		sizingDropdown.click();

		waitTillElementClickable(wait, upgrade);
		upgrade.click();

		waitTillElementClickable(wait, scenarioName);
		scenarioName.sendKeys(scenarioName1);

		waitTillElementClickable(wait, scenarioDEscription);
		scenarioDEscription.sendKeys(scenarioName1);

		waitTillElementClickable(wait, projectDropdown);
		projectDropdown.click();

		waitTillElementClickable(wait, searchProjects);
		searchProjects.sendKeys(projectName);

		Thread.sleep(2000);
		selectProject.click();

		waitTillElementClickable(wait, arraySN);
		arraySN.sendKeys(scenarioName1);

		waitTillElementClickable(wait, createScenario);
		createScenario.click();

		Thread.sleep(5000);

	}

	public void waitTillElementClickable(WebDriverWait wait, WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitTillElementVisible(WebDriverWait wait, WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/*
	 * @FindBy(xpath = "") private WebElement ;
	 * 
	 * @FindBy(xpath = "") private WebElement ;
	 */

}
