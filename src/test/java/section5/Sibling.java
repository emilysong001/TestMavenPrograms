package section5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sibling {
    public static void main(String[] args) {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        /*driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
        driver.findElement(By.xpath("//header/div/button[1]/preceding-sibling::button[1]")).click();
        driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[1]")).click();*/

       // driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.get("http://google.com");
        driver.navigate().to("https://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }
}
