package biz.promanage.tests;

import biz.promanage.Pages.ActivityApproval;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.InsightsCalls;
import biz.promanage.Pages.LoginPage;


import biz.promanage.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;

public class InsightsCallsTest extends BaseTest {

    @Test
    public void createInsightsCalls() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sterling Resorts")) {
        	InsightsCalls insightsCallsTest = new InsightsCalls(getDriver(), test);
        	insightsCallsTest.clickInsights().createInsightsCalls();
        	
  
                  
        }
        
    }
}
