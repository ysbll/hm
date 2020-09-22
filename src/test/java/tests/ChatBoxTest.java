package tests;

import org.testng.annotations.Test;
import pageobjects.CustomerServicePage;
import org.testng.Assert;

public class ChatBoxTest extends BaseTest{

    @Test
    public void shouldChatBoxOpened(){

        CustomerServicePage customerServicePage = new CustomerServicePage(driver,wait)
                .goTo(configuration.getBaseUrl() + testData.getCustomerServiceURL());
        customerServicePage.closeCookiePopup();
        System.out.println("weszlo");
        customerServicePage.goToChatBox();
        System.out.println("weszlo123");

        Assert.assertEquals(customerServicePage.isChatboxOpened(), "H&M Virtual Assistant:");

    }

    @Test
    public void chatboxMessageIsCorrect(){

    }

    @Test
    public void resizeFontShouldWork(){

    }
}
