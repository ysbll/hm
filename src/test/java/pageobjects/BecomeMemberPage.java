package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BecomeMemberPage extends BasePage{

    @FindBy(xpath = "//div[@class='merged-inputs invalid active']")
    private WebElement dateOfBirthField;

    public BecomeMemberPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void becomeMember(String mail, String password, String dateOfBirth){
        signInEmailField.sendKeys(mail);
        signInPasswordField.sendKeys(password);
        dateOfBirthField.sendKeys(dateOfBirth);
    }


}
