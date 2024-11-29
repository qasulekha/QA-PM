package biz.promanage.Pages;
import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ContactPage extends BasePage {

    By CONTACT = By.cssSelector("li:nth-child(10) > a > .sk-ripple-container");
    By CONTACT_LIST = By.cssSelector(".sk-show > li:nth-child(1) .sk-ripple-container");
    By CREATE_GROUP = By.cssSelector(".sk-text-end > .sk-mobile-hide > .sk-ripple-container");
    By GROUP_NAME = By.xpath("//div[@class='sk-form-label' and text()='Group Name']/following-sibling::div[1]/input[1]");
    By STATIC_GROUP = By.cssSelector("li:nth-child(2) > .sk-radio > .sk-check-label");
    By NEXT_BTN = By.cssSelector(".sk-text-end:nth-child(4) .sk-ripple-container");
    By SELECT_FILTER = By.cssSelector(".sk-text-select:nth-child(1) .sk-icons");
    By PHONE_NUMBER = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By PHONE_NUMBER_FILTER = By.cssSelector(".sk-form-row:nth-child(1) .sk-selected-text");
    By PHONE_NUMBER_KNOWN = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By DONE_BTN1 = By.cssSelector(".sk-text-end:nth-child(4) .sk-ripple-container");
    By SELECT_FILTER_2 = By.cssSelector(".sk-margin-bottom > .sk-text-select .sk-icons");
    By SELECT_AND_CONDITION_1 = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By SELECT_FILTER_3 = By.cssSelector(".create-cnt-group > .sk-text-select .sk-icons");
    By SELECT_EMAIL_ADDRESS = By.cssSelector(".sk-show > ul > li:nth-child(2)");
    By SELECT_FILTER_4 = By.cssSelector(".sk-form-row:nth-child(1) .sk-event-group");
    By EMAIL_ADDRESS_KNOWN = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By DONE_BTN_2 = By.cssSelector(".sk-text-end:nth-child(4) .sk-ripple-container");
    By SELECT_FILTER_5 = By.cssSelector("div:nth-child(2) > .sk-margin-bottom .sk-selected-text");
    By SELECT_FILTER_6 = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By SELECT_CONTACT_SOURCE = By.cssSelector(".sk-text-select:nth-child(3) .sk-selected-text");
    By CONTACT_SOURCE_FILTER_1 = By.cssSelector(".sk-overflow-list > ul > li:nth-child(3)");
    By CONTACT_SOURCE_FILTER_1_SELECT = By.cssSelector(".sk-form-row:nth-child(1) > .sk-text-select:nth-child(2) .sk-selected-text");
    By CONTACT_SOURCE_FILTER_OPTION = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By CONTACT_SOURCE_FILTER_2_SELECT = By.cssSelector(".sk-large:nth-child(3) .sk-selected-text");
    By CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE = By.cssSelector(".sk-show > ul > li:nth-child(1)");
    By DONE_BTN_3 = By.cssSelector(".sk-text-end:nth-child(4) .sk-ripple-container");
    By SUBMIT_BTN = By.cssSelector(".sk-flex-row > .sk-text-end > .sk-primary > .sk-ripple-container");
    By CONTACT_GROUP_MENU = By.cssSelector("li:nth-child(2) .sk-ripple-container:nth-child(2)");
    String GROUP_NAMES = "//div[@class='sk-surface table-card sk-avatar-item']//span[@class='sk-line-clamp sk-line-2']";
    String SEARCH_BY_GROUP_NAME = "(//div[@class='contact-list']//input)[1]";

    public ContactPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public ContactPage clickContact() {
        PageLoad.pause();
        takeScreenshot();
        test.log(Status.INFO, "contact page clicked");
      //  wait.until(ExpectedConditions.elementToBeClickable(CONTACT)).click();
        waitForElementAndClick(CONTACT);
        waitForPageLoadToComplete();
        return this;
    }

    public ContactPage clickContactList() {
    	 // wait.until(ExpectedConditions.elementToBeClickable(CONTACT_LIST)).click();
       waitForElementAndClick(CONTACT_LIST);
        return this;
    }

    public ContactPage clickCreateGroup() {
        waitForPageLoadToComplete();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
        PageLoad.pause();
        takeScreenshot();
       // wait.until(ExpectedConditions.elementToBeClickable(CREATE_GROUP)).click();
        waitForElementAndClick(CREATE_GROUP);
        return this;
    }

    public ContactPage enterGroupName(String groupName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
        PageLoad.pause();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(GROUP_NAME));
        sendDelayedKeys(element,groupName);
        test.log(Status.INFO, "group name entered : " + groupName);
        return this;
    }

    public ContactPage clickStaticGroup() {
        test.log(Status.INFO, "Static group selected");
        //wait.until(ExpectedConditions.elementToBeClickable(STATIC_GROUP)).click();
        waitForElementAndClick(STATIC_GROUP);
        return this;
    }

    public ContactPage clickNextBtn() {
        PageLoad.pause();
        takeScreenshot();
        //wait.until(ExpectedConditions.elementToBeClickable(NEXT_BTN)).click();
        waitForElementAndClick(NEXT_BTN);
        test.log(Status.INFO, "Next button clicked");
        return this;
    }

    public ContactPage clickSelectFilter() {
        test.log(Status.INFO, "Filter Conditions applied");
       // wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER)).click();
        waitForElementAndClick(SELECT_FILTER);
        return this;
    }

    public ContactPage clickPhoneNumber() {
       // wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER)).click();
        waitForElementAndClick(PHONE_NUMBER);
        return this;
    }

    public ContactPage clickPhoneNumberFilter() {
       // wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER_FILTER)).click();
        waitForElementAndClick(PHONE_NUMBER_FILTER);
        return this;
    }

    public ContactPage clickPhoneNumberKnown() {
       // wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER_KNOWN)).click();
        waitForElementAndClick(PHONE_NUMBER_KNOWN);
        return this;
    }

    public ContactPage clickDoneBtn1() {
        //wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN1)).click();
        waitForElementAndClick(DONE_BTN1);
        return this;
    }

    public ContactPage clickSelectFilter2() {
      //  wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_2)).click();
        waitForElementAndClick(SELECT_FILTER_2);
        return this;
    }

    public ContactPage clickSelectAndCondition1() {
       // wait.until(ExpectedConditions.elementToBeClickable(SELECT_AND_CONDITION_1)).click();
        waitForElementAndClick(SELECT_AND_CONDITION_1);
        return this;
    }

    public ContactPage clickSelectFilter3() {
       // wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_3)).click();
        waitForElementAndClick(SELECT_FILTER_3);
        return this;
    }

    public ContactPage clickSelectEmailAddress() {
       // wait.until(ExpectedConditions.elementToBeClickable(SELECT_EMAIL_ADDRESS)).click();
        waitForElementAndClick(SELECT_EMAIL_ADDRESS);
        return this;
    }

    public ContactPage clickSelectFilter4() {
       // wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_4)).click();
        waitForElementAndClick(SELECT_FILTER_4);
        return this;
    }

    public ContactPage clickEmailAddressKnown() {
        //wait.until(ExpectedConditions.elementToBeClickable(EMAIL_ADDRESS_KNOWN)).click();
        waitForElementAndClick(EMAIL_ADDRESS_KNOWN);
        return this;
    }

    public ContactPage clickDoneBtn2() {
        //wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN_2)).click();
        waitForElementAndClick(DONE_BTN_2);
        return this;
    }

    public ContactPage clickSelectFilter5() {
        //wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_5)).click();
        waitForElementAndClick(SELECT_FILTER_5);
        return this;
    }

    public ContactPage clickSelectFilter6() {
        //wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_6)).click();
        waitForElementAndClick(SELECT_FILTER_6);
        return this;
    }

    public ContactPage clickSelectContactSource() {
       // wait.until(ExpectedConditions.elementToBeClickable(SELECT_CONTACT_SOURCE)).click();
        waitForElementAndClick(SELECT_CONTACT_SOURCE);
        return this;
    }

    public ContactPage clickContactSourceFilter1() {
       // wait.until(ExpectedConditions.elementToBeClickable(CONTACT_SOURCE_FILTER_1)).click();
        waitForElementAndClick(CONTACT_SOURCE_FILTER_1);
        return this;
    }

    public ContactPage clickContactSourceFilter1Select() {

        //wait.until(ExpectedConditions.elementToBeClickable(CONTACT_SOURCE_FILTER_1_SELECT)).click();
        waitForElementAndClick(CONTACT_SOURCE_FILTER_1_SELECT);
        return this;
    }

    public ContactPage clickContactSourceFilterOption() {
       // wait.until(ExpectedConditions.elementToBeClickable(CONTACT_SOURCE_FILTER_OPTION)).click();
        waitForElementAndClick(CONTACT_SOURCE_FILTER_OPTION);
        return this;
    }

    public ContactPage clickContactSourceFilter2Select() {
        //wait.until(ExpectedConditions.elementToBeClickable(CONTACT_SOURCE_FILTER_2_SELECT)).click();
        waitForElementAndClick(CONTACT_SOURCE_FILTER_2_SELECT);
        return this;
    }

    public ContactPage clickContactSourceFilter2OptionGoogle() {
      //  wait.until(ExpectedConditions.elementToBeClickable(CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE)).click();
        waitForElementAndClick(CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE);
        return this;
    }

    public ContactPage clickDoneBtn3() {
      //  wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN_3)).click();
        waitForElementAndClick(DONE_BTN_3);
        return this;
    }

    public ContactPage clickSubmitBtn() {
        PageLoad.pause();
        takeScreenshot();
      //  wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BTN)).click();
        waitForElementAndClick(SUBMIT_BTN);
        return this;
    }

    public void clickContactGroupMenu() {
        clickContact();
       // wait.until(ExpectedConditions.elementToBeClickable(CONTACT_GROUP_MENU)).click();
        waitForElementAndClick(CONTACT_GROUP_MENU);
        PageLoad.pause();
        takeScreenshot();
    }

    public String getGroupName() {
        PageLoad.pauseThreeSecs();
        return driver.findElement(By.cssSelector(".sk-surface:nth-child(2) .sk-width-large > .sk-line-clamp")).getText();
    }

    public void deleteGroup(String groupName) {

        int i = 1;
        navigateToContactGroupPage();
        SearchGroup(groupName);
        List<WebElement> elements = driver.findElements(By.xpath(GROUP_NAMES));
        for (WebElement element : elements) {
            if (element.getText().equals(groupName)) {
                DeleteGroup(i);
                break;
            }
            i++;
        }
        driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)).clear();
    }

    private void SearchGroup(String groupName) {
        sendDelayedKeys(driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)),groupName);
        PageLoad.pauseThreeSecs();
        driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)).sendKeys(Keys.ENTER);
    }

    private void DeleteGroup(int i) {
        click(driver.findElement(By.xpath("(//div[@class='sk-overflow-menu']//button)[" + i + "]")));
        click(driver.findElement(By.cssSelector(".sk-show > li:nth-child(2)")));
        click(driver.findElement(By.cssSelector(".sk-dialog:nth-child(4) .sk-button:nth-child(2) > .sk-ripple-container")));
    }

    private void navigateToContactGroupPage() {
        PageLoad.pauseThreeSecs();
        wait.until(ExpectedConditions.elementToBeClickable(CONTACT)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CONTACT_GROUP_MENU)).click();
    }
}
