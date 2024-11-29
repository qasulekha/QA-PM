package biz.promanage.tests;

import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;
import biz.promanage.utils.Otp;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserLoginTest extends BaseTest {

    @Test
    public void validateUserLogin() throws IOException {
        try {
            LoginPage loginPage = new LoginPage(getDriver(), test);
            loginPage
                    .load()
                    .clickLoginLink()
                    .enterMobileNo(GetUserLoginCred())
                    .clickLoginBtn()
                    .enterOtp(Otp.getOTP(GetUserLoginCred()))
                    .isLoginSuccessful();

        } catch (Exception ex) {
            test.log(Status.FAIL, "Failed to login");
            throw ex;
        }
    }
}
