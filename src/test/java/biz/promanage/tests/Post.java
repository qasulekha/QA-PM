package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.PostPage;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Post extends BaseTest {

    @Test
    public void createPost() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.Com")) {
            PostPage postPage = new PostPage(getDriver(), test);
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