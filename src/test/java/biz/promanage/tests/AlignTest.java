package biz.promanage.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import biz.promanage.Pages.AlignPage;

import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;

public class AlignTest extends BaseTest {

	@Test
	public void alignTaskCreation() throws IOException, InterruptedException {
		new LoginPage(getDriver(), test).login(GetUserLoginCred());
		if (new Customer(getDriver(), test).changeCustomer("Sulekha.com")) {
			AlignPage alignPage = new AlignPage(getDriver(), test);
			alignPage.clickAlign().clickcreaBut().enterTitle("Test Task Creation").enterCus("Sul").enterassignee("CMO")
					.selectStatus().selectTask().proTask().priority().visibility()
					.description("When we try to upload an image, it is not uploaded correctly.")
					.includeUser("New CMO").comment("Please Work on this.").save().visibility1().save().showPastDue()
					.verifyPastDueTasks().showPastDue1().clickFilter().filterVisibility().taskStatus().taskPriority()
					.taskType().clickApply().clickSelectCustomer().passCustmoerName("sulekha.com").clickSubmit()
					.clickFilter().reset().clickApply().searchTask("#SUL-682").editStatus().editTaskType()
					.editPriority().editComment().updateComment().saveTask();

			String expected = alignPage.getTaskName();
			Assert.assertEquals("#SUL-682", expected);

			String expected3 = alignPage.getSelectedTaskType();
			Assert.assertEquals("New Feature", expected3);

			String expected2 = alignPage.getSelectedStatus();
			Assert.assertEquals("In Progress", expected2);

			String expected4 = alignPage.getSelectedPriority();
			Assert.assertEquals("High", expected4);

			test.log(Status.PASS, "Task created successfully!");

		}
	}

}
