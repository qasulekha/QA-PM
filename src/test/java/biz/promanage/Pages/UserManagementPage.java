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

    By US_MANAG = By.xpath("//span[text()='User Management']/parent::a[1]");
    By ADD_USER = By.xpath("//button[@class='sk-button sk-primary sk-fab sk-leading-icon fab-bottom']");
    By NA_ME = By.xpath("(//input[@class='sk-input'])[17]");
    By PH_NUM = By.xpath("(//input[@class='sk-input'])[18]");
    By E_MAIL = By.xpath("(//input[@class='sk-input'])[19]");
    By RO_LE = By.xpath("(//span[text()='expand_more'])[11]");
    By C_M_O = By.xpath("//li[text()='Chief Marketing Officer ']");
    By A_D_D = By.xpath("//button[@class='sk-button sk-primary sk-block']");
    By S_E_A_R_C_H = By.xpath("(//input[@placeholder='Search with name, email or phone number'])[1]");
    By D_T_E = By.xpath("(//button[@class='sk-button sk-round sk-no-shadow'])[4]");
    By S_A_V_E = By.xpath("//button[text()='Save Profile']");
    By O_K = By.xpath("(//button[@class='sk-button sk-small sk-primary'])[2]");
    By clickEdit = By.xpath("(//button[@class='sk-button sk-round sk-no-shadow'])[3]");
    By w_p_a_s = By.xpath("//b[text()='WhatsApp Assistant']");
    By a_p_p_r = By.xpath("//b[text()='Approval Activity Tracker']");

    public UserManagementPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public UserManagementPage clickUser() {
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(US_MANAG);
        wait.until(ExpectedConditions.elementToBeClickable(US_MANAG));

        test.log(Status.INFO, "Navigated to User Management page.");
        return this;
    }

    public UserManagementPage addUser(String name) {
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(ADD_USER);
        WebElement na = wait.until(ExpectedConditions.elementToBeClickable(NA_ME));
        sendDelayedKeys(na, name);

        test.log(Status.INFO, "Entered user name: " + name);
        return this;
    }

    public UserManagementPage enterPhNum(String phNo) {
        WebElement ph = wait.until(ExpectedConditions.elementToBeClickable(PH_NUM));
        sendDelayedKeys(ph, phNo);

        test.log(Status.INFO, "Entered phone number: " + phNo);
        return this;
    }

    public UserManagementPage enterEmail(String mail) {
        WebElement em = wait.until(ExpectedConditions.elementToBeClickable(E_MAIL));
        sendDelayedKeys(em, mail);

        test.log(Status.INFO, "Entered email: " + mail);
        return this;
    }

    public UserManagementPage selectRole() {
        waitForElementAndClick(RO_LE);

        test.log(Status.INFO, "Opened Role dropdown.");
        return this;
    }

    public UserManagementPage cmoUser() {
        waitForElementAndClick(C_M_O);

        test.log(Status.INFO, "Selected role: Chief Marketing Officer.");
        return this;
    }

    public UserManagementPage clickAdd() {
        waitForElementAndClick(A_D_D);

        test.log(Status.INFO, "Clicked Add User button.");
        return this;
    }

    public UserManagementPage saveProfile() {
        PageLoad.pauseThreeSecs();
        waitForElementAndClick(S_A_V_E);

        test.log(Status.INFO, "Clicked Save Profile button.");
        return this;
    }

    public String getPhoneNumber() {
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        String phone = driver.findElement(By.xpath("(//span[text()='9042219183'])[1]")).getText();

        test.log(Status.INFO, "Fetched phone number: " + phone);
        return phone;
    }

    public String getSelectedActiveAccess() throws InterruptedException {
        PageLoad.pauseThreeSecs();
        Thread.sleep(10000);
        waitForElementAndClick(clickEdit);
        scroll(w_p_a_s);

        String output = driver.findElement(
            By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='WhatsApp Assistant']")
        ).getText();

        test.log(Status.INFO, "Selected Active Access: " + output);
        takeScreenshot();
        return output;
    }

    public String getSelectedActiveAccess1() {
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        String output = driver.findElement(
            By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='Approval Activity Tracker']")
        ).getText();

        test.log(Status.INFO, "Selected Active Access: " + output);
        return output;
    }

    public UserManagementPage searchBox(String userName) {
        PageLoad.pause();
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(S_E_A_R_C_H));
        sendDelayedKeys(user, userName);
        waitForElementAndClick(S_E_A_R_C_H);

        test.log(Status.INFO, "Searched for user: " + userName);
        return this;
    }

    public UserManagementPage deleteUser() {
        waitForElementAndClick(D_T_E);
        PageLoad.pause();
        waitForElementAndClick(O_K);
        takeScreenshot();

        test.log(Status.INFO, "Deleted user successfully.");
        return this;
    }

    public UserManagementPage editUser() {
        PageLoad.pauseThreeSecs();
        scrollAndClick(w_p_a_s);
        scrollAndClick(a_p_p_r);
        takeScreenshot();

        test.log(Status.INFO, "Edited user: enabled WhatsApp Assistant and Approval Activity Tracker.");
        return this;
    }

    public UserManagementPage clearSearch() {
        PageLoad.pauseThreeSecs();
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(S_E_A_R_C_H));
        user.clear();

        test.log(Status.INFO, "Cleared search box.");
        return this;
    }

    public UserManagementPage clickTest() {
        waitForElementAndClick(RO_LE);

        test.log(Status.INFO, "Clicked on Role dropdown (Test).");
        return this;
    }

    public String getLocation(String lo) {
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        String location = driver.findElement(By.xpath("//span[text()='Karnataka(2)']")).getAttribute("value");

        test.log(Status.INFO, "Fetched location: " + location);
        return location;
    }
}
