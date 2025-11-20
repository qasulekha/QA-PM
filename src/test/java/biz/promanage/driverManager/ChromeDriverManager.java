package biz.promanage.driverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.page.Page;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected void startDriver() throws IOException {
	    ChromeOptions chromeOptions = new ChromeOptions();
	    
	    chromeOptions.addArguments("--headless=new");
	    chromeOptions.addArguments("--disable-gpu");
	    chromeOptions.addArguments("--incognito");
	    chromeOptions.addArguments("start-maximized");
	    chromeOptions.addArguments("--window-size=1920,1080");
	    chromeOptions.addArguments("disable-infobars");
	    chromeOptions.addArguments("--disable-extensions");
	    chromeOptions.addArguments("--remote-allow-origins=*");

	    String uniqueUserDataDir = Files.createTempDirectory("chrome_profile_").toString();
	    chromeOptions.addArguments("--user-data-dir=" + uniqueUserDataDir);

	    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

	    WebDriverManager.chromedriver().driverVersion("138.0.7204.102").setup();
	    driver = new ChromeDriver(chromeOptions);
	   
	    // Clean up temp profile directory after test run
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	        try {
	            org.apache.commons.io.FileUtils.deleteDirectory(new java.io.File(uniqueUserDataDir));
	        } catch (IOException e) {
	            System.out.println("Failed to delete Chrome temp profile directory: " + e.getMessage());
	        }
	    }));
	}
}