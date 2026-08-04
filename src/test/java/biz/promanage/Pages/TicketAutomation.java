package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TicketAutomation extends BasePage {
	private final By settings = By.xpath("//span[text()='Settings']/parent::a[1]");
	private final By Ticket_Automation = By.xpath("(((//div[@class='sk-tab-menu'])[3]//ul)[4]//li)[3]");
	private final By Create_Rule = By.xpath("//button[@class='sk-button sk-primary sk-fab']");
	private final By Enter_The_Rule_Name = By.xpath("//div[@class='sk-text-field sk-large']//input");
	private final By Select_location_Dropdown = By.xpath("(//div[@class='sk-event-group'])[9]//span");
	private final By Search_State = By.cssSelector(".filter-padding .sk-input");
	private final By SELECT_STATE = By.cssSelector(".location-filter-list .sk-check-label");
	private final By APPLY_BUTTON = By.cssSelector(".sk-flex-align-center .sk-button:nth-child(2) > .sk-ripple-container");
	private final By Next = By.xpath("((//div[@class='sk-button-group sk-flex-justify-end'])[8]//button)[2]");
	private final By With_Review_Text = By.xpath("(//div[@class='rating-group sk-show']//label)[3]");
	private final By Rating = By.xpath("(//div[@class='rating-group sk-show']//label)[7]");
	private final By Review_Sentiment = By.xpath("(//div[@class='rating-group sk-show']//label)[9]");
	private final By Assign_To = By.xpath("(//ul[@id='skOverflowMenu'])[3]");
	private final By Search_Role = By.xpath("(//div[@class='assign-group sk-show']//input)[3]");
	private final By Comment = By.xpath("(//div[@class='sk-text-field'])[4]//textarea");
	private final By Priority = By.xpath("(//div[@class='assign-group sk-show']//label)[4]");
	private final By Create_A_New_Rule_Yes = By.xpath("((//div[@class='sk-panel-inner'])[10]//button)[5]");
	private final By Rule_Create_A_New_Rule_Yes = By.xpath("((//div[@class='sk-panel-inner'])[11]//button)[4]");
	private final By Elipcse = By.xpath("((//div[@class='sk-surface sk-surface-outlined sk-gutter-base sk-padding-top rule-widget'])[1]//button)[1]");
	private final By Edit = By.xpath("(//div[@class='sk-overflow-list sk-show']//li)[1]");
	private final By Edit_Rule_Conformation = By.xpath("((//div[@class='sk-button-group sk-flex-justify-end'])[6]//button)[2]");
	private final By User_Name = By.xpath("(//div[@class='sk-flex-row sk-margin-bottom-small']//label)[2]");
	private final By Filter = By.xpath("((//div[@class='sk-flex-row sk-no-wrap'])[4]//button)[1]");
	private final By Status = By.xpath("((//div[@class='sk-form-row sk-margin-bottom-large'])[2]//label)[1]");
	private final By Apply = By.xpath("((//div[@class='sk-button-group sk-flex-justify-end'])[7]//button)[2]");
	private final By View_History = By.xpath("((//div[@class='sk-surface sk-surface-outlined sk-gutter-base sk-padding-top rule-widget'])[1]//button)[4]");
	private final By Statu1 = By.xpath("((//div[@class='automation-status'])[1]//span)[3]");
	private final By Stoped = By.xpath("((//div[@class='automation-status'])[2]//span)[3]");
	private final By Ratings = By.xpath("((//div[@class='sk-flex-row sk-flex-align-start sk-margin-bottom-large'])[1]//div)[1]");
	
	
	
	
	
	
	
    String comment = "Sample Testing";
    String state = "Tamil Nadu";
    String AssignTo = "CMO";
    String RuleName ="4 Star Rating";
    String AssignToUser ="CMO User";	
    
    public TicketAutomation(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public TicketAutomation load() {
    	System.out.println("\nTo Create settings : ");
		System.out.println("\nsettings Page loaded");
        logInfo("Loading settings Page");
        load("/app/settings");
        waitForPageLoaderToDisappear();
        takeScreenshot();
        return this;
    }
    public TicketAutomation clickTicketAutomation() {
    	PageLoad.pauseOneSec();
    	scroll(Ticket_Automation); 
        waitForElementAndClick(Ticket_Automation);
        System.out.println("Ticket Automation: Clicking Ticket Automation");
        takeScreenshot();
        return this;
    }
    
    public TicketAutomation clickCreateRule() {
    	 PageLoad.pause();
        waitForElementAndClick(Create_Rule);
        System.out.println("Ticket Automation : Clicking Create Rule");
        takeScreenshot();
        return this;
    }
    public TicketAutomation clickRuleName() {
        waitForElementAndClick(Enter_The_Rule_Name);
        System.out.println("Search box: Entering value in state search box successfully");
        sendDelayedKeys(driver.findElement(By.xpath("//div[@class='sk-text-field sk-large']//input")), RuleName);
        PageLoad.pauseOneSec();
        takeScreenshot();
        return this;
    }
    
    public TicketAutomation clickSelectLocation() {
        waitForElementAndClick(Select_location_Dropdown);
        System.out.println("Select dropdown successfully");
        PageLoad.pauseOneSec();
        sendDelayedKeys(driver.findElement(By.cssSelector(".filter-padding .sk-input")), state);
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATE)).click();
        System.out.println("Select State: Selecting value from state dropdown successfully");
        PageLoad.pauseOneSec();
        takeScreenshot();
        PageLoad.pauseOneSec();
        wait.until(ExpectedConditions.elementToBeClickable(APPLY_BUTTON)).click();
        System.out.println("Apply: Clicking Apply button successfully");
        waitForElementAndClick(Next);
        System.out.println("Next: Clicking Next button successfully");
        return this;
    }
    public TicketAutomation clickReviewType() {
   	 PageLoad.pause();
       waitForElementAndClick(With_Review_Text);
       System.out.println("Review Type : Clicking  with review text selected successfully");
       takeScreenshot();
       PageLoad.pauseThreeSecs();
       waitForElementAndClick(Rating);
       System.out.println("Rating : Clicking  four star rating successfully");
       takeScreenshot();
       PageLoad.pauseThreeSecs();
       waitForElementAndClick(Review_Sentiment);
       System.out.println("Review Sentiment : Clicking  positive  sentiment successfully");
       takeScreenshot();
       waitForElementAndClick(Next);
       System.out.println("Next: Clicking Next button successfully");
       PageLoad.pause();
       return this;
   }
    public TicketAutomation clickAssignToUser() {
   	 PageLoad.pause();
       waitForElementAndClick(Search_Role);
       System.out.println("Search Role : Clicking role successfully");
       takeScreenshot();
       driver.findElement(By.xpath("(//div[@class='assign-group sk-show']//input)[3]")).sendKeys("CMO");
       driver.findElement(By.xpath("(//ul[@id='skOverflowMenu'])[3]")).click();
       PageLoad.pauseThreeSecs();
       sendDelayedKeys(driver.findElement(By.xpath("(//div[@class='sk-text-field'])[4]//textarea")), comment);
       takeScreenshot();
       PageLoad.pauseThreeSecs();
       waitForElementAndClick(Priority);
       System.out.println("Priority : Clicking Priority successfully");
       takeScreenshot();
       waitForElementAndClick(Next);
       System.out.println("Next: Clicking Next button successfully");
       PageLoad.pauseThreeSecs();
       waitForElementAndClick(Create_A_New_Rule_Yes);
       System.out.println("Conformation : Clicking Yes successfully");
       takeScreenshot();
       PageLoad.pause();
       waitForElementAndClick(Rule_Create_A_New_Rule_Yes);
       System.out.println("Rule Conformation : Clicking Yes successfully");
       takeScreenshot();
       
       return this;
   }
    public TicketAutomation clickEdit() {
        waitForElementAndClick(Filter);
        System.out.println("Filter: Clicking filter successfully");
        PageLoad.pauseOneSec();
        waitForElementAndClick(Status);
        PageLoad.pauseOneSec();
        waitForElementAndClick(Apply);
        PageLoad.pauseOneSec();
        takeScreenshot();
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Elipcse);
        PageLoad.pauseOneSec();
        waitForElementAndClick(Edit);
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Edit_Rule_Conformation);
        takeScreenshot();
        PageLoad.pauseOneSec();
        waitForElementAndClick(Next);
        takeScreenshot();
        PageLoad.pauseOneSec();
        waitForElementAndClick(Next);
        takeScreenshot();
        PageLoad.pauseOneSec();
        waitForElementAndClick(User_Name);
        takeScreenshot();	
        PageLoad.pause();
  
        WebElement assignTo = driver.findElement(By.xpath("(//div[@class='assign-group sk-show']//input)[3]"));
        assignTo.clear();
        System.out.println("Search Role : Clicking role successfully");
        takeScreenshot();
        driver.findElement(By.xpath("(//div[@class='assign-group sk-show']//input)[3]")).sendKeys("CMO User");
        driver.findElement(By.xpath("(//ul[@id='skOverflowMenu'])[3]")).click();
        takeScreenshot();
        PageLoad.pauseOneSec();
        waitForElementAndClick(Next);
        PageLoad.pauseOneSec();
        waitForElementAndClick(Rule_Create_A_New_Rule_Yes);
        PageLoad.pauseOneSec();
        waitForElementAndClick(Filter);
        System.out.println("Filter: Clicking filter successfully");
        PageLoad.pauseOneSec();
        waitForElementAndClick(Status);
        PageLoad.pauseOneSec();
        waitForElementAndClick(Apply);
        PageLoad.pauseOneSec();
        waitForElementAndClick(View_History);
        System.out.println("View History: Clicking View History successfully");
        takeScreenshot();
        
		return this;
        
        
    }
    
 // Get latest rule name
    public String getLatestRuleName() {
 
        By latestRule = By.xpath("(//div[contains(@class,'rule-widget')]//h5)[1]");
 
        waitForElementToBeVisible(latestRule);
 
        String ruleName = driver.findElement(latestRule).getText().trim();
 
        System.out.println("Latest Rule : " + ruleName);
 
        return ruleName;
    }
    
// Convert V2 -> V1
    public String getPreviousRuleName(String latestRuleName) {
 
        String previousRule = latestRuleName.replace("-V2", "-V1");
 
        System.out.println("Previous Rule : " + previousRule);
 
        return previousRule;
    }
    
	
    
    public boolean isPreviousRuleStopped() {
 
        By stoppedBadge = By.xpath("//span[normalize-space()='Stopped']");
 
        List<WebElement> stoppedList = driver.findElements(stoppedBadge);
 
        System.out.println("Stopped badge count : " + stoppedList.size());
 
        return stoppedList.size() > 0;
    }

}
