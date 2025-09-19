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
	        String phoneNumber = "9042219183";
	        String mail = "mohamedasi0910@gmail.com";
	        String whatsAppAssis = "WhatsApp Assistant";

	        // Flow
	        userManagementPage.clickUser()
	                          .searchBox(phoneNumber)
	                          .deleteUser()
	                          .addUser(name)
	                          .enterPhNum(phoneNumber)
	                          .enterEmail(mail)
	                          .selectRole()
	                          .cmoUser()
	                          .clickAdd()
	                          .editUser()
	                          .saveProfile()
	                          .clearSearch()
	                          .searchBox(phoneNumber);

	        // Assertions
	        String expected = userManagementPage.getPhoneNumber();
	        Assert.assertEquals(phoneNumber, expected);

	        String expected1 = userManagementPage.getSelectedActiveAccess();
	        Assert.assertEquals(whatsAppAssis, expected1);

	        test.log(Status.PASS, "User created successfully. Phone: " + phoneNumber);
	    }
	}
}  