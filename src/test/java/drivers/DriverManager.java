package drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;
    private static final BrowserType BROWSER_TYPE = BrowserType.SAFARI;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(BrowserType.CHROME);
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!BROWSER_TYPE.equals(BrowserType.SAFARI)) {
            driver.quit();
        }
        driver = null;
    }
}
