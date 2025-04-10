package biz.promanage.Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import biz.promanage.base.BasePage;
import biz.promanage.listeners.RetryAnalyzer;
import biz.promanage.utils.PageLoad;
import biz.promanage.utils.TeamsAlert;

public class MyDashBoard extends BasePage {
	TeamsAlert comonmethods = new TeamsAlert();
	
	
	public MyDashBoard(WebDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}
	public MyDashBoard load() {
		test.log(Status.INFO, "Loading MyDashBoard Page");
		load("/app/insights");
		waitForPageLoaderToDisappear();
		return this;
	}


	

public void Storedata() throws InterruptedException, MalformedURLException, IOException {
	//TeamsAlert comonmethods = new TeamsAlert();
	  ArrayList<String> values = new ArrayList<>();
	  ArrayList<String> missingDataPoints = new ArrayList<>();
	 RetryAnalyzer retryAnalyzer = new RetryAnalyzer();
    Thread.sleep(25000); // Wait for elements to load

    String[] dataPoints =
    		  {"Total Values","Activity", "Views", "Overall Contact", "Profiles protected", "Unauthorized changes", "Discovery Activity", "Discovery Views", "Searches Value", "Overall Rating", "Current Rating", "Total Health Score"};
    String[] dataPoints1 =
    	      {"Total Values","Activity", "Views", "Overall Contact", "Profiles protected", "Unauthorized changes", "Discovery Activity", "Discovery Views", "Searches Value", "Overall Rating", "Current Rating", "Total Health Score" };
    		  String[] xPaths = { 
    	      "(//div[@class='sk-card animated'])[1]//div[@class='sk-h3']",
    		  "(//div[@class='sk-card animated'])[1]//ul//li//b",
    		  "((//div[@class='sk-card animated'])[1]//ul//li[2])//b",
    		  "//div[@class='sk-col-4 sk-col-fluid sk-flex']//div[@class='sk-h3']",
    		  "((//div[@class='sk-card animated'])[2]//div[@class='sk-h3'])[1]",
    		  "((//div[@class='sk-card animated'])[2]//div[@class='sk-h3'])[2]",
    		  "((//div[@class='sk-card animated'])[3]//b)[2]",
    		  "(((//div[@class='sk-card animated'])[3]//b)[4])", 
    		  "(//div[@class='sk-card animated'])[4]//div[@class='sk-h3']",
    		  "(//div[@class='sk-card animated'])[5]//div[@class='sk-h3']",
    		  "((//div[@class='sk-card animated'])[5]//span)[4]",
    		  "((//div[@class='sk-card animated'])[6]//b)[1]",
    		  
    		  
    		  
    		  
    		 
        };
    		  for (int i = 0; i < xPaths.length; i++) {
    		        try {
    		        	//scroll(By.xpath(xPaths[i])); // Scroll to the element
    		            WebElement element = driver.findElement(By.xpath(xPaths[i]));
    		            String value = element.getText();
    		            if (!value.isEmpty()) {
    		                System.out.println("✔ " + dataPoints[i] + " fetched successfully: " + value);
    		                values.add(value);
    		            } 
    		            else {
    		                 missingDataPoints.add(dataPoints[i]);
//    		                
//    		                if (retryAnalyzer.getRetryCount() == 1) {
//    		                	comonmethods.Teamsjson("Promanage", "❌ Test failed on second attempt: \r\n[" +  dataPoints[i]+"]","fail", "");
//    		                    Assert.fail("Test failed: '" + dataPoints[i] + "' value is empty or null.");
//    		                } else if (retryAnalyzer.getRetryCount() == 2) {
//    		                	comonmethods.Teamsjson("Promanage", "❌ Test failed on third attempt: \r\n[" +  dataPoints[i]+"]","fail", "");
//    		                    Assert.fail("Test failed: '" + dataPoints[i] + "' value is empty or null.");
//    		                } else {
//    		                    System.out.println("❌ Value Not Fetched for: " + dataPoints[i]);
//    		                    comonmethods.Teamsjson("Promanage", "❌ Test failed on first attempt: \r\n[" +  missingValues +"]","fail", "");
//    		                    Assert.fail("Test failed: '" + dataPoints[i] + "' value is empty or null.");
//    		                }
    		            }
    		        }
    		        catch (Exception e) {
    		            System.out.println("❌ Exception encountered while fetching value for " + dataPoints1);
    		            if (retryAnalyzer.getRetryCount() == 1) {
    		            	comonmethods.Teamsjson("Promanage", "❌ Test failed on second attempt: \r\n [Total Values,Activity,Views,Overall Contact,Profiles protected,Unauthorized changes,Discovery Activity,Discovery Views,Searches Value,Overall Rating,Current Rating,Total Health Score]","fail", "");
    		                Assert.fail("Test failed: '" + dataPoints1 + "' value is empty or null.");
    		            } else if (retryAnalyzer.getRetryCount() == 2) {
    		            	comonmethods.Teamsjson("Promanage", "❌ Test failed on third attempt: \r\n[Total Values,Activity,Views,Overall Contact,Profiles protected,Unauthorized changes,Discovery Activity,Discovery Views,Searches Value,Overall Rating,Current Rating,Total Health Score]","fail", "");
    		                Assert.fail("Test failed: '" + dataPoints1 + "' value is empty or null.");
    		            } else {
    		                System.out.println("❌ Value Not Fetched for: " + dataPoints1);
    		                comonmethods.Teamsjson("Promanage", "❌ Test failed on first attempt: \r\n[Total Values,Activity,Views,Overall Contact,Profiles protected,Unauthorized changes,Discovery Activity,Discovery Views,Searches Value,Overall Rating,Current Rating,Total Health Score]","fail", "");
    		                Assert.fail("Test failed: '" + dataPoints1 + "' value is empty or null.");
    		            }
//    		            Assert.fail("Test failed: Exception occurred while retrieving '" + dataPoints[i] + "' value.");
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
