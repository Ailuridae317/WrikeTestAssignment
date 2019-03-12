package Wrike.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static Wrike.RandomStringGenerator.getRandomString;
import static Wrike.pages.Answers.*;

public class SurveyPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private int interest;

    Random random;

    Answers answers;

    public SurveyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
//        random = new Random();
        answers = new Answers();
    }

    private By answerButtonLocator = By.cssSelector("[type=\"button\"]");
    private By commentLocator = By.cssSelector("[placeholder=\"Your comment\"]");
    private By submitButtonLocator = By.cssSelector("[class=\"submit wg-btn wg-btn--navy js-survey-submit\"]");
    private By submittedButtonLocator = By.cssSelector("[class=\"submit wg-btn wg-btn--navy js-survey-submit wg-btn--loading\"]");
    private By successTextLocator = By.cssSelector("h3");
    private By resendButtonLocator = By.cssSelector("[class=\"wg-btn wg-btn--white wg-btn--hollow button js-button\"]");
    private By againMessageDivLocator = By.cssSelector("[class=\"section section-resend-main section-resend-main-va section-resend-main--survey section-resend-main--again\"]");
    private By againMessageLocator = By.cssSelector("[class=\"again\"]");
    private By twitterLinkLocator = By.cssSelector("[href=\"https://twitter.com/wrike\"]");
    private By twitterLogoLocator = By.cssSelector("[*|href=\"/content/themes/wrike/dist/img/sprite/vector//footer-icons.symbol.svg?v1#twitter\"]");

    @FindBy(className = "wg-footer__bottom-section")
    private WebElement footerBottom;


    public void answerInterestQuestion() {
        String interestAnswer = answers.getInterestAnswer();
        //You can write your own answer String instead of getInterestAnswer() method (But it might break the test)
        WebElement interestSwitch = driver.findElement(By.cssSelector("[data-code=\"" + interestAnswer + "\"]"));
        WebElement interestSwitchParent = interestSwitch.findElement(By.xpath(".."));
        interestSwitchParent.findElement(answerButtonLocator).click();
        System.out.println("Interest button is clicked");
    }

    public void answerMembersQuestion() {
        String membersAnswer = answers.getMembersAnswer();
        //You can write your own answer String instead of getMembersAnswer() method (But it might break the test)
        WebElement membersSwitch = driver.findElement(By.cssSelector("[data-code=\"" + membersAnswer + "\"]"));
        WebElement membersSwitchParent = membersSwitch.findElement(By.xpath(".."));
        membersSwitchParent.findElement(answerButtonLocator).click();
        System.out.println("Members button is clicked");
    }

    public void answerBusinessQuestion(){
        String businessAnswer = answers.getBusinessAnswer();
        //You can write your own answer String instead of getBusinessAnswer() method (But it might break the test)
        WebElement businessSwitch = driver.findElement(By.cssSelector("[data-code=\""+ businessAnswer + "\"]"));
        WebElement businessSwitchParent = businessSwitch.findElement(By.xpath(".."));
        businessSwitchParent.findElement(answerButtonLocator).click();
        if (businessAnswer.equals("other")) {
            businessSwitchParent.findElement(commentLocator).sendKeys(getRandomString());
            //You can write your own comment String instead of getRandomString() method
        }
        System.out.println("Business button is clicked");
    }

    public void submitAnswers(){
        driver.findElement(submitButtonLocator).click();
        System.out.println("Submit button is clicked");
    }

    public Boolean answersAreSubmitted(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submittedButtonLocator));
        //If this element appears then answers are submitted
            return true;
    }

    public void clickResendButton() {
        driver.findElement(resendButtonLocator).click();
    }

    public Boolean emailIsResent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(againMessageDivLocator));
        WebElement againMessageDiv = driver.findElement(againMessageDivLocator);
        String expectedAgainText = "again.";
        String actualAgainText = againMessageDiv.findElement(againMessageLocator).getText();
        if (expectedAgainText.equals(actualAgainText))
            return true;
        else
            return false;
    }

    public void twitterLinkIsOk(){
        Assert.assertNotNull(footerBottom.findElement(twitterLinkLocator));
        //If we can find element with such link then the url is correct
        System.out.println("link is correct");
    }

    public void twitterLogoIsOk(){
        WebElement twitter = footerBottom.findElement(twitterLinkLocator);
        Assert.assertNotNull(twitter.findElement(twitterLogoLocator));
        //If we can find element with such link to svg image then the logo is correct
        System.out.println("Logo is correct");
    }
}
