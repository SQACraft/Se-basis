package multithreading;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public  WebDriver driver;
    public   WebDriverWait wait;

    @BeforeMethod
    public void start() {

        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait (driver, 10);
            return;
        }

        driver = new ChromeDriver();
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
             new Thread(() -> {driver.quit(); driver = null; })) ;

    }

    @AfterMethod
    public void stop() {
//        driver.quit();
//        driver = null;

    }
}
