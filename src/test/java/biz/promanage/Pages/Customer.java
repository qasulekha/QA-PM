package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;

public class Customer extends BasePage {

    private final By SWITCH_TENANT = By.xpath("//div[@class='sk-sidebar']//ul/li/a/span[text()='Switch Tenant']/parent::a[1]");
    private final By CUSTOMER_INPUT_FOCUS = By.cssSelector(".sk-outlined-input:nth-child(1) > .sk-input");
    private final By CUSTOMER_NAME = By.cssSelector(".sk-show > .sk-input");
    private final By SELECTED_CUSTOMER_NAME = By.cssSelector("div:nth-child(1) > .sk-truncate:nth-child(1)");

    public Customer(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public static void sendDelayedKeys(WebElement element, String text) {
        Random r = new Random();
        for (int i = 0; i < text.length(); i++) {
            try {
                Thread.sleep((int) (r.nextGaussian() * 25 + 200));
            } catch (InterruptedException ignored) {
                System.out.println("Error in Send Delayed Keys Method.");
            }

            String s = String.valueOf(text.charAt(i));
            element.sendKeys(s);
        }
    }

    public boolean changeCustomer(String customerName) {
        boolean isCustomerChanged = false;
        int maxRetries = 5;
        int count = 0;
      //  WaitForPageLoadToComplete();
        String selectedCustomer = wait.until(ExpectedConditions.elementToBeClickable(SELECTED_CUSTOMER_NAME)).getText();
        if (!selectedCustomer.equalsIgnoreCase(customerName)) {

            while (count < maxRetries && !isCustomerChanged) {
                try {
                    if (count > 0) {
                        ctrlF5Reload(driver);
                      //  WaitForPageLoadToComplete();
                    }

                    wait.until(ExpectedConditions.elementToBeClickable(SWITCH_TENANT)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(CUSTOMER_INPUT_FOCUS)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(CUSTOMER_NAME));

                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sk-show > .sk-input")));
                    sendDelayedKeys(element, customerName);

                    WebElement customerElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sk-overflow-menu']//ul[@class='sk-overflow-list sk-show']/li[. ='" + customerName + "']")));
                    customerElement.click();

                    String selectedCustomerName = wait.until(ExpectedConditions.elementToBeClickable(SELECTED_CUSTOMER_NAME)).getText();

                    PageLoad.pause();
                    
                    isCustomerChanged = selectedCustomerName.equalsIgnoreCase(customerName);

                } catch (Exception e) {
                    System.out.println("Attempt " + (count + 1) + " failed. Retrying...");
                }

                count++;
            }
        }
        else
        {
            isCustomerChanged = true;
        }

        return isCustomerChanged;
    }
}
