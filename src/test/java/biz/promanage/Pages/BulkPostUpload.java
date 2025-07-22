package biz.promanage.Pages;
import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Objects;

public class BulkPostUpload extends BasePage {
	 private final By INSIGHTS = By.xpath("((//div[@class='sk-vertical-menu sk-menu-shrink']/ul/li/a)[2]/span)[3]");
	// private final By POST = By.xpath("(//div[@class='sk-chipset sk-margin-bottom']/div)[1]");
	 private final By POST = By.xpath("(//div[@class='sk-surface sk-gutter-large animated']/ul/li)[1]");
	 private final By PROFILE = By.xpath("((//div[@class='sk-menu sk-scrollable'])[2]//ul/li)[3]");
	// String post ="//div[text()='Post']";
	 private final By WRITE_A_POST_TEXT = By.xpath("(//textarea[@id='PostTextArea'])[2]");
	 private final By POST_CONTENT = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[6]/div)[2]/div)[1]");
	 private final By SELECT_CITY = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[6]/div)[2]/div)[3]");
	 private final By UPLOAD_IMAGE = By.xpath("(//div[@class='add-image'])[3]");
	 private final By WEBSITE_ADDRESS = By.xpath("(//input[@class='sk-input sk-outlined-input sk-large'])[2]");
	 private final By BRANCH = By.xpath("(//div[@class='sk-event-group'])[23]");
	 private final By SELECT_CHECK_BOX = By.xpath("(//ul[@class='location-filter-list']//div)[5]");
	 private final By SELECT_CHECK_BOX1 = By.xpath("(//ul[@class='location-filter-list']//div)[8]");
	 private final By APPLY = By.xpath("(//button[.//span[text()='Apply']])[13]");
	 private final By PUBLISH_BTN = By.xpath("(//button[@class='sk-button sk-primary'])[26]");
	 
    String writeApost ="Welcome to";
    String writeApost1 ="the trusted source for you to navigate top countries, universities, and courses while pursuing your dreams of studying abroad.";
    String title ="Enter a brief but catchy title";
    String websiteAddress ="www.sulekha.com";
    
    public BulkPostUpload(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }
    
    public BulkPostUpload clickInsights() {
    	
        waitForElementAndClick(INSIGHTS);
       
        waitForElementAndClick(PROFILE);
        PageLoad.pause();
        waitForElementAndClick(POST);
        takeScreenshot();
        return this;

    
    }
    
    public BulkPostUpload addCompanyName() {
    	PageLoad.pause();  	
    	waitForElementAndClick(WRITE_A_POST_TEXT);
    	PageLoad.pause();
    	driver.findElement(By.xpath("(//textarea[@id='PostTextArea'])[2]")).sendKeys(writeApost);
    	PageLoad.pause();
    	waitForElementAndClick(POST_CONTENT);
    	PageLoad.pause();
    	driver.findElement(By.xpath("(//textarea[@id='PostTextArea'])[2]")).sendKeys(writeApost1);
    	PageLoad.pause();
    	waitForElementAndClick(SELECT_CITY);
    	test.log(Status.INFO, " Write a post successfully.");
    	takeScreenshot();
    	 return this;
    
    
    
    }
    public BulkPostUpload clickUploadBtn() {
	    PageLoad.pause();
		waitForElementAndClick(UPLOAD_IMAGE);
		
	  return this; 
	  }
    public void uploadDoc(String name, String filename) {
   	 
		try {
 
			PageLoad.pause();
 
			StringSelection selection = new StringSelection(filename);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
 
			 test.log(Status.INFO, "uploaded successfully.");
			 takeScreenshot();
			 scroll(WEBSITE_ADDRESS);
			 PageLoad.pause();
			 enterWebsiteAddress();
			 PageLoad.pause();
			 publish();
			 
			
 
		} catch (Exception e) {
 
			 test.log(Status.INFO, " is uploaded failed.");
 
			// TODO: handle exception
			
		}
	}

    public BulkPostUpload enterWebsiteAddress() {
	    
		waitForElementAndClick(WEBSITE_ADDRESS);
		PageLoad.pause();
		driver.findElement(By.xpath("(//input[@class='sk-input sk-outlined-input sk-large'])[2]")).sendKeys(websiteAddress);
		PageLoad.pause();
		waitForElementAndClick(BRANCH);
		PageLoad.pause();
		waitForElementAndClick(SELECT_CHECK_BOX);
		PageLoad.pause();
		waitForElementAndClick(SELECT_CHECK_BOX1);
		PageLoad.pause();
		waitForElementAndClick(APPLY);
		 takeScreenshot();
		 
		 
	  return this; 
	  
    }
    public void publish() {
    	PageLoad.pause();
        waitForElementAndClick(PUBLISH_BTN);
        test.log(Status.INFO, "Post Updated successfully.");
        PageLoad.pause();
        takeScreenshot();
    }

}























