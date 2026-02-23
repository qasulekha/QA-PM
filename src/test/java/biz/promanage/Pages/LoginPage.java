package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.Otp;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LoginPage extends BasePage {
    private final By LOGIN_LINK = By.xpath("(//a[text()='Login'])[1]");
    private final By MOBILE_NO = By.xpath("(//div[@class='sk-surface login-form sk-flex sk-flex-column'])//input[@placeholder='Mobile Number']");
    private final By Captcha_code = By.xpath("//input[@id='txtCaptchaCode']");
    private final By LOGIN_BTN = By.xpath("//span[.='Send OTP']/parent::button[1]");
    private final By OTP = By.id("otpField");
    private final By PAGE_TITLE = By.xpath("//div[@class='sk-title-primary'][normalize-space(text())='Insights-My Dashboard']");

    public LoginPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

/*
 * public LoginPage load() { test.log(Status.INFO, "Loading Home Page");
 * load(""); // WaitForPageLoadToComplete(); takeScreenshot(); return this; }
 * 
 * 
 * public LoginPage clickLoginLink() { takeScreenshot(); test.log(Status.INFO,
 * "Clicking on login link");
 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_LINK)).click();
 * return this; }
 * 
 * public LoginPage enterMobileNo(String mobileNo) { test.log(Status.INFO,
 * "Entering mobile number: " + mobileNo);
 * wait.until(ExpectedConditions.elementToBeClickable(MOBILE_NO)).sendKeys(
 * mobileNo); return this; }
 * 
 * public LoginPage clickLoginBtn() { test.log(Status.INFO,
 * "Clicking on login button");
 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(Captcha_code)).sendKeys(
 * "data/UserCred.json");
 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
 * return this; }
 * 
 * public LoginPage enterOtp(String otp) { test.log(Status.INFO,
 * "Entering OTP : " + otp);
 * wait.until(ExpectedConditions.elementToBeClickable(OTP)).sendKeys(otp);
 * return this; }
 * 
 * public void isLoginSuccessful() {
 * wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
 * PageLoad.pause(); takeScreenshot(); String pageTitle =
 * driver.findElement(PAGE_TITLE).getText(); System.out.println("Page title is"
 * + pageTitle); }
 * 
 * public void login(String mobileNo) throws IOException, InterruptedException {
 * load();
 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_LINK)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(MOBILE_NO)).sendKeys(
 * mobileNo);
 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(Captcha_code)).sendKeys(
 * "data/UserCred.json");
 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
 * wait.until(ExpectedConditions.elementToBeClickable(OTP)).sendKeys(Otp.getOTP(
 * mobileNo));
 * wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE)); } }
 */
    
    public LoginPage load() {
        System.out.println("Loading Home Page");
        load("");
        takeScreenshot();
        return this;
    }


    public LoginPage clickLoginLink() {
        System.out.println("Clicking on Login link");
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_LINK)).click();
        takeScreenshot();
        return this;
    }

    public LoginPage enterMobileNo(String mobileNo) {
        System.out.println("Entering Mobile Number: " + mobileNo);
        wait.until(ExpectedConditions.elementToBeClickable(MOBILE_NO)).sendKeys(mobileNo);
        takeScreenshot();
        return this;
    }

    public LoginPage clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
        System.out.println("Clicking on Login button");
        wait.until(ExpectedConditions.elementToBeClickable(Captcha_code)).sendKeys("data/UserCred.json");
        System.out.println("Entering Captcha file path");
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
        System.out.println("Clicking Login button again after Captcha");
        return this;
    }

    public LoginPage enterOtp(String otp) {
        System.out.println("Entering OTP: " + otp);
        wait.until(ExpectedConditions.elementToBeClickable(OTP)).sendKeys(otp);
        takeScreenshot();
        return this;
    }

    public void isLoginSuccessful() {

        System.out.println("Verifying Login Success");

        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
        PageLoad.pause();

        String pageTitle = driver.findElement(PAGE_TITLE).getText();
        System.out.println("Login successful. Page Title: " + pageTitle);

        takeScreenshot();
    }

    
	/*
	 * public void login(String mobileNo) throws IOException, InterruptedException {
	 * load();
	 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_LINK)).click();
	 * wait.until(ExpectedConditions.elementToBeClickable(MOBILE_NO)).sendKeys(
	 * mobileNo);
	 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
	 * wait.until(ExpectedConditions.elementToBeClickable(Captcha_code)).sendKeys(
	 * "data/UserCred.json");
	 * wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
	 * wait.until(ExpectedConditions.elementToBeClickable(OTP)).sendKeys(Otp.getOTP(
	 * mobileNo));
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE)); }
	 */
    
    public void login(String mobileNo) throws IOException, InterruptedException {

        System.out.println("Starting Login Flow");
        takeScreenshot();

        load();

        System.out.println("Clicking Login link");
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_LINK)).click();
      

        System.out.println("Entering Mobile Number: " + mobileNo);
        wait.until(ExpectedConditions.elementToBeClickable(MOBILE_NO)).sendKeys(mobileNo);
      

        System.out.println("Clicking Login button");
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
        

        System.out.println("Uploading Captcha file");
        wait.until(ExpectedConditions.elementToBeClickable(Captcha_code))
                .sendKeys("data/UserCred.json");
        takeScreenshot();

        System.out.println("Clicking Login button after Captcha");
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN)).click();
       

        System.out.println("Fetching and Entering OTP");
        String otp = Otp.getOTP(mobileNo);
        wait.until(ExpectedConditions.elementToBeClickable(OTP)).sendKeys(otp);
        takeScreenshot();

        System.out.println("Waiting for Login Success Page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
        takeScreenshot();

        System.out.println("Login Flow Completed Successfully");
    }

}