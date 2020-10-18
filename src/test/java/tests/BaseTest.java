package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import drivers.DriverManager;
import drivers.DriverUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ConfigurationReader;
import utilities.TestDataReader;
import utilities.UserDataGenerator;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigurationReader configuration;
    protected TestDataReader testData;

    @BeforeClass
    public void getConfiguration() {
        testData = new TestDataReader("src/test/java/tests/TestData.properties");
        configuration = new ConfigurationReader("src/main/java/configs/Configuration.properties");
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        wait = new WebDriverWait(driver, 5000);
    }

    @AfterMethod
    void afterMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed " + testResult.getMethod().getMethodName());
            String fileName = UserDataGenerator.fileNameGenerator() + ".png";
            String directory = System.getProperty("user.dir") + "//screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
        }
        DriverManager.disposeDriver();
    }
}

