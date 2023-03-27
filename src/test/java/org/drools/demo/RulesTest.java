package org.drools.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@QuarkusTest
public class RulesTest {

    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testSDisApproved() {
        PartyCountry pc = new PartyCountry();
        pc.setAlternativeCodeVal("SD");
        StatusRequest sr = new StatusRequest();
        sr.setPartyCountries(List.of(pc));
        
        StatusRequestUnit sru = new StatusRequestUnit();
        sru.getStatusRequests().add(sr);

        given()
          .when()
          .body(sru)
          .contentType(ContentType.JSON)
          .post("/find-approved")
          .then()
             .statusCode(200)
             .body(".", hasSize(1));
    }

    @Test
    public void testXnotApproved() {
        PartyCountry pc = new PartyCountry();
        pc.setAlternativeCodeVal("X");
        StatusRequest sr = new StatusRequest();
        sr.setPartyCountries(List.of(pc));
        
        StatusRequestUnit sru = new StatusRequestUnit();
        sru.getStatusRequests().add(sr);

        given()
          .when()
          .body(sru)
          .contentType(ContentType.JSON)
          .post("/find-approved")
          .then()
             .statusCode(200)
             .body(".", hasSize(0));
    }

}