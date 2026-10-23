package biz.promanage.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import biz.promanage.Pages.AlignPage;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.ReviewListingPage;
import biz.promanage.base.BaseTest;

public class ReviewListingTest extends BaseTest{

	
	@Test
	public void reviewListingPage() throws IOException, InterruptedException {
		
		new LoginPage(getDriver(), test).login(GetUserLoginCred());
		if (new Customer(getDriver(), test).changeCustomer("ProManage")) {
		/*	ReviewListingPage reviewPage = new ReviewListingPage(getDriver(), test);
			reviewPage.clickReputation().clickReview().switcInActiveTab().switchActiveTab().clickDateFilter().clickReviewFilter().reviewType().response().reviewRating().clickApply().clickReviewFilter().filterReset().clickApply().clickSummarize();
			
			   // Verify Dismiss button
	        Assert.assertTrue(
	                reviewPage.isDismissButtonDisplayed(),
	                "Dismiss button is not displayed after clicking Summarize.");

	        // Close popup
	        reviewPage.dismissSummarize();*/
			
		    ReviewListingPage reviewPage = new ReviewListingPage(getDriver(), test);

	        reviewPage.clickReputation()
	                  .switcInActiveTab()
	                  .switchActiveTab()
	                  .clickDateFilter()
	                  .clickReviewFilter()
	                  .reviewType()
	                  .response()
	                  .reviewRating()
	                  .clickApply()
	                  .clickReviewFilter()
	                  .filterReset()
	                  .clickApply()
	                  .clickSummarize();

	        

	        System.out.println("Review Summary : "
	                + reviewPage.isReviewSummaryDisplayed());

	        System.out.println("Overall Summary : "
	                + reviewPage.isOverallSummaryDisplayed());

	      
	        Assert.assertTrue(
	                reviewPage.isReviewSummaryLoaded(),
	                "Review Summary failed to load completely.");

	        reviewPage.dismissSummarize();
	        
	        
	        // Verify Oldest
	        reviewPage.sortBy().sortByOld();
	        Assert.assertTrue(
	                reviewPage.verifyOldestSorting(),
	                "Reviews are not sorted in Oldest order.");
	       
	     // Verify Newest
	        reviewPage.sortBy()
	                  .sortByNew();

	        Assert.assertTrue(
	                reviewPage.verifyNewestSorting(),
	                "Reviews are not sorted in Newest order.");
		}
	}
		
}