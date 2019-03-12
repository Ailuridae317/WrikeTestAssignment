package Wrike.config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class WebDriverConfig {

    public WebDriver driver;

    public WebDriverWait wait;

    public Random random;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver2.46.exe");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 15);

        random = new Random();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
