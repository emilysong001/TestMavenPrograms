package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().queryParam("key","qaclick123").header("Content-Type","application/jsaon")
                .body("{\r\n" +
                        "  \"location\": {\r\n" +
                        "    \"lat\": -38.383494,\r\n" +
                        "    \"lng\": 33.427362\r\n" +
                        "  },\r\n" +
                        "  \"accuracy\": 50,\r\n" +
                        "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                        "  \"types\": [\r\n" +
                        "    \"shoe park\",\r\n" +
                        "    \"shop\"\r\n" +
                        "  ],\r\n" +
                        "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                        "  \"language\": \"French-IN\"\r\n" +
                        "}\r\n" +
                        "").when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();

        JsonPath js = new JsonPath(response);
        js.getString("place_id");
        js.getInt("");


        //// TODO Auto-generated method stub
        //// validate if Add Place API is workimg as expected
        //		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
        //
        //		//given - all input details
        //		//when - Submit the API -resource,http method
        //		//Then - validate the response
        //		RestAssured.baseURI= "https://rahulshettyacademy.com";
        //		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
        //		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
        //		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
        //		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
        //
        //		System.out.println(response);
        //		JsonPath js=new JsonPath(response); //for parsing Json
        //		String placeId=js.getString("place_id");
        //
        //		System.out.println(placeId);
        //
        //		//Update Place
        //		String newAddress = "Summer Walk, Africa";
        //
        //		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
        //		.body("{\r\n" +
        //				"\"place_id\":\""+placeId+"\",\r\n" +
        //				"\"address\":\""+newAddress+"\",\r\n" +
        //				"\"key\":\"qaclick123\"\r\n" +
        //				"}").
        //		when().put("maps/api/place/update/json")
        //		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
        //
        //		//Get Place
        //
        //	String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
        //		.queryParam("place_id",placeId)
        //		.when().get("maps/api/place/get/json")
        //		.then().assertThat().log().all().statusCode(200).extract().response().asString();
        //	JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
        //	String actualAddress =js1.getString("address");
        //	System.out.println(actualAddress);
        //	Assert.assertEquals(actualAddress, "Pacific ocean");
        //	//Cucumber Junit, Testng
    }
}
