package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        wait.until(ExpectedConditions.elementToBeClickable(removeFromFavoritesButton));
        removeFromFavoritesButton.click();
        return new FavoritesPage(driver, wait);
    }

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOf(itemName));
        return itemName.getText();
    }

    public String getItemsQuantity() {
        wait.until(ExpectedConditions.visibilityOf(itemsQuantity));
        return itemsQuantity.getText();
    }

    public boolean isFavoriteListEmpty() {
        wait.until(ExpectedConditions.visibilityOf(browseNowButton));
        return browseNowButton.isDisplayed();
    }

    public FavoritesPage goTo(String productUrl) {
        driver.navigate().to(productUrl);
        return new FavoritesPage(driver, wait);
    }

    public FavoritesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        header = new HeaderPage(driver, wait);
    }


}

