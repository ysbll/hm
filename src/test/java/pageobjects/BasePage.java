package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    @FindBy(xpath = "//div[@class='menu__services__item']/a[text()='Customer Service']")
    private WebElement customerServiceMenu;

    @FindBy(xpath = "//button[@class='close icon-close-white js-close']")
    private WebElement closeCookiePopupButton;

    protected BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void openPage(){
        driver.get(MAIN_URL);
    }

    public void closeCookiePopup(){
        wait.until(ExpectedConditions.elementToBeClickable(closeCookiePopupButton));
        closeCookiePopupButton.click();
    }

    public boolean URLisCorrect(String url){
        return driver.getCurrentUrl().contains(url);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }



}
