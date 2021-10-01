package page.objects;

import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElements;

public abstract class BasePage {

    protected final String MAIN_URL = "https://www2.hm.com/en_us/index.html";
    private static final Logger logger = LogManager.getLogger(BasePage.class);


    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement closeCookiePopupButton;

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void openPage() {
        DriverManager.getWebDriver().get(MAIN_URL);
    }

    public void closeCookiePopup() {
        WaitForElements.waitUntilElementIsClickable(closeCookiePopupButton);
        closeCookiePopupButton.click();
    }

    public boolean URLisCorrect(String url) {
        return DriverManager.getWebDriver().getCurrentUrl().contains(url);
    }

    public void refreshPage() {
        logger.info("Refresh a page");
        DriverManager.getWebDriver().navigate().refresh();
    }

}
