package multithreading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeMethod
     void start() {

        if (tlDriver.get() != null) {
            wd = tlDriver.get();
            wait = new WebDriverWait(wd, 10);
            return;
        }

        wd = new ChromeDriver();
        tlDriver.set(wd);
        wait = new WebDriverWait(wd, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    wd.quit();
                    wd = null;
                }));
    }

    @AfterMethod
    void stop() {
        //    wd.quit();
        //  wd = null;
    }

    protected void search(String animal) {

        wd.get("https://bash.im/");
       // wd.findElement(By.name("text")).sendKeys(animal);
       //wd.findElement(By.xpath(".//*[@id='search']/button")).click();
        wd.findElement(By.cssSelector("div #search #text")).sendKeys(animal);
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();

    }

}
