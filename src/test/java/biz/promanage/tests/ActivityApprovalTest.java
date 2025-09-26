package biz.promanage.tests;

import biz.promanage.Pages.ActivityApproval;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.PostPage;
import biz.promanage.Pages.PostPages;
import biz.promanage.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;

public class ActivityApprovalTest extends BaseTest {

    @Test
    public void activityApproval() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.com")) {
        	 String APPROVED  ="Approved";
        	 String CMO ="CMO";
        	 String POST ="Posts";
        	 ActivityApproval activityApprovalTest = new ActivityApproval(getDriver(), test);
        	 activityApprovalTest
        	        .clickListingManagement()
            		.clickActivityApproval()
            		.clickActivityType()
            		.clickRespondedBy()
            		.clickStatus();
            
            
            
                    Assert.assertEquals(CMO, activityApprovalTest.getCMO());
                    test.log(Status.PASS, "Activity Approval updated. Status :  " + CMO);
            
            		Assert.assertEquals(APPROVED, activityApprovalTest.getApproval());
                    test.log(Status.PASS, "Activity Approval updated. Status :  " + APPROVED);   
            
                    
                    Assert.assertEquals(POST, activityApprovalTest.getPost());
                    test.log(Status.PASS, "Activity Approval updated. Status :  " + POST);   
                
        }
    }
}
