import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;


public class ApiTests {

    int statusCode;

    @Test
    void createUserTest() {
        RestAssured.baseURI = "https://www.yakaboo.ua/ua/customer/account/createpost/";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("firstname", "Student2");
        requestParams.put("email", "student2@gmail.com");
        requestParams.put("phone_number", "+38 (099) 556-8899");
        requestParams.put("password", "Password2");
        requestParams.put("confirmation", "Password2");
        requestParams.put("agree", "on");

        httpRequest.header("authenticity_token", "6EdJ6oyfMIkd9WkhhMCu/3UWR5zXhBvIUNtnebCVkdU2/zpP5H1aywgxJp/HFfcynQ1ozHUioIzrAN0VZIG/sw==");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST);
        statusCode = response.getStatusCode();
        Assert.assertEquals(302, statusCode);
    }

    @Test
    void addAddressTest() {
        RestAssured.baseURI = "https://www.yakaboo.ua/ua/customer/address/formPost/";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("form_key", "yKPUzEyVMaiFHQf7");
        requestParams.put("shipping[country_id]", "UA");
        requestParams.put("firstname", "Student1");
        requestParams.put("lastname", "First");
        requestParams.put("shipping[telephone]", "+38 (099) 556-8899");
        requestParams.put("shipping[city_id]", "201");
        requestParams.put("shipping[region_id]", "496");
        requestParams.put("shipping[city]", "кропивницький");
        requestParams.put("shipping[shipping_method]", "yakaboo_Novaya_pochta_abroad");
        requestParams.put("default_shipping", "1");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST);
        statusCode = response.getStatusCode();
        Assert.assertEquals(302, statusCode);
    }

    @Test
    void verifyCreatedUser() {
        RestAssured.baseURI = "https://www.googletagmanager.com/a?id=G-NLRLPV7JQ4";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        statusCode = response.getStatusCode();
        Assert.assertEquals(204, statusCode);
    }

    @Test
    void verifySearchOption() {
        RestAssured.baseURI = "https://www.yakaboo.ua/ua/search/?multi=0&cat=&q=english";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }
}


