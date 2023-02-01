package API_Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class util {
    public static RequestSpecification req;
    public static String value;

    public RequestSpecification requestSpecificationForPlaceAPI() throws IOException {

        if (req == null) {
            //** Logging to the output stream such as console or file or anything which we specifies*//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//*
            PrintStream stream = new PrintStream(new FileOutputStream("loggingForPlaceAPI.txt"));
            req = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(retrieveGlobalProperties("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(stream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .setContentType(ContentType.JSON).build();

            return req;
        }
        return req;

    }
    public RequestSpecification requestSpecificationForEcommerce() throws IOException {
        if (req == null) {
            /** Logging to the output stream such as console or file or anything which we specifies*/
            PrintStream stream = new PrintStream(new FileOutputStream("loggingForEcommerce.txt"));
            req = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(retrieveGlobalProperties("baseUrl"))
                    .addHeader("Content-Type","application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(stream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .setContentType(ContentType.JSON).build();

            return req;
        }
        return req;

    }

    public static String retrieveGlobalProperties(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        prop.load(fis);
        String property = prop.getProperty(key);
        return property;
    }

    public static String getJson_Path(Response res, String key) {
        String json_response = res.asString();
        JsonPath js = new JsonPath(json_response);
        value = js.getString(key);
        return value;
    }

    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}