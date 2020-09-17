package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage extends BasePage {

    @FindBy(xpath = "//h3[@class ='sub-sub-heading ng-binding']")
    public WebElement itemName;

    @FindBy(xpath = "//section[@class='segment favorites-empty']/a")
    private WebElement browseNowButton;

    @FindBy(xpath = "//button[@class='RemoveButton-module_RemoveButton__2pjXf']")
    private WebElement removeFromFavoritesButton;

    @FindBy(xpath = "//span[@class='favorite-items-quantity-number ng-binding']")
    private WebElement itemsQuantity;

    public void removeItemFromFavorites() {
        //wait.until(ExpectedConditions.elementToBeClickable(removeFromFavoritesButton));
        removeFromFavoritesButton.click();
    }

    public String getProductName() {
        wait.until(ExpectedConditions.invisibilityOf(itemName));
        return itemName.getText();
    }

    public String getItemsQuantity() {
        return itemsQuantity.getText();
    }

    public boolean isFavoriteListEmpty() {
        wait.until(ExpectedConditions.visibilityOf(browseNowButton));
        return browseNowButton.isDisplayed();
    }

    public FavoritesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}

