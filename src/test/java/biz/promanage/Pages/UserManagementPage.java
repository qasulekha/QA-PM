package biz.promanage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;

public class UserManagementPage extends BasePage {

	 private static final String String = null;
	 
	By US_MANAG = By.xpath("//span[text()='User Management']/parent::a[1]");
	 By ADD_USER = By.xpath("//button[@class='sk-button sk-primary sk-fab sk-leading-icon fab-bottom']");
	 By NA_ME = By.xpath("(//input[@class='sk-input'])[17]");
	 By PH_NUM = By.xpath("(//input[@class='sk-input'])[18]");
	 By E_MAIL = By.xpath("(//input[@class='sk-input'])[19]");
	 By RO_LE = By.xpath("(//span[text()='expand_more'])[11]");
	 By C_M_O = By.xpath("//li[text()='Chief Marketing Officer ']");
	 By A_D_D = By.xpath("//button[@class='sk-button sk-primary sk-block']");
	 By S_E_A_R_C_H = By.xpath("(//input[@placeholder='Search with name, email or phone number'])[1]");
	 By D_T_E = By.xpath("(//button[@class='sk-button sk-round sk-no-shadow'])[4]");
	// By S_A_V_E = By.xpath("(//button[@class='sk-button sk-primary'])[7]/parent::div");
	 By S_A_V_E = By.xpath("//button[text()='Save Profile']");
	 By O_K = By.xpath("(//button[@class='sk-button sk-small sk-primary'])[2]");
	 
	 By e_d_i_t = By.xpath("(//span[text()='Edit'])[3]");	 
	 By a_p_p_r = By.xpath("//b[text()='Approval Activity Tracker']");
	 By w_p_a_s = By.xpath("//b[text()='WhatsApp Assistant']");
	  By l_o_c = By.xpath("//span[text()='Karnataka(2)']");
	  By t_e_s = By.xpath("(//div[text()='TestZ'])[1]");
	  By clickEdit = By.xpath("(//button[@class='sk-button sk-round sk-no-shadow'])[3]");
	  


	  
	  
	  
	 public UserManagementPage(WebDriver driver, ExtentTest test) {
	        super(driver, test);   
	    }

	    public UserManagementPage clickUser() {
	       PageLoad.pauseThreeSecs();
	        waitForElementAndClick(US_MANAG);
	         wait.until(ExpectedConditions.elementToBeClickable(US_MANAG));
	       
	        test.log(Status.INFO, " UserManagement Page load successfully.");
	        PageLoad.pause();
	       
	        
	        return this;
	        
	    }
	    
	    public UserManagementPage addUser(String name) {
			
	    	PageLoad.pauseThreeSecs();
	    	waitForElementAndClick(ADD_USER);
	        WebElement na = wait.until(ExpectedConditions.elementToBeClickable(NA_ME));
	        sendDelayedKeys(na, name);
	       
	    	
	    	return this;
		}
	    public UserManagementPage enterPhNum(String phNo) {
	    	
	    	WebElement ph = wait.until(ExpectedConditions.elementToBeClickable(PH_NUM));
	        sendDelayedKeys(ph, phNo);
			return this;
		
	    }
	    
	    public UserManagementPage enterEmail(String mail) {
			
	    	WebElement em = wait.until(ExpectedConditions.elementToBeClickable(E_MAIL));
	        sendDelayedKeys(em, mail);
	        return this;
	    	
	     }
	    
	    public UserManagementPage selectRole() {
	    	 
	    	waitForElementAndClick(RO_LE);
	    	return this;    
	    	
	    }
	    
	    public UserManagementPage cmoUser() {
	    	
	    	waitForElementAndClick(C_M_O);
	    	return this;
	    }
	    
	    public UserManagementPage clickAdd() {
			
	    	waitForElementAndClick(A_D_D);
	    
	    	return this;
	    	
		}
	    
