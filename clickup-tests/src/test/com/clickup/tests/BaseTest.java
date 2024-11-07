package com.clickup.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    static {
        RestAssured.filters(new AllureRestAssured());

        // Enable detailed logging
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    }

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.clickup.com/api/v2";
        RequestSpecification spec = RestAssured.given()
                .header("Authorization", "pk_2144434058_74WQSRIORR0V0XWNQDOT6DSL9UN45KXU");

        RestAssured.requestSpecification = spec;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}