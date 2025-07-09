package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.PostPages;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Post extends BaseTest {

    @Test
    public void createPost() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.Com")) {
            PostPages postPage = new PostPages(getDriver(), test);
            postPage
                    .load()
                    .addNewPost()
                    .enterPostText("Automation Post")
                    .addCompanyAddress()
                    .uploadFile("images/post.png")
                    .enterWebsiteAddress("www.sulekha.com")
                    .publish();
        }
    }
}