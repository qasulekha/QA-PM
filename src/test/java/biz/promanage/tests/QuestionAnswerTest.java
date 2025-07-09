package biz.promanage.tests;
import biz.promanage.Pages.Customer;
import biz.promanage.Pages.LoginPage;
import biz.promanage.Pages.QuestionAnswerPage;
import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class QuestionAnswerTest extends BaseTest {

    @Test
    public void postQuestionAndAnswer() throws IOException, InterruptedException {
        new LoginPage(getDriver(), test).login(GetUserLoginCred());

        QuestionAnswerPage questionAnswerPage = null;
        Customer customerPage = new Customer(getDriver(), test);
        boolean isCustomerChanged = customerPage.changeCustomer("Sulekha.Com");

        if (isCustomerChanged) {
            questionAnswerPage = new QuestionAnswerPage(getDriver(), test);
        }

        if(questionAnswerPage !=null) {
            questionAnswerPage.load()
                    .clickAddQuestionButton()
                    .clickEnterLocation()
                    .clickStoreMenu()
                    .searchAndSelectLocation()
                    .clickApplyButton()
                    .enterFirstQuestionAndAnswer()
                    .addSecondQuestion()
                    .enterSecondQuestionAndAnswer()
                    .submitQuestions();
        }
    }
}
