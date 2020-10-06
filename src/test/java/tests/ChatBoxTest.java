package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CustomerServicePage;

public class ChatBoxTest extends BaseTest{

        @Test
        public void shouldChatBoxBeOpened(){
            CustomerServicePage customerServicePage = new CustomerServicePage(driver,wait)
                    .goTo(configuration.getBaseUrl() + testData.getCustomerServiceURL());
            customerServicePage.closeCookiePopup();
            customerServicePage.goToChatBox();
            Assert.assertTrue(customerServicePage.isChatboxOpened(), "Welcome message is not correct.");
        }

}
