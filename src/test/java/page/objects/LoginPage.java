package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElements;

public class LoginPage extends BasePage {

    @FindBy(id = "modal-txt-signin-password-required-error")
    private WebElement passwordAlert;

    @FindBy(id = "modal-txt-signin-email-required-error")
    private WebElement emailRequiredAlert;

    @FindBy(id = "modal-txt-signin-email-email-format-error")
    private WebElement incorrectEmailFormatAlert;

    @FindBy(xpath = ".//div[@class='account parbase']")
    private WebElement signInButton;

    @FindBy(xpath = ".//input[@id='modal-txt-signin-email']")
    private WebElement signInEmailField;

    @FindBy(xpath = ".//input[@id='modal-txt-signin-password']")
    private WebElement signInPasswordField;

    @FindBy(xpath = ".//button[contains(@class,'btn-login')]")
    private WebElement loginButton;

    public LoginPage goTo() {
        WaitForElements.waitUntilElementIsClickable(signInButton);
        signInButton.click();
        return new LoginPage();
    }

    public LoginPage login(String email, String password) {
        WaitForElements.waitUntilElementIsVisible(signInButton);
        signInEmailField.sendKeys(email);
        WaitForElements.waitUntilElementIsVisible(signInButton);
        signInPasswordField.sendKeys(password);
        loginButton.submit();
        return new LoginPage();
    }

    public boolean isPasswordRequiredAlertDisplayed() {
        WaitForElements.waitUntilElementIsVisible(passwordAlert);
        return passwordAlert.getText().contains("Please enter a password.");
    }

    public boolean isEmailRequiredAlertDisplayed() {
        WaitForElements.waitUntilElementIsVisible(emailRequiredAlert);
        return emailRequiredAlert.getText().contains("Enter an email address.");
    }

    public boolean isIncorrectEmailFormatAlertDisplayed() {
        WaitForElements.waitUntilElementIsVisible(incorrectEmailFormatAlert);
        return incorrectEmailFormatAlert.getText().contains("Incorrect format");
    }
}
