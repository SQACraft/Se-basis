package capabilities.chrome;


import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapabilitiesByArguments {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        System.out.println(((HasCapabilities) driver).getCapabilities()); // вывод всех capabilities после запуска браузера
        wait = new WebDriverWait (driver, 10);
    }

    @Test
    public void  search()  {
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
