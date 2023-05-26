package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

   public static RequestSpecification reqspe;
    public RequestSpecification requestSpecification() throws IOException {
        if(reqspe==null) {
            PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
            reqspe = new RequestSpecBuilder().setContentType(ContentType.JSON)
                    .setBaseUri(getGlobalvalue("baseURI"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return reqspe;
        }
        return reqspe;
    }
    public static String getGlobalvalue(String Key) throws IOException {
        Properties pr =new Properties(); // This class will scan all the files with .properties extension.
        FileInputStream fip = new FileInputStream("C:\\HANDSON\\RestAssured\\src\\test\\java\\resources\\global.properties");
        pr.load(fip);
        return pr.getProperty(Key);


    }
}
