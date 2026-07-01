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
 
	/*
	 * public CustomGroup load() { test.log(Status.INFO,
	 * "Loading Listing Management Page"); load("/app/ListingManagement");
	 * waitForPageLoaderToDisappear(); waitForPageLoadToComplete();
	 * takeScreenshot(); return this; }
	 * 
	 * public CustomGroup CreateCustomGroup(String groupName) {
	 * PageLoad.pauseTenSeconds(); dropdown = new
	 * Select(driver.findElement(By.xpath("//option[.='Action']/parent::select")));
	 * 
	 * if (isOptionPresent(groupName)) {
	 * 
	 * DeleteGroup(groupName); }
	 * 
	 * CreateGroup(groupName); return this; }
	 * 
	 * private void CreateGroup(String groupName) { PageLoad.pause();
	 * waitForElementAndClick(LOCATION_1); waitForElementAndClick(LOCATION_2);
	 * selectOption("Create Custom Group");
	 * waitForElementToBeVisible(CUSTOM_GROUP_NAME); type(CUSTOM_GROUP_NAME,
	 * groupName); test.log(Status.INFO, "Creating custom group : " + groupName );
	 * takeScreenshot(); waitForElementAndClick(CREATE_CUSTOM_GROUP_BTN);
	 * test.log(Status.INFO, "Custom group : " + groupName + " Created"); }
	 * 
	 * public void verifyCustomGroup(String customGroup) { PageLoad.pause();
	 * test.log(Status.INFO, "Location Filter Clicked");
	 * 
	 * try { PageLoad.pause(); waitForElementAndClick(FILTER_DDL);
	 * waitForElementAndClick(CUSTOM_GROUP_TAB);
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
	 * "svg.sk-circular")));
	 * wait.until(ExpectedConditions.elementToBeClickable(LOCATION_SEARCH_BOX)).
	 * click();
	 * sendDelayedKeys(driver.findElement(By.cssSelector(".filter-padding .sk-input"
	 * )), customGroup); WebElement element = waitForElementToBeVisible(By.xpath(
	 * "//ul[@class='location-filter-list']/li//p[normalize-space(.)='" +
	 * customGroup + "']")); if (element.getText().trim().equals(customGroup)) {
	 * test.log(Status.PASS, "Custom group '" + customGroup +
	 * "' verified successfully."); takeScreenshot(); } else { test.log(Status.FAIL,
	 * "Text mismatch for custom group. Expected: '" + customGroup + "', Found: '" +
	 * element.getText() + "'"); takeScreenshot(); } } catch (TimeoutException e) {
	 * test.log(Status.FAIL, "Timeout: Custom group '" + customGroup +
	 * "' not found."); takeScreenshot(); } catch (NoSuchElementException e) {
	 * test.log(Status.FAIL, "No such element: Custom group '" + customGroup +
	 * "' not found."); takeScreenshot(); } catch (Exception e) {
	 * test.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	 * takeScreenshot(); } }
	 * 
	 * private void DeleteGroup(String groupName) { PageLoad.pause();
	 * selectOption(groupName); waitForElementAndClick(DELETE_GROUP_BTN);
	 * waitForElementAndClick(DELETE_OK_BTN); }
	 * 
	 * public boolean isOptionPresent(String optionText) { PageLoad.pause(); return
	 * dropdown.getOptions().stream().anyMatch(option ->
	 * option.getText().trim().equals(optionText)); }
	 * 
	 * public void selectOption(String optionText) { PageLoad.pause();
	 * dropdown.selectByVisibleText(optionText); }
	 * 
	 * public String getSelectedOption() { return
	 * dropdown.getFirstSelectedOption().getText().trim(); }
	 * 
	 * 
	 * public CustomGroup CreateCustomGroup1(String groupName) {
	 * waitForElementAndClick(LOCATION_3); PageLoad.pause();
	 * waitForElementAndClick(ACTION); PageLoad.pause(); test.log(Status.INFO,
	 * "Action filter clicked"); WebElement option =
	 * driver.findElement(By.xpath("//option[text()='AutomationCustomgroup']"));
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", option);
	 * PageLoad.pause(); option.click(); PageLoad.pause(); CreateGroup1(groupName);
	 * return this; }
	 * 
	 * private void CreateGroup1(String groupName) {
	 * waitForElementAndClick(CUSTOM_GROUP_SAVE_BTN); test.log(Status.INFO,
	 * "Custom group : " + groupName + " Created"); }
	 */
    
    
    public CustomGroup load() {
    	System.out.println("\nTo Create CustomGroup : ");
		System.out.println("\nLoading Listing Management Page");
		test.log(Status.INFO, "Loading Listing Management Page");
		load("/app/ListingManagement");
		waitForPageLoaderToDisappear();
		waitForPageLoadToComplete();
		takeScreenshot();
		System.out.println("Listing Management Page loaded successfully");
		return this;
	}

	public CustomGroup CreateCustomGroup(String groupName) {
		System.out.println("CreateCustomGroup started for group: " + groupName);
		PageLoad.pauseTenSeconds();
		dropdown = new Select(driver.findElement(By.xpath("//option[.='Action']/parent::select")));

		if (isOptionPresent(groupName)) {
			System.out.println("Group already exists. Deleting group: " + groupName);

			DeleteGroup(groupName);
		}

		CreateGroup(groupName);
		return this;
	}

	private void CreateGroup(String groupName) {
		System.out.println("Creating custom group: " + groupName);
		PageLoad.pause();
		waitForElementAndClick(LOCATION_1);
		System.out.println("Location 1 selected");
		waitForElementAndClick(LOCATION_2);
		System.out.println("Location 2 selected");
		selectOption("Create Custom Group");
		System.out.println("Create Custom Group option selected");
		waitForElementToBeVisible(CUSTOM_GROUP_NAME);
		type(CUSTOM_GROUP_NAME, groupName);
		test.log(Status.INFO, "Creating custom group : " + groupName);
		System.out.println("Entered group name: " + groupName);
		takeScreenshot();
		waitForElementAndClick(CREATE_CUSTOM_GROUP_BTN);
		System.out.println("Create Custom Group button clicked");
		test.log(Status.INFO, "Custom group : " + groupName + " Created");
	}

	public void verifyCustomGroup(String customGroup) {
		System.out.println("Verifying custom group: " + customGroup);
		PageLoad.pause();
		test.log(Status.INFO, "Location Filter Clicked");

		try {
			waitForElementAndClick(FILTER_DDL);
			System.out.println("Filter dropdown clicked");
			waitForElementAndClick(CUSTOM_GROUP_TAB);
			System.out.println("Custom group tab clicked");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("svg.sk-circular")));
			wait.until(ExpectedConditions.elementToBeClickable(LOCATION_SEARCH_BOX)).click();
			sendDelayedKeys(driver.findElement(By.cssSelector(".filter-padding .sk-input")), customGroup);
			System.out.println("Entered custom group name in search");
			WebElement element = waitForElementToBeVisible(
					By.xpath("//ul[@class='location-filter-list']/li//p[normalize-space(.)='" + customGroup + "']"));
			if (element.getText().trim().equals(customGroup)) {
				test.log(Status.PASS, "Custom group '" + customGroup + "' verified successfully.");
				System.out.println("Custom group verified successfully");
				takeScreenshot();
			} else {
				test.log(Status.FAIL, "Text mismatch for custom group. Expected: '" + customGroup + "', Found: '"
						+ element.getText() + "'");
				System.out.println("Custom group text mismatch");
				takeScreenshot();
			}
		} catch (TimeoutException e) {
			test.log(Status.FAIL, "Timeout: Custom group '" + customGroup + "' not found.");
			System.out.println("Timeout while verifying custom group");
			takeScreenshot();
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "No such element: Custom group '" + customGroup + "' not found.");
			System.out.println("Custom group element not found");
			takeScreenshot();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unexpected error: " + e.getMessage());
			System.out.println("Unexpected error while verifying custom group: " + e.getMessage());
			takeScreenshot();
		}
	}

	private void DeleteGroup(String groupName) {
		System.out.println("Deleting custom group: " + groupName);
		PageLoad.pause();

		selectOption(groupName);
		takeScreenshot();

		waitForElementAndClick(DELETE_GROUP_BTN);
		System.out.println("Delete button clicked");

		waitForElementAndClick(DELETE_OK_BTN);
		System.out.println("Delete confirmation accepted");
		takeScreenshot();
	}

	/*
	 * private void DeleteGroup(String groupName) { PageLoad.pause();
	 * selectOption(groupName); waitForElementAndClick(DELETE_GROUP_BTN);
	 * waitForElementAndClick(DELETE_OK_BTN); }
	 */

	public boolean isOptionPresent(String optionText) {
		PageLoad.pause();
		boolean isPresent = dropdown.getOptions().stream()
				.anyMatch(option -> option.getText().trim().equals(optionText));

		System.out.println("Is option present [" + optionText + "] : " + isPresent);
		return isPresent;
	}

	/*
	 * public boolean isOptionPresent(String optionText) { PageLoad.pause(); return
	 * dropdown.getOptions().stream().anyMatch(option ->
	 * option.getText().trim().equals(optionText));
	 * 
	 * }
	 */

	public void selectOption(String optionText) {
		PageLoad.pause();
		dropdown.selectByVisibleText(optionText);
		System.out.println("Dropdown option selected: " + optionText);
	}

	/*
	 * public String getSelectedOption() { return
	 * dropdown.getFirstSelectedOption().getText().trim();
	 * System.out.println("Currently selected option: " + selected); }
	 */
	public String getSelectedOption() {
		String selected = dropdown.getFirstSelectedOption().getText().trim();
		System.out.println("Currently selected option: " + selected);
		return selected;
	}

	public CustomGroup CreateCustomGroup1(String groupName) {
		System.out.println("CreateCustomGroup1 started for: " + groupName);
		waitForElementAndClick(LOCATION_3);
		PageLoad.pause();
		waitForElementAndClick(ACTION);
		PageLoad.pause();
		test.log(Status.INFO, "Action filter clicked");
		System.out.println("Action filter clicked");
		WebElement option = driver.findElement(By.xpath("//option[text()='AutomationCustomgroup']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		PageLoad.pause();
		option.click();
		System.out.println("AutomationCustomgroup selected");
		PageLoad.pause();
		CreateGroup1(groupName);
		return this;
	}

	private void CreateGroup1(String groupName) {
		waitForElementAndClick(CUSTOM_GROUP_SAVE_BTN);
		test.log(Status.INFO, "Custom group : " + groupName + " Created");
		System.out.println("Custom group created successfully: " + groupName);
	}

}
