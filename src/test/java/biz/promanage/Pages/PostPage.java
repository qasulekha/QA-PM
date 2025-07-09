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

public class PostPage extends BasePage {
	private final By LSTING_MANAGEMENT = By.xpath("//span[text()='Listing Management']//parent::a");
    private final By ADD_POST_BTN = By.xpath("//button[@class='sk-button sk-primary sk-fab sk-leading-icon fab-bottom']");
    private final By POST = By.xpath("(//div[@class='sticky-top-scroll']//div[@class='sk-surface sk-sticky profile-menu-item']//ul//li)[3]");
    private final By POST_CONTENT = By.xpath(("(((//div[@class='chat-input-action sk-form-group'])[1]//div)[2]//div)[1]"));
    private final By SELECT_CITY = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[1]//div)[2]//div)[3]");
    private final By UPLOAD_IMAGE = By.xpath("(//div[@class='add-image'])[2]");
    //private final By UPLOAD_IMAGE = By.xpath("//span[text()='Browse Files']");
 
    private final By WEBSITE_ADDRESS = By.xpath("//input[@placeholder='Enter website address']");
    private final By PUBLISH_BTN = By.xpath("((//div[@class='sk-button-group sk-flex-justify-end'])[8]//button)[2]");
    private final By BUSINESS_PROFILE = By.xpath("//span[text()='Business Profiles']//parent::a");; 
    private final By BUSINESS_PROFILE_ID = By.xpath("(//div[@class='profile-list-wrapper']//a)[2]"); 
    //private final By WRITE_A_POST_TEXT = By.xpath("(//div[@class='sk-text-field'])[1]/textarea");
    private final By WRITE_A_POST_TEXT = By.xpath("//textarea[@id='PostTextArea']");
    
    private final By IMAGE_NAME_TEXT = By.xpath("//textarea[@id='ImageNameTextArea']");
    
    private final By IMAGE_NAME = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[2]/div)[2]/div)[1]");
    private final By IMAGE_CITY = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[2]/div)[2]/div)[2]");
    private final By IMAGE_AREA = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[2]/div)[2]/div)[3]");
  
    private final By OFFER = By.xpath("((//div[@class='post-type sk-margin-top-0'])[1]//div)[2]");
    private final By GIVE_TITLE = By.xpath("(//input[@class='sk-input'])[13]");
    String writeApost ="Welcome to";
    String writeApost1 ="the trusted source for you to navigate top countries, universities, and courses while pursuing your dreams of studying abroad.";
    String title ="Enter a brief but catchy title";
    public PostPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }
    public PostPage clickListingManagement() {
        waitForElementAndClick(LSTING_MANAGEMENT);
        return this;
    }

    public PostPage clickBusinessProfile() {
        waitForElementAndClick(BUSINESS_PROFILE);
        return this;
    }
    public PostPage clickBusinessProfileId() {
        waitForElementAndClick(BUSINESS_PROFILE_ID);
        PageLoad.pauseThreeSecs();;
        return this;
    }
    public PostPage clickPost() {
        waitForElementAndClick(POST);
        return this;
    }

    
    public PostPage addNewPost() {
    	PageLoad.pauseThreeSecs();
        waitForElementAndClick(ADD_POST_BTN);
        return this;
    }

    public PostPage addCompanyName() {
    	PageLoad.pause();
    	//Thread.sleep(null);   	
    	waitForElementAndClick(WRITE_A_POST_TEXT);
    	PageLoad.pause();
    	driver.findElement(By.xpath("//textarea[@id='PostTextArea']")).sendKeys(writeApost);
    	PageLoad.pause();
    	waitForElementAndClick(POST_CONTENT);
    	PageLoad.pause();
    	driver.findElement(By.xpath("//textarea[@id='PostTextArea']")).sendKeys(writeApost1);
    	PageLoad.pause();
    	waitForElementAndClick(SELECT_CITY);
    	test.log(Status.INFO, " Write a post successfully.");
    	takeScreenshot();
        return this;
    }
	
	  public PostPage clickUploadBtn() {
	    PageLoad.pause();
		waitForElementAndClick(UPLOAD_IMAGE);
		
	  return this; 
	  }
	 
    
    public void uploadDoc(String name, String filename) {
    	 
		try {
 
			PageLoad.pauseThreeSecs();
 
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
			 imageName();
			 publish();
			// addNewPost();
			// offerClick();
			
 
		} catch (Exception e) {
 
			 test.log(Status.INFO, " is uploaded failed.");
 
			// TODO: handle exception
			
		}
	}

    public void publish() {
    	PageLoad.pause();
        waitForElementAndClick(PUBLISH_BTN);
        test.log(Status.INFO, "Post Updated successfully.");
        PageLoad.pause();
        takeScreenshot();
    }
    
    public PostPage enterWebsiteAddress(String address) {
        driver.findElement(WEBSITE_ADDRESS).sendKeys(address);
        return this;
    }
    public PostPage imageName() {
    	PageLoad.pause();
    	waitForElementAndClick(IMAGE_NAME_TEXT);
    	PageLoad.pause();
    	waitForElementAndClick(IMAGE_NAME);
    	PageLoad.pause();
    	waitForElementAndClick(IMAGE_CITY);
    	PageLoad.pause();
    	waitForElementAndClick(IMAGE_AREA);
    	return this;	
    	
    }
    
    public PostPage offerClick() {
    PageLoad.pause();
   	waitForElementAndClick(OFFER);
   	PageLoad.pause();
   	waitForElementAndClick(UPLOAD_IMAGE);
   	takeScreenshot();
	PageLoad.pause();
	driver.findElement(By.xpath("(//input[@class='sk-input'])[13]")).sendKeys(title);
	test.log(Status.INFO, " Write a Text successfully.");
    return this;	
    }
    public void uploadFile1(String filePath, String string) {
        try {
            PageLoad.pauseThreeSecs();

            // Set the file path to clipboard
            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // Simulate Ctrl+V and Enter using Robot
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            test.log(Status.INFO, "File uploaded successfully: " + filePath);
            takeScreenshot();

        } catch (Exception e) {
            test.log(Status.INFO, "File upload failed: " + e.getMessage());
            e.printStackTrace(); // This helps during debugging
        }
    }
}
