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
    public void signUpTestSuccess(){

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.clickGetStartedButton();
        homePage.fillTheForm();
        homePage.submitTheForm();

        SurveyPage surveyPage = PageFactory.initElements(driver, SurveyPage.class);

        Assert.assertTrue(surveyPage.pageIsLoaded());
        surveyPage.answerInterestQuestion(); //You can add argument to change answer
        surveyPage.answerMembersQuestion(); //You can add argument to change answer
        surveyPage.answerBusinessQuestion(); //You can add argument to change answer
        Assert.assertTrue(surveyPage.submitAnswers());
        Assert.assertTrue(surveyPage.clickResendButton());
        Assert.assertTrue(surveyPage.twitterLinkIsOk());
        Assert.assertTrue(surveyPage.twitterLogoIsOk());
    }

    @Test
    public void signUpTestFailure(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.clickGetStartedButton();
        homePage.submitTheForm();
        Assert.assertTrue(homePage.dataMissing());
    }

    @Test
    public void signUpTestFailure2(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.clickGetStartedButton();
        homePage.fillTheForm();
        homePage.submitTheForm();

        SurveyPage surveyPage = PageFactory.initElements(driver, SurveyPage.class);

        Assert.assertTrue(surveyPage.pageIsLoaded());
        Assert.assertFalse(surveyPage.submitAnswers());
    }
}
