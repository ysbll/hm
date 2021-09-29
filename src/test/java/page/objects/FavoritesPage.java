package page.objects;

import drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElements;

public class FavoritesPage extends BasePage {
    public HeaderPage header;

    @FindBy(xpath = "//h2[@class ='BodyText-module--general__2yKZb ProductTitle-module--productTitle__2D3pq BodyText-module--ellipsis__2D65P']")
    public WebElement itemName;

    @FindBy(xpath = "//section[@class='segment favorites-empty']/a")
    private WebElement browseNowButton;

    @FindBy(xpath = "//button[@class='remove-product icon-close-black js-remove-favorite']")
    private WebElement removeFromFavoritesButton;

    @FindBy(xpath = "//span[@class='favorite-items-quantity-number ng-binding']")
    private WebElement itemsQuantity;

    public FavoritesPage removeItemFromFavorites() {
        WaitForElements.waitUntilElementIsClickable(removeFromFavoritesButton);
        removeFromFavoritesButton.click();
        return new FavoritesPage();
    }

    public String getProductName() {
        WaitForElements.waitUntilElementIsVisible(itemName);
        return itemName.getText();
    }

    public String getItemsQuantity() {
        WaitForElements.waitUntilElementIsVisible(itemsQuantity);
        return itemsQuantity.getText();
    }

    public boolean isFavoriteListEmpty() {
        WaitForElements.waitUntilElementIsVisible(browseNowButton);
        return browseNowButton.isDisplayed();
    }

    public FavoritesPage goTo(String productUrl) {
        DriverManager.getWebDriver().navigate().to(productUrl);
        return new FavoritesPage();
    }

    public FavoritesPage() {
        super();
        header = new HeaderPage();
    }
}

