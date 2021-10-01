package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.CategoryPage;
import page.objects.FavoritesPage;
import page.objects.ProductPage;

import java.util.Random;

public class FavoritesTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(FavoritesTest.class);

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromCategoryPage() {
        CategoryPage categoryPage = new CategoryPage()
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL());
        String productName = categoryPage.addItemToFavorites().getProductName();
        String addedItem = categoryPage.header.viewFavorites().getProductName();
        Assert.assertEquals(addedItem, productName, "Name of Added item is not match with item in Favorite page.");
    }

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromProductPage() {
        ProductPage productPage = new ProductPage()
                .goTo(configuration.getBaseUrl() + testData.getProductURL());
        String productName = productPage.addItemToFavorites().getProductName();
        String addedItem = productPage.header.viewFavorites().getProductName();
        Assert.assertEquals(addedItem, productName);
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnProductPage() {
        ProductPage productPage = new ProductPage()
                .goTo(configuration.getBaseUrl() + testData.getProductURL());
        productPage.closeCookiePopup();
        productPage.addItemToFavorites().addItemToFavorites();

        Assert.assertFalse(productPage.isFavoriteButtonActive());
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnCategoryPage() {
        CategoryPage categoryPage = new CategoryPage()
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL())
                .addItemToFavorites()
                .removeFromFavorites();
        categoryPage.header.viewFavorites();
        FavoritesPage favoritesPage = new FavoritesPage();
        Assert.assertTrue(favoritesPage.isFavoriteListEmpty());
    }

    @Test
    void shouldFavoritesIconBeInactiveOnProductPageWhenItemRemovedFromFavoritesPage() {
        ProductPage productPage = new ProductPage()
                .goTo(configuration.getBaseUrl() + testData.getProductURL());
        productPage.closeCookiePopup();
        productPage.addItemToFavorites()
                .header
                .viewFavorites()
                .removeItemFromFavorites();
        productPage.goTo(configuration.getBaseUrl() + testData.getProductURL());
        Assert.assertFalse(productPage.isFavoriteButtonActive());
    }


    @Test
    void isPossibleToAddMultipleItemsToFavorites() {
        Random rand = new Random();
        int itemQty = rand.nextInt(15);
        CategoryPage categoryPage = new CategoryPage()
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL());
        categoryPage.closeCookiePopup();
        String itemsQty = categoryPage.addItemsToFavorites(itemQty).header.viewFavorites().getItemsQuantity();
        Assert.assertEquals(itemsQty, itemQty + " Items");
    }

    @Test
    void shouldURLbeCorrectWhenUserGoToFavorites() {
        FavoritesPage favoritesPage = new FavoritesPage()
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL()).header.viewFavorites();
        Assert.assertTrue(favoritesPage.URLisCorrect("favourites"));
    }

    @Test
    void refreshingPageDoesntAffectFavoritesList() {
        CategoryPage categoryPage = new CategoryPage()
                .goTo(configuration.getBaseUrl() + testData.getCategoryURL());
        categoryPage.closeCookiePopup();
        LOGGER.info("Add 2 items to Favorites");
        categoryPage.addItemsToFavorites(2);
        FavoritesPage favoritesPage = new FavoritesPage().header.viewFavorites();
        favoritesPage.refreshPage();
        String itemsQty = favoritesPage.getItemsQuantity();
        Assert.assertEquals(itemsQty, "2 Items");
    }
}
