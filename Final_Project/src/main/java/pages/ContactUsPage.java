package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage{
    @Step("Navigate to Contact Us Page")
    public void navigateToHomePage() {
        driver.get("https://automationexercise.com/contact_us");
    }






    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
}
