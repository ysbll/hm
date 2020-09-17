package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(id= "modal-txt-signin-password-required-error")
    private WebElement passwordAlert;

    @FindBy(id="modal-txt-signin-email-required-error")
    private WebElement emailRequiredAlert;

    @FindBy(xpath = "//div[contains(@class, 'Name--container')]")
    private WebElement nameContainer;

    @FindBy(id="modal-txt-signin-email-email-format-error")
    private WebElement incorrectEmailFormatAlert;


    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    public void login(String email, String password){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInEmailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInPasswordField.sendKeys(password);
        loginButton.submit();
    }

    public boolean isPasswordRequiredAlertDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(passwordAlert));
        return passwordAlert.getText().contains("Please enter a password.");
    }

    public boolean isEmailRequiredAlertDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(emailRequiredAlert));
        return emailRequiredAlert.getText().contains("Enter an email address.");
    }

    public boolean isIncorrectEmailFormatAlertDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(incorrectEmailFormatAlert));
        return incorrectEmailFormatAlert.getText().contains("Incorrect format");
    }

}
