package org.example.ui;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utils.DriverFactory;

public class ProductsTests extends BaseTest {

    @Test(description = "Search Products")
    @Severity(SeverityLevel.CRITICAL)
    @Description("UI 9: Search Product")
    public void searchProductTest() {
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        productsPage.navigateToHomePage();

        productsPage.clickProductsLink();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page is NOT visible");

        String productName = "Sleeveless Dress";
        productsPage.searchProduct(productName);

        Assert.assertTrue(productsPage.isSearchedProductsTitleVisible(), "'SEARCHED PRODUCTS' title is NOT visible");

        Assert.assertTrue(productsPage.isProductVisible(productName), "Searched product '" + productName + "' is NOT visible");
    }
}
