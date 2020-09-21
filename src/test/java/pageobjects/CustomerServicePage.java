package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerServicePage extends BasePage {

    @FindBy(id="inqChatStage")
    private WebElement chatBox;

    @FindBy(xpath = "//button[@id='tcChat_btnRestore']")
    private WebElement chatButton;

    @FindBy(xpath = "td(@class='tcChat_agentLine')")
    private WebElement agentLineText;

    //td[@class='tcChat_agentLine']/span[@class='agentMsg']


    public CustomerServicePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openChatBox(){
        chatButton.click();
    }

    public void goToChatBox(){
        driver.switchTo().frame("inqChatStage");
        //wait.until(ExpectedConditions.elementToBeClickable(chatButton));
        chatButton.click();
        //driver.switchTo().frame(chatBox);
    }

    public CustomerServicePage goTo(String page){
        driver.navigate().to(page);
        return new CustomerServicePage(driver, wait);
    }

    public String isChatboxOpened(){
        //driver.switchTo().frame();
        wait.until(ExpectedConditions.visibilityOf(agentLineText));
        String welcomeText = agentLineText.getText();
        return welcomeText;
    }







}
