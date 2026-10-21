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

public class UserSettings extends BasePage {
	
	private final By User_Dropdown = By.xpath("(//div[@class='sk-group-dropdown'])[2]");
    private final By My_Settings = By.xpath("((//div[@class='sk-group-dropdown'])[2]//ul//li)[2]");
    private final By ReviewTab = By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[1]");
    private final By New_Reviews = By.xpath("//legend[normalize-space()='New reviews']");
    private final By Email_Box = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[1]//div)[1]//label");
    private final By Select_Rating = By.xpath("((//div[@class='filter-detail'])[1]//div)[1]");
    private final By Un_Responded_Review = By.xpath("//legend[normalize-space()='Un-responded reviews']");
    private final By InApp_Box = By.xpath("(//div[@class='sk-checkbox-group sk-inline'])[7]//div");
    private final By Select_rating1 = By.xpath("((//div[@class='filter-detail'])[2]//ul//label)[1]");
    private final By Edited_Reviews = By.xpath("//legend[normalize-space()='Edited Reviews']");
    private final By Edited_Reviews_Email = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[13]//div)[1]//label");
    private final By Inactive_Reviews = By.xpath("//legend[normalize-space()='Inactive Reviews']");
    private final By Inactive_Reviews_Email = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[14]//div)[1]//label");
    private final By Daily_Reviews_Report = By.xpath("//legend[normalize-space()='Daily Review Report']");
    private final By Daily_Reviews_Report_Email = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[15]//div)[1]");
    private final By Save = By.xpath("//div[@class='sk-button-group sk-padding-top']//button");
    
    private final By ChatTab = By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[2]");
    private final By Reminder_For_Chat_marked_followup = By.xpath("//legend[normalize-space()='Reminder for Chat marked follow-up']");
    private final By Reminder_For_Unresponded_Chats = By.xpath("//legend[normalize-space()='Reminder for Un-responded chats']");
    private final By Reminder_For_Unresponded_Chats_Email = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[2]//label)[1]");
    
