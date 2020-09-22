package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ConfigurationReader;
import utils.TestDataReader;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigurationReader configuration;
    protected TestDataReader testData;

    @BeforeClass
    public void getConfiguration(){
        testData = new TestDataReader("src/test/java/tests/TestData.properties");
        configuration = new ConfigurationReader("src/test/java/configs/Configuration.properties");
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5000);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
