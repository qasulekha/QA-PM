package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CustomGroup extends BasePage {
	 
	By DELETE_GROUP_BTN = By.xpath("//button[.='Delete Group']");
	By DELETE_OK_BTN = By.xpath("//*[contains(text(), 'delete this group')]/parent::div[@class='sk-dialog-body']/following-sibling::div[@class='sk-dialog-footer']//button[2]");
	// By LOCATION_1 = By.xpath("(//div[@class='sk-data-table'])[1]/child::table[1]//tr[2]/td[1]/div[1]/label[1]");
	By LOCATION_1 = By.xpath("((//div[@class='sk-data-table listings-table-item loader-min-height']//table//tbody//tr)[1]//td)[1]//div//label");
	// By LOCATION_2 = By.xpath("(//div[@class='sk-data-table'])[1]/child::table[1]//tr[3]/td[1]/div[1]/label[1]");
	By LOCATION_2 = By.xpath("((//div[@class='sk-data-table listings-table-item loader-min-height']//table//tbody//tr)[2]//td)[1]//div//label");
	By LOCATION_3 = By.xpath("((//div[@class='sk-data-table listings-table-item loader-min-height']//table//tbody//tr)[3]//td)[1]//div//label");
	By CUSTOM_GROUP_NAME = By.xpath("//input[@placeholder='Enter group name']");
	By CREATE_CUSTOM_GROUP_BTN = By.xpath("//h4[.='Create Group']/ancestor::div[@class='sk-panel-header']/following-sibling::div[@class='sk-panel-footer']//button[1]");
	By FILTER_DDL = By.cssSelector(".sk-group-dropdown:nth-child(3) > .sk-icons");
	By CUSTOM_GROUP_TAB = By.xpath("//li[@id='nav-0-99']/a[.=' Custom Group ']");
	By LOCATION_SEARCH_BOX = By.cssSelector(".filter-padding .sk-input");
	By CUSTOM_GROUP_SAVE_BTN = By.xpath("//span[text()='Save Changes']/parent::button[1]");
	// By CUSTOM_GROUP_SAVE_BTN = By.xpath("((//div[@class='sk-panel-footer'])[33]//parent::button)[2]");
	By ACTION = By.xpath("//option[.='Action']/parent::select");
	private Select dropdown;
	// (//div[@class='sk-text-select'])[2]//span

 
    public CustomGroup(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }
 
    public CustomGroup load() {
        test.log(Status.INFO, "Loading Listing Management Page");
        load("/app/ListingManagement");
        waitForPageLoaderToDisappear();
        waitForPageLoadToComplete();
        takeScreenshot();
        return this;
    }
 
    public CustomGroup CreateCustomGroup(String groupName) {
 
        dropdown = new Select(driver.findElement(By.xpath("//option[.='Action']/parent::select")));
 
        if (isOptionPresent(groupName)) {
            DeleteGroup(groupName);
        }
        PageLoad.pause();
        CreateGroup(groupName);
        return this;
    }
 
    private void CreateGroup(String groupName) {
        waitForElementAndClick(LOCATION_1);
        waitForElementAndClick(LOCATION_2);
        selectOption("Create Custom Group");
        waitForElementToBeVisible(CUSTOM_GROUP_NAME);
        type(CUSTOM_GROUP_NAME, groupName);
        test.log(Status.INFO, "Creating custom group : " + groupName );
        takeScreenshot();
        waitForElementAndClick(CREATE_CUSTOM_GROUP_BTN);
        test.log(Status.INFO, "Custom group : " + groupName + " Created");
    }
 
    public void verifyCustomGroup(String customGroup) {
        PageLoad.pause();
        test.log(Status.INFO, "Location Filter Clicked");
 
        try {
            waitForElementAndClick(FILTER_DDL);
            waitForElementAndClick(CUSTOM_GROUP_TAB);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
            wait.until(ExpectedConditions.elementToBeClickable(LOCATION_SEARCH_BOX)).click();
            sendDelayedKeys(driver.findElement(By.cssSelector(".filter-padding .sk-input")), customGroup);
            WebElement element = waitForElementToBeVisible(By.xpath("//ul[@class='location-filter-list']/li//p[normalize-space(.)='" + customGroup + "']"));
            if (element.getText().trim().equals(customGroup)) {
                test.log(Status.PASS, "Custom group '" + customGroup + "' verified successfully.");
                takeScreenshot();
            } else {
                test.log(Status.FAIL, "Text mismatch for custom group. Expected: '" + customGroup + "', Found: '" + element.getText() + "'");
                takeScreenshot();
            }
        } catch (TimeoutException e) {
            test.log(Status.FAIL, "Timeout: Custom group '" + customGroup + "' not found.");
            takeScreenshot();
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "No such element: Custom group '" + customGroup + "' not found.");
            takeScreenshot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Unexpected error: " + e.getMessage());
            takeScreenshot();
        }
    }
 
    private void DeleteGroup(String groupName) {
        selectOption(groupName);
        waitForElementAndClick(DELETE_GROUP_BTN);
        waitForElementAndClick(DELETE_OK_BTN);
    }
 
    public boolean isOptionPresent(String optionText) {
        return dropdown.getOptions().stream().anyMatch(option -> option.getText().trim().equals(optionText));
    }
 
    public void selectOption(String optionText) {
        dropdown.selectByVisibleText(optionText);
    }
 
    public String getSelectedOption() {
        return dropdown.getFirstSelectedOption().getText().trim();
    }
 
 
	public CustomGroup CreateCustomGroup1(String groupName) {
		waitForElementAndClick(LOCATION_3);
		PageLoad.pauseThreeSecs();
		waitForElementAndClick(ACTION);
		PageLoad.pause();
		test.log(Status.INFO, "Action filter clicked");
		WebElement option = driver.findElement(By.xpath("//option[text()='AutomationTestCustomgroup']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		PageLoad.pause();
		option.click();
		PageLoad.pause();
		CreateGroup1(groupName);
		return this;
	}
 
private void CreateGroup1(String groupName) {
    waitForElementAndClick(CUSTOM_GROUP_SAVE_BTN);
    test.log(Status.INFO, "Custom group : " + groupName + " Created");
}
}
