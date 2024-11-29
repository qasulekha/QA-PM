package biz.promanage.tests;

import biz.promanage.Pages.CustomGroup;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomGroupTest extends BaseTest
{
    @Test
    public void CreateCustomGroup() throws IOException {

        new LoginPage(getDriver(), test).login(GetUserLoginCred());

        CustomGroup CustomGroup = null;
        Customer customerPage = new Customer(getDriver(), test);
        boolean isCustomerChanged = customerPage.changeCustomer("Sulekha.Com");

        if (isCustomerChanged) {
            CustomGroup = new CustomGroup(getDriver(), test);
        }

        if(CustomGroup !=null) {
            String customGroupName = "AutomationTestGroup";
            CustomGroup.load().CreateCustomGroup(customGroupName).verifyCustomGroup(customGroupName);

        }
    }
}