	    public UserManagementPage saveProfile() {
	    	
	    	PageLoad.pauseThreeSecs();
	    	waitForElementAndClick(S_A_V_E);
	    	
	    	return this;
	    }
	    
	    public String getPhoneNumber() {
	    
	    	PageLoad.pauseThreeSecs();
//	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(
//	    		    By.xpath("(//span[text()='+91 9042219183'])[1]/parent::div")));
	    	 takeScreenshot();
	    	return driver.findElement(By.xpath("(//span[text()='9042219183'])[1]")).getText();
	    	
	    }
	    
	    public String getSelectedActiveAccess() throws InterruptedException {
	    	
	    	
		    
	    	PageLoad.pauseThreeSecs();
	    	Thread.sleep(10000);
waitForElementAndClick(clickEdit);
scroll(w_p_a_s);

String output = driver.findElement(By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='WhatsApp Assistant']")).getText();
//String output1 = driver.findElement(By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='Approval Activity Tracker']")).getText();

	    	System.out.println(output);
//	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(
//	    		    By.xpath("(//span[text()='+91 9042219183'])[1]/parent::div")));
	    	 takeScreenshot();
	    	return output;
	    	
	    	
	    }
	    
			public String getSelectedActiveAccess1() {
					    
				    	PageLoad.pauseThreeSecs();
			//	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(
			//	    		    By.xpath("(//span[text()='+91 9042219183'])[1]/parent::div")));
				    	 takeScreenshot();
				    	return driver.findElement(By.xpath("//div[@class='access-card sk-clickable card-selected']//b[text()='Approval Activity Tracker']")).getText();
				    	
				    	
				    }
	    
	    
	    
	    public UserManagementPage searchBox(String userName) {
	    	 PageLoad.pause();
	    	WebElement user = wait.until(ExpectedConditions.elementToBeClickable(S_E_A_R_C_H));
	    	sendDelayedKeys(user, userName);
	    	waitForElementAndClick(S_E_A_R_C_H);
	    	return this;
	    }	
	  
	    public UserManagementPage deleteUser() {
		
	    	waitForElementAndClick(D_T_E);	    	
	    	PageLoad.pause();
	    	//WebElement ok = driver.findElement(By.xpath("(//button[@class='sk-button sk-small sk-primary'])[2]"));
	    	waitForElementAndClick(O_K);
	    	takeScreenshot();
	    	return this;
            
		}

	    public UserManagementPage editUser() {
			
	    	PageLoad.pauseThreeSecs();
	    //	waitForElementAndClick(e_d_i_t);
	    	scrollAndClick(w_p_a_s);
	    	scrollAndClick(a_p_p_r);
	    	takeScreenshot();
	    	//waitForElementAndClick(a_p_p_r);
	    	
	    	return this;
	    	
	    	
	    }
	    
//	    public UserManagementPage editUser1() {
//			
//	    	waitForElementAndClick(s_e_t);
//	    	takeScreenshot();
//	    	
//	    	return this;
//	    	
//	    }
    
  
	    public UserManagementPage clearSearch() {
			
	    	PageLoad.pauseThreeSecs();
	    	WebElement user = wait.until(ExpectedConditions.elementToBeClickable(S_E_A_R_C_H));
	    	user.clear();
	    	return this;
	    	
	       }
	    
	  
	   

	    public UserManagementPage clickTest() {
	    	
	    	
	    	waitForElementAndClick(RO_LE);
	    	return this;
	    }
	    
	    public String getLocation(String lo) {
			
	    	PageLoad.pauseThreeSecs();
	    	takeScreenshot();
	    	return driver.findElement(By.xpath("//span[text()='Karnataka(2)']")).getAttribute("value");
			
	    	
	    
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   
		
	     
	    
	    
	    
	//    clickUser().addUser(name).enterPhNum(phNo).enterEmail(mail).selectRole().cmoUser()
      //  .clickAdd()
	    
	    
	    
	    }

		
	    