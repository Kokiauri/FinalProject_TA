package org.example.api;

import base.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BrandsApiTests extends BaseApiTest {

    private static final String BASE_URL = "https://automationexercise.com/api";

    @Test(priority = 1, description = "API 3: Get All Brands List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the API returns a 200 status code and a list of brands")
    public void getAllBrandsList() {
        Response response = given()
            .baseUri(BASE_URL)
        .when()
            .get("/brandsList");
        
        JsonPath jsonPath = getJsonPath(response);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("responseCode"), 200);
        Assert.assertNotNull(jsonPath.get("brands"), "Brands list should not be null");
    }

    @Test(priority = 2, description = "API 4: PUT To All Brands List")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that PUT request to /brandsList returns 405 Method Not Allowed")
    public void putToAllBrandsList() {
        Response response = given()
            .baseUri(BASE_URL)
        .when()
            .put("/brandsList");
        
        JsonPath jsonPath = getJsonPath(response);
        Assert.assertEquals(jsonPath.getInt("responseCode"), 405);
        Assert.assertEquals(jsonPath.getString("message"), "This request method is not supported.");
    }
}