package biz.promanage.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.Discovery;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;
import biz.promanage.listeners.RetryAnalyzer;
import biz.promanage.utils.TeamsAlert;

public class DiscoveryTabTest extends BaseTest{
	int retryCount = 0;
	
	
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Discovery() throws IOException, InterruptedException {
		TeamsAlert comonmethods = new TeamsAlert();
		 
		try {
			 //if (new Customer(getDriver(), test).changeCustomer("Muthoot Finance Limited")) {
		 new LoginPage(getDriver(), test).login(GetUserLoginCred());
		 Discovery discoveryPage=new Discovery(getDriver(), test);
		 discoveryPage.Discoverytab().ValidateDiscoveryData();
			// }
		  }catch (Exception e) {
             System.out.println("Problems in loading site");
             comonmethods.Teamsjson("Promanage", "Problems in loading site","fail", "");
             if (retryCount == 2) {
            	 takeScreenshot(null); 
            	 //comonmethods.snap(driver);
//            	 comonmethods.mailWithAttachment("Promanage Failure alert", "Hi Team</br> \r\n"
// 						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; There was a problem in posting a lead.Kindly find the screenshot in this attachment</br>\r\n"
// 						+ "<br>" + "<b>Regards</b></br>\r\n" + "QA@sulekha.com");
 			}
             test.log(Status.FAIL, "Failed to login");
             throw e;
         }
		 
	

}
}
