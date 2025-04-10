package biz.promanage.tests;

import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.SidebarNavigation;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationBarTest extends BaseTest {

    @Test
    public void testSidebarNavigation() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        SidebarNavigation sidebarPage = new SidebarNavigation(getDriver(), test);
        sidebarPage
                .clickListings()
                .clickLeaderboard()
                .clickTickets()
                .clickReviews()
                .clickCampaigns()
                .clickChat()
                .clickContacts()
                .clickDuplicateListings()
                //.clickRankTracker()
                .clickBulkUploadTracker()
                .clickQuestionAndAnswer()
                .clickBusinessProfiles()
                .clickUserManagement()
                .clickSettings()
                .clickPlatform()
                .clickSwitchTenant()
                .clickProfileScore()
                .clickRoiCalculator()
                .clickPromanageCustomer()
                .clickSmbListingManagement()
                .clickMentions()
                .clickGmbProfileAnalyzer();

    }

/*    @Test
    public void testSidebarNavigation() throws IOException {
        new LoginPage(getDriver(),test).login(GetUserLoginCred());
        SidebarNavigation sidebarPage = new SidebarNavigation(getDriver(), test);
        sidebarPage.Navigate();
    }*/
}