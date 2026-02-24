package biz.promanage.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;

public class AlignPage extends BasePage {

	By A_L_I_G_N = By.xpath("(//span[@class='sk-ripple-container'])[3]/parent::a");
	By CREATE_TASK = By.xpath("//button[@class='sk-button sk-primary sk-fab sk-leading-icon fab-bottom task-fab-btn']");
	By ENTER_TITLE = By.xpath("//input[@placeholder='Enter title']");
	By SELECT_CUS = By.xpath("//input[@placeholder='Select Customer']");
	By SUL = By.xpath("((//ul[@id='skOverflowMenu'])[5]//li)[2]");
	By Assigned_To = By.xpath("(//input[@placeholder='Assign To'])[2]");
	By CMO = By.xpath("((//ul[@id='skOverflowMenu'])[6]//li)[1]");
	By STATUS = By.xpath("(//div[@class='sk-selected-text'])[15]/parent::div");

	By EDIT_STATUS = By.xpath("(//span[text()='expand_more'])[13]");
	By EDIT_TASK_TYPE = By.xpath("(//span[text()='expand_more'])[14]");
	By EDIT_PRIORITY = By.xpath("(//span[text()='expand_more'])[15]");
	By INPROGRESS = By.xpath("//li[text()='In Progress ']");
	By NEW_FEATURE = By.xpath("(//li[text()='New Feature '])[1]");
	By HIGH = By.xpath("(//li[text()='High '])[1]");

	By NEW = By.xpath("(//div[text()='New'])[6]");
	By SELTASK = By.xpath("(//span[text()='expand_more'])[19]");
	By PROTASK = By.xpath("(//li[text()='Program Management '])[2]");
	By PRIORITY = By.xpath("(//span[text()='expand_more'])[20]");
	By MED = By.xpath("(//li[text()='Medium '])[2]");
	By VISIBILITY = By.xpath("(//span[text()='expand_more'])[21]");
	By EXTERNAL = By.xpath("(//li[text()='External '])[2]");
	By INTERNAL = By.xpath("(//li[text()='Internal '])[2]");
	By DESCRIPTION = By.xpath("(//div[@class='ql-editor ql-blank'])[1]");
	By INClUSER = By.xpath("(//input[@type='text'])[24]");
	By CMO_TEST = By.xpath("(//li[text()='New CMO '])[2]");
	// By COMMENT = By.xpath("(//div[@class='ql-editor ql-blank'])[2]");
	By ATTACH_FILE = By.xpath("(//span[text()='Attach File'])[2]");
	By SAVE = By.xpath("((//div[@class='sk-text-end sk-button-group'])[2]//button)[2]");
	By SEARCH_BOX = By.xpath("(//input[@placeholder='Search Task'])[1]");
	By CLICK_TASK = By.xpath("//button[@class='sk-button sk-button-link sk-small sk-truncate sk-no-shadow']");
	By CLOSE_TASK = By.xpath("(//button[@class='sk-button sk-round sk-mobile-hide sk-no-shadow'])[8]");
	By FILTER = By.xpath("(//button[@class='sk-button sk-small sk-secondary-outline sk-mobile-hide'])[2]");
	By FILTER_VISIBILITY = By.xpath("(//div[@class='sk-checkbox sk-show'])[57]");
	By FILTER_TASK_STATUS = By.xpath("(//div[@class='sk-checkbox sk-show'])[58]");
	By FILTER_PRIORITY = By.xpath("(//div[@class='sk-checkbox sk-show'])[64]");
	By FILTER_TASK_TYPE = By.xpath("(//div[@class='sk-checkbox sk-show'])[67]");
	By FILTER_APPLY = By.xpath("(//button[@class='sk-button sk-primary'])[7]");
	By RESET = By.xpath("(//button[@class='sk-button sk-button-link'])[3]");
	By SELECT_CUSTOMER = By.xpath("(//div[@class='sk-selected-text'])[6]/parent::div");
	By SEARCH_CUSTOMER = By.xpath("//input[@placeholder='Search customer']");
	By CUSTOMER_NAME = By.xpath("(//div[@class='sk-checkbox sk-show'])[56]");
	By SUBMIT = By.xpath("(//button[@class='sk-button sk-small sk-primary'])[1]");
	By EDIT_COMMENT = By.xpath("//button[@class='sk-button sk-round sk-small sk-primary-text sk-button-link']");
	By UPDATE_COMMENT = By.xpath("(//button[@class='sk-button sk-small sk-primary'])[1]");
	By EDIT = By.xpath("(//div[@class='ql-editor'])[2]");
	By INCLUDE_USER = By.xpath("(//div[@class='sk-chip sk-chip-removable sk-bg-success sk-small'])[1]");
	By PAST_DUE = By.xpath("(//div[@class='sk-switch'])[3]");
	By SAVE_TASK = By.xpath("(//button[@class='sk-button sk-primary'])[8]");

