package org.example.ui;

import base.BaseTest;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class SubscriptionTests extends BaseTest {

    @Test(  description = "UI 8: Verify Subscription in HomePage")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that subscription works in HomePage")
    public void HomeSubscriptionTest(){
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        homePage.navigateToHomePage();
        
        homePage.scrollToSubscriptionInput();
        
        String subscriptionText = homePage.getSubscriptionText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Subscription text is NOT visible or incorrect");
        
        homePage.subscribe("test" + System.currentTimeMillis() + "@example.com");
        
        String successMsg = homePage.getSubscriptionSuccessMessage();
        Assert.assertEquals(successMsg, "You have been successfully subscribed!", "Success message is NOT visible or incorrect");
    }



    @Test(  description = "UI 9: Verify Subscription in CartPage")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that subscription works in CartPage")
    public void cartSubscriptionTest(){
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        homePage.navigateToHomePage();

        homePage.clickCartLink();

        homePage.scrollToSubscriptionInput();

        String subscriptionText = homePage.getSubscriptionText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Subscription text is NOT visible or incorrect");

        homePage.subscribe("test" + System.currentTimeMillis() + "@example.com");

        String successMsg = homePage.getSubscriptionSuccessMessage();
        Assert.assertEquals(successMsg, "You have been successfully subscribed!", "Success message is NOT visible or incorrect");
    }


}



