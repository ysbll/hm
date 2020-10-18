package pageobjects;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElements;

public class FavoritesPage extends BasePage {
    public HeaderPage header;

    @FindBy(xpath = "//h3[@class ='sub-sub-heading ng-binding']")
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

