package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SmbLeadPage extends BasePage {
    private final By customerName = By.id("customerName");
    private final By mobileNo = By.id("mobileNo");
    private final By email = By.id("email");
    private final By otp = By.id("otpField");
    private final By companyName = By.id("companyName");
    private final By continueBtnStepOne = By.id("next");
    private final By category = By.id("subcategory");
    private final By selectCategory = By.xpath("//div[@id='openSubcategory']/ul/li[1]");
    private final By city = By.id("city");
    private final By selectCity = By.xpath("//div[@id='openCity']/ul/li/a[text()='Chennai']");
    private final By companyWebsiteUrl = By.id("companyWebsiteUrl");
    private final By businessProof = By.xpath("//label[text()='Business Proof']/ancestor::div[1]");
    private final By selectProof = By.xpath("//div[@id='divbusinessprooflist']/Ul/li[1]");
    private final By continueBtnStepTwo = By.xpath("(//button[text()='Continue'])[2]");
    private final By gbpNo = By.id("gbpNo");
    private final By employeeCount = By.id("noOfEmployee");
    private final By annualRevenue = By.id("annualRevenue");
    private final By selectAnnualRevenue = By.xpath("//div[@id='divannualRevenue']/ul/li[last()]");
    private final By locationCount = By.id("divnoOfListings");
    private final By selectLocationCount = By.xpath("//div[@id='divnoOfListingsResults']/ul/li[1]");
    private final By activeProfiles = By.id("divActiveListing");
    private final By selectActiveProfiles = By.xpath("//div[@id='divActiveListingResults']/ul/li[1]");
    private final By continueBtnStepThree = By.xpath("(//div[@class='lead-form-button']/button[text()='Continue'])[3]");
    private final By successMsg = By.xpath("//h4[text()='Thank you for your interest!']");

    public SmbLeadPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public SmbLeadPage load() {
        test.log(Status.INFO, "Loading SMB Lead Page");
        load("/smbindex");
        wait.until(ExpectedConditions.elementToBeClickable(this.customerName));
        takeScreenshot();
        return this;
    }

    public SmbLeadPage enterCustomerName(String customerName) {
        test.log(Status.INFO, "Entering customer name: " + customerName);
        wait.until(ExpectedConditions.elementToBeClickable(this.customerName)).sendKeys(customerName);
        return this;
    }

    public SmbLeadPage enterMobileNumber(String mobileNumber) {
        test.log(Status.INFO, "Entering mobile number: " + mobileNumber);
        wait.until(ExpectedConditions.elementToBeClickable(mobileNo)).sendKeys(mobileNumber);
        return this;
    }

    public SmbLeadPage enterEmail(String emailAddress) {
        test.log(Status.INFO, "Entering email address: " + emailAddress);
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(emailAddress);
        return this;
    }

    public SmbLeadPage enterCompanyName(String name) {
        test.log(Status.INFO, "Entering company name: " + name);
        wait.until(ExpectedConditions.elementToBeClickable(companyName)).sendKeys(name);
        return this;
    }

    public SmbLeadPage clickContinueButtonOne() {
        takeScreenshot();
        test.log(Status.INFO, "Clicking Continue Button Step One");
        wait.until(ExpectedConditions.elementToBeClickable(continueBtnStepOne)).click();
        return this;
    }

    public SmbLeadPage selectCategory(String categoryName) {
        test.log(Status.INFO, "Selecting category: " + categoryName);
        wait.until(ExpectedConditions.elementToBeClickable(category)).sendKeys(categoryName);
        wait.until(ExpectedConditions.elementToBeClickable(selectCategory)).click();
        return this;
    }

    public SmbLeadPage enterCity(String cityName) {
        test.log(Status.INFO, "Entering city name: " + cityName);
        wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys(cityName);
        wait.until(ExpectedConditions.elementToBeClickable(selectCity)).click();
        return this;
    }

    public SmbLeadPage enterWebsiteUrl(String WebsiteUrl) {
        test.log(Status.INFO, "Entering website URL: " + WebsiteUrl);
        wait.until(ExpectedConditions.elementToBeClickable(companyWebsiteUrl)).sendKeys(WebsiteUrl);
        return this;
    }

    public SmbLeadPage selectBusinessProof(String Proof) {
        test.log(Status.INFO, "Selecting business proof: " + Proof);
        wait.until(ExpectedConditions.elementToBeClickable(businessProof)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectProof)).click();
        return this;
    }

    public SmbLeadPage clickContinueButtonTwo() {
        takeScreenshot();
        test.log(Status.INFO, "Clicking Continue Button Step Two");
        wait.until(ExpectedConditions.elementToBeClickable(continueBtnStepTwo)).click();
        return this;
    }

    public SmbLeadPage hasGoogleProfile(boolean googleProfileExists) {
        if (!googleProfileExists) {
            test.log(Status.INFO, "Google profile does not exist");
            wait.until(ExpectedConditions.elementToBeClickable(gbpNo)).click();
        }
        return this;
    }

    public SmbLeadPage enterEmployeeCount(String employeeCount) {
        test.log(Status.INFO, "Entering employee count: " + employeeCount);
        wait.until(ExpectedConditions.elementToBeClickable(this.employeeCount)).sendKeys(employeeCount);
        return this;
    }

    public SmbLeadPage selectAnnualRevenue(String revenue) {
        test.log(Status.INFO, "Selecting annual revenue: " + revenue);
        wait.until(ExpectedConditions.elementToBeClickable(annualRevenue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAnnualRevenue)).click();
        return this;
    }

    public SmbLeadPage selectProfileCount(String googleBusinessProfileCount) {
        test.log(Status.INFO, "Selecting profile count: " + googleBusinessProfileCount);
        wait.until(ExpectedConditions.elementToBeClickable(locationCount)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectLocationCount)).click();
        return this;
    }

    public SmbLeadPage selectActiveProfiles(String currentlyActiveProfiles) {
        test.log(Status.INFO, "Selecting active profiles: " + currentlyActiveProfiles);
        wait.until(ExpectedConditions.elementToBeClickable(activeProfiles)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectActiveProfiles)).click();
        return this;
    }

    public SmbLeadPage clickContinueButtonThree() {
        takeScreenshot();
        test.log(Status.INFO, "Clicking Continue Button Step Three");
        wait.until(ExpectedConditions.elementToBeClickable(continueBtnStepThree)).click();
        return this;
    }

    public void enterOtp(String otpValue) {
        test.log(Status.INFO, "Entering OTP: " + otpValue);
        wait.until(ExpectedConditions.elementToBeClickable(otp)).sendKeys(otpValue);
    }

    public String getSuccessMessage() {
        test.log(Status.INFO, "success message");
        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
        takeScreenshot();
        return successMessage;
    }
}
