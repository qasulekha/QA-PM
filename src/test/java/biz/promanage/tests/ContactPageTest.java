package biz.promanage.tests;

import biz.promanage.Pages.ContactPage;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactPageTest extends BaseTest {
    @Test
    public void ContactGroupCreation() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());

        if (new Customer(getDriver(), test).changeCustomer("Sulekha.Com")) {
            String groupName = "AutomationTestingGroup";
            ContactPage contactPageTest = new ContactPage(getDriver(), test);
            contactPageTest.deleteGroup(groupName);
            contactPageTest.clickContact()
                    .clickContactList()
                    .clickCreateGroup()
                    .enterGroupName(groupName)
                    .clickStaticGroup()
                    .clickNextBtn()
                    .clickSelectFilter()
                    .clickPhoneNumber()
                    .clickPhoneNumberFilter()
                    .clickPhoneNumberKnown()
                    .clickDoneBtn1()
                    .clickSelectFilter2()
                    .clickSelectAndCondition1()
                    .clickSelectFilter3()
                    .clickSelectEmailAddress()
                    .clickSelectFilter4()
                    .clickEmailAddressKnown()
                    .clickDoneBtn2()
                    .clickSelectFilter5()
                    .clickSelectFilter6()
                    .clickSelectContactSource()
                    .clickContactSourceFilter1()
                    .clickContactSourceFilter1Select()
                    .clickContactSourceFilterOption()
                    .clickContactSourceFilter2Select()
                    .clickContactSourceFilter2OptionGoogle()
                    .clickDoneBtn3()
                    .clickSubmitBtn()
                    .clickContactGroupMenu();

            Assert.assertEquals(groupName, contactPageTest.getGroupName());
            test.log(Status.PASS, "Contact group created. Group Name :  " + groupName);
        }
    }
}
