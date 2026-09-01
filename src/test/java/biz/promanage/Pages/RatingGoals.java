package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.LocalDate;

public class RatingGoals extends BasePage {

	 String Group_Name = "AutomationCustomgroup";
	 String state = "Tamil Nadu";
    
    private final By Group_Goals = By.xpath("((//div[@class='sk-menu sk-scrollable'])[2]//li)[2]");
    private final By Search_GRoup_Name = By.xpath("//div[@class='sk-text-field sk-small']//input");
    private final By Group_Name1 = By.xpath("((//div[@class='sk-data-table']//tr)[2]//td)[1]");
    private final By Store_Wise_Goals = By.xpath("((//div[@class='sk-menu sk-scrollable'])[2]//li)[1]");
    private final By Step_Up_Target = By.xpath("(//div[@class='sk-flex-row sk-margin-bottom']//button)[1]");
    private final By Drop_Down = By.xpath("(//div[@class='sk-event-group'])[3]//span");
    By LOCATION_SEARCH_BOX = By.cssSelector(".filter-padding .sk-input");
    By SELECT_STATE = By.cssSelector(".location-filter-list .sk-check-label");
    By APPLY_BUTTON = By.cssSelector(".sk-flex-align-center .sk-button:nth-child(2) > .sk-ripple-container");
    private final By Increment_Drop_Down = By.xpath("(//div[@class='sk-event-group'])[4]//span");
    private final By Select_Value = By.xpath("(//div[@class='sk-overflow-list sk-show']//li)[4]");
    private final By Submit = By.xpath("(//div[@class='sk-button-group sk-flex-justify-end']//button)[8]");
    private final By View_History = By.xpath("//div[@class='sk-flex-row sk-margin-bottom']/div//button");
    private final By User_Name = By.xpath("((//div[@class='sk-group-dropdown'])[2]//div)[2]//p");
    private final By User_Name_History = By.xpath("((//div[@class='sk-data-table']//tr)[2]//td)[1]");
    
    
    
    public RatingGoals(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public RatingGoals load() {
    	System.out.println("\nTo Create Rating Goals : ");
        load("/app/RatingGoals");
        System.out.println("\nRating Goals Page loaded");
        waitForPageLoaderToDisappear();
      //  waitForElementToBeVisible(img);
        takeScreenshot();
        return this;
    }
    
    public RatingGoals clickGroupGoals() {

        waitForElementAndClick(Group_Goals);
        PageLoad.pauseOneSec();

        waitForElementAndClick(Search_GRoup_Name);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        WebElement groupSearchInput = driver.findElement(By.xpath("//div[@class='sk-text-field sk-small']//input"));

        sendDelayedKeys(groupSearchInput, Group_Name);
        PageLoad.pauseThreeSecs();

        WebElement groupNameElement = driver.findElement(By.xpath("((//div[@class='sk-data-table']//tr)[2]//td)[1]"));

        String groupName = groupNameElement.getText().trim();
        System.out.println("Group Name: " + groupName);

        String inputText = groupSearchInput.getAttribute("value").trim();
        System.out.println("Search Input Text: " + inputText);
        takeScreenshot();
        Assert.assertEquals(inputText,groupName,"Search group name and table group name are not matching");

        System.out.println("Both group names are matching successfully");

        return this;
    }


    public RatingGoals clickStoreWiseGoals() {
        waitForElementAndClick(Store_Wise_Goals);
        System.out.println("Clicking on Store Wise Goals");
        takeScreenshot();
        waitForElementAndClick(Step_Up_Target);
        System.out.println("Clicking on Step Up Target");
        takeScreenshot();
        waitForElementAndClick(Drop_Down);
        System.out.println("Clicking on Drop Down");
        takeScreenshot();
        waitForElementAndClick(LOCATION_SEARCH_BOX);
        System.out.println("Search box: Entering value in state search box successfully");
        test.log(Status.INFO, "Entering value in state search box successfully");
        sendDelayedKeys(driver.findElement(By.cssSelector(".filter-padding .sk-input")), state);
        PageLoad.pauseOneSec();
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATE)).click();
        System.out.println("Select State: Selecting value from state dropdown successfully");
        PageLoad.pauseOneSec();
        takeScreenshot();
        wait.until(ExpectedConditions.elementToBeClickable(APPLY_BUTTON)).click();
        System.out.println("Apply: Clicking Apply button successfully");
        takeScreenshot();
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Increment_Drop_Down);
        System.out.println("Clicking on Increment Drop Down successfully");
        PageLoad.pauseOneSec();
        waitForElementAndClick(Select_Value);
        System.out.println("Taking screenshot after selecting the value");
        takeScreenshot();
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Submit);
        System.out.println("Clicking on Submit button");
        PageLoad.pauseOneSec();
        takeScreenshot();
        return this;
    }
    
    public RatingGoals clickViewHistory() {
    	PageLoad.pauseFifteenSeconds();
        waitForElementAndClick(View_History);

        // 1. Assert top-right logged-in user name
        WebElement topUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='sk-group-dropdown'])[2]//div)[2]//p")));
        System.out.println("Top-right logged-in user name: " + topUserName.getText().trim());
        PageLoad.pauseThreeSecs();
        Assert.assertEquals(topUserName.getText().trim(), "AutomationTesting", "Top-right logged-in user name does not match");

        // 2. Assert first row's "User Name" column value in the table
        WebElement tableUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='sk-data-table']//tr)[2]//td)[1]")));
        System.out.println("Table row User Name: " + tableUserName.getText().trim());
        Assert.assertEquals(tableUserName.getText().trim(), "AutomationTesting", "Table row User Name does not match logged-in user");
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    