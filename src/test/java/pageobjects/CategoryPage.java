package pageobjects;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElements;

public class CategoryPage extends BasePage {

    public HeaderPage header;

    @FindBy(xpath = "//button[@class='favorite icon-favorites js-favorite']")
    private WebElement favoriteButton;

    @FindBy(xpath = "//button[@class='favorite icon-favorites js-favorite is-favorite']")
    private WebElement favoriteButtonActive;

    @FindBy(xpath = "//h3[@class='item-heading']/a")
    public WebElement productName;

    public CategoryPage addItemToFavorites() {
        WaitForElements.waitUntilElementIsClickable(favoriteButton);
        favoriteButton.click();
        return new CategoryPage();
    }

    public CategoryPage goTo(String productUrl) {
        DriverManager.getWebDriver().navigate().to(productUrl);
        return new CategoryPage();
    }

    public CategoryPage addItemsToFavorites(int qty) {
        for (int i = 0; i < qty; i++) {
            addItemToFavorites();
        }
        return new CategoryPage();
    }

    public CategoryPage removeFromFavorites() {
        favoriteButtonActive.click();
        return new CategoryPage();
    }

    public String getProductName() {
        return productName.getText();
    }

    public CategoryPage() {
        super();
        header = new HeaderPage();
    }

}
