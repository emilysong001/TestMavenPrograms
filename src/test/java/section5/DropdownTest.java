package section5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DropdownTest {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/locatorspractice/"); //URL in the browser

        //driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");

        //driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        //driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("hello123");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("hello123");
        //driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        //Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        //driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Emily");

        // driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("27864566");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("27864566");
        //driver.findElement(By.xpath("//form/input[3]")).sendKeys("27864566");

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.xpath("//form/p")).getText());

        //driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Emilygfh");

        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("hello");
        //driver.findElement(By.cssSelector("input[type^='pass']")).sendKeys("hello");
        //driver.findElement(By.cssSelector("input[type$='pass']")).sendKeys("hello");

        //driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        //driver.findElement(By.xpath("//button[starts-with(@class,'submit')]")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        //driver.findElement(By.xpath("//div[contains(@class,'pwd')]/a")).click();


    }

    //a[@value='MAA']  - Xpath for chennai
    //a[@value='BLR']
    //Thread.sleep(2000);
    //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        /*driver.findElement(By.xpath("//div[@id='destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();*/

}
