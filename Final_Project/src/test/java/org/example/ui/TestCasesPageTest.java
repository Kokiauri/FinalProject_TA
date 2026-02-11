package org.example.ui;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.TestCasesPage;
import utils.DriverFactory;

public class TestCasesPageTest extends BaseTest {

    @Test(description = "UI 7: Verify Test Cases Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that 'Test Cases Page' successfully loads")
    public void TestCasesTest(){
        TestCasesPage testCasesPage = new TestCasesPage(DriverFactory.getDriver());

        testCasesPage.navigateToHomePage();
        testCasesPage.navigateToTestCases();
    }
}