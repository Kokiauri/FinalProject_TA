package org.example.ui;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import utils.DriverFactory;
import java.io.File;

public class ContactFormTest extends BaseTest {
    @Test(description = "Test Case 6: Contact Us Form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that 'Contact Us' Form Works and success message is displayed")
    public void ContactUsFormTest(){
        ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
        contactUsPage.navigateToHomePage();

        contactUsPage.clickContactUs();

        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' is not visible");

        contactUsPage.fillContactForm("Mr Krabs", "Mr.Krabs@Krab.com", "Test Subject", "This is a test message.");

        String filePath = System.getProperty("user.dir") + File.separator + "sampleImages" + File.separator + "crab.jpg";
        contactUsPage.uploadFile(filePath);

        contactUsPage.clickSubmit();

        contactUsPage.handleAlert();

        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message is not visible");
        /*I am aware that I'm supposed to use the "Home" button here instead of calling the driver. But for some reason,
        /a Google ad pops up at random times, so I decided to go with a more reliable option */
        contactUsPage.navigateToHomePage();
        contactUsPage.isHomePageVisible();
    }
}
