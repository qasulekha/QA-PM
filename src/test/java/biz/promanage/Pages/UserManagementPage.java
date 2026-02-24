package biz.promanage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;

public class UserManagementPage extends BasePage {

    By USER_MANAGEMENT = By.xpath("//span[text()='User Management']/parent::a[1]");
    By ADD_USER = By.xpath("//button[@class='sk-button sk-primary sk-fab sk-leading-icon fab-bottom']");
    By NAME = By.xpath("(//input[@class='sk-input'])[17]");
    By PHONE_NUMBER = By.xpath("(//input[@class='sk-input'])[18]");
    By EMAIL = By.xpath("(//input[@class='sk-input'])[19]");
    By ROLE = By.xpath("(//span[text()='expand_more'])[11]");
    By CMO = By.xpath("//li[text()='Chief Marketing Officer ']");
    By ADD = By.xpath("//button[@class='sk-button sk-primary sk-block']");
    By SEARCH = By.xpath("(//input[@placeholder='Search with name, email or phone number'])[1]");
    By DELETE = By.xpath("(//button[@class='sk-button sk-round sk-no-shadow'])[4]");
    By SAVE = By.xpath("//button[text()='Save Profile']");
    By OK_BUTTON = By.xpath("(//button[@class='sk-button sk-small sk-primary'])[2]");
    By Click_Edit = By.xpath("(//button[@class='sk-button sk-round sk-no-shadow'])[3]");
    By WHATSAPP_ASSISTANT = By.xpath("//b[text()='WhatsApp Assistant']");
    By APPROVER = By.xpath("//b[text()='Approver']");

    public UserManagementPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

/*
 * public UserManagementPage clickUser() { PageLoad.pauseThreeSecs();
 * waitForElementAndClick(USER_MANAGEMENT);
 * wait.until(ExpectedConditions.elementToBeClickable(USER_MANAGEMENT));
 * 
 * test.log(Status.INFO, "Navigated to User Management page."); return this; }
 * 
 * public UserManagementPage addUser(String name) { PageLoad.pauseThreeSecs();
 * waitForElementAndClick(ADD_USER); WebElement na =
 * wait.until(ExpectedConditions.elementToBeClickable(NAME));
 * sendDelayedKeys(na, name);
 * 
 * test.log(Status.INFO, "Entered user name: " + name); return this; }
 * 
 * public UserManagementPage enterPhNum(String phNo) { WebElement ph =
 * wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER));
 * sendDelayedKeys(ph, phNo);
 * 
 * test.log(Status.INFO, "Entered phone number: " + phNo); return this; }
 * 
 * public UserManagementPage enterEmail(String mail) { WebElement em =
 * wait.until(ExpectedConditions.elementToBeClickable(EMAIL));
 * sendDelayedKeys(em, mail);
 * 
 * test.log(Status.INFO, "Entered email: " + mail); return this; }
 * 
 * public UserManagementPage selectRole() { waitForElementAndClick(ROLE);
 * 
 * test.log(Status.INFO, "Opened Role dropdown."); return this; }
 * 
 * public UserManagementPage cmoUser() { waitForElementAndClick(CMO);
 * 
 * test.log(Status.INFO, "Selected role: Chief Marketing Officer."); return
 * this; }
 * 
 * public UserManagementPage clickAdd() { waitForElementAndClick(ADD);
 * 
 * test.log(Status.INFO, "Clicked Add User button."); return this; }
 * 
 * public UserManagementPage saveProfile() { PageLoad.pauseThreeSecs();
 * waitForElementAndClick(SAVE);
 * 
 * test.log(Status.INFO, "Clicked Save Profile button."); return this; }
 * 
 * public String getPhoneNumber() { PageLoad.pauseThreeSecs(); takeScreenshot();
 * String phone =
 * driver.findElement(By.xpath("(//span[text()='9042219183'])[1]")).getText();
 * 
 * test.log(Status.INFO, "Fetched phone number: " + phone); return phone; }
 * 
 * public String getSelectedActiveAccess() throws InterruptedException {
 * PageLoad.pauseThreeSecs(); Thread.sleep(10000);
 * waitForElementAndClick(Click_Edit); scroll(WHATSAPP_ASSISTANT);
 * 
 * String output = driver.findElement( By.
 * xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='WhatsApp Assistant']"
 * ) ).getText();
 * 
 * test.log(Status.INFO, "Selected Active Access: " + output); takeScreenshot();
 * return output; }
 * 
 * public String getSelectedActiveAccess1() { PageLoad.pauseThreeSecs();
 * takeScreenshot(); String output = driver.findElement( By.
 * xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='Approval Activity Tracker']"
 * ) ).getText();
 * 
 * test.log(Status.INFO, "Selected Active Access: " + output); return output; }
 * 
 * public UserManagementPage searchBox(String userName) { PageLoad.pause();
 * WebElement user =
 * wait.until(ExpectedConditions.elementToBeClickable(SEARCH));
 * sendDelayedKeys(user, userName); waitForElementAndClick(SEARCH);
 * 
 * test.log(Status.INFO, "Searched for user: " + userName); return this; }
 * 
 * public UserManagementPage deleteUser() { waitForElementAndClick(DELETE);
 * PageLoad.pause(); waitForElementAndClick(OK_BUTTON); takeScreenshot();
 * 
 * test.log(Status.INFO, "Deleted user successfully."); return this; }
 * 
 * public UserManagementPage editUser() { PageLoad.pauseThreeSecs();
 * scrollAndClick(WHATSAPP_ASSISTANT); scrollAndClick(APPROVER);
 * takeScreenshot();
 * 
 * test.log(Status.INFO,
 * "Edited user: enabled WhatsApp Assistant and Approval Activity Tracker.");
 * return this; }
 * 
 * public UserManagementPage clearSearch() { PageLoad.pauseThreeSecs();
 * WebElement user =
 * wait.until(ExpectedConditions.elementToBeClickable(SEARCH)); user.clear();
 * 
 * test.log(Status.INFO, "Cleared search box."); return this; }
 * 
 * public UserManagementPage clickTest() { waitForElementAndClick(ROLE);
 * 
 * test.log(Status.INFO, "Clicked on Role dropdown (Test)."); return this; }
 * 
 * public String getLocation(String lo) { PageLoad.pauseThreeSecs();
 * takeScreenshot(); String location =
 * driver.findElement(By.xpath("//span[text()='Karnataka(2)']")).getAttribute(
 * "value");
 * 
 * test.log(Status.INFO, "Fetched location: " + location); return location; } }
 */
    
