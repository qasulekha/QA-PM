package biz.promanage.tests;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.Discovery;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.MyDashBoard;
import biz.promanage.base.BaseTest;
import biz.promanage.listeners.RetryAnalyzer;
import biz.promanage.utils.TeamsAlert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;

public class MyDashBoardTest extends BaseTest {
int retryCount = 0;
	
	
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void MyDashBoard() throws IOException, InterruptedException {
		TeamsAlert comonmethods = new TeamsAlert();
		try {
			// if (new Customer(getDriver(), test).changeCustomer("Muthoot Finance Limited")) {
		 new LoginPage(getDriver(), test).login(GetUserLoginCred());	
		 MyDashBoard myDashBoardPage=new MyDashBoard(getDriver(), test);
		 myDashBoardPage.ValidateMyDashBoardData();
			// }
		 } catch (Exception e) {
             System.out.println("Problems in loading site");
             comonmethods.Teamsjson("Promanage", "Problems in loading site","fail", "");
             test.log(Status.FAIL, "Failed to login");
             throw e;
}
}
}