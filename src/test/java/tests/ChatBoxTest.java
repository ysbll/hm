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

        curl -v --silent -X POST -H 'Content-Type: application/json' -H 'accept: application/json' -d '{"grant_type":"http://auth0.com/oauth/grant-type/password-realm", "username": "izabela.kwiatkowska@xyleminc.com", "password": "Majorka2910!”, "scope": "openid email profile api:customer:", "client_id": "VsnLUFS8sNOspGUu1CxwkzCJ4fcvuSI0", "client_secret": "WmBJsiqr0GFX_U0gT3LGsjjHOD8VGfaZPo9aBYeND60MW1me_tR7rObtrg4AdOVR", "audience": "urn:xylem-xcloud-api", "realm": "customdb" }' 'https://xylem-dev.auth0.com/oauth/token'


    }
}
