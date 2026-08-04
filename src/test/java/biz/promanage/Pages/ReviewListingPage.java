package biz.promanage.Pages;

import java.time.Duration;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ReviewListingPage extends BasePage {

	By Reputaion_Management = By.xpath("(//span[@class='sk-ripple-container'])[14]");
	By Reviews = By.xpath("(//span[@class='sk-ripple-container'])[15]");
	By InActive_Tab = By.xpath("//a[text()=' In-Active ']");
	By Active_Tab = By.xpath("//a[text()=' Active ']");
	By Date_Filter = By.xpath("//div[contains(@class,'sk-event-group')][.//span[text()='date_range']]");
	By All = By.xpath("//li[text()=' All ']");
	By Summarize = By.xpath("//button[@class='sk-button sk-small sk-primary-outline sk-mobile-hide']");
	// (//span[@class='sk-button-text'])[36]
	By Dismiss_Summarize = By.xpath("(//button[contains(@class,'sk-primary-text')][.//span[text()='Dismiss']])[2]");
	// //div[@id='ReviewSummaryContent']/preceding-sibling::div//span[normalize-space()='Dismiss']
	By Review_Filter = By.xpath("//button[@class='sk-button sk-rounded sk-small sk-secondary-outline sk-mobile-hide']");
	// (//span[@class='sk-icons'])[74]
	By Review_Type = By.xpath("//label[text()='With Review Text ']");
	By Review_Response = By.xpath("//label[text()='All Responses ']");
	By Rating3 = By.xpath("//label[text()='3']");
	By Rating5 = By.xpath("//label[text()='5']");
	By Filter_Apply = By.xpath("(//button[@class='sk-button sk-primary'])[10]");
	By Filter_Reset = By.xpath("(//button[@class='sk-button sk-button-link'])[3]");

	By ReviewSummary = By.id("ReviewSummaryContent");
	By OverallSummary = By.xpath("//strong[normalize-space()='Overall Summary:']");
	By ViewMore_CTA = By.xpath("(//button[@class='sk-button sk-pill'])[2]");
	
	By Sort_By = By.xpath("(//div[@class='sk-event-group'])[3]");	
	By Newest = By.xpath("(//li[text()='Newest '])[1]");
	By Oldest = By.xpath("(//li[text()='Oldest '])[1]");
	By Posted_Dates = By.xpath("(//small[contains(.,'Posted On:')])[2]");
	
	
	
	public ReviewListingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	public ReviewListingPage clickReputation() {
		
		
		 load("/app/reviews");
		 System.out.println("To Click Reviews sucessfully");
			/*
			 * waitForElementAndClick(Reputaion_Management); test.log(Status.INFO,
			 * "Reputation dropdown Clicked");
			 */
		takeScreenshot();
		return this;
	}

	public ReviewListingPage clickReview() {
		
		waitForElementAndClick(Reviews);
		System.out.println("To click Review");
		test.log(Status.INFO, "Reviews Clicked");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage switcInActiveTab() {
		
		wait.until(ExpectedConditions.elementToBeClickable(InActive_Tab)).click();
		System.out.println("Click InActive Tab");
		PageLoad.pauseThreeSecs();
		waitForPageLoaderToDisappear();
		test.log(Status.INFO, "InActive Tab Clicked");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage switchActiveTab() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Active_Tab)).click();
		System.out.println("Click Active Tab");
		PageLoad.pauseThreeSecs();
		waitForPageLoaderToDisappear();
		test.log(Status.INFO, "Active Tab Clicked");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage clickDateFilter() {
	
		waitForElementAndClick(Date_Filter);
		waitForElementAndClick(All);
		System.out.println("Click Date Filter");
		test.log(Status.INFO, "Selected Date Filter");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage clickSummarize() throws InterruptedException {
		/*
		 * Thread.sleep(3000); System.out.println("Click Summarize");
		 * waitForElementAndClick(Summarize); PageLoad.pauseTenSeconds();
		 * test.log(Status.INFO, "View Summarize"); takeScreenshot(); return this;
		 */

		
		wait.until(ExpectedConditions.elementToBeClickable(Summarize)).click();
		PageLoad.pauseThreeSecs();
		wait.until(ExpectedConditions.elementToBeClickable(ViewMore_CTA)).click();
		PageLoad.pauseThreeSecs();
		System.out.println("Clicked Summarize");
		test.log(Status.INFO, "Clicked Summarize");
		 takeScreenshot();
		return this;

	}

	
	  
	  public ReviewListingPage dismissSummarize() {
	  
	  waitForElementAndClick(Dismiss_Summarize); 
	  System.out.println("Dismissed Summarize");
	  test.log(Status.INFO,
	  "Dismissed Summarize");
	  takeScreenshot();
	  return this; 
	  }
	
	 

	public ReviewListingPage clickReviewFilter() throws InterruptedException {
		
		waitForElementAndClick(Review_Filter);
		System.out.println("Review Filter Clicked");
		Thread.sleep(4000);
		test.log(Status.INFO, "Review Filter clicked");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage reviewType() {
		
		waitForElementAndClick(Review_Type);
		System.out.println("Selecting Review type");
		test.log(Status.INFO, "Review type selected");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage response() {
		
		waitForElementAndClick(Review_Response);
		System.out.println("Selecting Review Response");
		test.log(Status.INFO, "Review response selected");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage reviewRating() {
		
		waitForElementAndClick(Rating3);
		waitForElementAndClick(Rating5);
		System.out.println("Selected Review Rating");
		test.log(Status.INFO, "Review Rating selected");
		takeScreenshot();
		return this;
	}

	public ReviewListingPage clickApply() {
		
		waitForElementAndClick(Filter_Apply);
		System.out.println("Clicked Apply button");
		test.log(Status.INFO, "Filter Applied");
		PageLoad.pauseThreeSecs();
		takeScreenshot();
		return this;
	}

	public ReviewListingPage filterReset() {
		
		waitForElementAndClick(Filter_Reset);
		System.out.println("Clicked Reset button");
		test.log(Status.INFO, "Filter Reset");
		PageLoad.pauseThreeSecs();
		takeScreenshot();
		return this;
	}

	/*
	 * public boolean isDismissButtonDisplayed() {
	 * 
	 * try {
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(Dismiss_Summarize));
	 * 
	 * List<WebElement> buttons = driver.findElements(Dismiss_Summarize);
	 * 
	 * System.out.println("Dismiss Elements Found = " + buttons.size());
	 * 
	 * for (WebElement button : buttons) {
	 * 
	 * System.out.println(button.getAttribute("outerHTML"));
	 * 
	 * if (button.isDisplayed()) { return true; } }
	 * 
	 * } catch (TimeoutException e) {
	 * System.out.println("Dismiss button not displayed."); }
	 * 
	 * return false; }
	 */

	public boolean isReviewSummaryDisplayed() {

		/*
		 * try {
		 * 
		 * return wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(ReviewSummary)) .isDisplayed();
		 * 
		 * } catch (TimeoutException e) {
		 * 
		 * return false; }
		 */

		try {

			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReviewSummaryContent")));

			String text = element.getText().trim();

			System.out.println("Review Summary Content : " + text);

			return text.contains("Overall Summary") && text.length() > 100;

		} catch (Exception e) {

			return false;

		}
	}

	public boolean isOverallSummaryDisplayed() {

		try {

			return wait.until(ExpectedConditions.visibilityOfElementLocated(OverallSummary)).isDisplayed();

		} catch (TimeoutException e) {

			return false;
		}
	}

	public boolean isReviewSummaryLoaded() {

		return isReviewSummaryDisplayed() 
				&& isOverallSummaryDisplayed();

		
	}
	
	public ReviewListingPage sortBy() {
		
		waitForElementAndClick(Sort_By);
		System.out.println("Clicked Sort by");
		test.log(Status.INFO, "Sort By");
		PageLoad.pauseThreeSecs();
		takeScreenshot();
		return this;
	}

	public ReviewListingPage sortByOld() {
		
		waitForElementAndClick(Oldest);
		System.out.println("Clicked Oldest");
		test.log(Status.INFO, "Sort By");
		PageLoad.pauseThreeSecs();
		takeScreenshot();
		return this;
	}
	
	public ReviewListingPage sortByNew() {
		
		waitForElementAndClick(Newest);
		System.out.println("Clicked Newest");
		test.log(Status.INFO, "Sort By");
		PageLoad.pauseThreeSecs();
		takeScreenshot();
		return this;
	}
	
	public ReviewListingPage postedOn() {
		
		return this;
	}
	
	/*
	 * public List<LocalDateTime> getReviewDates() {
	 * 
	 * List<WebElement> reviews = driver.findElements(Posted_Dates);
	 * 
	 * DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a");
	 * 
	 * List<LocalDateTime> dates = new ArrayList<>();
	 * 
	 * for (WebElement review : reviews) {
	 * 
	 * String text = review.getText();
	 * 
	 * String[] lines = text.split("\n");
	 * 
	 * String dateTime = lines[1].trim() + " " + lines[2].trim();
	 * 
	 * System.out.println(dateTime);
	 * 
	 * dates.add(LocalDateTime.parse(dateTime, formatter)); }
	 * 
	 * return dates; }
	 */
	
	public List<LocalDateTime> getReviewDates() {

	    List<WebElement> reviews = driver.findElements(Posted_Dates);

	    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
	            .parseCaseInsensitive()
	            .appendPattern("dd MMM yyyy hh:mm a")
	            .toFormatter(Locale.ENGLISH);

	    List<LocalDateTime> dates = new ArrayList<>();

	    for (WebElement review : reviews) {

	        String[] lines = review.getText().split("\\R");

	        String dateTime = (lines[1] + " " + lines[2])
	                .replace('\u00A0', ' ')   // Replace non-breaking spaces
	                .replaceAll("\\s+", " ")  // Normalize whitespace
	                .trim();

	        System.out.println("Date = [" + dateTime + "]");
	        System.out.println("Length = " + dateTime.length());

	        dates.add(LocalDateTime.parse(dateTime, formatter));
	    }

	    return dates;
	}
	
	public boolean verifyOldestSorting() {

	    List<LocalDateTime> dates = getReviewDates();

	    for (int i = 0; i < dates.size() - 1; i++) {

	        if (dates.get(i).isAfter(dates.get(i + 1))) {
	            return false;
	        }
	    }

	    return true;
	}
	
	public boolean verifyNewestSorting() {
		

	    List<LocalDateTime> dates = getReviewDates();

	    for (int i = 0; i < dates.size() - 1; i++) {

	        if (dates.get(i).isBefore(dates.get(i + 1))) {
	            return false;
	        }
	    }

	    return true;
	}
}
