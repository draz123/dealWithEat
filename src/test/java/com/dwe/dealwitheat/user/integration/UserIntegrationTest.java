package com.dwe.dealwitheat.user.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:/application-test.properties")
public class UserIntegrationTest {

    private static final String CONTEXT_PATH = "/dwe/api/";
    private Header userId = new Header("nickname", "albpod");
    private Header password = new Header("password", "qwerty1234");

    @LocalServerPort
    private int port;


    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    public void getUserInfo() throws Exception {

        given().contentType(ContentType.JSON)
                .header(userId)
                .header(password)
                .header(new Header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbnRDaXMiLCJleHAiOjE1MTYzMjUyNjl9.GkQKCGiueCuyYE8s9WHiudEIpBsXPxn19qXWpGmyxlrI2WEvH1t4X0aWCb6Ro50ODLBYyeg6xM8ovi4bivXdVQ"))
                .accept(ContentType.JSON)
                .when().get(CONTEXT_PATH + "userInfo")
                .then()
                .statusCode(org.apache.http.HttpStatus.SC_OK)
                .and().body("response.nickname", is("albpod"))
                .and().body("response.password", is("qwerty1234"))
                .and().body("response.name", is("Albert"))
                .and().body("response.surname", is("Podraza"))
                .and().body("response.groupName", is("restaurant"));

    }

    @Test
    public void testCreateUser() throws Exception{

        given().contentType(ContentType.JSON)
                .header( new Header("id", "2"))
                .header(new Header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbnRDaXMiLCJleHAiOjE1MTYzMjUyNjl9.GkQKCGiueCuyYE8s9WHiudEIpBsXPxn19qXWpGmyxlrI2WEvH1t4X0aWCb6Ro50ODLBYyeg6xM8ovi4bivXdVQ"))
                .body(getRequestBodyFromFile("create-user.json"))
                .when()
                .post(CONTEXT_PATH + "createUser")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("status", is(true));
    }

    private String getRequestBodyFromFile(String filename) throws IOException {
        File file = ResourceUtils.getFile(String.format("classpath:user/%s", filename));
        return new String(Files.readAllBytes(file.toPath()));
    }

    @Test
    public void testDeleteUser() throws Exception{

        given().contentType(ContentType.JSON)
                .header( new Header("id", "6"))
                .header(new Header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbnRDaXMiLCJleHAiOjE1MTYzMjUyNjl9.GkQKCGiueCuyYE8s9WHiudEIpBsXPxn19qXWpGmyxlrI2WEvH1t4X0aWCb6Ro50ODLBYyeg6xM8ovi4bivXdVQ"))
                .body(getRequestBodyFromFile("delete-user.json"))
                .when()
                .post(CONTEXT_PATH + "deleteUser")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("status", is(true));
    }

}