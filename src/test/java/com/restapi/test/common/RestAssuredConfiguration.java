package com.restapi.test.common;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

/**
 * Created by subbu on 23/02/2017.
 */
public class RestAssuredConfiguration {

    static {
        RestAssured.baseURI = "http://services.groupkt.com";
    }

    public static RequestSpecification givenConfig(){
        return given().header("Accept-Language","en").header("Content-type","application/json");
    }

    public ResponseSpecification getResponseSpecBuilder(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(TestConstants.STATUS_CODE_OK);
        builder.expectContentType(TestConstants.CONTENT_TYPE);
        return builder.build();
    }


}
