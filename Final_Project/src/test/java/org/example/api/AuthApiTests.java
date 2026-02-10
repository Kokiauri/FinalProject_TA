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

public class AuthApiTests extends BaseApiTest {

    private static final String BASE_URL = "https://automationexercise.com/api";

    @Test(priority = 1, description = "API 7: POST To Verify Login with valid details")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that POST request to /verifyLogin with valid email and password returns 200 and User exists!")
    public void postToVerifyLoginWithValidDetails() {
        Response response = given()
            .baseUri(BASE_URL)
            .formParam("email", "t@protonmail.com")
            .formParam("password", "123456")
        .when()
            .post("/verifyLogin");
        
        JsonPath jsonPath = getJsonPath(response);
        Assert.assertEquals(jsonPath.getInt("responseCode"), 200);
        Assert.assertEquals(jsonPath.getString("message"), "User exists!");
    }

    @Test(priority = 2, description = "API 8: POST To Verify Login without email parameter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that POST request to /verifyLogin without email parameter returns 400 Bad Request")
    public void postToVerifyLoginWithoutEmailParameter() {
        Response response = given()
            .baseUri(BASE_URL)
            .formParam("password", "123456")
        .when()
            .post("/verifyLogin");
        
        JsonPath jsonPath = getJsonPath(response);
        Assert.assertEquals(jsonPath.getInt("responseCode"), 400);
        Assert.assertEquals(jsonPath.getString("message"), "Bad request, email or password parameter is missing in POST request.");
    }
}
