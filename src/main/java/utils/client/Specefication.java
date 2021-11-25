package utils.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specefication {
    static String baseUri = "http://a.testaddressbook.com";
    static String basePath = "/addresses";

    public static RequestSpecification requestSpec() {
        RestAssuredConfig config = RestAssuredConfig.newConfig().logConfig(new LogConfig().defaultStream(System.out));
        return given(new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(basePath)
                .setConfig(config)
                .setContentType(ContentType.JSON)
                .build().log().all());
    }
}



