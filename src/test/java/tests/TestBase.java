package tests;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite
    public void Driver() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void CloseDriver() {
        driver.quit();
    }
}
