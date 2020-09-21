package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CustomerServicePage;

public class ChatBoxTest extends BaseTest{

    @Test
    public void shouldChatBoxOpened(){

        CustomerServicePage customerServicePage = new CustomerServicePage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCustomerServiceURL());
        customerServicePage.closeCookiePopup();
        System.out.println("weszlo");
        customerServicePage.goToChatBox();
        System.out.println("weszlo123");

        Assertions.assertEquals("H&M Virtual Assistant:", customerServicePage.isChatboxOpened());

    }

    @Test
    public void chatboxMessageIsCorrect(){

    }

    @Test
    public void resizeFontShouldWork(){

    }
}
