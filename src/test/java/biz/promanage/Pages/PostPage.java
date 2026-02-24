package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class PostPage extends BasePage {
	private final By INSIGHTS = By.xpath("//span[text()='Insights']//parent::a");
    private final By LSTING_MANAGEMENT = By.xpath("//span[text()='Listing Management']//parent::a");
    private final By ADD_POST_BTN = By.xpath("//button[@class='sk-button sk-primary sk-fab sk-leading-icon fab-bottom']");
    private final By POST = By.xpath("(//div[@class='sticky-top-scroll']//div[@class='sk-surface sk-sticky profile-menu-item']//ul//li)[3]");
    private final By POST_CONTENT = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[1]//div)[2]//div)[1]");
    private final By SELECT_CITY = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[1]//div)[2]//div)[3]");
    private final By UPLOAD_IMAGE = By.xpath("(//div[@class='add-image'])[2]");

    private final By WEBSITE_ADDRESS = By.xpath("//input[@placeholder='Enter website address']");
    private final By PUBLISH_BTN = By.xpath("((//div[@class='sk-button-group sk-flex-justify-end'])[8]//button)[2]");
    private final By BUSINESS_PROFILE = By.xpath("//span[text()='Business Profiles']//parent::a");
    private final By BUSINESS_PROFILE_ID = By.xpath("(//div[@class='profile-list-wrapper']//a)[2]");
    private final By WRITE_A_POST_TEXT = By.xpath("//textarea[@id='PostTextArea']");
    private final By IMAGE_NAME_TEXT = By.xpath("//textarea[@id='ImageNameTextArea']");
    private final By IMAGE_NAME = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[2]/div)[2]/div)[1]");
    private final By IMAGE_CITY = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[2]/div)[2]/div)[2]");
    private final By IMAGE_AREA = By.xpath("(((//div[@class='chat-input-action sk-form-group'])[2]/div)[2]/div)[3]");
    private final By SEND_FOR_APPROVAL = By.xpath("//label[contains(text(), 'Send for Approval')]");
  

    String writeApost = "Welcome to";
    String writeApost1 = "the trusted source for you to navigate top countries, universities, and courses while pursuing your dreams of studying abroad.";

    public PostPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }
    
    public PostPage clickInsights() {
    	System.out.println("\nTo Create Post : ");
		System.out.println("\nAttempting to click on Insights");
    	PageLoad.pauseThreeSecs();
        waitForElementAndClick(INSIGHTS);
        test.log(Status.INFO, "Clicked on Insights");
        return this;
    }

    public PostPage clickListingManagement() {
        waitForElementAndClick(LSTING_MANAGEMENT);
        System.out.println("Clicked on Listing Management");
        test.log(Status.INFO, "Clicked on Listing Management");
        return this;
    }

    public PostPage clickBusinessProfile() {
        waitForElementAndClick(BUSINESS_PROFILE);
        System.out.println("Clicked on Business Profiles");
        test.log(Status.INFO, "Clicked on Business Profiles");
        return this;
    }

    public PostPage clickBusinessProfileId() {
        waitForElementAndClick(BUSINESS_PROFILE_ID);
        PageLoad.pauseThreeSecs();
        System.out.println("Selected Business Profile ID");
        test.log(Status.INFO, "Selected Business Profile ID");
        return this;
    }

    public PostPage clickPost() {
        waitForElementAndClick(POST);
        System.out.println("Clicked on Post");
        test.log(Status.INFO, "Clicked on Post");
        return this;
    }

    public PostPage addNewPost() {
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(ADD_POST_BTN);
        System.out.println("Clicked Add Post button");
        test.log(Status.INFO, "Clicked Add Post button");
        return this;
    }

    public PostPage addCompanyName() {
        PageLoad.pause();
        waitForElementAndClick(WRITE_A_POST_TEXT);
        driver.findElement(WRITE_A_POST_TEXT).sendKeys(writeApost);
        PageLoad.pause();
        waitForElementAndClick(POST_CONTENT);
        driver.findElement(WRITE_A_POST_TEXT).sendKeys(writeApost1);
        PageLoad.pause();
        waitForElementAndClick(SELECT_CITY);
        System.out.println("Write a post successfully");
        test.log(Status.INFO, "Write a post successfully");
        takeScreenshot();
        
        clickSendForApproval();
        publish();
        return this;
    }

    public PostPage clickUploadBtn() {
        PageLoad.pauseTenSeconds();
        waitForElementAndClick(UPLOAD_IMAGE);
        System.out.println("Clicked on Upload Image button");
        test.log(Status.INFO, "Clicked on Upload Image button");
        
       
        return this;
    }

    public void uploadDoc(String name, String filename) {
        try {
            PageLoad.pauseTenSeconds();
            StringSelection selection = new StringSelection(filename);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("File uploaded successfully: " + filename);
            test.log(Status.INFO, "File uploaded successfully: " + filename);
            takeScreenshot();
           

        } catch (Exception e) {
            System.out.println("File upload failed: " + e.getMessage());
            test.log(Status.FAIL, "File upload failed: " + e.getMessage());
        }
    }

    public void publish() {
        PageLoad.pause();
        waitForElementAndClick(PUBLISH_BTN);
        System.out.println("Post Published successfully");
        test.log(Status.INFO, "Post Published successfully");
        PageLoad.pause();
        takeScreenshot();
    }

    public PostPage enterWebsiteAddress(String address) {
        driver.findElement(WEBSITE_ADDRESS).sendKeys(address);
        System.out.println("Entered Website Address: " + address);
        test.log(Status.INFO, "Entered Website Address: " + address);
        return this;
    }

    public PostPage imageName() {       
        WebElement element = driver.findElement(IMAGE_NAME_TEXT);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForElementAndClick(IMAGE_NAME_TEXT);
        waitForElementAndClick(IMAGE_NAME);
        waitForElementAndClick(IMAGE_CITY);
        waitForElementAndClick(IMAGE_AREA);
        System.out.println("Entered Image details (Name, City, Area)");
        test.log(Status.INFO, "Entered Image details (Name, City, Area)");
        return this;
    }

    public PostPage clickSendForApproval() {
        WebElement element = driver.findElement(SEND_FOR_APPROVAL);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click the element
        waitForElementAndClick(SEND_FOR_APPROVAL);
        System.out.println("Clicked on Send for Approval");
        return this;
    }
}
