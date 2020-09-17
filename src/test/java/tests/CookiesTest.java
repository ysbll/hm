package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pageobjects.HomePage;

import java.util.Set;

public class CookiesTest extends BaseTest{

    @Test
    void openURL()  {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();

        Set<Cookie> cookies = driver.manage().getCookies();
        Cookie cookieSecure = driver.manage().getCookieNamed("__Secure-3PAPISID");

    }

    //dodaj do koszyka 2 rzeczy, sprawdz czy liczba sie zgadza - kolejny test: przed delete cookies konkretne
    //lub wszystkie dla porownania

}
