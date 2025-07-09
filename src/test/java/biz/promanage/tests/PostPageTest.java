package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.PostPage;
import biz.promanage.Pages.PostPages;
import biz.promanage.base.BaseTest;

import org.testng.annotations.Test;

import java.io.IOException;

public class PostPageTest extends BaseTest {

    @Test
    public void createPost() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.Com"))
        {
            PostPage postPageTest = new PostPage(getDriver(), test);
            postPageTest
            		.clickListingManagement()
                    .clickBusinessProfile()
                    .clickBusinessProfileId()
                    .clickPost()
                    .addNewPost()
                    .addCompanyName()
                    .clickUploadBtn()
                    .uploadDoc("ProfileImage","D:\\Blogs\\2024-08-15.jpg");
           
               
            
                    
            
                   // .enterWebsiteAddress("www.sulekha.com")
                 //  .publish();
        }
    }
}
