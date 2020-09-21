package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CustomerServicePage;
import pageobjects.HomePage;

public class ChatBoxTest extends BaseTest{

    @Test
    public void shouldChatBoxOpened(){

        CustomerServicePage customerServicePage = new CustomerServicePage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCustomerServiceURL());
        customerServicePage.closeCookiePopup();
        customerServicePage.goToChatBox();

        Assertions.assertEquals();

    }

    @Test
    public void chatboxMessageIsCorrect(){

    }

    @Test
    public void resizeFontShouldWork(){

    }
}
