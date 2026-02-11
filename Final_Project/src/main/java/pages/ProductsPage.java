package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends HomePage {
    private By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private By searchInput = By.xpath("//*[@id='search_product']");
    private By searchButton = By.id("submit_search");
    private By productsTitle = By.xpath("//h2[contains(text(), 'All Products')]");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(), 'Searched Products')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Products' button")
    public void clickProductsLink() {
        click(productsLink);
    }

    @Step("Verify user is navigated to ALL PRODUCTS page successfully")
    public boolean isAllProductsPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).isDisplayed();
    }

    @Step("Enter product name in search input and click search button")
    public void searchProduct(String productName) {
        type(searchInput, productName);
        click(searchButton);
    }

    @Step("Verify 'SEARCHED PRODUCTS' is visible")
    public boolean isSearchedProductsTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle)).isDisplayed();
    }

    @Step("Verify all the products related to search are visible")
    public boolean isProductVisible(String productName) {
        By locator = By.xpath("//p[contains(text(),'" + productName + "')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }
}
