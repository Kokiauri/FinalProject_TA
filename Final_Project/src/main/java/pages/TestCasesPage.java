package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TestCasesPage extends HomePage {
    private By testCasesTitle = By.xpath("//h2[contains(@class, 'title')]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTestCasesPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesTitle)).isDisplayed();
    }

    @Step("Navigate To TestCases Page")
    public void navigateToTestCases() {
        click(testCasesLink);
        Assert.assertTrue(isTestCasesPageVisible(), "TestCases page is NOT visible");
    }
}