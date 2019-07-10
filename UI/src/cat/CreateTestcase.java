package cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTestcase {

	public CreateTestcase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// public CreateTestcase() {
	// // TODO Auto-generated constructor stub
	// }

	BasePage basePage = new BasePage();

	@FindBy(xpath = "//a[text()='Create Test']")
	private WebElement createTest;

	@FindBy(xpath = "//a[text()='Test Cases']")
	private WebElement testCases;

	@FindBy(xpath = "//a[text()='Tests']")
	private WebElement tests;

	@FindBy(css = "#ctl00_m_testName")
	private WebElement name;

	@FindBy(css = "#ctl00_m_description")
	private WebElement description;

	@FindBy(xpath = "//span[text()='Product']/following::span[1]")
	private WebElement product;

	@FindBy(css = "#ctl00_m_featureProductVersionFilter_cb_Input")
	private WebElement featureVersionFilter;

	@FindBy(xpath = "//a[@id='ctl00_m_featureProductVersionFilter_cb_Arrow']")
	private WebElement featureVersionDropDownArrow;

	@FindBy(xpath = "//li[contains(text(),'v4.2')]")
	private WebElement versionFoxtail;

	@FindBy(xpath = "//a[@id='ctl00_m_featureComboTree_Combo_Arrow']")
	private WebElement featureDropDownArrow;

	@FindBy(xpath = "//span[contains(text(),'Anchor')]")
	private WebElement featureExpand;

	@FindBy(xpath = "//span[contains(text(),'RR4800')]/../input")
	private WebElement featureCheckBox;

	@FindBy(xpath = "//label[contains(text(),'Primary Strategy')]")
	private WebElement primaryClick;

	// @FindBy(xpath = "(//span[contains(text(),'Select')]/following::span[1])[1]")
	@FindBy(xpath = "(//span[contains(text(),'Select')])[1]")
	private WebElement primaryStrategy;

	@FindBy(xpath = "//span[text()='Functional Testing']/preceding::span[1]")
	private WebElement functionalTesting;

	@FindBy(xpath = "//span[text()='Core Functionalities']")
	private WebElement coreFunctionalities;

	@FindBy(xpath = "//input[@id='ctl00_m_approved']")
	private WebElement approved;

	@FindBy(xpath = "//input[@id='ctl00_m_manualOnly']")
	private WebElement manualOnly;

	@FindBy(xpath = "//a[@id='ctl00_m_newFeatLevel_cb_Arrow']")
	private WebElement newFeatureLevelArrow;

	@FindBy(xpath = "//li[contains(text(),'New Features')]")
	private WebElement newFeatures;

	@FindBy(xpath = "//a[@id='ctl00_m_requirements_Combo_Arrow']")
	private WebElement boxRequirementArrow;

	@FindBy(xpath = "(//span[text()='None']/preceding::span[1])[1]")
	private WebElement boxRequirementExpand;

	@FindBy(xpath = "//span[text()='None']/../input")
	private WebElement boxRequirementNone;

	@FindBy(xpath = "//input[@id='ctl00_m_testPoints_i0_testSteps_i0_name']")
	private WebElement stepName;

	@FindBy(xpath = "//a[@class='command-but'][contains(text(),'Save')]")
	private WebElement save;

	@FindBy(xpath = "//a[contains(text(),'Edit Steps')]")
	private WebElement editSteps;

	@FindBy(xpath = "//div[@id='ctl00_m_testPoints_i0_testStepspAdd']//img[@class='add-but']")
	private WebElement add;

	// @FindBy(xpath="//input[@id='ctl00_m_testPoints_i0_testSteps_i0_name']")
	// private WebElement stepName;

	@FindBy(xpath = "//div[@id = 'ctl00_m_testPoints_i0_testSteps_i0']/div[2]/div[1]")
	private WebElement stepDescriptionClick;

	@FindBy(xpath = "//iframe[@id='ctl00_m_stepDescription_contentIframe']")
	private WebElement frame;

	@FindBy(xpath = "//span[@id='ctl00_ButtonPanel']/a[text()='Save']")
	private WebElement saveSteps;

	public void addTestcasesOnUI(WebDriver driver, String testcaseName, String testDescription, String stepNumber,
			String steps) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		testCases.click();
		BasePage.moveToElementAndClickElement(driver, tests, createTest);
		BasePage.editTextBox(name, testcaseName);
		BasePage.editTextBox(description, testDescription);
		System.out.println(BasePage.getTextString(product).contains("VMAX Sizer"));
		waitForElementClickable(wait, featureVersionDropDownArrow);
		featureVersionDropDownArrow.click();
		waitForElementClickable(wait, versionFoxtail);
		BasePage.moveAndClickOnElements(driver, versionFoxtail);
		Thread.sleep(1000);
		waitForElementClickable(wait, featureDropDownArrow);
		featureDropDownArrow.click();
		waitForElementClickable(wait, featureExpand);
		featureExpand.click();
		waitForElementClickable(wait, featureExpand);
		featureCheckBox.click();
		waitForelementToVisible(wait, primaryClick);
		primaryClick.click();
		waitForElementClickable(wait, primaryStrategy);
		// BasePage.moveAndClickOnElements(driver, primaryStrategy);
		Thread.sleep(1000);
		primaryStrategy.click();
		waitForElementClickable(wait, functionalTesting);
		functionalTesting.click();
		waitForElementClickable(wait, coreFunctionalities);
		coreFunctionalities.click();
		Thread.sleep(1000);
		waitForelementToVisible(wait, primaryClick);
		primaryClick.click();
		Thread.sleep(1000);
		waitForElementClickable(wait, approved);
		approved.click();
		waitForElementClickable(wait, manualOnly);
		manualOnly.click();
		waitForElementClickable(wait, newFeatureLevelArrow);
		newFeatureLevelArrow.click();
		waitForElementClickable(wait, newFeatures);
		newFeatures.click();
		waitForElementClickable(wait, boxRequirementArrow);
		boxRequirementArrow.click();
		waitForElementClickable(wait, boxRequirementExpand);
		boxRequirementExpand.click();
		waitForElementClickable(wait, boxRequirementNone);
		boxRequirementNone.click();
		primaryClick.click();
		waitForElementClickable(wait, save);
		save.click();
		waitForElementClickable(wait, editSteps);
		editSteps.click();
		waitForElementClickable(wait, add);
		add.click();
		BasePage.editTextBox(stepName, stepNumber);
		stepDescriptionClick.click();
		driver.switchTo().frame(frame);
		// frame.sendKeys(steps);
		BasePage.actionsSendKeys(driver, steps);
		driver.switchTo().defaultContent();
		waitForElementClickable(wait, saveSteps);
		saveSteps.click();
	}

	public void waitForElementClickable(WebDriverWait wait, WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	public void waitForelementToVisible(WebDriverWait wait, WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	// public void addTestcases(WebDriver driver) throws InterruptedException {
	// addTestcasesOnUI(driver, null, null);
	// }

	public void readTestcaseNameFromExcel(WebDriver driver, String path, String fileName, String sheetName)
			throws IOException, InterruptedException {
		File file = new File(path + "\\" + fileName);
		FileInputStream inStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inStream);
		Sheet sheet = workbook.getSheet(sheetName);
		String testCaseName = null;
		String testDescription = null;
		String stepName = null;
		String stepDescription = null;

		// HashSet<String> testNameSet = new HashSet<>();

		int cellCount = 1;
		for (Row row : sheet) {
			for (Cell cell : row) {
				// System.out.println(cell.toString());

				if (cellCount == 1) {
					stepName = cell.toString();
					System.out.println("stepName ->" + stepName);
				}

				if (cellCount == 3) {
					testCaseName = stepName + " "
							+ cell.toString().substring(0, Math.min(cell.toString().length(), 70));
					// testNameSet.add(testCaseName);
					// if (testNameSet.contains(testCaseName)) {
					// testCaseName.replace("SCM", "SCM" + stepName);
					// testCaseName = cell.toString().substring(0,
					// Math.min(cell.toString().length(), 80));
					// }

					System.out.println("testCaseName ->" + testCaseName);
				}
				if (cellCount == 4) {
					testDescription = cell.toString();
					System.out.println("testDescription -> " + testDescription);
				}
				if (cellCount == 5) {
					stepDescription = cell.toString();
					addTestcasesOnUI(driver, testCaseName, testDescription, stepName, stepDescription);
					System.out.println("stepDescription -> " + stepDescription);
					cellCount = 0;
				}
				cellCount++;
			}
		}

	}

}