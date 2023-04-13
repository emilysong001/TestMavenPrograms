package API;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "BookName")
    public void addItem(int productID) {
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";
        //RestAssured.baseURI = "http://216.10.245.166";

        String resp = given().

                header("Content-Type", "application/json").
        //change items everytime
        body(Payload.Addbook(productID)).

                when().

                post("/carts/d0hPuquU2go7Pva-5FbWs/items").

                then().assertThat().statusCode(201).

                extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(resp);
        int id = js.get("itemId");
        System.out.println(id);
    }

    @DataProvider(name = "BookName")
    public Object[][] getData(){
        return new Object[][] {{3674}, {2585}};
    }
}
