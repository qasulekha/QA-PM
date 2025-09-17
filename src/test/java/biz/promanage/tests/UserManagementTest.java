package biz.promanage.tests;

import biz.promanage.Pages.UserManagementPage;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;

public class UserManagementTest extends BaseTest {

	
	@Test 
	public void userManagementCreation() throws IOException, InterruptedException {
	    new LoginPage(getDriver(), test).login(GetUserLoginCred());

	    if (new Customer(getDriver(), test).changeCustomer("Sulekha.Com")) {

	        UserManagementPage userManagementPage = new UserManagementPage(getDriver(), test);

	        String name = "TestZ";
	        String phNo = "9042219183";
	        String mail = "mohamedasi0910@gmail.com";
	        String ac = "WhatsApp Assistant";

	        // Flow
	        userManagementPage.clickUser()
	                          .searchBox(phNo)
	                          .deleteUser()
	                          .addUser(name)
	                          .enterPhNum(phNo)
	                          .enterEmail(mail)
	                          .selectRole()
	                          .cmoUser()
	                          .clickAdd()
	                          .editUser()
	                          .saveProfile()
	                          .clearSearch()
	                          .searchBox(phNo);

	        // Assertions
	        String expected = userManagementPage.getPhoneNumber();
	        Assert.assertEquals(phNo, expected);

	        String expected1 = userManagementPage.getSelectedActiveAccess();
	        Assert.assertEquals(ac, expected1);

	        test.log(Status.PASS, "User created successfully. Phone: " + phNo);
	    }
	}
}  