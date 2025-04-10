package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.GlobalFilter;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;


import java.io.IOException;

public class GlobalFilterTest extends BaseTest {

    @Test
    public void validateLocationFilter() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Aster Pharmacy")) {
            GlobalFilter globalFilterTest = new GlobalFilter(getDriver(), test);
            globalFilterTest.clickOnFilter().searchState().selectState().clickApply().clickBusinessProfiles().ScrollToTheBottom();
        }
    }
}