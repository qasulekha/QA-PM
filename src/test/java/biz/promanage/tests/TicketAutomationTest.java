package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.TicketAutomation;
import biz.promanage.base.BaseTest;
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
 
 
import java.io.IOException;
 
public class TicketAutomationTest extends BaseTest {
 
 
	
 
	@Test
	public void ticketAutomation() throws Exception {
 
	    new LoginPage(getDriver(), test).login(GetUserLoginCred());
 
	    if (new Customer(getDriver(), test).changeCustomer("ProManage")) {
 
	        TicketAutomation page = new TicketAutomation(getDriver(), test);
 
	        page.load()
	                .clickTicketAutomation()
	                .clickCreateRule()
	                .clickRuleName()
	                .clickSelectLocation()
	                .clickReviewType()
	                .clickAssignToUser()
	                .clickEdit()
	                ;
 
					
					  String latestRule = page.getLatestRuleName();
					 
					  String previousRule = page.getPreviousRuleName(latestRule);
					 
 
	        Assert.assertTrue(
	                page.isPreviousRuleStopped(),
	                "Previous rule should be marked as Stopped.");
	    }
	}
}