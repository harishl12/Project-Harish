package other;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BinUpgrade {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Files//chromedriver.exe");
		System.out.println(System.getProperty("user.dir") + "\\Files\\bins");
		String dirPath = System.getProperty("user.dir") + "\\Files\\bins";
		String projectName = "ASNUpg";
		File file = new File(dirPath);
		System.out.println(file.listFiles());
		WebDriver driver = new ChromeDriver();
		driver.get("https://vmaxtest.isus.emc.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		CreateUpgScenario ct = new CreateUpgScenario(driver);
		for (File f : file.listFiles()) {
			System.out.println(f.getName());
			String scenarioName = f.getName();
			String filePath = f.getAbsolutePath();
			ct.upgradeScenario(driver, scenarioName, projectName, filePath);
		}

	}
}
