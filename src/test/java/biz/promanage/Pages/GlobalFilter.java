package biz.promanage.Pages;
import biz.promanage.base.BasePage;
import biz.promanage.utils.Otp;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class GlobalFilter extends BasePage {

    By FILTER_DDL = By.cssSelector(".sk-group-dropdown:nth-child(3) > .sk-icons");
    By LOCATION_SEARCH_BOX = By.cssSelector(".filter-padding .sk-input");
    By SELECT_STATE = By.cssSelector(".location-filter-list .sk-check-label");
    By APPLY_BUTTON = By.cssSelector(".sk-flex-align-center .sk-button:nth-child(2) > .sk-ripple-container");
    By PROFILE_COUNT = By.xpath("//div[@class='sk-card-secondary']");
    By PROFILE_COUNT_FILTER = By.cssSelector(".location-filter-list > li:nth-child(1) .sk-h8");
    private final By businessProfiles = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Business Profiles']/parent::a[1]");
    String profileCount="";
    String state = "kerala";

    public GlobalFilter(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public GlobalFilter clickOnFilter() {
        waitForPageLoadToComplete();
        test.log(Status.INFO, "Location Filter Clicked");
        waitForElementAndClick(FILTER_DDL);
        takeScreenshot();
        return this;
    }

    public GlobalFilter searchState() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
        PageLoad.pause();
        waitForElementAndClick(LOCATION_SEARCH_BOX);
        test.log(Status.INFO, state + " state entered");
        sendDelayedKeys(driver.findElement(By.cssSelector(".filter-padding .sk-input")), state);
        takeScreenshot();
        return this;
    }

    public GlobalFilter selectState() {
        test.log(Status.INFO, state + " state selected");
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATE)).click();
        PageLoad.pauseThreeSecs();
        profileCount = wait.until(ExpectedConditions.visibilityOfElementLocated(PROFILE_COUNT_FILTER)).getText();
        test.log(Status.INFO, state + " state selected, Profile count : " + profileCount);
        return this;
    }

    public GlobalFilter clickApply() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
        takeScreenshot();
        test.log(Status.INFO, "Apply button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(APPLY_BUTTON)).click();
        return this;
    }

    public GlobalFilter clickBusinessProfiles() {
        PageLoad.pause();
        test.log(Status.INFO, "Clicking on Business Profiles link");
        wait.until(ExpectedConditions.elementToBeClickable(businessProfiles)).click();
        return this;
    }

    public void ScrollToTheBottom() {
        waitForPageLoadToComplete();
        PageLoad.pause();
        dynamicScrolling();
        getProfileCount();
        PageLoad.pauseOneSec();
        takeScreenshot();
    }

    public void getProfileCount()
    {
        List<WebElement> elements = driver.findElements(PROFILE_COUNT);
        System.out.println("Profile Count : " + elements.size());
        test.log(Status.INFO, "Total profile count : " + elements.size());
        Assert.assertEquals(elements.size(),Integer.parseInt(Otp.ExtractNumberFromString(profileCount)));
    }
}
