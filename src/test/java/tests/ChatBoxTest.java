package tests;

import org.junit.jupiter.api.Test;
import pageobjects.CustomerServicePage;
import pageobjects.HomePage;

public class ChatBoxTest extends BaseTest{

    @Test
    public void shouldChatBoxOpened(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.closeCookiePopup();
        CustomerServicePage customerServicePage = homePage.goToCustomerServicePage();
        customerServicePage.goToChatBox();


    }
}
