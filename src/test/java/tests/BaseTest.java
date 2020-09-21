package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;
import utils.TestDataReader;

import java.util.concurrent.TimeUnit;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigurationReader configuration;
    protected TestDataReader testData;



    @BeforeAll
    public void setUp(){
        testData = new TestDataReader("src/test/java/tests/TestData.properties");
        configuration = new ConfigurationReader("src/test/java/configs/Configuration.properties");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeEach
    void clearCookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    void tearDown(){
        driver.quit();
    }
}
