package pojoClasses;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class Maps {

    public static void main(String args[]) {


        AddAddress add = new AddAddress();

        add.setAccuracy(100);
        add.setName("Frontline house");
        add.setAddress("29, side layout, cohen 09");
        add.setPhone_number("(+91) 983 893 3937");
        add.setWebsite("http://google.com");
        add.setLanguage("French-IN");

        List<String> types= new ArrayList<String>();

        types.add("shop");
        types.add("shoe park");

        Location loc = new Location();
        loc.setLat(-12.344);
        loc.setLng(-99.99);
      /*  RestAssured.baseURI ="https://rahulshettyacademy.com/";
        given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(add)
                .when().post("/maps/api/place/add/json");
*/
         RequestSpecification reqspe=new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri("https://rahulshettyacademy.com/")
                .addQueryParam("key","qaclick123").setBody(add).build();
        ResponseSpecification resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                                                                 .expectStatusCode(200).build();

                String response = given().spec(reqspe).when().post("/maps/api/place/add/json")
                         .then().spec(resspec).toString();



    }
}