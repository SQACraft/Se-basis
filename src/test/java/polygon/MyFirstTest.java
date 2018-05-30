package polygon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait (driver, 10);
    }

    @Test
    public void  myFirstTest()  {
        driver.get ("https://bash.im/");
        driver.findElement(By.name("text")).sendKeys("котик");
        driver.findElement(By.xpath(".//*[@id='search']/button")).click();
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;

    }


}
