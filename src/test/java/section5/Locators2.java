package section5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators2 {
    @Test
    public void test() throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/locatorspractice/"); //URL in the browser
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".signInBtn")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        //Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(),"You are successfully logged in.");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        //driver.findElement(By.xpath("//button[text()='Log Out']")).click();




    }
}
