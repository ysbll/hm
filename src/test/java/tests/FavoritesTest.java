package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import java.util.Random;

public class FavoritesTest extends BaseTest{

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromCategoryPage(){
        String productUrl = "https://www2.hm.com/en_us/women/products/view-all.html";

        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(productUrl);
        String productName = categoryPage.addItemToFavorites().getProductName();
        String addedItem = categoryPage.header.viewFavorites().getProductName();
        Assertions.assertEquals(productName, addedItem);
    }

    @Test
    void nameOfAddedItemToFavoriteIsCorrectFromProductPage() {
        String productUrl = "https://www2.hm.com/en_us/productpage.0803757001.html";

        ProductPage productPage = new ProductPage(driver, wait).goTo(productUrl);
        productPage.closeCookiePopup();
        String productName = productPage.addItemToFavorites().getProductName();
        String addedItem = productPage.header.viewFavorites().getProductName();
        Assertions.assertEquals(productName, addedItem);
    }

    @Test
    void shouldBeRemoveFromFavoritePage(){
       /* HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        WomenClothesPage womenClothesPage = homePage.goToWomenClothesPage();
        womenClothesPage.goToViewAllPage();
        ProductPage productPage = womenClothesPage.goToProductPage();
        productPage.addItemToFavorites();
        FavoritesPage favoritesPage = productPage.goToFavoritesPage();
        favoritesPage.removeItemFromFavorites();
        Assertions.assertFalse(favoritesPage.isFavoritesItemListDisplayed());


        int productAmount = categoryPage.addToCart(productId).viewCart().getProductsAmount(productId);


        boolean isCartEmpty = productPage.addToCart().viewCart().removeProduct(productId).isCartEmpty();

*/
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnProductPage(){
        String productUrl = "https://www2.hm.com/en_us/productpage.0803757001.html";

        ProductPage productPage = new ProductPage(driver, wait).goTo(productUrl);
        productPage.closeCookiePopup();
        productPage.addItemToFavorites().addItemToFavorites();
        //System.out.println(productPage.favoriteButton.getAttribute("class"));
        Assertions.assertFalse(productPage.isFavoriteButtonActive());
    }

    @Test
    void shouldBeRemovedFromFavoritesWhenUnclickButtonOnCategoryPage(){
        String productUrl = "https://www2.hm.com/en_us/women/products/view-all.html";

        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(productUrl).addItemToFavorites()
                .removeFromFavorites();
        categoryPage.header.viewFavorites();
        FavoritesPage favoritesPage= new FavoritesPage(driver,wait);
        Assertions.assertTrue(favoritesPage.isFavoriteListEmpty());

    }

    @Test
    void shouldFavoritesIconBeInactiveOnProductPageWhenItemRemovedFromFavoritesPage(){

    }

    @Test
    void shouldFavoritesIconBeInactiveOnCategoryPageWhenItemRemovedFromFavoritesPage(){

    }

    @Test
    void isPossibleToAddMultipleItemsToFavorites(){
        String productUrl = "https://www2.hm.com/en_us/women/products/view-all.html";
        Random rand = new Random();
        int itemQty = rand.nextInt(15);

        CategoryPage categoryPage = new CategoryPage(driver,wait).goTo(productUrl);
        String itemsQty = categoryPage.addItemsToFavorites(itemQty).header.viewFavorites().getItemsQuantity();

        Assertions.assertEquals(itemQty + " Items", itemsQty);
    }

    @Test
    void shouldURLbeCorrectWhenUserGoToFavorites(){


    }

    @Test
    void refreshingPageDoesntAffectFavoritesList(){

    }

    @Test
    void favoritesButtonIsActiveOnProductPageWhenItemWasAddedToFavoritesFromMainPage(){

    }

    @Test
    void favoritesButtonIsActiveOnCategoryPageWhenItemWasAddedToFavoritesFromProductPage(){

    }

    @Test
    void shouldFavoritesIconBeInactiveOnProductPageWhenItemRemovedFromFavoritesFromMainPage(){

    }

    //1.Kliknac w ikonke, odkliknac - zmieniona ++??
    //2.kliknac w ikonke, odkliknac - sprawdzic strone favorites
    //3. usunac ze strony favorite: usuniete ze strony produktu
    //4. usuniete wtedy z glownej (ikona niekatywna)
    //5. czy nazwa sie zgdza dodanego ++++
    //6. czy mozna dodac multiple? - dodac
    //7 czy po odswieeniu dalej jest w ulubione?
    //8. sesja-- czy zapamietuje w ulubionych
    // 9. dodam z glownej do ulubionyhc, wejde na strone produktu - czy zaznaczone?
    //odznacze ze strony produkty - czy usuniete w stronie Favorites
    //url sie zgadza
    // 1. Gdy klika w favorites - url sie zmienia
    //




}
