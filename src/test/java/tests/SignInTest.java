package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.UserDataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInTest extends BaseTest {

    @Test
    void shouldDisplayErrorMessageWhenNoPasswordProvided(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        LoginPage loginPage = new LoginPage(driver, wait).goTo()
                .login(UserDataGenerator.emailGenerator(), "");
        Assertions.assertTrue(loginPage.isPasswordRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayErrorMessageWhenNoEmailProvided(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        LoginPage loginPage = new LoginPage(driver,wait).goTo().login("", UserDataGenerator.passwordGenerator());
        assertTrue(loginPage.isEmailRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayErrorMessageWhenNoEmailAndPasswordProvided(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        LoginPage loginPage = new LoginPage(driver,wait).goTo().login("", "");
        assertTrue(loginPage.isPasswordRequiredAlertDisplayed() && loginPage.isEmailRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayErrorMessageWhenIncorrectEmailFormatProvided(){
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        LoginPage loginPage = new LoginPage(driver,wait).goTo()
                .login("lalala", UserDataGenerator.passwordGenerator());
        assertTrue(loginPage.isIncorrectEmailFormatAlertDisplayed());
    }
}
