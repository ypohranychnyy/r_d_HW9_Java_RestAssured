package com.clickup.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ClickUpListsCRUDTest extends BaseTest {
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
        String listId = response.jsonPath().getString("id");
        Assert.assertNotNull(listId, "List ID should not be null after creation.");

        // Clean up by deleting the created list
        given().delete("/list/" + listId);
    }

    @Test(priority = 2)
    public void getList() {
        // Create a list to ensure it exists for retrieval
        String listName = "Test List " + System.currentTimeMillis();
        Response createResponse = given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + listName + "\"," +
                        "\"content\": \"List created using REST Assured\" }")
                .when()
                .post("/folder/" + FOLDER_ID + "/list");
        String listId = createResponse.jsonPath().getString("id");

        // Retrieve the list
        Response response = given()
                .when()
                .get("/list/" + listId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), listId);

        // Clean up by deleting the created list
        given().delete("/list/" + listId);
    }

    @Test(priority = 3)
    public void updateList() {
        // Create a list to update
        String listName = "Test List " + System.currentTimeMillis();
        Response createResponse = given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + listName + "\"," +
                        "\"content\": \"List created using REST Assured\" }")
                .when()
                .post("/folder/" + FOLDER_ID + "/list");
        String listId = createResponse.jsonPath().getString("id");

        // Update the list
        String updatedListName = "Updated List " + System.currentTimeMillis();
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + updatedListName + "\"," +
                        "\"content\": \"List updated using REST Assured\" }")
                .when()
                .put("/list/" + listId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), updatedListName, "List name should be updated.");

        // Clean up by deleting the updated list
        given().delete("/list/" + listId);
    }

    @Test(priority = 4)
    public void deleteList() {
        // Create a list to delete
        String listName = "Test List " + System.currentTimeMillis();
        Response createResponse = given()
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\": \"" + listName + "\"," +
                        "\"content\": \"List created using REST Assured\" }")
                .when()
                .post("/folder/" + FOLDER_ID + "/list");
        String listId = createResponse.jsonPath().getString("id");

        // Delete the list
        Response response = given()
                .when()
                .delete("/list/" + listId);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
