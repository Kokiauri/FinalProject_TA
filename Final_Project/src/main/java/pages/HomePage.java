package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    private By homeHeader = By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]");
    private By signupLink = By.xpath("//a[contains(text(),'Signup')]");
    private By subscriptionEmailInput = By.xpath("//*[@id='susbscribe_email']");
    private By subscribeButton = By.id("subscribe");
    private By subscriptionText = By.xpath("//h2[contains(text(), 'Subscription')]");
    private By successMessage = By.cssSelector(".alert-success");
    private By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    protected By testCasesLink = By.xpath("//a[contains(text(),'Test Cases')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader)).isDisplayed();
    }

    @Step("Navigate To Home Page")
    public void navigateToHomePage() {
        driver.get(baseUrl);
        Assert.assertTrue(isHomePageVisible(), "Home page is NOT visible");
    }

    @Step("Scroll down to subscription input")
    public void scrollToSubscriptionInput() {
        scrollToElement(subscriptionEmailInput);
    }

    @Step("Get Subscription text")
    public String getSubscriptionText() {
        return getText(subscriptionText);
    }

    @Step("Enter email address in input and click arrow button")
    public void subscribe(String email) {
        type(subscriptionEmailInput, email);
        click(subscribeButton);
    }

    @Step("Verify success message is visible")
    public String getSubscriptionSuccessMessage() {
        return getText(successMessage);
    }

    @Step("Click on Signup / Login link")
    public void clickSignupLink() {
        click(signupLink);
    }
    public void clickCartLink() {
        click(cartLink);
    }


}