	public AlignPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public AlignPage clickAlign() {
		System.out.println("\nTo Create Align Task :");
		System.out.println("\nAim to Click Align");
		waitForElementAndClick(A_L_I_G_N);
		test.log(Status.INFO, "Align Clicked");
		takeScreenshot();
		return this;
	}

	public AlignPage searchTask(String searchTask) throws InterruptedException {

		PageLoad.pause();
		System.out.println("Aiming to click Searchbox");
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BOX));
		sendDelayedKeys(searchBox, searchTask);
		Thread.sleep(2000);
		waitForElementAndClick(CLICK_TASK);
		PageLoad.pauseThreeSecs();
		// waitForElementAndClick(CLOSE_TASK);
		test.log(Status.INFO, "Searched for Task");
		takeScreenshot();
		return this;

	}

	public AlignPage clickcreaBut() {
		System.out.println("Aiming to Click Create button");
		waitForElementAndClick(CREATE_TASK);
		test.log(Status.INFO, "Create Task Clicked");
		return this;
	}

	public AlignPage enterTitle(String ti) {
		System.out.println("Aiming to Enter Title");
		WebElement title = wait.until(ExpectedConditions.elementToBeClickable(ENTER_TITLE));
		sendDelayedKeys(title, ti);
		test.log(Status.INFO, "Title Entered");
		return this;
	}

	public AlignPage enterCus(String cus) {
		System.out.println("Aiming to Enter Customer");
		WebElement cusName = wait.until(ExpectedConditions.elementToBeClickable(SELECT_CUS));
		sendDelayedKeys(cusName, cus);
		waitForElementAndClick(SUL);
		test.log(Status.INFO, "Customer Selected");
		return this;
	}

	public AlignPage enterassignee(String as) {
		System.out.println("Aiming to ENter Assignee");
		WebElement assign = wait.until(ExpectedConditions.elementToBeClickable(Assigned_To));
		sendDelayedKeys(assign, as);
		waitForElementAndClick(CMO);
		test.log(Status.INFO, "Assignee Selected");
		return this;
	}

	public AlignPage selectStatus() {
		System.out.println("Aiming to select status");
		waitForElementAndClick(STATUS);
		// waitForElementAndClick(NEW);
		test.log(Status.INFO, "Status Selected");
		return this;
	}

	public AlignPage selectTask() {
		System.out.println("Aiming to select task");
		waitForElementAndClick(SELTASK);
		test.log(Status.INFO, "Task Clicked");
		return this;
	}

	public AlignPage proTask() {
		System.out.println("Aiming to select ProManage Task");
		waitForElementAndClick(PROTASK);
		test.log(Status.INFO, "ProManage Task Selected");
		return this;
	}

	public AlignPage priority() {
		System.out.println("Aiming to Select Priority");
		waitForElementAndClick(PRIORITY);
		waitForElementAndClick(MED);
		test.log(Status.INFO, "Priority Selected");
		return this;
	}

	public AlignPage visibility() {
		System.out.println("Aiming to select invalid visibility");
		waitForElementAndClick(VISIBILITY);
		waitForElementAndClick(INTERNAL);
		test.log(Status.INFO, "Internal Visibility Selected");
		takeScreenshot();
		return this;
	}

	public AlignPage visibility1() {
		System.out.println("Aiming to select valid visibility");
		waitForElementAndClick(VISIBILITY);
		waitForElementAndClick(EXTERNAL);
		PageLoad.pauseThreeSecs();
		test.log(Status.INFO, "External Visibility Selected");
		return this;
	}


	public AlignPage description(String desc) {
		System.out.println("Aiming to enter Desripton");
		// Wait until the description editor is visible
		WebElement de = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'sk-form-row')][div[contains(text(),'Description')]]//div[contains(@class,'ql-editor')]")));

		// Ensure any loader/overlay is gone before interacting (update CSS if loader
		// differs)
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-overlay, .sk-spinner") 
																														
			));
		} catch (Exception e) {
			test.log(Status.INFO, "No loader overlay found, proceeding...");
		}

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", de);

		// Try JS click to avoid interception
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", de);

		// Send description text
		de.sendKeys(desc);

		test.log(Status.INFO, "Description Entered");
		return this;


	}



	public AlignPage attachFile() {
		waitForElementAndClick(ATTACH_FILE);
		return this;
	}

	public AlignPage includeUser(String user) {
		System.out.println("Aiming for include user");
		WebElement in = wait.until(ExpectedConditions.elementToBeClickable(INClUSER));
		sendDelayedKeys(in, user);
		waitForElementAndClick(CMO_TEST);
		test.log(Status.INFO, "Include User Selected");
		return this;
	}


	public AlignPage comment(String com) {

		System.out.println("Aiming to enter comment");
		WebElement co = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'sk-form-row')][div[contains(text(),'Add Comment')]]//div[contains(@class,'ql-editor')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", co);
		co.click();
		co.sendKeys(com);
		test.log(Status.INFO, "Comment Entered");
		PageLoad.pauseThreeSecs();
		return this;
	}



	public AlignPage editComment() {
		System.out.println("Aiming to edit a comment");
		waitForElementAndClick(EDIT_COMMENT);
		PageLoad.pauseOneSec();
		WebElement ed = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ql-editor'])[2]")));
		ed.click();
		ed.sendKeys(". It is Important");
		return this;
	}

	public AlignPage updateComment() {
		System.out.println("Aiming to click update comment");
		PageLoad.pauseOneSec();
//		WebElement clearTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='sk-button sk-small sk-primary'])[1]")));
//		clearTxt.clear();
		waitForElementAndClick(UPDATE_COMMENT);
		PageLoad.pauseThreeSecs();
		test.log(Status.INFO, "Comment Updated");
		takeScreenshot();
		return this;
	}

	public AlignPage save() throws InterruptedException {
		System.out.println("Aiming to click save");
		// Thread.sleep(5000);
		waitForElementAndClick(SAVE);
		Thread.sleep(5000);

		test.log(Status.INFO, "Task Saved");
		takeScreenshot();
		return this;

	}

