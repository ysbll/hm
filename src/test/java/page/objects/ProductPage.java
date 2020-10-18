package page.objects;

import drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public HeaderPage header;

    @FindBy(xpath = "//button[@id='favourite_']")
    public WebElement favoriteButton;

    @FindBy(xpath = "//h1[@class='primary product-item-headline']")
    public WebElement productName;

    public ProductPage addItemToFavorites() {
        favoriteButton.click();
        return new ProductPage();
    }

    public ProductPage goTo(String productUrl) {
        DriverManager.getWebDriver().navigate().to(productUrl);
        return new ProductPage();
    }

    public String getProductName() {
        return productName.getText();
    }

    public ProductPage() {
        super();
        header = new HeaderPage();
    }

    public boolean isFavoriteButtonActive() {
        return favoriteButton.getAttribute("class").contains("is-favorite");
    }
}
