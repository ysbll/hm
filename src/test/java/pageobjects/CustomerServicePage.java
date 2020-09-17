package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerServicePage extends BasePage {

    @FindBy(id="inqChatStage")
    private WebElement chatBox;

    @FindBy(xpath = "//button[@aria-label='Click to chat']")
    private WebElement chatButton;

    //td[@class='tcChat_agentLine']/span[@class='agentMsg']


    public CustomerServicePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openChatBox(){
        chatButton.click();
    }

    public void goToChatBox(){
        chatButton.click();
        driver.switchTo().frame(chatBox);
    }





}
