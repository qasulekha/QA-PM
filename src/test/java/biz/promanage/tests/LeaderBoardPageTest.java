package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LeaderBoardPage;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LeaderBoardPageTest extends BaseTest {

    @Test
    public void LeaderBoardTest() throws IOException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Aster Pharmacy")) {
            LeaderBoardPage leaderBoardPage = new LeaderBoardPage(getDriver(), test);
            leaderBoardPage.load().selectYearAndMonth().verifyCityFilter().compareLeaderboardResults().verifyGroupFilter();
        }
    }
}

