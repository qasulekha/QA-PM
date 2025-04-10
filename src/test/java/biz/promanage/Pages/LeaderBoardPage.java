package biz.promanage.Pages;

import biz.promanage.base.BasePage;
import biz.promanage.utils.PageLoad;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.LocalDate;

public class LeaderBoardPage extends BasePage {

    private static final String FOCUSED_GROUP_NAME = "Focused_AsterP_Karnataka";
    private static final String CITY_NAME = "Hyderabad";
    private final By img = By.xpath("//div[@class='table-card table-card-body']//img");
    private final By DATE = By.xpath("(//div[@class='sk-flex-row sk-flex-align-start sk-sticky']//div)[12]");
    private final By SUBMIT_BUTTON = By.xpath("//div[@class='sk-flex-row sk-flex-justify-between sk-flex-align-center sk-no-wrap']//button");
    private final By CITY_TAB = By.xpath("(//div[@class='board-menu']//nav//ul//li)[2]");
    private final By STATE_TAB = By.xpath("(//div[@class='board-menu']//nav//ul//li)[3]");
    private final By GROUPS_TAB = By.xpath("(//div[@class='board-menu']//nav//ul//li)[4]");
    private final By SEARCH_BY_GROUP = By.xpath("(//input[@class='sk-input' and @placeholder='Search by Group'])[1]");
    private final By SEARCH_BY_CITY = By.xpath("(//input[@class='sk-input' and @placeholder='Search by City'])[1]");
    private final By LEADER_BOARD_CITY = By.xpath("//div[@class='table-card table-card-body']/div[@class='sk-flex-row']/div[@class='sk-flex'][3]/span");
    private final By RESULT_CITY = By.xpath("(//div[contains(@class, 'result-group')])[2]/ul/li/div/child::div[2]");
    private final By GROUP_NAME = By.xpath("((//div[@class='table-card table-card-body']//div)[1]//div)[4]");
    private final By CITY_NAME_RESULT = By.xpath("((//div[@class='table-card table-card-body']//div)[1]//div)[4]");

    public LeaderBoardPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public LeaderBoardPage load() {
        logInfo(" Loading Leaderboard Page ");
        load("/app/Leaderboard");
        waitForPageLoaderToDisappear();
        waitForElementToBeVisible(img);
        takeScreenshot();
        return this;
    }

    public LeaderBoardPage selectYearAndMonth() {
        logInfo(" Selecting Month and Year ");
        int currentMonth = LocalDate.now().getMonthValue() - 1;
        int currentYear = LocalDate.now().getYear();

        By MONTH_SELECTOR = By.xpath("(//div[@class='month-group'])[1]//ul//li[" + currentMonth + "]");
        By YEAR_SELECTOR = By.xpath("//ul/li[contains(@id,'" + currentYear + "')]");

        waitForElementAndClick(DATE);
        waitForElementAndClick(YEAR_SELECTOR);
        waitForElementAndClick(MONTH_SELECTOR);
        waitForElementAndClick(SUBMIT_BUTTON);

        test.log(Status.INFO, "Selected Month: " + currentMonth + ", Year: " + currentYear);
        takeScreenshot();

        return this;
    }

    public LeaderBoardPage verifyCityFilter() {
        logInfo(" Verifying City filter ");
        waitForElementAndClick(CITY_TAB);
        waitForPageLoaderToDisappear();

        sendDelayedKeys(wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BY_CITY)), CITY_NAME);
        test.log(Status.INFO, "Searched City Name: " + CITY_NAME);
        PageLoad.pauseTenSeconds();

        String filteredResult = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_NAME_RESULT)).getText();
        Assert.assertEquals(filteredResult, CITY_NAME, "City Name did not match");

        test.log(Status.INFO, "Expected City Name: " + CITY_NAME + ", Actual City Name: " + filteredResult);
        takeScreenshot();
        return this;
    }

    public LeaderBoardPage compareLeaderboardResults() {
        logInfo(" Comparing Leaderboard Results ");
        String selectedCityName = wait.until(ExpectedConditions.visibilityOfElementLocated(LEADER_BOARD_CITY)).getText();
        test.log(Status.INFO, "Selected Leaderboard City: " + selectedCityName);

        String resultCityName = wait.until(ExpectedConditions.visibilityOfElementLocated(RESULT_CITY)).getText();
        test.log(Status.INFO, "Searched Result City: " + resultCityName);

        Assert.assertEquals(selectedCityName, resultCityName, "City names on leaderboard do not match");
        takeScreenshot();
        return this;
    }

    public void verifyGroupFilter() {
        logInfo(" Verifying Group filter ");
        waitForElementAndClick(GROUPS_TAB);
        waitForPageLoaderToDisappear();

        sendDelayedKeys(wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BY_GROUP)), FOCUSED_GROUP_NAME);

        String selectedGroupName = wait.until(ExpectedConditions.visibilityOfElementLocated(GROUP_NAME)).getText();
        test.log(Status.INFO, "Selected Group Name: " + selectedGroupName);

        Assert.assertEquals(selectedGroupName, FOCUSED_GROUP_NAME, "Group names do not match");
        takeScreenshot();
    }

}
