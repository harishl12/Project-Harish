package other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ASNUpgrade {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Files//chromedriver.exe");
		String projectName = "ASNUpg";
		String filePath = System.getProperty("user.dir") + "\\Files";
		File file = new File(filePath + "\\ASN2.txt");
		FileReader rd = new FileReader(file);
		BufferedReader br = new BufferedReader(rd);
		String line = br.readLine();
		WebDriver driver = new ChromeDriver();
		driver.get("https://vmaxperf.isus.emc.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		CreateUpgScenarioASN asn = new CreateUpgScenarioASN(driver);
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String scenario = line;
			asn.upgradeScenario(driver, scenario, projectName);
		}

	}
}
