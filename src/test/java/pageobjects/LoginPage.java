package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElements;

public class LoginPage extends BasePage {

    @FindBy(id = "modal-txt-signin-password-required-error")
    private WebElement passwordAlert;

    @FindBy(id = "modal-txt-signin-email-required-error")
    private WebElement emailRequiredAlert;

    @FindBy(xpath = "//div[contains(@class, 'Name--container')]")
    private WebElement nameContainer;

    @FindBy(id = "modal-txt-signin-email-email-format-error")
    private WebElement incorrectEmailFormatAlert;

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
