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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactPage extends BasePage {

	// By INTERACTIONS = By.xpath("(//div[@class='sk-vertical-menu
	// sk-menu-shrink']/ul/li)[8]");
	By INTERACTIONS = By.xpath("//span[text()='Interactions']/parent::a[1]");
	By CONTACT = By.xpath("//span[text()='Contacts']/parent::a[1]");
//	((//div[@class='sk-vertical-menu sk-menu-shrink']/ul/li)[7]//li)[2]
	By CONTACT_GROUP = By.xpath("//span[text()='Contact Group']/parent::a[1]");
	By CREATE_GROUP = By.cssSelector(".sk-text-end > .sk-mobile-hide > .sk-ripple-container");
	By GROUP_NAME = By
			.xpath("//div[@class='sk-form-label' and text()='Group Name']/following-sibling::div[1]/input[1]");
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
	By CONTACT_SOURCE_FILTER_1_SELECT = By
			.cssSelector(".sk-form-row:nth-child(1) > .sk-text-select:nth-child(2) .sk-selected-text");
	By CONTACT_SOURCE_FILTER_OPTION = By.cssSelector(".sk-show > ul > li:nth-child(1)");
	By CONTACT_SOURCE_FILTER_2_SELECT = By.cssSelector(".sk-large:nth-child(3) .sk-selected-text");
	By CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE = By.cssSelector(".sk-show > ul > li:nth-child(1)");
	By DONE_BTN_3 = By.cssSelector(".sk-text-end:nth-child(4) .sk-ripple-container");
	By SUBMIT_BTN = By.cssSelector(".sk-flex-row > .sk-text-end > .sk-primary > .sk-ripple-container");
	By CONTACT_GROUP_MENU = By.xpath("//span[text()='Contact Group']/parent::a[1]");
	String GROUP_NAMES = "(//div[@class='sk-surface table-card sk-avatar-item']//span[@class='sk-line-clamp sk-line-2'])[1]";
	String SEARCH_BY_GROUP_NAME = "(//div[@class='contact-list']//input)[1]";

	public ContactPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	/*
	 * public ContactPage clickInteractions() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT_LIST)).click();
	 * waitForElementAndClick(INTERACTIONS); return this; }
	 * 
	 * 
	 * public ContactPage clickContact() { PageLoad.pause(); takeScreenshot();
	 * test.log(Status.INFO, "contact page clicked"); //
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT)).click();
	 * waitForElementAndClick(CONTACT); waitForPageLoadToComplete(); return this; }
	 * 
	 * public ContactPage clickContactGroup() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT_LIST)).click();
	 * waitForElementAndClick(CONTACT_GROUP); return this; }
	 * 
	 * public ContactPage clickCreateGroup() { waitForPageLoadToComplete();
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
	 * "svg.sk-circular"))); PageLoad.pause(); takeScreenshot(); //
	 * wait.until(ExpectedConditions.elementToBeClickable(CREATE_GROUP)).click();
	 * waitForElementAndClick(CREATE_GROUP); return this; }
	 * 
	 * public ContactPage enterGroupName(String groupName) {
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
	 * "svg.sk-circular"))); PageLoad.pause(); WebElement element =
	 * wait.until(ExpectedConditions.elementToBeClickable(GROUP_NAME));
	 * sendDelayedKeys(element,groupName); test.log(Status.INFO,
	 * "group name entered : " + groupName); return this; }
	 * 
	 * public ContactPage clickStaticGroup() { test.log(Status.INFO,
	 * "Static group selected");
	 * //wait.until(ExpectedConditions.elementToBeClickable(STATIC_GROUP)).click();
	 * waitForElementAndClick(STATIC_GROUP); return this; }
	 * 
	 * public ContactPage clickNextBtn() { PageLoad.pause(); takeScreenshot();
	 * //wait.until(ExpectedConditions.elementToBeClickable(NEXT_BTN)).click();
	 * waitForElementAndClick(NEXT_BTN); test.log(Status.INFO,
	 * "Next button clicked"); return this; }
	 * 
	 * public ContactPage clickSelectFilter() { test.log(Status.INFO,
	 * "Filter Conditions applied"); //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER)).click();
	 * waitForElementAndClick(SELECT_FILTER); return this; }
	 * 
	 * public ContactPage clickPhoneNumber() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER)).click();
	 * waitForElementAndClick(PHONE_NUMBER); return this; }
	 * 
	 * public ContactPage clickPhoneNumberFilter() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER_FILTER)).
	 * click(); waitForElementAndClick(PHONE_NUMBER_FILTER); return this; }
	 * 
	 * public ContactPage clickPhoneNumberKnown() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER_KNOWN)).click
	 * (); waitForElementAndClick(PHONE_NUMBER_KNOWN); return this; }
	 * 
	 * public ContactPage clickDoneBtn1() {
	 * //wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN1)).click();
	 * waitForElementAndClick(DONE_BTN1); return this; }
	 * 
	 * public ContactPage clickSelectFilter2() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_2)).click();
	 * waitForElementAndClick(SELECT_FILTER_2); return this; }
	 * 
	 * public ContactPage clickSelectAndCondition1() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_AND_CONDITION_1)).
	 * click(); waitForElementAndClick(SELECT_AND_CONDITION_1); return this; }
	 * 
	 * public ContactPage clickSelectFilter3() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_3)).click();
	 * waitForElementAndClick(SELECT_FILTER_3); return this; }
	 * 
	 * public ContactPage clickSelectEmailAddress() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_EMAIL_ADDRESS)).
	 * click(); waitForElementAndClick(SELECT_EMAIL_ADDRESS); return this; }
	 * 
	 * public ContactPage clickSelectFilter4() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_4)).click();
	 * waitForElementAndClick(SELECT_FILTER_4); return this; }
	 * 
	 * public ContactPage clickEmailAddressKnown() {
	 * //wait.until(ExpectedConditions.elementToBeClickable(EMAIL_ADDRESS_KNOWN)).
	 * click(); waitForElementAndClick(EMAIL_ADDRESS_KNOWN); return this; }
	 * 
	 * public ContactPage clickDoneBtn2() {
	 * //wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN_2)).click();
	 * waitForElementAndClick(DONE_BTN_2); return this; }
	 * 
	 * public ContactPage clickSelectFilter5() {
	 * //wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_5)).click(
	 * ); waitForElementAndClick(SELECT_FILTER_5); return this; }
	 * 
	 * public ContactPage clickSelectFilter6() {
	 * //wait.until(ExpectedConditions.elementToBeClickable(SELECT_FILTER_6)).click(
	 * ); waitForElementAndClick(SELECT_FILTER_6); return this; }
	 * 
	 * public ContactPage clickSelectContactSource() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(SELECT_CONTACT_SOURCE)).
	 * click(); waitForElementAndClick(SELECT_CONTACT_SOURCE); return this; }
	 * 
	 * public ContactPage clickContactSourceFilter1() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT_SOURCE_FILTER_1)).
	 * click(); waitForElementAndClick(CONTACT_SOURCE_FILTER_1); return this; }
	 * 
	 * public ContactPage clickContactSourceFilter1Select() {
	 * 
	 * //wait.until(ExpectedConditions.elementToBeClickable(
	 * CONTACT_SOURCE_FILTER_1_SELECT)).click();
	 * waitForElementAndClick(CONTACT_SOURCE_FILTER_1_SELECT); return this; }
	 * 
	 * public ContactPage clickContactSourceFilterOption() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(
	 * CONTACT_SOURCE_FILTER_OPTION)).click();
	 * waitForElementAndClick(CONTACT_SOURCE_FILTER_OPTION); return this; }
	 * 
	 * public ContactPage clickContactSourceFilter2Select() {
	 * //wait.until(ExpectedConditions.elementToBeClickable(
	 * CONTACT_SOURCE_FILTER_2_SELECT)).click();
	 * waitForElementAndClick(CONTACT_SOURCE_FILTER_2_SELECT); return this; }
	 * 
	 * public ContactPage clickContactSourceFilter2OptionGoogle() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(
	 * CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE)).click();
	 * waitForElementAndClick(CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE); return this; }
	 * 
	 * public ContactPage clickDoneBtn3() { //
	 * wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN_3)).click();
	 * waitForElementAndClick(DONE_BTN_3); return this; }
	 * 
	 * public ContactPage clickSubmitBtn() {
	 * 
	 * takeScreenshot(); //
	 * wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BTN)).click();
	 * waitForElementAndClick(SUBMIT_BTN); return this; }
	 * 
	 * public void clickContactGroupMenu() { clickContact(); //
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT_GROUP_MENU)).click
	 * (); waitForElementAndClick(CONTACT_GROUP_MENU); PageLoad.pause();
	 * takeScreenshot(); }
	 * 
	 * public String getGroupName() { PageLoad.pauseThreeSecs(); return
	 * driver.findElement(By.
	 * cssSelector(".sk-surface:nth-child(2) .sk-width-large > .sk-line-clamp")).
	 * getText(); }
	 * 
	 * 
	 * public void deleteGroup(String groupName) {
	 * 
	 * int i = 1; //navigateToContactGroupPage(); SearchGroup(groupName);
	 * List<WebElement> elements = driver.findElements(By.xpath(GROUP_NAMES));
	 * 
	 * for (WebElement element : elements) { if
	 * (element.getText().equals(groupName)) { DeleteGroup(i); break; } i++; } //
	 * driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)).clear(); }
	 * 
	 * private void SearchGroup(String groupName) { PageLoad.pause();
	 * sendDelayedKeys(driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)),groupName)
	 * ; PageLoad.pauseThreeSecs();
	 * driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)).sendKeys(Keys.ENTER); }
	 * 
	 * private void DeleteGroup(int i) { click(driver.findElement(By.xpath(
	 * "(//div[@class='sk-overflow-menu']//button)[" + i + "]")));
	 * PageLoad.pauseOneSec();
	 * click(driver.findElement(By.cssSelector(".sk-show > li:nth-child(2)")));
	 * PageLoad.pauseOneSec(); click(driver.findElement(By.
	 * cssSelector(".sk-dialog:nth-child(4) .sk-button:nth-child(2) > .sk-ripple-container"
	 * ))); }
	 * 
	 * 
	 * public void deleteGroup(String groupName) { // Navigate to group page if
	 * needed SearchGroup(groupName); PageLoad.pause(); DeleteGroupp(); // // Get
	 * all groups // List<WebElement> elements =
	 * driver.findElements(By.xpath(GROUP_NAMES)); // int i = 1; // for (WebElement
	 * element : elements) { // String text = element.getText().trim(); // if
	 * (text.equalsIgnoreCase(groupName)) { // DeleteGroup(i); // break; // } //
	 * i++; // } } private void SearchGroup(String groupName) { WebDriverWait wait =
	 * new WebDriverWait(driver, Duration.ofSeconds(15));
	 * 
	 * WebElement searchBox =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * SEARCH_BY_GROUP_NAME))); //searchBox.clear(); searchBox.sendKeys(groupName,
	 * Keys.ENTER); } private void DeleteGroup(int i) {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 * 
	 * // Click overflow menu button WebElement menuButton =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "(//div[@class='sk-overflow-menu']//button)[" + i + "]")));
	 * menuButton.click();
	 * 
	 * // Click delete option WebElement deleteOption =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.
	 * cssSelector(".sk-show > li:nth-child(2)") )); deleteOption.click();
	 * 
	 * // Confirm delete WebElement confirmBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable( By.
	 * cssSelector(".sk-dialog:nth-child(4) .sk-button:nth-child(2) > .sk-ripple-container"
	 * ))); confirmBtn.click(); }
	 * 
	 * private void DeleteGroupp() {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 * 
	 * // Click overflow menu button WebElement menuButton =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "(//div[@class='sk-overflow-menu']//button)[1]"))); menuButton.click();
	 * 
	 * // Click delete option WebElement deleteOption =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.
	 * cssSelector(".sk-show > li:nth-child(2)") )); deleteOption.click();
	 * 
	 * // Confirm delete WebElement confirmBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable( By.
	 * cssSelector(".sk-dialog:nth-child(4) .sk-button:nth-child(2) > .sk-ripple-container"
	 * ))); confirmBtn.click(); }
	 * 
	 * 
	 * 
	 * private void navigateToContactGroupPage() { PageLoad.pauseThreeSecs();
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT)).click();
	 * wait.until(ExpectedConditions.elementToBeClickable(CONTACT_GROUP_MENU)).click
	 * (); }
	 * 
	 */
	
	 public ContactPage clickInteractions() {
	   	 // wait.until(ExpectedConditions.elementToBeClickable(CONTACT_LIST)).click();
	       waitForElementAndClick(INTERACTIONS);
	       return this;
	   }
	
	 public ContactPage clickContact() {
	        PageLoad.pause();
	        System.out.println("Contact Page: Clicking Contact menu");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT);
	        waitForPageLoadToComplete();
	        return this;
	    }

	    public ContactPage clickContactGroup() {
	        System.out.println("Contact Group: Clicking Contact Group");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT_GROUP);
	        return this;
	    }

	    public ContactPage clickCreateGroup() {
	        waitForPageLoadToComplete();
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
	        PageLoad.pause();
	        System.out.println("Create Group: Clicking Create Group button");
	        takeScreenshot();
	        waitForElementAndClick(CREATE_GROUP);
	        return this;
	    }

	    public ContactPage enterGroupName(String groupName) {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
	        PageLoad.pause();
	        System.out.println("Create Group: Entering group name");
	        takeScreenshot();
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(GROUP_NAME));
	        sendDelayedKeys(element, groupName);
	        return this;
	    }

	    public ContactPage clickStaticGroup() {
	        System.out.println("Create Group: Selecting Static Group");
	        takeScreenshot();
	        waitForElementAndClick(STATIC_GROUP);
	        return this;
	    }

	    public ContactPage clickNextBtn() {
	        PageLoad.pause();
	        System.out.println("Create Group: Clicking Next button");
	        takeScreenshot();
	        waitForElementAndClick(NEXT_BTN);
	        return this;
	    }

	    public ContactPage clickSelectFilter() {
	        System.out.println("Filter: Clicking Select Filter");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_FILTER);
	        return this;
	    }

	    public ContactPage clickPhoneNumber() {
	        System.out.println("Filter: Selecting Phone Number");
	        takeScreenshot();
	        waitForElementAndClick(PHONE_NUMBER);
	        return this;
	    }

	    public ContactPage clickPhoneNumberFilter() {
	        System.out.println("Filter: Selecting Phone Number Filter");
	        takeScreenshot();
	        waitForElementAndClick(PHONE_NUMBER_FILTER);
	        return this;
	    }

	    public ContactPage clickPhoneNumberKnown() {
	        System.out.println("Filter: Selecting Phone Number Known");
	        takeScreenshot();
	        waitForElementAndClick(PHONE_NUMBER_KNOWN);
	        return this;
	    }

	    public ContactPage clickDoneBtn1() {
	        System.out.println("Filter: Clicking Done button (Step 1)");
	        takeScreenshot();
	        waitForElementAndClick(DONE_BTN1);
	        return this;
	    }

	    public ContactPage clickSelectFilter2() {
	        System.out.println("Filter: Clicking Select Filter (Step 2)");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_FILTER_2);
	        return this;
	    }

	    public ContactPage clickSelectAndCondition1() {
	        System.out.println("Filter: Selecting AND condition");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_AND_CONDITION_1);
	        return this;
	    }

	    public ContactPage clickSelectFilter3() {
	        System.out.println("Filter: Clicking Select Filter (Step 3)");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_FILTER_3);
	        return this;
	    }

	    public ContactPage clickSelectEmailAddress() {
	        System.out.println("Filter: Selecting Email Address");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_EMAIL_ADDRESS);
	        return this;
	    }

	    public ContactPage clickSelectFilter4() {
	        System.out.println("Filter: Clicking Select Filter (Step 4)");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_FILTER_4);
	        return this;
	    }

	    public ContactPage clickEmailAddressKnown() {
	        System.out.println("Filter: Selecting Email Address Known");
	        takeScreenshot();
	        waitForElementAndClick(EMAIL_ADDRESS_KNOWN);
	        return this;
	    }

	    public ContactPage clickDoneBtn2() {
	        System.out.println("Filter: Clicking Done button (Step 2)");
	        takeScreenshot();
	        waitForElementAndClick(DONE_BTN_2);
	        return this;
	    }

	    public ContactPage clickSelectFilter5() {
	        System.out.println("Filter: Clicking Select Filter (Step 5)");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_FILTER_5);
	        return this;
	    }

	    public ContactPage clickSelectFilter6() {
	        System.out.println("Filter: Clicking Select Filter (Step 6)");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_FILTER_6);
	        return this;
	    }

	    public ContactPage clickSelectContactSource() {
	        System.out.println("Filter: Selecting Contact Source");
	        takeScreenshot();
	        waitForElementAndClick(SELECT_CONTACT_SOURCE);
	        return this;
	    }

	    public ContactPage clickContactSourceFilter1() {
	        System.out.println("Filter: Selecting Contact Source Filter");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT_SOURCE_FILTER_1);
	        return this;
	    }

	    public ContactPage clickContactSourceFilter1Select() {
	        System.out.println("Filter: Selecting Contact Source Option");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT_SOURCE_FILTER_1_SELECT);
	        return this;
	    }

	    public ContactPage clickContactSourceFilterOption() {
	        System.out.println("Filter: Selecting Contact Source Value");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT_SOURCE_FILTER_OPTION);
	        return this;
	    }

	    public ContactPage clickContactSourceFilter2Select() {
	        System.out.println("Filter: Selecting Secondary Contact Source");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT_SOURCE_FILTER_2_SELECT);
	        return this;
	    }

	    public ContactPage clickContactSourceFilter2OptionGoogle() {
	        System.out.println("Filter: Selecting Google Contact Source");
	        takeScreenshot();
	        waitForElementAndClick(CONTACT_SOURCE_FILTER_2_OPTION_GOOGLE);
	        return this;
	    }

	    public ContactPage clickDoneBtn3() {
	        System.out.println("Filter: Clicking Done button (Final)");
	        takeScreenshot();
	        waitForElementAndClick(DONE_BTN_3);
	        return this;
	    }

	    public ContactPage clickSubmitBtn() {
	        PageLoad.pause();
	        System.out.println("Create Group: Clicking Submit button");
	        takeScreenshot();
	        waitForElementAndClick(SUBMIT_BTN);
	        return this;
	    }

	    public void clickContactGroupMenu() {
	        System.out.println("Contact Group Menu: Opening Contact Group menu");
	        takeScreenshot();
	        clickContact();
	        waitForElementAndClick(CONTACT_GROUP_MENU);
	        PageLoad.pause();
	        takeScreenshot();
	    }

	    public String getGroupName() {
	        PageLoad.pauseThreeSecs();
	        System.out.println("Fetching created group name");
	        takeScreenshot();
	        return driver.findElement(
	                By.cssSelector(".sk-surface:nth-child(2) .sk-width-large > .sk-line-clamp")
	        ).getText();
	    }

	    public void deleteGroup(String groupName) {
	        System.out.println("Delete Group: Initiating group deletion");
	        takeScreenshot();
	        SearchGroup(groupName);
	        PageLoad.pause();
	        DeleteGroup();
	    }

	    private void SearchGroup(String groupName) {
	        PageLoad.pause();
	        System.out.println("Searching group by name");
	        takeScreenshot();
	        sendDelayedKeys(driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)), groupName);
	        PageLoad.pauseThreeSecs();
	        driver.findElement(By.xpath(SEARCH_BY_GROUP_NAME)).sendKeys(Keys.ENTER);
	    }

	    private void DeleteGroup() {
	        System.out.println("Deleting selected group");
	        takeScreenshot();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        WebElement menuButton = wait.until(
	                ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sk-overflow-menu']//button)[1]"))
	        );
	        menuButton.click();

	        WebElement deleteOption = wait.until(
	                ExpectedConditions.elementToBeClickable(By.cssSelector(".sk-show > li:nth-child(2)"))
	        );
	        deleteOption.click();

	        WebElement confirmBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.cssSelector(".sk-dialog:nth-child(4) .sk-button:nth-child(2) > .sk-ripple-container")
	                )
	        );
	        confirmBtn.click();
	        takeScreenshot();
	    }
}
