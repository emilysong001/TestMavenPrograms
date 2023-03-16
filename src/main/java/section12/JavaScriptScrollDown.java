package section12;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaScriptScrollDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        //scroll inside the component
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            //Integer.parseInt() parse String into int
            int a = Integer.parseInt(values.get(i).getText());
            sum = sum + a;
        }
        System.out.println(sum);
        //string
        //driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
        //parse into int
        int total = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        System.out.println(total);
        Assert.assertEquals(sum,total);

    }
}
