package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActivityApproval extends BasePage {
	private final By LSTING_MANAGEMENT = By.xpath("//span[text()='Listing Management']//parent::a");
    private final By ACTIVITY_APPROVAL = By.xpath("//span[text()='Activity Approval']//parent::a");
    private final By ACTIVITY__TYPE = By.xpath("(//div[@class='sk-flex-row approval-dropdown sk-margin-bottom']/div)[1]");
    private final By ACTIVITY__TYPE_POST = By.xpath("((//div[@class='sk-flex-row approval-dropdown sk-margin-bottom']/div)[1]//child::li)[2]");
    private final By RESPONDED_BY  = By.xpath("(//div[@class='sk-text-select sk-small'])[1]");
    private final By C_USER_TEST = By.xpath("//div[@class='sk-overflow-list sk-show']//li[text()='New CMO ']");
    private final By RESPONDED_BY_CMO = By.xpath("(((//div[@class='sk-data-table'])[1]//tr)[2]//td)[6]//div");
    private final By STATUS = By.xpath("(//div[@class='sk-event-group'])[5]");
    private final By STATUS_APPROVAL = By.xpath("(//div[@class='sk-overflow-list sk-show']//child::li)[3]");

    String writeApost = "Welcome to";
    String writeApost1 = "the trusted source for you to navigate top countries, universities, and courses while pursuing your dreams of studying abroad.";

    public ActivityApproval(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

   
   
    public ActivityApproval clickListingManagement() {
        waitForElementAndClick(LSTING_MANAGEMENT);
        test.log(Status.INFO, "Clicked on Listing Management");
        return this;
    }
    
    public ActivityApproval clickActivityApproval() {
    	 PageLoad.pause();
        waitForElementAndClick(ACTIVITY_APPROVAL);
        System.out.println("Clicked on: Activity Approval");
        test.log(Status.INFO, "Clicked on Activity Approval");
        takeScreenshot();
        return this;
    }

    public ActivityApproval clickActivityType() {
        waitForElementAndClick(ACTIVITY__TYPE);
        PageLoad.pause();
        waitForElementAndClick(ACTIVITY__TYPE_POST);
        System.out.println("Selected Activity Type: Post");
        test.log(Status.INFO, "Selected Activity Type: Post");
        takeScreenshot();
        return this;
    }

    public ActivityApproval clickRespondedBy() {
        waitForElementAndClick(RESPONDED_BY);
        PageLoad.pause();
        WebElement cmoElement = driver.findElement(C_USER_TEST); 
        Actions actions = new Actions(driver); 
        actions.moveToElement(cmoElement).click().build().perform();
       // WebElement element = driver.findElement(CMO);
      //  waitForElementAndClick(CMO);
        
        System.out.println("Selected Responded By: CMO ");
        test.log(Status.INFO, "Selected Responded By: CMO");
        takeScreenshot();
        return this;
    }

    public  ActivityApproval clickStatus() {
        waitForElementAndClick(STATUS);
        PageLoad.pause();
        waitForElementAndClick(STATUS_APPROVAL);
        System.out.println("Selected Status: Status Approval");
        test.log(Status.INFO, "Selected Status: Status Approval");
        takeScreenshot();
        return this;
    }

    

    public String getApproval() {
        PageLoad.pauseThreeSecs();
        String status = driver.findElement(By.xpath("(((//div[@class='sk-data-table'])[1]//tr)[2]//td)[7]//b")).getText();
        test.log(Status.INFO, "Fetched Pending Approval status: " + status);
        return status;
    }
    public String getCMO() {
        PageLoad.pauseThreeSecs();
        String status = driver.findElement(By.xpath("(((//div[@class='sk-data-table'])[1]//tr)[2]//td)[6]//div")).getText();
        test.log(Status.INFO, "Fetched Pending Approval status: " + status);
        return status;
    }
    public String getPost() {
        PageLoad.pauseThreeSecs();
        String status = driver.findElement(By.xpath("(((//div[@class='sk-data-table'])[1]//tr)[2]//b)[1]")).getText();
        test.log(Status.INFO, "Fetched Pending Approval status: " + status);
        return status;
    }
}
