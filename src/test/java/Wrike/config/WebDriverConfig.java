package Wrike.config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by Osychenko Yuriy on 12.03.2019
 * Class to configurate necessary objects before each test and to close them after
 */

public class WebDriverConfig {

    protected WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver2.46.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
