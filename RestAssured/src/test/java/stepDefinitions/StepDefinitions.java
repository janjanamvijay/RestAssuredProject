package stepDefinitions;

import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import pojoClasses.AddAddress;
import pojoClasses.Location;
import resources.MapAPIresouces;
import resources.TestData;
import utils.Utils;

import javax.swing.plaf.nimbus.State;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static resources.MapAPIresouces.addAddress;

public class StepDefinitions extends Utils {
    RequestSpecification reqspe;
    RequestSpecification actualRequest;
    ResponseSpecification response;
    Response finalresponse;
    TestData data = new TestData();
   // MapAPIresouces resources;
    @Given("add place details payload with {string} {int} {string} {string} {string}")
    public void add_place_details_payload_with_abcd_https_cbc_com_english(String Name, int Accuracy,String Phone_number,String Website,String Language)  throws IOException {


        // System.out.println(reqspe);

         actualRequest = given().spec(requestSpecification()).body(data.mapsPayloadData(Name,Accuracy,Phone_number,Website,Language));
        //System.out.println(actualRequest.log());

    }
    @When("user submit the {string} {string} request")
    public void user_submit_the_request(String path, String method) {
        response = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200).build();
        MapAPIresouces apiPath= MapAPIresouces.valueOf(path);
       if (method=="POST") {
           finalresponse = actualRequest.when().post(apiPath.getPath())
                   .then().spec(response).extract().response();
       } else if (method=="GET") {
           finalresponse = actualRequest.when().get(apiPath.getPath())
                   .then().spec(response).extract().response();

       } else if (method=="DELETE") {
           finalresponse = actualRequest.when().delete(apiPath.getPath())
                   .then().spec(response).extract().response();

       }
    }
    @Then("place shall be added successfully")
    public void place_shall_be_added_successfully() {
       // assertEquals(finalresponse.getStatusCode(),200);
    }
    @Then("get the response payload")
    public void get_the_response_payload() {
       // assertEquals(finalresponse.getStatusCode(),200);

    }
    @Then("{string} code as {string}")
    public void success_code_as_ok(String string1,String string2) {

        String str = finalresponse.asString();
        //assertFalse(str.isBlank());
        System.out.println(str);
       // JsonPath js = new JsonPath(str);
      //  assertEquals(js.get(string1), string2);


    }
}
