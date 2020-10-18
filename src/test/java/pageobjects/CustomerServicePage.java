package pageobjects;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElements;

public class CustomerServicePage extends BasePage {

    @FindBy(id = "inqChatStage")
    private WebElement chatBox;

    @FindBy(xpath = "//button[@aria-label='Click to chat']")
    private WebElement chatButton;

    @FindBy(xpath = "//span[@class='agentMsg']")
    private WebElement agentLineText;

    public void openChatBox() {
        chatButton.click();
    }

    public void goToChatBox() {
        WaitForElements.waitUntilElementIsClickable(chatButton);
        chatButton.click();
    }

    public CustomerServicePage goTo(String page) {
        DriverManager.getWebDriver().navigate().to(page);
        return new CustomerServicePage();
    }

    public boolean isChatboxOpened() {
        //driver.switchTo().frame("inqChatStage");
        //wait.until(ExpectedConditions.visibilityOf(agentLineText));
        //waitForElementToBeVisible("agentLineText");
        String welcomeText = agentLineText.getText();
        return welcomeText.contains("H&M Virtual Assistant:");
    }


}
