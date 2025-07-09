package biz.promanage.listeners;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import biz.promanage.base.BasePage;
import biz.promanage.base.BaseTest;
import biz.promanage.utils.TeamsAlert;

public class RetryAnalyzer extends BaseTest implements IRetryAnalyzer  {
    public static int retryCount = 0;
    public static final int maxRetryCount = 3; // Retry up to 3 times

    @Override
    public boolean retry(ITestResult result) {
    	TeamsAlert comonmethods = new TeamsAlert();
        retryCount++;
        
        if (retryCount == 1) {
            System.out.println("❌ Test failed on first attempt: " + result.getName());
//            try {
//				comonmethods.Teamsjson("Promanage", "❌ Test failed on first attempt: " + result.getName(),"fail", "");
//			} catch (IOException | InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        } else if (retryCount == 2) {
            System.out.println("❌ Test failed on second attempt: " + result.getName());
        } else if (retryCount == 3) {
            System.out.println("❌ Test failed on third attempt: " + result.getName());
        }

        if (retryCount < maxRetryCount) {
            System.out.println("🔄 Retrying test: " + result.getName() + " | Attempt: " + (retryCount + 1));
            try {
				comonmethods.Teamsjson("Retry Listener", "Retrying: Checking for Next Attempt","fail", "");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return true; // Retry test
        }

        return false; // Stop retrying after max retries
    }
    // ✅ Add this method to get the retry count
    public int getRetryCount() {
    	System.out.println(retryCount);
        return retryCount;
    }
}


