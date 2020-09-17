package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage {

    protected HeaderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[@class='menu__favorites']")
    protected WebElement favoritesIcon;

    public FavoritesPage viewFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(favoritesIcon));
        favoritesIcon.click();
        return new FavoritesPage(driver, wait);
    }
}
