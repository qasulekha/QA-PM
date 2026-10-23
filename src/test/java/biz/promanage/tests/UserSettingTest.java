package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;

import biz.promanage.Pages.PostPage;
import biz.promanage.Pages.UserSettings;
import biz.promanage.base.BaseTest;


import org.testng.annotations.Test;



import java.io.IOException;

public class UserSettingTest extends BaseTest {

    @Test
    public void createUserSetting() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("ProManage ")) {
        	 
        	UserSettings userSettingTest = new UserSettings(getDriver(), test);
        	userSettingTest.clickUserSettings()
        	               .clickReviewTab()
                           .selectNewReviews()
                           .selectUnRespondedReviews()
                           .selectEditedReviews()
                           .selectInactiveReviews()
                           .selectDailyReviewReport()
                           .clickSave()
                           .clickTabs()
                           ;
        	
                  
        }
    }
}
