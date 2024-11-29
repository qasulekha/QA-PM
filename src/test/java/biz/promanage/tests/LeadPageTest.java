package biz.promanage.tests;

import biz.promanage.Pages.EnterpriseLeadPage;
import biz.promanage.Pages.SmbLeadPage;
import biz.promanage.base.BaseTest;
import biz.promanage.businessObjects.EnterpriseLead;
import biz.promanage.businessObjects.SmbLead;
import biz.promanage.utils.JacksonUtils;
import biz.promanage.utils.Otp;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LeadPageTest extends BaseTest {

    @Test(enabled = true)
    public void testEnterpriseLeadSubmission() throws IOException, InterruptedException {

        EnterpriseLead enterpriseLead = JacksonUtils.deserializeJson("EnterpriseLead.json", EnterpriseLead.class);
        EnterpriseLeadPage enterpriseLeadPage = new EnterpriseLeadPage(getDriver(), test);

        enterpriseLeadPage
                .load()
                .ClickRequestDemoButton()
                .enterCustomerName(enterpriseLead.getCustomerName())
                .enterMobileNumber(enterpriseLead.getMobileNo())
                .enterEmail(enterpriseLead.getEmail())
                .selectNoOfStores(enterpriseLead.getStoreCount())
                .selectRole(enterpriseLead.getJobTitle())
                .enterCompanyName(enterpriseLead.getCompanyName())
                .enterCompanyWebsite(enterpriseLead.getCompanyWebsiteUrl())
                .enterCityName(enterpriseLead.getCityName())
                .acceptTermsAndConditions(enterpriseLead.acceptTerms())
                .submit()
                .enterOtp(Otp.getOTP(enterpriseLead.getMobileNo()));

        Assert.assertTrue(enterpriseLeadPage.getSuccessMessage().contains("Thank you for your interest!"));

    }

    @Test(enabled = true)
    public void testSmbLeadSubmission() throws IOException, InterruptedException {

        SmbLead smbLead = JacksonUtils.deserializeJson("SmbLead.json", SmbLead.class);
        SmbLeadPage smbLeadPage = new SmbLeadPage(getDriver(), test);

        smbLeadPage
                .load()
                .enterCustomerName(smbLead.getName())
                .enterMobileNumber(smbLead.getMobileNo())
                .enterEmail(smbLead.getEmail())
                .enterCompanyName(smbLead.getBusinessName())
                .clickContinueButtonOne()
                .selectCategory(smbLead.getBusinessCategory())
                .enterCity(smbLead.getCityName())
                .enterWebsiteUrl(smbLead.getCompanyWebsiteUrl())
                .selectBusinessProof(smbLead.getBusinessProof())
                .clickContinueButtonTwo()
                .hasGoogleProfile(smbLead.getGoogleProfile())
                .enterEmployeeCount(smbLead.getNoOfEmployees())
                .selectAnnualRevenue(smbLead.getAnnualRevenue())
                .selectProfileCount(smbLead.getGoogleBusinessProfileCount())
                .selectActiveProfiles(smbLead.getGoogleProfileActive())
                .clickContinueButtonThree()
                .enterOtp(Otp.getOTP(smbLead.getMobileNo()));

        Assert.assertTrue(smbLeadPage.getSuccessMessage().contains("Thank you for your interest!"));
        Otp.resetMobileNumber(GetUserLoginCred());

    }

}
