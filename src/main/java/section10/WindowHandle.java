package section10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    //another tab
    //new window
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        //return how many windows are opened, return all window ids
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

        Iterator<String> it = windows.iterator();
        //go to the 0 index of windows - parent id
        String parentId = it.next();
        //go to the 1 index of windows - child id
        String childId = it.next();
        //Selenium don't know, so we should switch to child window
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(emailId);


    }
}
