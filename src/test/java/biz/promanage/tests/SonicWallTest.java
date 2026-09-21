	package biz.promanage.tests;
	
	import org.testng.annotations.Test;
	
	import biz.promanage.Pages.SonicWallPage;
	import biz.promanage.base.BaseTest;
	
	
	public class SonicWallTest extends BaseTest {
	
		  @Test
		    public void sonicWallLogin() throws InterruptedException {
	
		        String url = "https://rmz.sulekha.net/";
	
		        getDriver().get(url);
	
		        getDriver().manage().window().maximize();
	
		        SonicWallPage sonicwallPage = new SonicWallPage(getDriver(), getTest());
		       sonicwallPage.login("qa", "QaTesting!2026");
		       Thread.sleep(10000);
		        
		    }
		
		
		
		
		
		}
