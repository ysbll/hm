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
        String categoryUrl = "https://www2.hm.com/en_us/women/products/view-all.html";

        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(categoryUrl);
        System.out.println("weszlo");
        String productName = categoryPage.addItemToFavorites().getProductName();
        String addedItem = categoryPage.header.viewFavorites().getProductName();
        Assertions.assertEquals(productName, addedItem);
    }

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromProductPage() {
        String productUrl = "https://www2.hm.com/en_us/productpage.0763194001.html";

        ProductPage productPage = new ProductPage(driver, wait).goTo(productUrl);
        productPage.closeCookiePopup();
        String productName = productPage.addItemToFavorites().getProductName();
        String addedItem = productPage.header.viewFavorites().getProductName();
        Assertions.assertEquals(productName, addedItem);
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnProductPage(){
        String productUrl = "https://www2.hm.com/en_us/productpage.0763194001.html";

        ProductPage productPage = new ProductPage(driver, wait).goTo(productUrl);
        productPage.closeCookiePopup();
        productPage.addItemToFavorites().addItemToFavorites();
        Assertions.assertFalse(productPage.isFavoriteButtonActive());
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnCategoryPage(){
        String categoryUrl = "https://www2.hm.com/en_us/women/products/view-all.html";

        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(categoryUrl).addItemToFavorites()
                .removeFromFavorites();
        categoryPage.header.viewFavorites();
        FavoritesPage favoritesPage= new FavoritesPage(driver,wait);
        Assertions.assertTrue(favoritesPage.isFavoriteListEmpty());

    }

    @Test
    void shouldFavoritesIconBeInactiveOnProductPageWhenItemRemovedFromFavoritesPage(){
        String productUrl = "https://www2.hm.com/en_us/productpage.0763194001.html";

        ProductPage productPage = new ProductPage(driver, wait).goTo(productUrl);
        productPage.closeCookiePopup();
        productPage.addItemToFavorites().header.viewFavorites().removeItemFromFavorites();
        productPage.goTo(productUrl);
        Assertions.assertFalse(productPage.isFavoriteButtonActive());
    }


    @Test
    void isPossibleToAddMultipleItemsToFavorites(){
        String categoryUrl = "https://www2.hm.com/en_us/women/products/view-all.html";
        Random rand = new Random();
        int itemQty = rand.nextInt(15);
        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(categoryUrl);
        String itemsQty = categoryPage.addItemsToFavorites(itemQty).header.viewFavorites().getItemsQuantity();
        Assertions.assertEquals(itemQty + " Items", itemsQty);
    }

    @Test
    void shouldURLbeCorrectWhenUserGoToFavorites(){
        String categoryUrl = "https://www2.hm.com/en_us/women/products/view-all.html";
        FavoritesPage favoritesPage = new FavoritesPage(driver,wait).goTo(categoryUrl).header.viewFavorites();
        Assertions.assertTrue(favoritesPage.URLisCorrect("favourites"));
    }

    @Test
    void refreshingPageDoesntAffectFavoritesList(){
        String categoryUrl = "https://www2.hm.com/en_us/women/products/view-all.html";

        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(categoryUrl).addItemsToFavorites(2);
        FavoritesPage favoritesPage = new FavoritesPage(driver,wait).header.viewFavorites();
        favoritesPage.refreshPage();
        String itemsQty = favoritesPage.getItemsQuantity();
        Assertions.assertEquals("2 Items", itemsQty);
    }

}
