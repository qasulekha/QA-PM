package biz.promanage.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import biz.promanage.Pages.BulkPostUpload;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.base.BaseTest;


public class BulkPostUploadTest extends BaseTest {

    

	@Test
    public void createBulkPost() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());
        if (new Customer(getDriver(), test).changeCustomer("Sulekha.Com"))
        {
        	
			
        	
        	
        	BulkPostUpload bulkPostUpload = new BulkPostUpload(getDriver(), test);
        	bulkPostUpload.clickInsights()
        	              .addCompanyName()
        	              .clickUploadBtn()
        	              .uploadDoc("ProfileImage","C:\\Desktop Files\\Blogs\\Images\\2024-08-15.jpg");
                  
                              
            
            
            
                  
        }
    }
}
