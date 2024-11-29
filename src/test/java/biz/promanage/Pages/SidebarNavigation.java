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

import java.util.List;

public class SidebarNavigation extends BasePage {
    private final By insightPage = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Insights']/parent::a[1]");
    private final By listings = By.xpath(" //div[@class='sk-sidebar']//ul/li/a/span[text()='Listings']/parent::a[1]");
    private final By leaderboard = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Leaderboard']/parent::a[1]");
    private final By tickets = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Tickets']/parent::a[1]");
    private final By reviews = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Reviews']/parent::a[1]");
    private final By campaigns = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Campaigns']/parent::a[1]");
    private final By campaignSMS = By.xpath("//ul[@class='sub-menu sk-show']/li//span[text()='SMS']/parent::a[1]");
    private final By chat = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Chat']/parent::a[1]");
    private final By chatPage = By.xpath("//div[contains(@class,'sk-chat-title')]/h4");
    private final By contacts = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Contacts']/parent::a[1]");
    private final By contactList = By.xpath("//ul[@class='sub-menu sk-show']/li/a/span[text()='List']/parent::a[1]");
    private final By contactGroup = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Groups']/parent::a[1]");
    private final By createGroup = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Create Groups']/parent::a[1]");
    private final By duplicateListings = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Duplicate Listings']/parent::a[1]");
    private final By rankTracker = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Rank Tracker']/parent::a[1]");
    private final By bulkUploadTracker = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Bulk Upload Tracker']/parent::a[1]");
    private final By questionAndAnswer = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Question and Answer']/parent::a[1]");
    private final By businessProfiles = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Business Profiles']/parent::a[1]");
    private final By userManagement = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='User Management']/parent::a[1]");
    private final By settings = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Settings']/parent::a[1]");
    private final By platform = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Platforms']/parent::a[1]");
    private final By switchTenant = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Switch Tenant']/parent::a[1]");
    private final By profileScore = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Profile Score']/parent::a[1]");
    private final By roiCalculator = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='ROI Calculator']/parent::a[1]");
    private final By promanageCustomer = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Promanage Customer']/parent::a[1]");
    private final By smbListingManagement = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='SMB Listing Management']/parent::a[1]");
    private final By mentions = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Mentions']/parent::a[1]");
    private final By gmbProfileAnalyzer = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='GMB Profile Analyzer']/parent::a[1]");
    private final By seoConfiguration = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='SEO Configuration']/parent::a[1]");
    private final By insightTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Insights-My Dashboard']");
    private final By leaderboardTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Leaderboard']");
    private final By ticketsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Tickets']");
    private final By reviewsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Reviews']");
    private final By campaignsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Campaigns']");
    private final By chatTitle = By.xpath("//div[contains(@class,'sk-chat-title')]/h4");
    private final By contactsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Contacts']");
    private final By duplicateListingsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Duplicate Listings']");
    private final By rankTrackerTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Rank Tracker']");
    private final By bulkUploadTrackerTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Bulk Upload Tracker']");
    private final By questionAndAnswerTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Question and Answer']");
    private final By businessProfilesTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Business Profiles']");
    private final By userManagementTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='User Management']");
    private final By settingsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Settings']");
    private final By platformTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Platform']");
    private final By switchTenantTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Switch Tenent']");
    private final By profileScoreTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Profile Score']");
    private final By roiCalculatorTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='ROI Calculator']");
    private final By promanageCustomerTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Promanage Customer']");
    private final By smbListingManagementTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='SMB Listing Management']");
    private final By mentionsTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Mentions']");
    private final By gmbProfileAnalyzerTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='GMB Profile Analyzer']");
    private final By seoConfigurationTitle = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='SEOConfiguration']");

    public SidebarNavigation(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public SidebarNavigation load() {
        test.log(Status.INFO, "Home Page Loaded");
        takeScreenshot();
        return this;
    }

    public SidebarNavigation clickInsightPage() {
        //logToExtentReport(Status.INFO, "Clicking on Insight page Menu Item");
        test.log(Status.INFO, "Clicking on Insight page Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(insightPage)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(insightTitle));
        String insightPageTitle = driver.findElement(insightTitle).getText();
        System.out.println("Insight Page Title :" + insightPageTitle);
        return this;
    }

    public SidebarNavigation clickLeaderboard() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Leaderboard Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(leaderboard)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaderboardTitle));
        String leaderBoardPageTitle = driver.findElement(leaderboardTitle).getText();
        System.out.println("Leader Board Page Title :" + leaderBoardPageTitle);
        return this;
    }

    public SidebarNavigation clickTickets() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Tickets Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(tickets)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ticketsTitle));
        String ticketingPageTitle = driver.findElement(ticketsTitle).getText();
        System.out.println("Leader Board Page Title :" + ticketsTitle);
        return this;
    }

    public SidebarNavigation clickReviews() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Reviews Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(reviews)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewsTitle));
        return this;
    }

    public SidebarNavigation clickCampaigns() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Campaigns Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(campaigns)).click();
        wait.until(ExpectedConditions.elementToBeClickable(campaignSMS)).click();
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(campaignsTitle));
        return this;
    }

    public SidebarNavigation clickChat() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Chat Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(chat)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
        PageLoad.pause();
        driver.navigate().back();
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(chatTitle));
        return this;
    }

    public SidebarNavigation clickContacts() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Contains Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(contacts)).click();
        wait.until(ExpectedConditions.elementToBeClickable(contactList)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
/*      driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(contacts)).click();
        wait.until(ExpectedConditions.elementToBeClickable(contactGroup)).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(contacts)).click();
        wait.until(ExpectedConditions.elementToBeClickable(createGroup)).click();*/
        return this;
    }

    public SidebarNavigation clickDuplicateListings() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Duplicate Listings Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(duplicateListings)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateListingsTitle));
        return this;
    }

    public SidebarNavigation clickRankTracker() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Rank Tracker Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(rankTracker)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(rankTrackerTitle));
        return this;
    }

    public SidebarNavigation clickBulkUploadTracker() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Bulk Upload Tracker Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(bulkUploadTracker)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(bulkUploadTrackerTitle));
        return this;
    }

    public SidebarNavigation clickQuestionAndAnswer() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Question and Answer Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(questionAndAnswer)).click();
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(questionAndAnswerTitle));
        return this;
    }

    public SidebarNavigation clickBusinessProfiles() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Business Profiles Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(businessProfiles)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessProfilesTitle));
        return this;
    }

    public SidebarNavigation clickUserManagement() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on User Management Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(userManagement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userManagementTitle));
        return this;
    }

    public SidebarNavigation clickSettings() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Settings Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(settingsTitle));
        return this;
    }

    public SidebarNavigation clickPlatform() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Platform Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(platform)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(platformTitle));
        return this;
    }

    public SidebarNavigation clickSwitchTenant() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Switch Tenant Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(switchTenant)).click();
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(switchTenantTitle));
        return this;
    }

    public SidebarNavigation clickProfileScore() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Profile Score Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(profileScore)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(profileScoreTitle));
        return this;
    }

    public SidebarNavigation clickRoiCalculator() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on ROI Calculator Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(roiCalculator)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(roiCalculatorTitle));
        return this;
    }

    public SidebarNavigation clickPromanageCustomer() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Promanage Customer Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(promanageCustomer)).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(promanageCustomerTitle));
        return this;
    }

    public SidebarNavigation clickSmbListingManagement() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on SMB Listing Management Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(smbListingManagement)).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(smbListingManagementTitle));
        return this;
    }

    public SidebarNavigation clickMentions() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on Mentions Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(mentions)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(mentionsTitle));
        return this;
    }

    public SidebarNavigation clickGmbProfileAnalyzer() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on GMB Profile Analyzer Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(gmbProfileAnalyzer)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(gmbProfileAnalyzerTitle));
        // getPageTitle();
        return this;
    }

    public void clickSeoConfiguration() {
        driver.navigate().refresh();
        test.log(Status.INFO, "Clicking on SEO Configuration Menu Item");
        wait.until(ExpectedConditions.elementToBeClickable(seoConfiguration)).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(seoConfigurationTitle));
    }

    private void getPageTitle() {
        String text = driver.findElement(By.xpath("//div[@class='sk-title-primary']")).getText();
        test.log(Status.INFO, "Expected : " + "Actual : " + text);
    }

    public SidebarNavigation clickListings() {
        test.log(Status.INFO, "Clicking on Listings Page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(listings));
        wait.until(ExpectedConditions.elementToBeClickable(listings)).click();
        return this;
    }

    public void Navigate() {
        List<WebElement> menuItems = driver.findElements(By.xpath("//div[@class='sk-sidebar']//ul/li/a"));
        int menuCount = menuItems.size();
        String menuName = "";
        for (WebElement menuItem : menuItems) {
            menuName = menuItem.getText();
            if(!menuName.equalsIgnoreCase("chat"))
            menuItem.click();
            new DevToolsHelper(driver).waitForPageLoadAndAsyncCompletion();
            System.out.println("Page title after click: " + driver.getTitle());
        }
    }
}


