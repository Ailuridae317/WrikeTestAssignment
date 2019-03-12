package Wrike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static Wrike.RandomStringGenerator.getRandomString;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    @FindBy(className = "wg-header__desktop")
    private WebElement header;

    private By getStartedButtonLocator = By.cssSelector("[class=\"wg-header__free-trial-button wg-btn wg-btn--green\"]");
    private By headerLocator = By.cssSelector("[class=\"wg-header__desktop\"]");
    private By inputFormLocator = By.cssSelector("[class=\"wg-input modal-form-trial__input\"]");
    private By inputFormSubmitLocator = By.cssSelector("[class=\"wg-btn wg-btn--blue modal-form-trial__submit\"]");
    private By surveyLocator = By.cssSelector("[class=\"survey\"]");


    public void open() {
        driver.get("https://www.wrike.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        System.out.println("site is opened");
    }

    public void clickGetStartedButton() {
        header.findElement(getStartedButtonLocator).click();
        System.out.println("button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFormLocator));
        System.out.println("Form is opened");
    }

    public void fillTheForm() {
        String email = getRandomString() + "+wpt@wriketask.qaa";
        driver.findElement(inputFormLocator).sendKeys(email);
        System.out.println("Keys are entered");
    }

    public void submitTheForm() {
        driver.findElement(inputFormSubmitLocator).click();
        System.out.println("Create button is clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(surveyLocator));
        System.out.println("Next page is loaded");
    }
}
