package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LeaderBoardPage;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.RatingGoals;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RatingGoalsTest extends BaseTest {

    @Test
    public void RatingGoalsPageTest() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("ProManage")) {
        	RatingGoals ratingGoals = new RatingGoals(getDriver(), test);
        	ratingGoals.load().clickGroupGoals().clickStoreWiseGoals().clickViewHistory();
        }
    }
}

