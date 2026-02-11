package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected String baseUrl = "https://automationexercise.com";


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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