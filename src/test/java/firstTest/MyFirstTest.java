package firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {

    private WebDriver wd;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        wd = new ChromeDriver();
        wait = new WebDriverWait (wd, 10);
    }

    @Test
    public void  myFirstTest()  {
        wd.get ("https://bash.im/");
        wd.findElement(By.name("text")).sendKeys("котик");
        wd.findElement(By.xpath(".//*[@id='search']/button")).click();
    }

    @AfterTest
    public void stop() {
        wd.quit();
        wd = null;

    }


}
