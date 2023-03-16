package section15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
       //selenium open a new tab, but the driver still in the original window.
        //WindowType.TAB - tab
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().newWindow(WindowType.WINDOW);
        //get the id of new opened tab/window
        //selenium get all the windows
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();
        String parentId = i.next();
        String childId = i.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

                .get(1).getText();

        driver.switchTo().window(parentId);
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //Screenshot
        //get the only name(element) screenshot
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

        //driver.quit();
        //Get Height & Width of an element

        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }
}
