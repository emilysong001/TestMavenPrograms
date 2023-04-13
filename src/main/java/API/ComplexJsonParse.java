package API;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {
    @Test

    public void verifyPrice(){
        String response = Payload.CoursePrice();
        //System.out.println(response);
        JsonPath js = new JsonPath(response);
        int totalPrice = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalPrice);
        int count = js.getInt("courses.size()");
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            String title = js.get("courses[" + i + "].title");
            System.out.println(title);
            if (title.equalsIgnoreCase("RPA")) {
                int copies = js.getInt("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int price = js.get("courses[" + i + "].price");
            int copies = js.get("courses[" + i + "].copies");
            sum = sum + price * copies;
        }
        System.out.println(sum);
        Assert.assertEquals(sum,totalPrice);
    }
}
