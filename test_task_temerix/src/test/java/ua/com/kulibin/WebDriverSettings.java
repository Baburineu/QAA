package ua.com.kulibin;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WebDriverSettings<driver> {

    public WebDriver driver;

    @BeforeSuite
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 1020));
        System.out.println("Test start");
    }

    @AfterSuite
    public void close() {
        System.out.println("Test close");
//        driver.quit();
    }
}
