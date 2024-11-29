package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuestionAnswerPage extends BasePage {

    By QNS_ANS_BTN = By.xpath("//div[@class='question-upload']//span[.='Add question']/parent::button[1]");
    By STORE_MENU = By.xpath("//li[@id='nav-4-61']/a/span");
    By ENTER_LOCATION = By.xpath("(//div[@class='sk-event-group']//span[.='expand_more'])[4]");
    String SEARCH_LOCATION = "//input[contains(@placeholder,'/Business ID')]";
    By SELECT_LOCATION = By.xpath("//input[@id='chkid 11218756']");
    By APPLY_BTN = By.xpath("(//div[@class='sk-text-end sk-flex-row'])[3]/button[2]");
    By QUESTION_1 = By.cssSelector(".sk-outlined-input:nth-child(1) > .sk-input");
    By ANSWER_1 = By.id("auto-height-textarea-0");
    By ADD_SECOND_QUESTION = By.cssSelector(".sk-button-link:nth-child(4) > .sk-ripple-container");
    By QUESTION_2 = By.cssSelector(".question-group:nth-child(5) .sk-input");
    By ANSWER_2 = By.id("auto-height-textarea-1");
    By SUBMIT_BTN = By.cssSelector(".sk-panel:nth-child(8) .sk-button:nth-child(2) > .sk-ripple-container");

    String locationID = "11218756";
    String question1 = "Provide me the list of best plumbing services";
    String answer1 = "Visit Sulekha.com";
    String question2 = "Provide me the list of best AC technicians";
    String answer2 = "Visit Sulekha.com";

    public QuestionAnswerPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public QuestionAnswerPage load() {
        test.log(Status.INFO, "Loading Question Answer Page");
        load("/app/QuestionAndAnswer");
        waitForPageLoaderToDisappear();
        return this;
    }

    public QuestionAnswerPage clickAddQuestionButton() {
        waitForElementAndClick(QNS_ANS_BTN);
        return this;
    }

    public QuestionAnswerPage clickEnterLocation() {
        waitForElementAndClick(ENTER_LOCATION);
        return this;
    }

    public QuestionAnswerPage clickStoreMenu() {
        waitForElementAndClick(STORE_MENU);
        return this;
    }

    public QuestionAnswerPage searchAndSelectLocation() {
        sendDelayedKeys(driver.findElement(By.xpath(SEARCH_LOCATION)), locationID);
        waitForLoaderToDisappear();
        PageLoad.pauseThreeSecs();
        waitForElementAndClickUsingActions(SELECT_LOCATION);
        return this;
    }

    public QuestionAnswerPage clickApplyButton() {
        scrollAndClick(APPLY_BTN);
        return this;
    }

    public QuestionAnswerPage enterFirstQuestionAndAnswer() {
        type(driver.findElement(QUESTION_1), question1);
        type(driver.findElement(ANSWER_1), answer1);
        return this;
    }

    public QuestionAnswerPage addSecondQuestion() {
        click(driver.findElement(ADD_SECOND_QUESTION));
        return this;
    }

    public QuestionAnswerPage enterSecondQuestionAndAnswer() {
        type(driver.findElement(QUESTION_2), question2);
        type(driver.findElement(ANSWER_2), answer2);
        takeScreenshot();
        return this;
    }

    public void submitQuestions() {
        click(driver.findElement(SUBMIT_BTN));
        waitForElementToBeInVisible(APPLY_BTN);
        PageLoad.pauseThreeSecs();
        takeScreenshot();
        test.log(Status.INFO, "Question and answer submitted successfully");
    }


}
