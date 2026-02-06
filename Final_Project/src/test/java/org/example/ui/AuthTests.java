package org.example.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import base.BaseTest;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;


public class AuthTests extends BaseTest {

    @Test(
            priority = 1,
            description = "Register new user with valid data"
    )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a new user can register successfully using valid credentials")
    public void registerUserFullFlow() {

        LoginPage page =
                new LoginPage(DriverFactory.getDriver());

        page.navigateToHomePage();

        String email =
                "test" + System.currentTimeMillis() + "@gmail.com";

        page.clickSignupLink();

        page.enterSignupName("Test User");
        page.enterSignupEmail(email);
        page.clickSignupButton();

        page.selectMale();
        page.enterAccountPassword("123456");

        page.selectDay("10");
        page.selectMonth("May");
        page.selectYear("2000");

        page.subscribeToNewsletter();

        page.enterFirstName("Test");
        page.enterLastName("User");
        page.enterCompany("MyCompany");

        page.enterAddress1("123 Main Street");
        page.enterAddress2("Apt 4");

        page.selectCountry("Canada");

        page.enterState("Ontario");
        page.enterCity("Toronto");
        page.enterZipCode("12345");
        page.enterMobileNumber("1234567890");

        page.clickCreateAccount();
        page.isAccountCreated();
    }
    @Test(
            priority = 2,
            description = "Login user with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a registered user can login successfully and delete account")
    public void loginUserWithCorrectCredentials() {


        LoginPage page =
                new LoginPage(DriverFactory.getDriver());


        page.navigateToHomePage();
        Assert.assertTrue(page.isHomePageVisible(), "Home page is NOT visible");
        if (page.isLogoutVisible()) {
      page.logOut();
        }

        page.clickSignupLink();

        Assert.assertTrue(page.isLoginPageVisible(), "Login page is NOT visible");

        page.login("t@protonmail.com", "123456");

        Assert.assertTrue(page.isLoggedInTextVisible(), "'Logged in as username' not visible");
    }
    @Test(
            priority = 2,
            description = "Login user with Incorrect credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a non-registered user can't login")
    public void loginUserWithIncorrectCredentials() {


        LoginPage page =  new LoginPage(DriverFactory.getDriver());


        page.navigateToHomePage();
        Assert.assertTrue(page.isHomePageVisible(), "Home page is NOT visible");
        if (page.isLogoutVisible()) {
            page.logOut();
        }
        page.clickSignupLink();
        Assert.assertTrue(page.isLoginPageVisible(), "Login page is NOT visible");

        page.login("incorrect@mail.com", "123");

       Assert.assertTrue(page.areCredentialsIncorrect(), "Error message for incorrect credentials is not visible");
    }

    @Test(description = "Logout user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that users can successfully log out")
    public void logoutUserTest(){
        LoginPage page = new LoginPage(DriverFactory.getDriver());
        page.navigateToHomePage();
        Assert.assertTrue(page.isHomePageVisible(), "Home page is NOT visible");
        page.clickSignupLink();
        Assert.assertTrue(page.isLoginPageVisible(), "Login page is NOT visible");
        page.login("t@protonmail.com", "123456");
        Assert.assertTrue(page.isLoggedInTextVisible(), "'Logged in as username' not visible");
        page.logOut();
        Assert.assertTrue(page.isLoginPageVisible(), "Login page is NOT visible");

    }
}

