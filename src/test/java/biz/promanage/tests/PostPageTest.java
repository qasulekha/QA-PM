package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.PostPage;

import biz.promanage.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;

public class PostPageTest extends BaseTest {

    @Test
    public void createPost() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.com")) {
        	 
            PostPage postPageTest = new PostPage(getDriver(), test);
            postPageTest
                    .clickInsights()
            		.clickListingManagement()
                    .clickBusinessProfile()
                    .clickBusinessProfileId()
                    .clickPost()
                    .addNewPost()
                    .addCompanyName();
                   // .clickUploadBtn()
                    //.uploadDoc("ProfileImage","C:\\Desktop Files\\Blogs\\Images\\2024-08-15.jpg");
            
            
            
                   
                   // .enterWebsiteAddress("www.sulekha.com")
                 //  .publish();
        }
    }
}