//	public String getSelectedVisibility() {
//
//		PageLoad.pauseOneSec();
//		String visibility = driver.findElement(By.xpath("(//li[text()='External '])[2]")).getText();
//		System.out.println("Task Visibility : "+visibility);
//		test.log(Status.INFO, "Retrieved Selected Visibility");
//		takeScreenshot();
//		return visibility;
//
//	}

	public String getSelectedStatus() {
		PageLoad.pauseThreeSecs();
		String status = driver.findElement(By.xpath("//div[text()='In Progress']")).getText();
		System.out.println("Task Status : "+status);
		test.log(Status.INFO, "Retrieved Selected Status");
		return status;
	}


	public String getSelectedTaskType() {
		String task = driver.findElement(By.xpath("//td[text()='New Feature']")).getText();
		System.out.println("Task Type : "+task);
		test.log(Status.INFO, "Retrieved Selected Task Type");
		return task;
	}

	public String getSelectedPriority() {
		String priority = driver.findElement(By.xpath("(//td[text()='High'])[1]")).getText();
		System.out.println("Task Priority : "+priority);
		test.log(Status.INFO, "Retrieved Selected Priority");
		return priority;
	}

	public String getTaskName() {
		PageLoad.pauseThreeSecs();
		String taskName = driver.findElement(By.xpath("//div[text()='#SUL-682']")).getText();
		System.out.println("Task Name : "+taskName);
		test.log(Status.INFO, "Retrieved Task Name");
		return taskName;
	}

