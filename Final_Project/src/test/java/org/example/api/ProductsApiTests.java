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

public class ProductsApiTests extends BaseApiTest {

    private static final String BASE_URL = "https://automationexercise.com/api";

    @Test(priority = 1, description = "API 1: Get All Products List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the API returns a 200 status code and a list of products")
    public void getAllProductsList() {
        Response response = given()
            .baseUri(BASE_URL)
        .when()
            .get("/productsList");
        
        JsonPath jsonPath = getJsonPath(response);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("responseCode"), 200);
        Assert.assertNotNull(jsonPath.get("products"), "Products list should not be null");
    }

        @Test(priority = 2, description = "API 2: POST To All Products List")

        @Severity(SeverityLevel.NORMAL)

        @Description("Verify that POST request to /productsList returns 405 Method Not Allowed")

        public void postToAllProductsList() {

            Response response = given()

                .baseUri(BASE_URL)

            .when()

                .post("/productsList");

            

            JsonPath jsonPath = getJsonPath(response);

            Assert.assertEquals(jsonPath.getInt("responseCode"), 405);

            Assert.assertEquals(jsonPath.getString("message"), "This request method is not supported.");

        }

    

        @Test(priority = 3, description = "API 5: POST To Search Product")

        @Severity(SeverityLevel.CRITICAL)

        @Description("Verify that POST request to /searchProduct with search_product parameter returns 200 and product list")

        public void postToSearchProduct() {

            Response response = given()

                .baseUri(BASE_URL)

                .formParam("search_product", "top")

            .when()

                .post("/searchProduct");

            

            JsonPath jsonPath = getJsonPath(response);

            Assert.assertEquals(jsonPath.getInt("responseCode"), 200);

            Assert.assertNotNull(jsonPath.get("products"), "Searched products list should not be null");

        }

    

        @Test(priority = 4, description = "API 6: POST To Search Product without search_product parameter")

        @Severity(SeverityLevel.NORMAL)

        @Description("Verify that POST request to /searchProduct without search_product parameter returns 400 Bad Request")

        public void postToSearchProductWithoutParameter() {

            Response response = given()

                .baseUri(BASE_URL)

            .when()

                .post("/searchProduct");

            

            JsonPath jsonPath = getJsonPath(response);

            Assert.assertEquals(jsonPath.getInt("responseCode"), 400);

            Assert.assertEquals(jsonPath.getString("message"), "Bad request, search_product parameter is missing in POST request.");

        }

    }