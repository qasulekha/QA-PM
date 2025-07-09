package biz.promanage.tests;
import biz.promanage.Pages.Customer;

import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.MyDashBoard;
import biz.promanage.base.BaseTest;

import org.testng.annotations.Test;

import java.io.IOException;

public class MyDashBoardTest extends BaseTest {

	@Test
    public void InsightsPage() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Muthoot Finance Limited")) {

        	MyDashBoard myDashBoardTest = new MyDashBoard(getDriver(), test);
        myDashBoardTest.Storedata();
}
}
}