package cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMethod {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Files//chromedriver.exe");
		String path = System.getProperty("user.dir") + "\\Files";
		String confFile = "configuration.properties";
		Properties prop = new Properties();
		File file = new File(path + "\\" + confFile);
		FileInputStream inStream = new FileInputStream(file);
		prop.load(inStream);
		System.out.println(prop.getProperty("featureVersion"));
		String fileName = "Test.xlsx";
		String sheetName = "Sheet1";
		WebDriver driver = new ChromeDriver();
		driver.get("http://catprd.corp.emc.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		CreateTestcase ct = new CreateTestcase(driver);
		// ct.addTestcases(driver);
		ct.readTestcaseNameFromExcel(driver, path, fileName, sheetName);
	}
}