    private final By CallTab = By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[3]");
    private final By Not_Connected_Calls = By.xpath("//legend[normalize-space()='Not connected calls']");
    private final By Zero_Connected_Calls = By.xpath("//legend[normalize-space()='Zero Connected Calls']");
    private final By Zero_Connected_Calls_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[4])//label)[1]");
    private final By Missed_Call_Report = By.xpath("//legend[normalize-space()='Missed Call Report']");
    private final By Missed_Call_Report_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[5])//label)[1]");
    
    private final By ReportsTab = By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[4]");
    private final By Weekly_Reports = By.xpath("//legend[normalize-space()='Weekly reports']");
    private final By Monthly_Reports = By.xpath("//legend[normalize-space()='Monthly reports']");
    private final By Monthly_Reports_Email = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[2]//label)[1]");
    private final By SMS_Delivery_Status = By.xpath("//legend[normalize-space()='SMS delivery status']");
    private final By SMS_Delivery_Status_Email = By.xpath("((//div[@class='sk-checkbox-group sk-inline'])[3]//label)[1]");
    
    private final By Misc_Tab = By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[5]");
    private final By Social_Mentions = By.xpath("//legend[normalize-space()='Social mentions']");
    private final By Social_Mentions_InApp = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[1])//label)[1]");
    private final By Temporarily_Closed = By.xpath("//legend[normalize-space()='Temporarily closed']");
    private final By Temporarily_Closed_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[2])//label)[1]");
    private final By Permanently_Closed = By.xpath("//legend[normalize-space()='Permanently closed']");
    private final By Permanently_Closed_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[3])//label)[1]");
    private final By Suspended = By.xpath("//legend[normalize-space()='Suspended']");
    private final By Suspended_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[4])//label)[1]");
    private final By Duplicate_Listings = By.xpath("//legend[normalize-space()='Duplicate listings']");
    private final By Duplicate_Listings_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[5])//label)[1]");
    private final By Microsite = By.xpath("//legend[normalize-space()='Microsite']");
    private final By Microsite_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[6])//label)[1]");
    private final By UnVerified_Listings = By.xpath("//legend[normalize-space()='UnVerified listings']");
    private final By UnVerified_Listings_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[7])//label)[1]");
    
    private final By Tickets_Tab = By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[6]");
    private final By Tickets = By.xpath("//legend[normalize-space()='Tickets']");
    private final By Tickets_Email = By.xpath("(((//div[@class='sk-checkbox-group sk-inline'])[1])//label)[1]");
    
     
   
    

  

    public UserSettings(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }
    
    public UserSettings clickUserSettings() {
    	System.out.println("\nTo Create User Settings : ");
    	PageLoad.pauseThreeSecs();
        waitForElementAndClick(User_Dropdown);
        test.log(Status.INFO, "Clicked on User Settings");
        waitForElementAndClick(My_Settings);
        takeScreenshot();
        return this;
    }
    
    public UserSettings clickReviewTab() {
    	PageLoad.pauseThreeSecs();
        waitForElementAndClick(ReviewTab);
        System.out.println("Review tab clicked successfully");

        return this;
    }
    public UserSettings selectNewReviews() {
       String newReviewsText = driver.findElement(By.xpath("//legend[normalize-space()='New reviews']")).getText();
        System.out.println("New Reviews Text: " + newReviewsText);
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Email_Box);
        System.out.println("Email checkbox selected");
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Select_Rating);
        System.out.println("Rating 1 selected");

        return this;
    }
    public UserSettings selectUnRespondedReviews() {
        String unRespondedReviewsText = driver.findElement(By.xpath("//legend[normalize-space()='Un-responded reviews']")).getText();
        System.out.println("Un-responded Reviews Text: " + unRespondedReviewsText);
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(InApp_Box);
        System.out.println("InApp checkbox selected");
        PageLoad.pauseThreeSecs();
		/*
		 * waitForElementAndClick(Select_rating1);
		 * System.out.println("Rating 1 selected");
		 */

        return this;
    }
    public UserSettings selectEditedReviews() {
        String editedReviewsText = driver.findElement(By.xpath("//legend[normalize-space()='Edited Reviews']")).getText();
        System.out.println("Edited Reviews Text: " + editedReviewsText);
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Edited_Reviews_Email);
        System.out.println("Email checkbox selected for Edited Reviews");
        
        return this;
    }
    public UserSettings selectInactiveReviews() {
        String inactiveReviewsText = driver.findElement(By.xpath("(//div[@class='sk-checkbox-group sk-inline'])[7]//div")).getText();
        System.out.println("Inactive Reviews Text: " + inactiveReviewsText);
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Inactive_Reviews_Email);
        System.out.println("Email checkbox selected for Inactive Reviews");
        takeScreenshot();
        return this;
    }
    public UserSettings selectDailyReviewReport() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        String dailyReviewsReportText = driver.findElement(By.xpath("//legend[normalize-space()='Daily Review Report']")).getText();
        System.out.println("Daily Reviews Report Text: " + dailyReviewsReportText);
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Daily_Reviews_Report_Email);
        System.out.println("Email checkbox selected for Daily Review Report");

        return this;
    }
        public UserSettings clickSave() {
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(Save);
        System.out.println("User notification settings saved successfully");
        PageLoad.pauseThreeSecs();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");

        takeScreenshot();
        return this;
    }
        
        
        
        public UserSettings clickTabs() {
        	PageLoad.pauseThreeSecs();
            clickChatTab();
            selectReminderForChatMarkedFollowup();
            selectReminderUnRespondedChats();
            clickSave();
            PageLoad.pauseThreeSecs();
           
            
            PageLoad.pauseThreeSecs();
            clickCallTab();
            selectNotConnectedCalls();
            selectZeroConnectedCalls();
            selectMissedCallReport();
            clickSave();
            
            PageLoad.pauseThreeSecs();
            clickReportsTab();
            selectWeeklyReports();
            selectMonthlyReports();
            selectSMSDeliveryStatus();
            clickSave();
            
            PageLoad.pauseThreeSecs();
            clickMiscTab();
            selectSocialMentions();
            selectTemporarilyClosed();
            selectPermanentlyClosed();
            selectSuspended();
            selectDuplicateListings();
            selectMicrosite();
            selectUnVerifiedListings();
            clickSave();
            
            PageLoad.pauseThreeSecs();
            clickTicketsTab();
            selectTickets();
            clickSave();
        	
            return this;
        }
  
        public UserSettings clickChatTab() {
			/*
			 * WebElement chatTab =
			 * driver.findElement(By.xpath("((//div[@class='sk-tab-menu'])[4]//ul//li)[1]"))
			 * ; JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("arguments[0].scrollIntoView(true);", chatTab);
			 * PageLoad.pauseThreeSecs();
			 */
        waitForElementAndClick(ChatTab);
        System.out.println("Chat tab clicked successfully");
        return this;
    }
    
        public UserSettings selectReminderForChatMarkedFollowup() {
            String reminderForChatMarkedFollowupText = driver.findElement(By.xpath("//legend[normalize-space()='Reminder for Chat marked follow-up']")).getText();
            System.out.println("Reminder For Chat Marked Followup Text: " + reminderForChatMarkedFollowupText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Email_Box);
            System.out.println("Email checkbox selected");

            return this;
        }
        public UserSettings selectReminderUnRespondedChats() {
            String reminderUnRespondedChatsText = driver.findElement(By.xpath("//legend[normalize-space()='Reminder for Un-responded chats']")).getText();
            System.out.println("Reminder Un-responded Chats Text: " + reminderUnRespondedChatsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Reminder_For_Unresponded_Chats_Email);
            System.out.println("Email checkbox selected");
            
           
            return this;
        }
        public UserSettings clickCallTab() {
        	PageLoad.pauseThreeSecs();
            waitForElementAndClick(CallTab);
            System.out.println("Calls tab clicked successfully");
            return this;
        }
        
    
        public UserSettings selectNotConnectedCalls() {
            String notConnectedCallsText = driver.findElement(By.xpath("//legend[normalize-space()='Not connected calls']")).getText();
            System.out.println("Not connected calls Text: " + notConnectedCallsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Email_Box);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectZeroConnectedCalls() {
            String zeroConnectedCallsText = driver.findElement(By.xpath("//legend[normalize-space()='Zero Connected Calls']")).getText();
            System.out.println("Zero Connected Calls Text: " + zeroConnectedCallsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Zero_Connected_Calls_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectMissedCallReport() {
            String missedCallReportText = driver.findElement(By.xpath("//legend[normalize-space()='Missed Call Report']")).getText();
            System.out.println("Missed Call Report Text: " + missedCallReportText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Missed_Call_Report_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        
        
        public UserSettings clickReportsTab() {
        	PageLoad.pauseThreeSecs();
            waitForElementAndClick(ReportsTab);
            System.out.println("Reports tab clicked successfully");
            return this;
        }
        
        
        public UserSettings selectWeeklyReports() {
            String weeklyReportsText = driver.findElement(By.xpath("//legend[normalize-space()='Weekly reports']")).getText();
            System.out.println("Weekly Reports Text: " + weeklyReportsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Email_Box);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectMonthlyReports() {
            String MonthlyReportsText = driver.findElement(By.xpath("//legend[normalize-space()='Monthly reports']")).getText();
            System.out.println("Monthly Reports Text: " + MonthlyReportsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Monthly_Reports_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectSMSDeliveryStatus() {
            String SMSDeliveryStatusText = driver.findElement(By.xpath("//legend[normalize-space()='SMS delivery status']")).getText();
            System.out.println("SMS delivery status Text: " + SMSDeliveryStatusText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(SMS_Delivery_Status_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        
        public UserSettings clickMiscTab() {
        	PageLoad.pauseThreeSecs();
            waitForElementAndClick(Misc_Tab);
            System.out.println("Misc tab clicked successfully");
            return this;
        }
        
        public UserSettings selectSocialMentions() {
            String socialMentionsText = driver.findElement(By.xpath("//legend[normalize-space()='Social mentions']")).getText();
            System.out.println("Social mentions Text: " + socialMentionsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Social_Mentions_InApp);
            System.out.println("InApp checkbox selected");
           
            return this;
        }
        public UserSettings selectTemporarilyClosed() {
            String temporarilyClosedText = driver.findElement(By.xpath("//legend[normalize-space()='Temporarily closed']")).getText();
            System.out.println("Temporarily closed Text: " + temporarilyClosedText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Temporarily_Closed_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectPermanentlyClosed() {
            String permanentlyClosedText = driver.findElement(By.xpath("//legend[normalize-space()='Permanently closed']")).getText();
            System.out.println("Permanently closed Text: " + permanentlyClosedText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Permanently_Closed_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectSuspended() {
            String suspendedText = driver.findElement(By.xpath("//legend[normalize-space()='Suspended']")).getText();
            System.out.println("Suspended Text: " + suspendedText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Suspended_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectDuplicateListings() {
            String duplicateListingsText = driver.findElement(By.xpath("//legend[normalize-space()='Duplicate listings']")).getText();
            System.out.println("Duplicate listingss Text: " + duplicateListingsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Duplicate_Listings_Email);
            System.out.println("Email checkbox selected");
            takeScreenshot();
            return this;
        }
        public UserSettings selectMicrosite() {
        	 JavascriptExecutor js = (JavascriptExecutor) driver;
             js.executeScript("window.scrollBy(0, 500);");
            String micrositeText = driver.findElement(By.xpath("//legend[normalize-space()='Microsite']")).getText();
            System.out.println("SMS delivery status Text: " + micrositeText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(Microsite_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
        public UserSettings selectUnVerifiedListings() {
            String unVerifiedListingsText = driver.findElement(By.xpath("//legend[normalize-space()='UnVerified Listings']")).getText();
            System.out.println("UnVerified Listings Text: " + unVerifiedListingsText);
            PageLoad.pauseThreeSecs();
            waitForElementAndClick(UnVerified_Listings_Email);
            System.out.println("Email checkbox selected");
           
            return this;
        }
     
    
        public UserSettings clickTicketsTab() {
        	PageLoad.pauseThreeSecs();
            waitForElementAndClick(Tickets_Tab);
            System.out.println("Tickets tab clicked successfully");
            return this;
        }
        
            public UserSettings selectTickets() {
                String ticketsText = driver.findElement(By.xpath("//legend[normalize-space()='Tickets']")).getText();
                System.out.println("Tickets Text: " + ticketsText);
                PageLoad.pauseThreeSecs();
                waitForElementAndClick(Tickets_Email);
                System.out.println("Email checkbox selected");

                return this;
            }
            
    
    
           
    
    
    
    
    
    
    
    
}
