package com.ntrs.testpractice;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
public class APIAutomation{

    public static void main(String[] args) {

        // base URI setup

       RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";



        RequestSpecification request = RestAssured.given();

        Response response = request.get();



        int statusCode = response.getStatusCode();

        System.out.println("Status Code: " + statusCode);



        if (statuscode== 200) {

            System.out.println("successful.");

        } else {

            System.out.println("failed with status code: " + statuscode);

            return;

        }



        String responseBody = response.getBody().asString();

        System.out.println("Response Body: " + responseBody);



        // Verify the response contains 3 BPIs

        int CountBPI = response.jsonPath().getMap("bpi").size();

        if (CountBPI == 3) {

            System.out.println("Pass contains 3 BPIs.");

        } else {

            System.out.println("failed but found: " + CountBPI);

        }



        // Validate response contains USD, GBP, and EUR

        boolean USD = response.jsonPath().getMap("bpi").containsKey("USD");

        boolean GBP = response.jsonPath().getMap("bpi").containsKey("GBP");

        boolean EUR = response.jsonPath().getMap("bpi").containsKey("EUR");



        if (USD && GBP && EUR) {

            System.out.println("Response contains USD, GBP, and EUR BPIs.");

        } else {

            System.out.println("Missing one or more BPIs ");

        }



        // validation of description equals 'British Pound Sterling'

        String finalDescription = response.jsonPath().getString("bpi.GBP.description");

        if ("British Pound Sterling".equals(gbpDescription)) {

            System.out.println("description passed");

        } else {

            System.out.println("not found  'British Pound Sterling' but found: " + finalDescription);

        }

    }

}
