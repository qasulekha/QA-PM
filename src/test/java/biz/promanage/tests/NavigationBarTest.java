package biz.promanage.tests;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.SidebarNavigation;
import biz.promanage.base.BaseTest;


import org.testng.annotations.Test;



import java.io.IOException;

public class NavigationBarTest extends BaseTest {

    @Test
    public void testSidebarNavigation() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.com")) {
        SidebarNavigation sidebarPage = new SidebarNavigation(getDriver(), test);
        
        sidebarPage
            .clickAlignPage()
            .clickInsightPage()
            .clickReportPage()
            .clickRankTrackerPage()
            .clickScheduledTrackerPage()
            .clickRatingGolesPage()
            .clickListingsPage()
            .clickBusinessProfilesPage()
            .clickActivityApprovalPage()
            .clickBulkUploadTrackerPage()
            .clickDuplicateListingsPage()
            .clickPlatformPage()
            .clickReviewsPage()
            .clickTicketsPage()
            .clickImagePredictionPage()
            .clickLeaderboardPage()
            .clickQuestionAndAnswerPage()
           // .clickmentionsPage()
            .clickCallsPage()
            .clickContactsPage()
            .clickContactGroupPage()
            .clickChatPage()
            .clickCampaignSMSPage()
            .clickUserManagementPage()
            .clickSwitchTenantPage()
            .clickSettingsPage();
        

        

        
        
    }

}
}