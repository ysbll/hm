package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElements;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//a[@class='menu__favorites']")
    protected WebElement favoritesIcon;

    public FavoritesPage viewFavorites() {
        WaitForElements.waitUntilElementIsClickable(favoritesIcon);
        favoritesIcon.click();
        return new FavoritesPage();
    }
}
