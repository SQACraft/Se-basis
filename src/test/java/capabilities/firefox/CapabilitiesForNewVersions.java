package capabilities.firefox;


import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class CapabilitiesForNewVersions {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

//        DesiredCapabilities caps = new DesiredCapabilities();
//       caps.setCapability(FirefoxDriver.MARIONETTE, true);
        System.setProperty("webdriver.gecko.driver", "c:\\TOOLS\\geckodriver.exe");
       System.setProperty("webdriver.firefox.marionette","c:\\TOOLS\\geckodriver.exe");
        FirefoxBinary bin = new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe"));
        FirefoxOptions options = new FirefoxOptions().setBinary(bin).setLegacy(true);

        driver = new FirefoxDriver(options);


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
