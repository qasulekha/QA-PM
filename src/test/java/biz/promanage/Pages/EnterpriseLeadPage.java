package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnterpriseLeadPage extends BasePage {

    By CUSTOMER_NAME = By.id("customerName");
    By MOBILE_NUMBER = By.id("mobileNo");
    By EMAIL = By.id("email");
    By ROLE = By.id("role");
    By COMPANY_NAME = By.id("companyName");
    By COMPANY_WEBSITE = By.id("companyWebsiteUrl");
    By CITY_NAME = By.id("cityName");
    By SELECT_TERMS = By.cssSelector(".sk-check-label");
    By DEMO_BTN = By.xpath("(//button[normalize-space(text()) = 'Request Demo'])[1]");
    By SUBMIT_BTN = By.xpath("(//button[normalize-space(text()) = 'Submit Now'])[1]");
    By SUCCESS_MSG = By.xpath("//h2[. = 'Thank you for your interest!']");
    private final By otp = By.id("otpField");

    public EnterpriseLeadPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public EnterpriseLeadPage load() {
        test.log(Status.INFO, "Loading Enterprise Lead Page");
        load("");
        takeScreenshot();
        return this;
    }

    public EnterpriseLeadPage ClickRequestDemoButton() {
        test.log(Status.INFO, "Demo button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(this.DEMO_BTN)).click();
        return this;
    }

    public EnterpriseLeadPage enterCustomerName(String customerName) {
        test.log(Status.INFO, "Entering customer name: " + customerName);
        wait.until(ExpectedConditions.elementToBeClickable(this.CUSTOMER_NAME)).sendKeys(customerName);
        return this;
    }

    public EnterpriseLeadPage enterMobileNumber(String mobileNo) {
        test.log(Status.INFO, "Entering mobile no: " + mobileNo);
        wait.until(ExpectedConditions.elementToBeClickable(this.MOBILE_NUMBER)).sendKeys(mobileNo);
        return this;
    }

    public EnterpriseLeadPage enterEmail(String email) {
        test.log(Status.INFO, "Entering email: " + email);
        wait.until(ExpectedConditions.elementToBeClickable(this.EMAIL)).sendKeys(email);
        return this;
    }

    public EnterpriseLeadPage selectNoOfStores(String storeCount) {
        test.log(Status.INFO, "Entering store count: " + storeCount);
        driver.findElement(By.cssSelector("select")).click();
        WebElement dropdown = driver.findElement(By.cssSelector("select"));
        dropdown.findElement(By.xpath("//option[. = '1 to 10']")).click();
        return this;
    }

    public EnterpriseLeadPage selectRole(String role) {
        test.log(Status.INFO, "Entering role : " + role);
        wait.until(ExpectedConditions.elementToBeClickable(this.ROLE)).sendKeys(role);
        return this;
    }

    public EnterpriseLeadPage enterCompanyName(String companyName) {
        test.log(Status.INFO, "Entering Company name : " + companyName);
        wait.until(ExpectedConditions.elementToBeClickable(this.COMPANY_NAME)).sendKeys(companyName);
        return this;
    }

    public EnterpriseLeadPage enterCompanyWebsite(String website) {
        test.log(Status.INFO, "Entering company website : " + website);
        wait.until(ExpectedConditions.elementToBeClickable(this.COMPANY_WEBSITE)).sendKeys(website);
        return this;
    }

    public EnterpriseLeadPage enterCityName(String cityName) {
        test.log(Status.INFO, "Entering city name : " + cityName);
        wait.until(ExpectedConditions.elementToBeClickable(this.CITY_NAME)).sendKeys(cityName);
        return this;
    }

    public EnterpriseLeadPage acceptTermsAndConditions(Boolean isTermsAccepted) {
        test.log(Status.INFO, "Accepting terms and conditions : " + isTermsAccepted);
        wait.until(ExpectedConditions.elementToBeClickable(this.SELECT_TERMS)).click();
        return this;
    }

    public EnterpriseLeadPage submit() {
        takeScreenshot();
        test.log(Status.INFO, "Form submitted ");
        wait.until(ExpectedConditions.elementToBeClickable(this.SUBMIT_BTN)).click();
        return this;
    }

    public void enterOtp(String otpValue) {
        test.log(Status.INFO, "Entering OTP: " + otpValue);
        wait.until(ExpectedConditions.elementToBeClickable(otp)).sendKeys(otpValue);
    }

    public String getSuccessMessage() {
        test.log(Status.INFO, "success message");
        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MSG)).getText();
        takeScreenshot();
        return successMessage;
    }
}
