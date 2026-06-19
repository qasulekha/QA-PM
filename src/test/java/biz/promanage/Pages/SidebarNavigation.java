package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.driverManager.DevToolsHelper;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class SidebarNavigation extends BasePage {
	
    private final By align = By.xpath("//span[text()='Align']/parent::a[1]");
    private final By insight = By.xpath("//span[text()='Insights']/parent::a[1]");
    private final By report = By.xpath("//span[text()='Reports']/parent::a[1]");
    private final By rankTracker = By.xpath("//span[text()='Rank tracker']/parent::a[1]");
    private final By realTime = By.xpath("//span[text()='Real-time Tracker']/parent::a[1]");
    private final By scheduledTracker = By.xpath("//span[text()='Scheduled Tracker']/parent::a[1]");
    private final By ratingGoles = By.xpath("//span[text()='Rating Goals']/parent::a[1]");
    private final By listingManagement = By.xpath("//span[text()='Listing Management']/parent::a[1]");
    private final By listings = By.xpath("//span[text()='Listings']/parent::a[1]");
    private final By businessProfiles = By.xpath("//span[text()='Business Profiles']/parent::a[1]");
    private final By activityApproval = By.xpath("//span[text()='Activity Approval']/parent::a[1]");
    private final By bulkUploadTracker = By.xpath("//span[text()='Bulk Upload Tracker']/parent::a[1]");
    private final By duplicateListings = By.xpath("//span[text()='Duplicate Listings']/parent::a[1]");
    private final By platform = By.xpath("//span[text()='Platforms']/parent::a[1]");
    private final By reputationManagement = By.xpath("//span[text()='Reputation Management']/parent::a[1]");
    private final By reviews = By.xpath("//span[text()='Reviews']/parent::a[1]");
    private final By tickets = By.xpath("//span[text()='Tickets']/parent::a[1]");
    private final By imagePrediction = By.xpath("//span[text()='Image Prediction']/parent::a[1]");
    private final By leaderboard = By.xpath("//span[text()='Leaderboard']/parent::a[1]");
    private final By questionAndAnswer = By.xpath("//span[text()='Question and Answer']/parent::a[1]");
    private final By mentions = By.xpath("//span[text()='Mentions']/parent::a[1]");
    private final By interaction = By.xpath("//span[text()='Interactions']/parent::a[1]");
    private final By callLogs = By.xpath(" //span[text()='Call Logs']/parent::a[1]");
    private final By contacts = By.xpath("//span[text()='Contacts']/parent::a[1]");
    private final By contactGroup = By.xpath("//span[text()='Contact Group']/parent::a[1]");
    private final By chat = By.xpath(" //span[text()='Chats']/parent::a[1]");
    private final By campaignSMS = By.xpath("//span[text()='SMS Campaigns']/parent::a[1]");
    private final By userManagement = By.xpath("//span[text()='User Management']/parent::a[1]");
    private final By switchTenant = By.xpath("//span[text()='Switch Tenant']/parent::a[1]");
    private final By settings = By.xpath("//span[text()='Settings']/parent::a[1]");
    private final By back = By.xpath("(//span[@class='sk-ripple-container'])[1]");
    
    
    private final By alignTitle = By.cssSelector("div.sk-title-primary");
    private final By insightTitle = By.cssSelector("div.sk-title-primary");
    private final By reportTitle = By.cssSelector("div.sk-title-primary");
    private final By rankTrackerTitle = By.cssSelector("div.sk-title-primary");
    private final By bulkUploadTrackerTitle = By.cssSelector("div.sk-title-primary");
    private final By ratingGolesTitle = By.cssSelector("div.sk-title-primary");
    private final By listingsTitle = By.cssSelector("div.sk-title-primary");
    private final By businessProfilesTitle = By.cssSelector("div.sk-title-primary");
    private final By activityApprovalTitle = By.cssSelector("div.sk-title-primary");
    private final By duplicateListingsTitle = By.cssSelector("div.sk-title-primary");
    private final By platformTitle = By.cssSelector("div.sk-title-primary");
    private final By reviewsTitle = By.cssSelector("div.sk-title-primary");
    private final By ticketsTitle = By.cssSelector("div.sk-title-primary");
    private final By imagePredictionTitle = By.cssSelector("div.sk-title-primary");
    private final By leaderboardTitle = By.cssSelector("div.sk-title-primary");
    private final By questionAndAnswerTitle =By.cssSelector("div.sk-title-primary");
    private final By mentionsTitle = By.cssSelector("div.sk-title-primary");   
    private final By callLogsTitle = By.cssSelector("h4.sk-h4");
    private final By contactsTitle = By.cssSelector("div.sk-title-primary");
    private final By contactGroupTitle = By.cssSelector("div.sk-title-primary");
    private final By chatTitle = By.cssSelector("h4.sk-h4");
    private final By campaignSMSTitle = By.cssSelector("div.sk-title-primary");
    private final By userManagementTitle = By.cssSelector("div.sk-title-primary");
    private final By switchTenantTitle = By.cssSelector("div.sk-title-primary");
    private final By settingsTitle = By.cssSelector("div.sk-title-primary");
  
   
  
  
    
    
   
    
    
    

    public SidebarNavigation(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public SidebarNavigation load() {
        test.log(Status.INFO, "Home Page Loaded");
        takeScreenshot();
        return this;
    }

    public SidebarNavigation clickAlignPage() {
        test.log(Status.INFO, "Clicking on Align Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(align)).click();
        String alignPageTitle = driver.findElement(alignTitle).getText();
        Assert.assertEquals(alignPageTitle, "Align", "Align page title mismatch!");
        System.out.println("Align Page Title :" + alignPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		/*
		 * clickInsightPage(); clickReportPage(); clickRankTrackerPage();
		 * clickRatingGolesPage(); clickListingsPage(); clickBusinessProfilesPage();
		 * clickActivityApprovalPage(); // clickBulkUploadTrackerPage();
		 * clickDuplicateListingsPage(); clickPlatformPage(); clickReviewsPage();
		 * clickTicketsPage(); clickImagePredictionPage(); clickLeaderboardPage();
		 * clickQuestionAndAnswerPage(); clickmentionsPage(); clickCallsPage();
		 * clickContactsPage(); clickContactGroupPage(); clickChatPage();
		 * clickCampaignSMSPage(); clickUserManagementPage(); clickSwitchTenantPage();
		 * clickSettingsPage();
		 */
        
        return this;
  
        
    }
    
    public SidebarNavigation clickInsightPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Insights Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(insight)).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(insightTitle));
        String insightPageTitle = driver.findElement(insightTitle).getText();
        Assert.assertEquals(insightPageTitle, "Insights-My Dashboard", "Insights page title mismatch!");
        System.out.println("Insight Page Title :" + insightPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickReportPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Reports Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(report)).click();
        String reportsPageTitle = driver.findElement(reportTitle).getText();
        Assert.assertEquals(reportsPageTitle, "Reports", "Reports page title mismatch!");
        System.out.println("Reports Page Title :" + reportsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickRankTrackerPage() {
    	PageLoad.pauseOneSec();
    	wait.until(ExpectedConditions.elementToBeClickable(rankTracker)).click();
    	PageLoad.pause();
        test.log(Status.INFO, "Clicking on Real time Rank Tracker Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(realTime)).click();
        String realTimeTrackerPageTitle = driver.findElement(By.xpath("//div[@class='filter-group-wrapper']/preceding::div[contains(@class,'sk-title-primary')][1]")).getText();
        //  System.out.println(bulkUploadTrackerPageTitle);
          if(realTimeTrackerPageTitle.contains("Real-Time Keyword Rank Tracker")) {
          	
          } else {
          	Assert.assertEquals(false, true);
          }
         // Assert.assertEquals(bulkUploadTrackerPageTitle, "arrow_back Bulk Upload Tracker", "Bulk Upload Tracker page title mismatch!");
          System.out.println("Real Time Tracker Page Title :" + realTimeTrackerPageTitle);
          PageLoad.pauseThreeSecs();
          takeScreenshot();
         
          
          
  		return this;
        
    }
    
    public SidebarNavigation clickScheduledTrackerPage() {
    	PageLoad.pauseOneSec();
    	//wait.until(ExpectedConditions.elementToBeClickable(rankTracker)).click();
    	PageLoad.pause();
        test.log(Status.INFO, "Clicking on Scheduled Tracker Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(scheduledTracker)).click();
        String scheduledTrackerPageTitle = driver.findElement(By.xpath("//div[@class='filter-group-wrapper']/preceding::div[contains(@class,'sk-title-primary')][1]")).getText();
        //  System.out.println(bulkUploadTrackerPageTitle);
          if(scheduledTrackerPageTitle.contains("Scheduled Keyword Rank Tracker")) {
          	
          } else {
          	Assert.assertEquals(false, true);
          }
         // Assert.assertEquals(bulkUploadTrackerPageTitle, "arrow_back Bulk Upload Tracker", "Bulk Upload Tracker page title mismatch!");
          System.out.println("Scheduled Tracker Page Title :" + scheduledTrackerPageTitle);
          PageLoad.pauseThreeSecs();
          takeScreenshot();
  		return this;
        
    }
    public SidebarNavigation clickRatingGolesPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Rating Goles Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(ratingGoles)).click();
        String ratingGolesPageTitle = driver.findElement(ratingGolesTitle).getText();
        Assert.assertEquals(ratingGolesPageTitle, "Rating Goals", "Rating Goals page title mismatch!");
        System.out.println("Rating Goals Page Title :" + ratingGolesPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickListingsPage() {
    	PageLoad.pauseOneSec();
    	wait.until(ExpectedConditions.elementToBeClickable(listingManagement)).click();
    	PageLoad.pause();
        test.log(Status.INFO, "Clicking on Listings Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(listings)).click();
        PageLoad.pause();
        String listingsPageTitle = driver.findElement(listingsTitle).getText();
        Assert.assertEquals(listingsPageTitle, "Listings", "Listings page title mismatch!");
        System.out.println("Listings Page Title :" + listingsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickBusinessProfilesPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Business Profiles Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(businessProfiles)).click();
        PageLoad.pauseThreeSecs();
        String businessProfilePageTitle = driver.findElement(businessProfilesTitle).getText();
        Assert.assertEquals(businessProfilePageTitle, "Business Profiles", "Business Profiles page title mismatch!");
        System.out.println("Business Profiles Page Title :" + businessProfilePageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickActivityApprovalPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on activity Approval PageTitle Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(activityApproval)).click();
        PageLoad.pauseThreeSecs();
        String activityApprovalPageTitle = driver.findElement(activityApprovalTitle).getText();
        Assert.assertEquals(activityApprovalPageTitle, "Activity Approval", "Activity Approval page title mismatch!");
        System.out.println("Activity Approval Page Title :" + activityApprovalPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickBulkUploadTrackerPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Bulk Upload Tracker Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(bulkUploadTracker)).click();
        PageLoad.pauseThreeSecs();
        String bulkUploadTrackerPageTitle = driver.findElement(By.xpath("//div[@class='filter-group-wrapper']/preceding::div[contains(@class,'sk-title-primary')][1]")).getText();
      //  System.out.println(bulkUploadTrackerPageTitle);
        if(bulkUploadTrackerPageTitle.contains("Bulk Upload Tracker")) {
        	
        } else {
        	Assert.assertEquals(false, true);
        }
       // Assert.assertEquals(bulkUploadTrackerPageTitle, "arrow_back Bulk Upload Tracker", "Bulk Upload Tracker page title mismatch!");
        System.out.println("Bulk Upload Tracker Page Title :" + bulkUploadTrackerPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickDuplicateListingsPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Duplicate Listings Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(duplicateListings)).click();
        PageLoad.pauseThreeSecs();
        String duplicateListingsPageTitle = driver.findElement(duplicateListingsTitle).getText();
        Assert.assertEquals(duplicateListingsPageTitle, "Duplicate Listings", "Duplicate Listings page title mismatch!");
        System.out.println("Duplicate Listings  Page Title :" + duplicateListingsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickPlatformPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Platforms Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(platform)).click();
        PageLoad.pauseThreeSecs();
        String platformTitlePageTitle = driver.findElement(platformTitle).getText();
        Assert.assertEquals(platformTitlePageTitle, "Connected Platforms", "Platforms page title mismatch!");
        System.out.println("Platforms Page Title :" + platformTitlePageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
   
    public SidebarNavigation clickReviewsPage() {
    	PageLoad.pauseOneSec();
    	 wait.until(ExpectedConditions.elementToBeClickable(reputationManagement)).click();
        test.log(Status.INFO, "Clicking on Reviews Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(reviews)).click();
        PageLoad.pauseThreeSecs();
        String reviewsPageTitle = driver.findElement(reviewsTitle).getText();
        Assert.assertEquals(reviewsPageTitle, "Reviews", "Reviews page title mismatch!");
        System.out.println("Reviews Page Title :" + reviewsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickTicketsPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Tickets Title Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(tickets)).click();
        PageLoad.pauseThreeSecs();
        String ticketsPageTitle = driver.findElement(ticketsTitle).getText();
        Assert.assertEquals(ticketsPageTitle, "Tickets", "Ticktes page title mismatch!");
        System.out.println("Tickets Page Title :" + ticketsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickImagePredictionPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking onImage prediction Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(imagePrediction)).click();
        PageLoad.pauseThreeSecs();
        String imagePredictionPageTitle = driver.findElement(imagePredictionTitle).getText();
        Assert.assertEquals(imagePredictionPageTitle, "Image Prediction", "Image Prediction page title mismatch!");
        System.out.println("Image Prediction Page Title :" + imagePredictionPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickLeaderboardPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Duplicate Listings Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(leaderboard)).click();
        PageLoad.pauseThreeSecs();
        String leaderboardPageTitle = driver.findElement(leaderboardTitle).getText();
        Assert.assertEquals(leaderboardPageTitle, "Leaderboard", "Leaderboard page title mismatch!");
        System.out.println("Leaderboard  Page Title :" + leaderboardPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickQuestionAndAnswerPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Question And Answer Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(questionAndAnswer)).click();
        PageLoad.pauseThreeSecs();
        String questionAndAnswerPageTitle = driver.findElement(questionAndAnswerTitle).getText();
        Assert.assertEquals(questionAndAnswerPageTitle, "Question and Answer", "Question And Answer page title mismatch!");
        System.out.println("Question And Answer Page Title :" + questionAndAnswerPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickmentionsPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Mentions Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(mentions)).click();
        PageLoad.pauseThreeSecs();
        String mentionsPageTitle = driver.findElement(mentionsTitle).getText();
        Assert.assertEquals(mentionsPageTitle, "Mentions", "Mentions page title mismatch!");
        System.out.println("Mentions Page Title :" + mentionsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
   
   
    public SidebarNavigation clickCallsPage() {
    	 PageLoad.pauseTenSeconds();
    	wait.until(ExpectedConditions.elementToBeClickable(interaction)).click();
        test.log(Status.INFO, "Clicking on Calls Title Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(callLogs)).click();
        PageLoad.pauseTenSeconds();
        String callsPageTitle = driver.findElement(callLogsTitle).getText();
        Assert.assertEquals(callsPageTitle, "Calls", "Calls page title mismatch!");
        System.out.println("Calls Page Title :" + callsPageTitle);
        PageLoad.pauseTwentySeconds();
        takeScreenshot();
        wait.until(ExpectedConditions.elementToBeClickable(back)).click();
        return this;
    }
    
    public SidebarNavigation clickContactsPage() {
    	PageLoad.pauseOneSec();
    	 wait.until(ExpectedConditions.elementToBeClickable(interaction)).click();
        test.log(Status.INFO, "Clicking on Contact Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(contacts)).click();
        PageLoad.pauseThreeSecs();
        String contactsPageTitle = driver.findElement(contactsTitle).getText();
        Assert.assertEquals(contactsPageTitle, "Contacts", "Contact page title mismatch!");
        System.out.println("Contacts Page Title :" + contactsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickContactGroupPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Contacts Group Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(contactGroup)).click();
        PageLoad.pauseThreeSecs();
        String contactGropupPageTitle = driver.findElement(contactGroupTitle).getText();
        Assert.assertEquals(contactGropupPageTitle, "Group", "Contacts Group title mismatch!");
        System.out.println("Contact Group  Page Title :" + contactGropupPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickChatPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Chats Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(chat)).click();
        PageLoad.pauseThreeSecs();
        String chatsPageTitle = driver.findElement(chatTitle).getText();
        Assert.assertEquals(chatsPageTitle, "Chat", "Chats page title mismatch!");
        System.out.println("Chats Page Title :" + chatsPageTitle);
        PageLoad.pauseTenSeconds();
        takeScreenshot();
        wait.until(ExpectedConditions.elementToBeClickable(back)).click();
        return this;
    }
    public SidebarNavigation clickCampaignSMSPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Campaign SMS Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(campaignSMS)).click();
        PageLoad.pauseThreeSecs();
        String campaignSMSPageTitle = driver.findElement(campaignSMSTitle).getText();
        Assert.assertEquals(campaignSMSPageTitle, "Campaign - SMS", "Campaign SMS title mismatch!");
        System.out.println("Campaign SMS Page Title :" + campaignSMSPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    
    
    
    public SidebarNavigation clickUserManagementPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on User Management Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(userManagement)).click();
        PageLoad.pauseThreeSecs();
        String userManagementPageTitle = driver.findElement(userManagementTitle).getText();
        Assert.assertEquals(userManagementPageTitle, "User Management", "User Management page title mismatch!");
        System.out.println("User Management  Page Title :" + userManagementPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
		return this;
        
    }
    public SidebarNavigation clickSwitchTenantPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Switch Tenant Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(switchTenant)).click();
        PageLoad.pauseThreeSecs();
        String switchTenantPageTitle = driver.findElement(switchTenantTitle).getText();
        Assert.assertEquals(switchTenantPageTitle, "Switch Tenant", "Switch Tenant page title mismatch!");
        System.out.println("Switch Tenant Page Title :" + switchTenantPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
    public SidebarNavigation clickSettingsPage() {
    	PageLoad.pauseOneSec();
        test.log(Status.INFO, "Clicking on Settings Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
        PageLoad.pauseThreeSecs();
        String settingsPageTitle = driver.findElement(settingsTitle).getText();
        Assert.assertEquals(settingsPageTitle, "Settings", "Settings page title mismatch!");
        System.out.println("Settings Page Title :" + settingsPageTitle);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        return this;
    }
   
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    



