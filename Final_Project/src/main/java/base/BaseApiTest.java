package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.filters(new AllureRestAssured());
    }

    /**
     * Extracts JSON from the response body, handling the inconsistent HTML-wrapped JSON 
     * returned by the Automation Exercise API.
     */
    protected JsonPath getJsonPath(Response response) {
        String body = response.asString();
        if (body.contains("<body>")) {
            body = body.replaceAll("(?s).*<body>(.*)</body>.*", "$1");
        }
        return new JsonPath(body);
    }
}