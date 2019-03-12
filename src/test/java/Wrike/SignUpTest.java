package Wrike;

import Wrike.config.WebDriverConfig;
import Wrike.pages.HomePage;
import Wrike.pages.SurveyPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osychenko Yuriy on 12.03.2019
 */

public class SignUpTest extends WebDriverConfig {

    @Test
    public void signUpTest(){

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.clickGetStartedButton();
        homePage.fillTheForm();
        homePage.submitTheForm();

        SurveyPage surveyPage = PageFactory.initElements(driver, SurveyPage.class);

        surveyPage.answerInterestQuestion();
        surveyPage.answerMembersQuestion();
        surveyPage.answerBusinessQuestion();
        surveyPage.submitAnswers();
        Assert.assertTrue(surveyPage.answersAreSubmitted());
        surveyPage.clickResendButton();
        Assert.assertTrue(surveyPage.emailIsResent());
        surveyPage.twitterLinkIsOk();
        surveyPage.twitterLogoIsOk();






        System.out.println("THE END");

    }




}
