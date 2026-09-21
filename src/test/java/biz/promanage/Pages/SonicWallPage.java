package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;


public class SonicWallPage extends BasePage {

	
	
	  private By loginBackButton =
	            By.xpath("//button[@type='button']");

	    private By username =
	            By.xpath("//input[@name='username']");

	    private By password =
	            By.xpath("//input[@name='password']");

	    private By loginButton =
	            By.xpath("//div[text()='LOG IN']");

	    private By logoutMessage =
	            By.xpath("//div[@class='login-ftr-logout__line sw-typo-heading-4']");
	    
	    private By continueButton = By.xpath("//button[contains(.,'Continue')]");


	    public SonicWallPage(WebDriver driver, ExtentTest test) {
	        super(driver, test);
	    }


	    public void login(String userName, String passwordValue) {

			/*
			 * if (Xpathcheck( "//div[@class='login-ftr-logout__line sw-typo-heading-4']"))
			 * {
			 * 
			 * waitForElementAndClick(loginBackButton);
			 * 
			 * type(username, userName);
			 * 
			 * type(password, passwordValue);
			 * 
			 * waitForElementAndClick(loginButton);
			 * 
			 * waitForElementAndClick(loginBackButton);
			 * 
			 * logInfo("SonicWall login completed successfully.");
			 * 
			 * } else {
			 * 
			 * logInfo("SonicWall login screen was not displayed."); }
			 */
	   
	    	 type(username, userName);

	         type(password, passwordValue);

	         waitForElementAndClick(loginButton);

	         logInfo("SonicWall login completed successfully.");
	         
	         waitForElementAndClick(continueButton);
	         
	         logInfo("Continue button clicked successfully.");
	    }
	}
	
	
	
	
	
	
	
	
	

