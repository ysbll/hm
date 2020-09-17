package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    public HeaderPage header;

    @FindBy(xpath = "//button[@class='favorite icon-favorites js-favorite']")
    private WebElement favoriteButton;

    @FindBy(xpath = "//button[@class='favorite icon-favorites js-favorite is-favorite']")
    private WebElement favoriteButtonActive;

    @FindBy(xpath = "//h3[@class='item-heading']/a")
    public WebElement productName;

    public CategoryPage addItemToFavorites(){
        favoriteButton.click();
        return new CategoryPage(driver, wait);
    }

    public CategoryPage goTo(String productUrl) {
        driver.navigate().to(productUrl);
        return new CategoryPage(driver, wait);
    }

    public CategoryPage addItemsToFavorites(int qty){
        for( int i =0; i < qty; i++ ){
            addItemToFavorites();
        }
        return new CategoryPage(driver,wait);
    }

    public CategoryPage removeFromFavorites(){
        favoriteButtonActive.click();
        return new CategoryPage(driver,wait);
    }

    public String getProductName(){
        return productName.getText();
    }

    public CategoryPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        header = new HeaderPage(driver, wait);
    }

}
