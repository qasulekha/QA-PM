package biz.promanage.Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import biz.promanage.base.BasePage;
import biz.promanage.listeners.RetryAnalyzer;
import biz.promanage.utils.TeamsAlert;

@Test
public class Discovery extends BasePage {
	
	TeamsAlert comonmethods = new TeamsAlert();
	private final By Discovery = By.xpath("//li[@id='nav-1']/span");

	public Discovery(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public Discovery load() {
		test.log(Status.INFO, "Loading Discovery tab Page");
		load("/app/insights/discovery");
		waitForPageLoaderToDisappear();
		return this;
	}

	public Discovery Discoverytab() throws MalformedURLException, IOException, InterruptedException {
		try {
		waitForElementAndClick(Discovery);
		} catch (Exception e) {
			 comonmethods.Teamsjson("Promanage", "❌ Test failed due to unclickable in Discovery tab ","fail", "");
			 Assert.fail("Test failed due to unclickable in Discovery tab ");
			 
		}
		return this;
		
	}
	public void ValidateDiscoveryData() throws InterruptedException, MalformedURLException, IOException {
		 ArrayList<String> missingDataPoints = new ArrayList<>();//TeamsAlert comonmethods = new TeamsAlert();
	    ArrayList<String> values = new ArrayList<>();
	   // List to store missing values
	    
	    RetryAnalyzer retryAnalyzer = new RetryAnalyzer();
	    Thread.sleep(25000); // Wait for elements to load


	    String[] dataPoints = { "View by device", "Maps Views", "Search views", "Directions Requests", "Phone Calls", "Website Visits", "Searches" };
	    String[] dataPoints1 = { "View by device", "Maps Views", "Search views", "Directions Requests", "Phone Calls", "Website Visits", "Searches" };
	    String[] xPaths = {
	            "//div[@class='device-details']/div/div",
	            "((//div[@class='sk-card animated'])[2]//div[@class='data-wrapper']//div[@class='sk-flex']/b)[1]",
	            "((//div[@class='sk-card animated'])[2]//div[@class='data-wrapper']//div[@class='sk-flex']/b)[2]",
	            "((//div[@class='sk-card-secondary'])[3]//div[@class='sk-flex'])[2]/b",
	            "((//div[@class='sk-card-secondary'])[3]//div[@class='sk-flex'])[4]/b",
	            "((//div[@class='sk-card-secondary'])[3]//div[@class='sk-flex'])[6]/b",
	            "(//div[@class='sk-card-secondary'])[5]//div[@class='sk-h3']"
	    };

	    for (int i = 0; i < xPaths.length; i++) {
	        try {
	        	scroll(By.xpath(xPaths[i])); // Scroll to the element
	            WebElement element = driver.findElement(By.xpath(xPaths[i]));
	            String value = element.getText();
	            
	            if (!value.isEmpty()) {
	                System.out.println("✔ " + dataPoints[i] + " fetched successfully: " + value);
	                values.add(value);
	            } 
	            else {
	                 missingDataPoints.add(dataPoints[i]);
//	                
//	                if (retryAnalyzer.getRetryCount() == 1) {
//	                	comonmethods.Teamsjson("Promanage", "❌ Test failed on second attempt: \r\n[" +  dataPoints[i]+"]","fail", "");
//	                    Assert.fail("Test failed: '" + dataPoints[i] + "' value is empty or null.");
//	                } else if (retryAnalyzer.getRetryCount() == 2) {
//	                	comonmethods.Teamsjson("Promanage", "❌ Test failed on third attempt: \r\n[" +  dataPoints[i]+"]","fail", "");
//	                    Assert.fail("Test failed: '" + dataPoints[i] + "' value is empty or null.");
//	                } else {
//	                    System.out.println("❌ Value Not Fetched for: " + dataPoints[i]);
//	                    comonmethods.Teamsjson("Promanage", "❌ Test failed on first attempt: \r\n[" +  missingValues +"]","fail", "");
//	                    Assert.fail("Test failed: '" + dataPoints[i] + "' value is empty or null.");
//	                }
	            }
	        } catch (Exception e) {
	            System.out.println("❌ Exception encountered while fetching value for " + dataPoints1);
	            if (retryAnalyzer.getRetryCount() == 1) {
	            	comonmethods.Teamsjson("Promanage", "❌ Test failed on second attempt: \r\n [View by device,Maps Views,Search views,Directions Requests,Phone Calls,Website Visits,Searches]","fail", "");
	                Assert.fail("Test failed: '" + dataPoints1 + "' value is empty or null.");
	            } else if (retryAnalyzer.getRetryCount() == 2) {
	            	comonmethods.Teamsjson("Promanage", "❌ Test failed on third attempt: \r\n[View by device,Maps Views,Search views,Directions Requests,Phone Calls,Website Visits,Searches]","fail", "");
	            	String screenshotPath = takeScreenshot();
					  comonmethods.mailWithAttachmentfile( "Promanage Failure alert",
					  "Hi Team</br>\r\n" +
					  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; There was a problem in loading promanage site. where widget is missing  "
					  + "[View by device,Maps Views,Search views,Directions Requests,Phone Calls,Website Visits,Searches] "+ "Kindly find the screenshot in this attachment</br>\r\n" +
					  "<br><b>Regards</b></br>\r\nQA@sulekha.com"
					  );
	            	Assert.fail("Test failed: '" + dataPoints1 + "' value is empty or null.");
	            } else {
	                System.out.println("❌ Value Not Fetched for: " + dataPoints1);
	                comonmethods.Teamsjson("Promanage", "❌ Test failed on first attempt: \r\n[View by device,Maps Views,Search views,Directions Requests,Phone Calls,Website Visits,Searches]","fail", "");
	                Assert.fail("Test failed: '" + dataPoints1 + "' value is empty or null.");
	            }
	            
//	            Assert.fail("Test failed: Exception occurred while retrieving '" + dataPoints[i] + "' value.");
	        }
	    }

	    // Check if any data points are missing and trigger failure message
	    if (!missingDataPoints.isEmpty()) {
	        String missingValues = String.join(", ", missingDataPoints);
	        if (retryAnalyzer.getRetryCount() == 1) {
            	comonmethods.Teamsjson("Promanage", "❌ Test failed on second attempt: \r\n[" +  missingValues+"]","fail", "");
                Assert.fail("Test failed: '" + missingValues + "' value is empty or null.");
            } else if (retryAnalyzer.getRetryCount() == 2) {
            	comonmethods.Teamsjson("Promanage", "❌ Test failed on third attempt: \r\n[" +  missingValues+"]","fail", "");
            	 takeScreenshot(); 
               	 //comonmethods.snap(driver);
            	 String screenshotPath = takeScreenshot();
					  comonmethods.mailWithAttachmentfile( "Promanage Failure alert",
					  "Hi Team</br>\r\n" +
					  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; There was a problem in loading promanage site. where widget is missing -"
					  + missingValues + " Kindly find the screenshot in this attachment</br>\r\n" +
					  "<br><b>Regards</b></br>\r\nQA@sulekha.com"
					  );
					
                Assert.fail("Test failed: '" + missingValues + "' value is empty or null.");
   
            } else {
                System.out.println("❌ Value Not Fetched for: " + missingValues);
                comonmethods.Teamsjson("Promanage", "❌ Test failed on first attempt: \r\n[" +  missingValues +"]","fail", "");
                Assert.fail("Test failed: '" + missingValues + "' value is empty or null.");
            }
	    } else {
	        System.out.println("✅ All data points fetched successfully.");
	    }
	    if (retryAnalyzer.getRetryCount() == 1) {
            System.out.println("✅ Value fetched on second attempt!");
            try {
				comonmethods.Teamsjson("Promanage", "✅ Value fetched on second attempt!","pass", "");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (retryAnalyzer.getRetryCount() == 2) {
            System.out.println("✅ Value fetched on third attempt!");
            try {
				comonmethods.Teamsjson("Promanage", "✅ Value fetched on third attempt! \r\n" ,"pass", "");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
