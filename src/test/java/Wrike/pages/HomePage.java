package Wrike.pages;

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
    private By dataMissingLocator = By.cssSelector("[class=\"wg-field-error wg-tooltip wg-tooltip--error wg-tooltip--input wg-field-error--visible\"]");

    @Step("Open the Wrike Home Page")
    public void open() {
        driver.get("https://www.wrike.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    @Step("Clicking get started button")
    public void clickGetStartedButton() {
        header.findElement(getStartedButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFormLocator));
    }

    @Step("Filling the form")
    public void fillTheForm() {
        String email = getRandomString() + "+wpt@wriketask.qaa";
        driver.findElement(inputFormLocator).sendKeys(email);
    }

    @Step("Submitting the form")
    public void submitTheForm() {
        driver.findElement(inputFormSubmitLocator).click();
    }

    @Step("Checking if data is missing")
    public Boolean dataMissing(){
        return (driver.findElement(dataMissingLocator) != null);
    }
}
