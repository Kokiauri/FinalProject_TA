package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    private By homeHeader = By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]");
    private By signupLink = By.xpath("//a[contains(text(),'Signup')]");
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
    @Step("Click on Signup / Login link")
    public void clickSignupLink() {
        click(signupLink);
    }
}
