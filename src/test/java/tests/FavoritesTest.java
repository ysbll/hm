package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import java.util.Random;

public class FavoritesTest extends BaseTest{

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromCategoryPage(){
        CategoryPage categoryPage = new CategoryPage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL());
        System.out.println("weszlo");
        String productName = categoryPage.addItemToFavorites().getProductName();
        String addedItem = categoryPage.header.viewFavorites().getProductName();
        Assertions.assertEquals(productName, addedItem);
    }

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromProductPage() {
        ProductPage productPage = new ProductPage(driver, wait)
                .goTo(configuration.getBaseUrl() + testData.getProductURL());
        productPage.closeCookiePopup();
        String productName = productPage.addItemToFavorites().getProductName();
        String addedItem = productPage.header.viewFavorites().getProductName();
        Assertions.assertEquals(productName, addedItem);
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnProductPage(){
        ProductPage productPage = new ProductPage(driver, wait)
                .goTo(configuration.getBaseUrl() + testData.getProductURL());
        productPage.closeCookiePopup();
        productPage.addItemToFavorites().addItemToFavorites();
        Assertions.assertFalse(productPage.isFavoriteButtonActive());
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnCategoryPage(){
        CategoryPage categoryPage = new CategoryPage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL()).addItemToFavorites()
                .removeFromFavorites();
        categoryPage.header.viewFavorites();
        FavoritesPage favoritesPage= new FavoritesPage(driver,wait);
        Assertions.assertTrue(favoritesPage.isFavoriteListEmpty());
    }

    @Test
    void shouldFavoritesIconBeInactiveOnProductPageWhenItemRemovedFromFavoritesPage(){
        ProductPage productPage = new ProductPage(driver, wait)
                .goTo(configuration.getBaseUrl() + testData.getProductURL());
        productPage.closeCookiePopup();
        productPage.addItemToFavorites().header.viewFavorites().removeItemFromFavorites();
        productPage.goTo(testData.getProductURL());
        Assertions.assertFalse(productPage.isFavoriteButtonActive());
    }


    @Test
    void isPossibleToAddMultipleItemsToFavorites(){
        Random rand = new Random();
        int itemQty = rand.nextInt(15);
        CategoryPage categoryPage = new CategoryPage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL());
        String itemsQty = categoryPage.addItemsToFavorites(itemQty).header.viewFavorites().getItemsQuantity();
        Assertions.assertEquals(itemQty + " Items", itemsQty);
    }

    @Test
    void shouldURLbeCorrectWhenUserGoToFavorites(){
        FavoritesPage favoritesPage = new FavoritesPage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL()).header.viewFavorites();
        Assertions.assertTrue(favoritesPage.URLisCorrect("favourites"));
    }

    @Test
    void refreshingPageDoesntAffectFavoritesList(){
        CategoryPage categoryPage = new CategoryPage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL()).addItemsToFavorites(2);
        FavoritesPage favoritesPage = new FavoritesPage(driver,wait).header.viewFavorites();
        favoritesPage.refreshPage();
        String itemsQty = favoritesPage.getItemsQuantity();
        Assertions.assertEquals("2 Items", itemsQty);
    }

}
