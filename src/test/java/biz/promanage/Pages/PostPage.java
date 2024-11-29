package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.Objects;

public class PostPage extends BasePage {

    private final By ADD_POST_BTN = By.xpath("//div[@class='sk-container']/button[1]");
    private final By POST_CONTENT = By.id("PostTextArea");
    private final By SELECT_COMPANY_ADDRESS = By.cssSelector(".post-group .sk-chip:nth-child(2)");
    private final By UPLOAD_IMAGE = By.xpath("(//input[@type='file'])[1]");
    private final By WEBSITE_ADDRESS = By.xpath("//input[@placeholder='Enter website address']");
    private final By PUBLISH_BTN = By.xpath("(//div[@class='sk-panel-footer'])[8]//button[2]");

    public PostPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public PostPage load() {
        test.log(Status.INFO, "Loading Overview Page");
        load("/app/profileDetail/post?BusinessId=11218752");
        waitForPageLoaderToDisappear();
        return this;
    }

    public PostPage addNewPost() {
        waitForElementAndClick(ADD_POST_BTN);
        return this;
    }

    public PostPage enterPostText(String text) {
        WebElement postTextElement = driver.findElement(POST_CONTENT);
        postTextElement.clear();
        type(postTextElement, text);
        return this;
    }

    public PostPage addCompanyAddress() {
        waitForElementAndClick(SELECT_COMPANY_ADDRESS);
        return this;
    }

    public PostPage uploadFile(String filePath) {
      /*  ClassLoader classLoader = getClass().getClassLoader();
        File image = new File(Objects.requireNonNull(classLoader.getResource(filePath)).getFile());

        if (image.exists()) {
            System.out.println("Image file found: " + image.getAbsolutePath());
        } else {
            throw new RuntimeException("Image file not found.");
        }*/
        driver.findElement(UPLOAD_IMAGE).sendKeys(filePath);
        return this;
    }

    public PostPage enterWebsiteAddress(String address) {
        driver.findElement(WEBSITE_ADDRESS).sendKeys(address);
        return this;
    }

    public void publish() {
        waitForElementAndClick(PUBLISH_BTN);
    }
}
