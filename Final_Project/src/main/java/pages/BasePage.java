package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected String baseUrl = "https://automationexercise.com";

    private By homeHeader = By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToHomePage() {
        driver.get(baseUrl);
    }

    public boolean isHomePageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader)).isDisplayed();
    }

    protected void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    protected void type(By locator, String text) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);

    }

    protected String getText(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

   }


}