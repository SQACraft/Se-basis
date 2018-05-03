package capabilities.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapabilitiesForESR {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false); // старая схема работы с FF

        driver = new FirefoxDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
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