//	public String getIncluseUser() throws InterruptedException {
//		PageLoad.pauseOneSec();
//		Thread.sleep(4000);
//		String inUser = driver.findElement(By.xpath(
//				"//div[@class='sk-panel sk-show sk-panel-fullscreen']//div[@class='sk-chip sk-chip-removable sk-bg-success sk-small']"))
//				.getText();
//		System.out.println("Include UseName : "+inUser);
//
//		test.log(Status.INFO, "Retrieved Incluse User");
//		return inUser;
//
//	}

	public AlignPage clickFilter() {
		System.out.println("Aiming to click Filter");
		waitForElementAndClick(FILTER);
		test.log(Status.INFO, "Filter Clicked");
		return this;
	}

	public AlignPage filterVisibility() {
		System.out.println("Aiming to select filter visibility");
		PageLoad.pauseThreeSecs();
		waitForElementAndClick(FILTER_VISIBILITY);
		test.log(Status.INFO, "Visibility Selected");
		return this;

	}

	public AlignPage taskStatus() {
		System.out.println("Aiming to select filter task");
		waitForElementAndClick(FILTER_TASK_STATUS);
		test.log(Status.INFO, "Task Status Selected");
		return this;
	}

	public AlignPage taskPriority() {
		System.out.println("Aiming to select filter task priority");
		waitForElementAndClick(FILTER_PRIORITY);
		test.log(Status.INFO, "Priority Selected");
		return this;
	}

	public AlignPage taskType() {
		System.out.println("Aiming to select filter task type");
		waitForElementAndClick(FILTER_TASK_TYPE);
		test.log(Status.INFO, "Task Type Selected");
		return this;
	}

	public AlignPage clickApply() {
		System.out.println("Aiming to click filter apply");
		PageLoad.pauseOneSec();
		waitForElementAndClick(FILTER_APPLY);
		test.log(Status.INFO, "Apply Button Clicked");
		takeScreenshot();
		return this;
	}

	public AlignPage clickSelectCustomer() {
		PageLoad.pauseOneSec();
		System.out.println("Aiming to click select customer field");
		waitForElementAndClick(SELECT_CUSTOMER);
		test.log(Status.INFO, "Select Customer Clicked");
		return this;
	}

	public AlignPage passCustmoerName(String cusName) {
		System.out.println("Aiming to enter customer name");
		WebElement passCus = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_CUSTOMER));
		sendDelayedKeys(passCus, cusName);
		PageLoad.pauseOneSec();
		waitForElementAndClick(CUSTOMER_NAME);
		test.log(Status.INFO, "Customer Name Clicked");
		return this;
	}

	public AlignPage clickSubmit() {
		System.out.println("Aiming to click submit customer");
		waitForElementAndClick(SUBMIT);
		test.log(Status.INFO, "Submit Clicked");
		takeScreenshot();
		return this;
	}

	public AlignPage showPastDue() {
		System.out.println("Aiming to click show past due toggle");
		waitForElementAndClick(PAST_DUE);
		PageLoad.pauseThreeSecs();
		test.log(Status.INFO, "Past Due Clicked");
		takeScreenshot();
		return this;
	}

	public AlignPage showPastDue1() {
		System.out.println("Aiming to click past due toggle to reset");
		waitForElementAndClick(PAST_DUE);
		PageLoad.pauseThreeSecs();
		test.log(Status.INFO, "Past Due Unclicked");
		takeScreenshot();
		return this;
	}

	public AlignPage saveTask() {
		PageLoad.pauseOneSec();
		waitForElementAndClick(SAVE_TASK);
		test.log(Status.INFO, "Task Saved");
		return this;
	}

	public AlignPage reset() {
		System.out.println("Aiming to click reset filter");
		PageLoad.pauseThreeSecs();
		waitForElementAndClick(RESET);
		test.log(Status.INFO, "Filter Resetted");
		takeScreenshot();
		return this;
	}

	public AlignPage editStatus() {
		System.out.println("Aiming to edit status field");
		PageLoad.pauseOneSec();
		waitForElementAndClick(EDIT_STATUS);
		PageLoad.pauseOneSec();
		waitForElementAndClick(INPROGRESS);
		return this;
	}

	public AlignPage editTaskType() {
		System.out.println("Aiming to edit task type");
		PageLoad.pauseOneSec();
		waitForElementAndClick(EDIT_TASK_TYPE);
		PageLoad.pauseOneSec();
		waitForElementAndClick(NEW_FEATURE);
		return this;
	}

	public AlignPage editPriority() {
		System.out.println("Aiming to edit priority");
		PageLoad.pauseOneSec();
		waitForElementAndClick(EDIT_PRIORITY);
		PageLoad.pauseOneSec();
		waitForElementAndClick(HIGH);
		return this;
	}

	public AlignPage verifyPastDueTasks() {
		// Wait for table to load
		PageLoad.pauseThreeSecs();
		System.out.println("Aiming to verify past due tasks");
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

		if (rows.isEmpty()) {
			test.log(Status.FAIL, "No tasks found in list!");
			return this;
		}

		boolean allValid = true;

		for (WebElement row : rows) {
			try {
				// Extract ETA
				WebElement etaElement = row.findElement(By.xpath(".//td[6]"));
				String etaText = etaElement.getText().replace("Past Due", "").trim();

				// Extract Status
				WebElement statusElement = row.findElement(By.xpath(".//td[7]"));
				String status = statusElement.getText().trim();

				// Validate status
				boolean validStatus = status.equals("New") && status.equals("In Progress");

				// Parse ETA date
				java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter
						.ofPattern("dd MMM yyyy");
				java.time.LocalDate etaDate = java.time.LocalDate.parse(etaText, formatter);
				java.time.LocalDate today = java.time.LocalDate.now();

				boolean isDateExceeded = etaDate.isBefore(today);

				// Check Past Due badge exists
				boolean hasPastDueBadge = etaElement.getText().contains("Past Due");

				if (!(validStatus && isDateExceeded && hasPastDueBadge)) {
					allValid = false;

					test.log(Status.INFO, "valid Past Due Task → ETA: " + etaText + ", Status: " + status + ", Badge: "
							+ hasPastDueBadge);

					takeScreenshot();
				}

			} catch (Exception e) {
				allValid = false;
				test.log(Status.INFO, "Error while verifying row: " + e.getMessage());
				takeScreenshot();
			}
		}

		return this;
	}
}
