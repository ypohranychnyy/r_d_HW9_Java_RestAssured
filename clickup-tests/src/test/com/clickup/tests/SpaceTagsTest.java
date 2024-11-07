package com.clickup.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import com.clickup.utils.EnvConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpaceTagsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = EnvConfig.getEnv("BASE_URL");
    }

    @Test
    public void getSpaceTags() {
        String token = EnvConfig.getEnv("CLICKUP_API_TOKEN");
        String spaceId = EnvConfig.getEnv("SPACE_ID");

        Response response = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when()
                .get("/space/" + spaceId + "/tag");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());
        System.out.println("Response: " + response.prettyPrint());
    }
}