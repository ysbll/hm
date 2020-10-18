package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
