package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class InsightsCalls extends BasePage {
	
	  By INSIGHTS = By.xpath("//span[text()='Insights']//parent::a");
	  By YOUR_TOTAL_CALLS_LOCATOR = By.xpath("//div[@class='total-call-bg']//ul//div");
	  By YOUR_CONNECTS_LOCATOR = By.xpath("(((//div[@class='sk-flex-row sk-margin-bottom-small'])[2]//div)[1]//b)[2]");
	  By YOUR_MISSED_LOCATOR = By.xpath("(((//div[@class='sk-flex-row sk-margin-bottom-small'])[2]//div)[9]//b)[2]");
	  By YOUR_NOT_CONNECTED_LOCATOR = By.xpath("(((//div[@class='sk-flex-row sk-margin-bottom-small'])[2]//div)[17]//b)[2]");
	 
	  By Insights_Calls = By.xpath("(//div[@class='sticky-top-scroll']//ul//li)[4]");
	  
	  By Insights_Total_Calls = By.xpath("(//div[@class='sk-flex-row sk-no-wrap'])[1]//b");
	  By Connects_Calls = By.xpath("((//div[@class='sk-flex-row sk-margin-bottom-small']//div)[1]//b)[2]");
	  By Missed_Calls = By.xpath("((//div[@class='sk-flex-row sk-margin-bottom-small']//div)[13]//b)[2]");
	  By Not_Connected_Calls = By.xpath("((//div[@class='sk-flex-row sk-margin-bottom-small']//div)[25]//b)[2]");
	  By Calls = By.xpath("(//div[@class='sk-card-primary'])[7]//h5");
	  By View_Details = By.xpath("(//button[.//span[normalize-space()='View Details']])[5]");
	
	  private String dashboardTotal;
	  private String dashboardConnects;
	  private String dashboardMissed;
	  private String dashboardNotConnected;

	  private String insightsTotal;
	  private String insightsConnects;
	  private String insightsMissed;
	  private String insightsNotConnected;
	  
	 


    public InsightsCalls(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public InsightsCalls clickInsights() {
    	System.out.println("\nTo Validate InsightsCalls : ");
    	
		System.out.println("\nClicked on Insights");
        waitForElementAndClick(INSIGHTS);
        PageLoad.pauseThreeSecs();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");
        waitForElementAndClick(Calls);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500);");
        PageLoad.pauseThreeSecs();
        
        // Capture Dashboard values before navigation
         dashboardTotal = getTotalCalls();
         dashboardConnects = getConnects();
         dashboardMissed = getMissed();
         dashboardNotConnected = getNotConnected();

        // Navigate to Insights Calls details
        clickViewDeatails();
        PageLoad.pauseThreeSecs();

        // Capture Insights values
         insightsTotal = getInsightsTotalCalls();
         insightsConnects = getInsightsConnects();
         insightsMissed = getInsightsMissed();
         insightsNotConnected = getInsightsNotConnected();

        return this;
    }
    public InsightsCalls createInsightsCalls() {

        Assert.assertEquals(insightsTotal, dashboardTotal, "Total Calls mismatch");

        Assert.assertEquals(insightsConnects, dashboardConnects, "Connects mismatch");

        Assert.assertEquals(insightsMissed, dashboardMissed, "Missed Calls mismatch");

        Assert.assertEquals(insightsNotConnected, dashboardNotConnected, "Not Connected Calls mismatch");

        System.out.println("All Dashboard and Insights call counts match.");

        return this;
    }
  

 // Get Total Calls
    public String getTotalCalls() {
        String totalCalls = driver.findElement(YOUR_TOTAL_CALLS_LOCATOR).getText();

        System.out.println("Total Calls: " + totalCalls);
        return totalCalls;
    }

    // Get Connects
    public String getConnects() {
        String connects = driver.findElement(YOUR_CONNECTS_LOCATOR).getText();

        System.out.println("Connects: " + connects);
        return connects;
    }

    // Get Missed
    public String getMissed() {
        String missed = driver.findElement(YOUR_MISSED_LOCATOR).getText();

        System.out.println("Missed: " + missed);
        return missed;
    }

    // Get Not Connected
    public String getNotConnected() {
        String notConnected = driver.findElement(YOUR_NOT_CONNECTED_LOCATOR).getText();

        System.out.println("Not Connected: " + notConnected);
        return notConnected;
    }
    public InsightsCalls clickViewDeatails() {
		/*
		 * waitForElementAndClick(View_Deatials);
		 * System.out.println("Insights Calls : Clicking Insights Calls");
		 * takeScreenshot(); return this;
		 */
    	((JavascriptExecutor) driver).executeScript(
    	        "var widget = document.getElementById('promanage-widget');" +
    	        "if (widget) widget.style.setProperty('pointer-events', 'none', 'important');"
    	    );

    	    try {
    	        wait.until(ExpectedConditions.elementToBeClickable(View_Details));
    	        waitForElementAndClick(View_Details);
    	        
    	        

    	        test.log(Status.PASS, "View Details CTA clicked successfully");
    	        System.out.println("View Details: CTA clicked successfully");

    	    } finally {
    	        // Restore the widget's normal pointer behavior.
    	        ((JavascriptExecutor) driver).executeScript(
    	            "var widget = document.getElementById('promanage-widget');" +
    	            "if (widget) widget.style.removeProperty('pointer-events');"
    	        );
    	    }

    	    return this;
    	}
   
 
    public String getInsightsTotalCalls() {
        String totalCalls = driver.findElement(Insights_Total_Calls).getText();
        System.out.println("Insights Total Calls: " + totalCalls);
        return totalCalls;
    }

    public String getInsightsConnects() {
        String connects = driver.findElement(Connects_Calls).getText();
        System.out.println("Insights Connects: " + connects);
        return connects;
    }

    public String getInsightsMissed() {
        String missed = driver.findElement(Missed_Calls).getText();
        System.out.println("Insights Missed Calls: " + missed);
        return missed;
    }

    public String getInsightsNotConnected() {
        String notConnected = driver.findElement(Not_Connected_Calls).getText();
        System.out.println("Insights Not Connected Calls: " + notConnected);
        return notConnected;
    }

}
