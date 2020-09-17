package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    public HeaderPage header;

    @FindBy(xpath = "//button[@id='favourite_']")
    public WebElement favoriteButton;

    @FindBy(xpath = "//h1[@class='primary product-item-headline']")
    public WebElement productName;



    public ProductPage addItemToFavorites(){
        favoriteButton.click();
        return new ProductPage(driver, wait);
    }

    public ProductPage goTo(String productUrl) {
        driver.navigate().to(productUrl);
        return new ProductPage(driver, wait);
    }

    public String getProductName(){
        return productName.getText();
    }

    public ProductPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        header = new HeaderPage(driver, wait);
    }

    public boolean isFavoriteButtonActive() {
        return favoriteButton.getAttribute("class").contains("is-favorite");
    }

}
