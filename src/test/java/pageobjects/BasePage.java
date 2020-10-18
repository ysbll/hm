package pageobjects;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElements;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final String MAIN_URL = "https://www2.hm.com/en_us/index.html";

    @FindBy(xpath = ".//div[@class='account parbase']")
    protected WebElement signInButton;

    @FindBy(xpath = ".//input[@id='modal-txt-signin-email']")
    protected WebElement signInEmailField;

    @FindBy(xpath = ".//input[@id='modal-txt-signin-password']")
    protected WebElement signInPasswordField;

    @FindBy(xpath = ".//button[contains(@class,'btn-login')]")
    protected WebElement loginButton;

    @FindBy(xpath = "//li/a[@data-signin-state='signedin']")
    protected WebElement myAccountButton;

    @FindBy(xpath = "//button[@class='close icon-close-white js-close']")
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
        DriverManager.getWebDriver().navigate().refresh();
    }

}