    public UserManagementPage clickUser() {
    	System.out.println("\nTo Create User Management : ");
		System.out.println("\nUser Management page");
        takeScreenshot();

        PageLoad.pauseThreeSecs();
        waitForElementAndClick(USER_MANAGEMENT);
        wait.until(ExpectedConditions.elementToBeClickable(USER_MANAGEMENT));

        test.log(Status.INFO, "Navigated to User Management page.");
        System.out.println("User Management page loaded successfully");
        takeScreenshot();

        return this;
    }

    public UserManagementPage addUser(String name) {
        System.out.println("Adding new user. Name: " + name);
        takeScreenshot();

        PageLoad.pauseThreeSecs();
        waitForElementAndClick(ADD_USER);

        WebElement na = wait.until(ExpectedConditions.elementToBeClickable(NAME));
        sendDelayedKeys(na, name);

        test.log(Status.INFO, "Entered user name: " + name);
        System.out.println("User name entered successfully");
        takeScreenshot();

        return this;
    }

    public UserManagementPage enterPhNum(String phNo) {
        System.out.println("Entering phone number: " + phNo);

        WebElement ph = wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER));
        sendDelayedKeys(ph, phNo);

        test.log(Status.INFO, "Entered phone number: " + phNo);
        takeScreenshot();

        return this;
    }

    public UserManagementPage enterEmail(String mail) {
        System.out.println("Entering email: " + mail);

        WebElement em = wait.until(ExpectedConditions.elementToBeClickable(EMAIL));
        sendDelayedKeys(em, mail);

        test.log(Status.INFO, "Entered email: " + mail);
        takeScreenshot();

        return this;
    }

    public UserManagementPage selectRole() {
        System.out.println("Opening Role dropdown");
        takeScreenshot();

        waitForElementAndClick(ROLE);

        test.log(Status.INFO, "Opened Role dropdown.");
        takeScreenshot();

        return this;
    }

    public UserManagementPage cmoUser() {
        System.out.println("Selecting role: Chief Marketing Officer");

        waitForElementAndClick(CMO);

        test.log(Status.INFO, "Selected role: Chief Marketing Officer.");
        takeScreenshot();

        return this;
    }

    public UserManagementPage clickAdd() {
        System.out.println("Clicking Add User button");
        takeScreenshot();

        waitForElementAndClick(ADD);

        test.log(Status.INFO, "Clicked Add User button.");
        takeScreenshot();

        return this;
    }

    public UserManagementPage saveProfile() {
        System.out.println("Saving user profile");
        takeScreenshot();

        PageLoad.pauseThreeSecs();
        waitForElementAndClick(SAVE);

        test.log(Status.INFO, "Clicked Save Profile button.");
        takeScreenshot();

        return this;
    }

    public String getPhoneNumber() {
        System.out.println("Fetching phone number");
        PageLoad.pauseThreeSecs();
        takeScreenshot();

        String phone = driver
                .findElement(By.xpath("(//span[text()='9042219183'])[1]"))
                .getText();

        test.log(Status.INFO, "Fetched phone number: " + phone);
        System.out.println("Phone number fetched successfully: " + phone);

        return phone;
    }

    public String getSelectedActiveAccess() throws InterruptedException {
        System.out.println("Fetching selected active access");
        PageLoad.pauseThreeSecs();
        Thread.sleep(10000);

        waitForElementAndClick(Click_Edit);
        scroll(WHATSAPP_ASSISTANT);
        takeScreenshot();

        String output = driver.findElement(
                By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='WhatsApp Assistant']")
        ).getText();

        test.log(Status.INFO, "Selected Active Access: " + output);
        System.out.println("Selected active access: " + output);
        takeScreenshot();

        return output;
    }

    public String getSelectedActiveAccess1() {
        System.out.println("Fetching selected active access (Approval Activity Tracker)");
        PageLoad.pauseThreeSecs();
        takeScreenshot();

        String output = driver.findElement(
                By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='Approval Activity Tracker']")
        ).getText();

        test.log(Status.INFO, "Selected Active Access: " + output);
        System.out.println("Selected active access fetched: " + output);

        return output;
    }

    public UserManagementPage searchBox(String userName) {
        System.out.println("Searching for user: " + userName);
        PageLoad.pause();

        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(SEARCH));
        sendDelayedKeys(user, userName);
        waitForElementAndClick(SEARCH);

        test.log(Status.INFO, "Searched for user: " + userName);
        takeScreenshot();

        return this;
    }

    public UserManagementPage deleteUser() {
        System.out.println("Deleting user");
        takeScreenshot();

        waitForElementAndClick(DELETE);
        PageLoad.pause();
        waitForElementAndClick(OK_BUTTON);

        takeScreenshot();
        test.log(Status.INFO, "Deleted user successfully.");
        System.out.println("User deleted successfully");

        return this;
    }

    public UserManagementPage editUser() {
        System.out.println("Editing user access permissions");
        PageLoad.pauseThreeSecs();

        scrollAndClick(WHATSAPP_ASSISTANT);
        scrollAndClick(APPROVER);

        takeScreenshot();
        test.log(Status.INFO, "Edited user: enabled WhatsApp Assistant and Approval Activity Tracker.");
        System.out.println("User permissions updated");

        return this;
    }

    public UserManagementPage clearSearch() {
        System.out.println("Clearing search box");
        PageLoad.pauseThreeSecs();

        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(SEARCH));
        user.clear();

        test.log(Status.INFO, "Cleared search box.");
        takeScreenshot();

        return this;
    }

    public UserManagementPage clickTest() {
        System.out.println("Clicking Role dropdown (Test)");
        takeScreenshot();

        waitForElementAndClick(ROLE);

        test.log(Status.INFO, "Clicked on Role dropdown (Test).");
        takeScreenshot();

        return this;
    }

    public String getLocation(String lo) {
        System.out.println("Fetching location");
        PageLoad.pauseThreeSecs();
        takeScreenshot();

        String location = driver
                .findElement(By.xpath("//span[text()='Karnataka(2)']"))
                .getAttribute("value");

        test.log(Status.INFO, "Fetched location: " + location);
        System.out.println("Location fetched: " + location);

        return location;
    }
}