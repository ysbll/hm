package page.objects;

import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElements;

public class FavoritesPage extends BasePage {
    public HeaderPage header;
    private static final Logger LOGGER = LogManager.getLogger(FavoritesPage.class);


    @FindBy(xpath = "//h2[contains(@class, 'ProductTitle-module')]/a")
    public WebElement itemName;

    @FindBy(xpath = "//div[contains(@class, 'FavouritesEmpty--button')]/button")
    private WebElement browseNowButton;

    @FindBy(xpath = "//button[contains(@class, 'RemoveButton')]")
    private WebElement removeFromFavoritesButton;

    @FindBy(xpath = "//p[@role='region']")
    private WebElement itemsQuantity;

    public FavoritesPage removeItemFromFavorites() {
        WaitForElements.waitUntilElementIsClickable(removeFromFavoritesButton);
        LOGGER.info("Remove from favorites");
        removeFromFavoritesButton.click();
        return new FavoritesPage();
    }

    public String getProductName() {
        WaitForElements.waitUntilElementIsVisible(itemName);
        LOGGER.info("Get item name text");
        return itemName.getText();
    }

    public String getItemsQuantity() {
        WaitForElements.waitUntilElementIsVisible(itemsQuantity);
        LOGGER.info("Get items qty");
        return itemsQuantity.getText();
    }

    public boolean isFavoriteListEmpty() {
        WaitForElements.waitUntilElementIsVisible(browseNowButton);
        return browseNowButton.isDisplayed();
    }

    public FavoritesPage goTo(String productUrl) {
        LOGGER.info("Go to Favorites page");
        DriverManager.getWebDriver().navigate().to(productUrl);
        return new FavoritesPage();
    }

    public FavoritesPage() {
        super();
        header = new HeaderPage();
    }
}

