package com.clickup.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ClickUpListsCRUDTest extends BaseTest {
    private static String listId;
    private static final String FOLDER_ID = "90122788672";

    @Test(priority = 1)
    public void createList() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"Test List\"," +
                        "\"content\": \"List created using REST Assured\" }")
                .when()
                .post("/folder/" + FOLDER_ID + "/list");

        Assert.assertEquals(response.getStatusCode(), 200);
        listId = response.jsonPath().getString("id");
    }

    @Test(priority = 2, dependsOnMethods = {"createList"})
    public void getList() {
        Response response = given()
                .when()
                .get("/list/" + listId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), listId);
    }

    @Test(priority = 3, dependsOnMethods = {"createList"})
    public void updateList() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"Updated List\"," +
                        "\"content\": \"List updated using REST Assured\" }")
                .when()
                .put("/list/" + listId);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4, dependsOnMethods = {"createList"})
    public void deleteList() {
        Response response = given()
                .when()
                .delete("/list/" + listId);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}