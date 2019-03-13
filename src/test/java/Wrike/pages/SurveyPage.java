package Wrike.pages;

import Wrike.Answers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Wrike.RandomStringGenerator.getRandomString;

/**
 * Created by Osychenko Yuriy on 12.03.2019
 */

public class SurveyPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private Answers answers;


    public SurveyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        answers = new Answers();
    }

    private By surveyLocator = By.cssSelector("[class=\"survey\"]");
    private By answerButtonLocator = By.cssSelector("[type=\"button\"]");
    private By commentLocator = By.cssSelector("[placeholder=\"Your comment\"]");
    private By submitButtonLocator = By.cssSelector("[class=\"submit wg-btn wg-btn--navy js-survey-submit\"]");
    private By disabledButtonLocator = By.cssSelector("[disabled]");
    private By surveyFormSubmittedStyleLocator = By.cssSelector("form[style=\"display: none;\"]");
    private By resendButtonLocator = By.cssSelector("[class=\"wg-btn wg-btn--white wg-btn--hollow button js-button\"]");
    private By againMessageDivLocator = By.cssSelector("[class=\"section section-resend-main section-resend-main-va section-resend-main--survey section-resend-main--again\"]");
    private By againMessageLocator = By.cssSelector("[class=\"again\"]");
    private By twitterLinkLocator = By.cssSelector("[href=\"https://twitter.com/wrike\"]");
    private By twitterLogoLocator = By.cssSelector("[*|href=\"/content/themes/wrike/dist/img/sprite/vector//footer-icons.symbol.svg?v1#twitter\"]");

    @FindBy(className = "wg-footer__bottom-section")
    private WebElement footerBottom;

    @FindBy(className = "survey-form")
    private WebElement surveyForm;

    @Step("Checking if Survey Page is loaded")
    public  Boolean pageIsLoaded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(surveyLocator));
        return (driver.findElement(surveyLocator) != null);
    }
    @Step("Choosing answer to question about interest")
    public void answerInterestQuestion() {
        String interestAnswer = answers.getInterestAnswer();
        WebElement interestSwitch = driver.findElement(By.cssSelector("[data-code=\"" + interestAnswer + "\"]"));
        WebElement interestSwitchParent = interestSwitch.findElement(By.xpath(".."));
        interestSwitchParent.findElement(answerButtonLocator).click();
    }

    @Step("Choosing answer to question about interest")
    public void answerInterestQuestion(String interestAnswer){
        WebElement interestSwitch = driver.findElement(By.cssSelector("[data-code=\"" + interestAnswer + "\"]"));
        WebElement interestSwitchParent = interestSwitch.findElement(By.xpath(".."));
        interestSwitchParent.findElement(answerButtonLocator).click();
    }

    @Step("Choosing answer to question about members")
    public void answerMembersQuestion() {
        String membersAnswer = answers.getMembersAnswer();
        WebElement membersSwitch = driver.findElement(By.cssSelector("[data-code=\"" + membersAnswer + "\"]"));
        WebElement membersSwitchParent = membersSwitch.findElement(By.xpath(".."));
        membersSwitchParent.findElement(answerButtonLocator).click();
    }

    @Step("Choosing answer to question about members")
    public void answerMembersQuestion(String membersAnswer) {
        WebElement membersSwitch = driver.findElement(By.cssSelector("[data-code=\"" + membersAnswer + "\"]"));
        WebElement membersSwitchParent = membersSwitch.findElement(By.xpath(".."));
        membersSwitchParent.findElement(answerButtonLocator).click();
    }

    @Step("Choosing answer to question about business")
    public void answerBusinessQuestion(){
        String businessAnswer = answers.getBusinessAnswer();
        WebElement businessSwitch = driver.findElement(By.cssSelector("[data-code=\""+ businessAnswer + "\"]"));
        WebElement businessSwitchParent = businessSwitch.findElement(By.xpath(".."));
        businessSwitchParent.findElement(answerButtonLocator).click();
        if (businessAnswer.equals("other")) {
            businessSwitchParent.findElement(commentLocator).sendKeys(getRandomString());
        }
    }

    @Step("Choosing answer to question about business")
    public void answerBusinessQuestion(String businessAnswer) {
        WebElement businessSwitch = driver.findElement(By.cssSelector("[data-code=\""+ businessAnswer + "\"]"));
        WebElement businessSwitchParent = businessSwitch.findElement(By.xpath(".."));
        businessSwitchParent.findElement(answerButtonLocator).click();
        if (businessAnswer.equals("other")) {
            businessSwitchParent.findElement(commentLocator).sendKeys(getRandomString());
        }
    }

    @Step("Choosing answer to question about business")
    public void answerBusinessQuestion(String businessAnswer, String comment) {
        WebElement businessSwitch = driver.findElement(By.cssSelector("[data-code=\""+ businessAnswer + "\"]"));
        WebElement businessSwitchParent = businessSwitch.findElement(By.xpath(".."));
        businessSwitchParent.findElement(answerButtonLocator).click();
        if (businessAnswer.equals("other")) {
            businessSwitchParent.findElement(commentLocator).sendKeys(comment);
        }
    }

    @Step("Submitting answers and checking if they are sent")
    public Boolean submitAnswers(){
        WebElement submitButton = driver.findElement(submitButtonLocator);
        if (submitButton.isEnabled()) {
            submitButton.click();
            wait.until(ExpectedConditions.invisibilityOf(surveyForm));
            return (driver.findElement(surveyFormSubmittedStyleLocator) != null);
            //If we can find element with such locator then answers are submitted
        } else
            return false;
    }

    @Step("Clicking Resend Email button")
    public Boolean clickResendButton() {
        driver.findElement(resendButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(againMessageDivLocator));
        WebElement againMessageDiv = driver.findElement(againMessageDivLocator);
        String expectedAgainText = "again.";
        String actualAgainText = againMessageDiv.findElement(againMessageLocator).getText();
        return (expectedAgainText.equals(actualAgainText));
    }

    @Step("Checking if twitter link is ok")
    public Boolean twitterLinkIsOk(){
        return (footerBottom.findElement(twitterLinkLocator)!= null);
        //If we can find element with such link then the url is correct
    }

    @Step("Checking if twitter logo is ok")
    public Boolean twitterLogoIsOk(){
        WebElement twitter = footerBottom.findElement(twitterLinkLocator);
        return (twitter.findElement(twitterLogoLocator) != null);
        //If we can find element with such link to svg image then the logo is correct
    }
}
