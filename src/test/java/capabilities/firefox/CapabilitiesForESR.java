package capabilities.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapabilitiesForESR {

    private WebDriver wd;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false); // старая схема работы с FF
        caps.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager"); // устанавливаем конкретные capabilities браузера при запускею Здесь - ожидание
                                                                                                            // статуса загрузки страницы ready state = interactive


        wd = new FirefoxDriver(caps);
        System.out.println(((HasCapabilities) wd).getCapabilities());
        wait = new WebDriverWait (wd, 10);

    }

    @Test
    public void  search()  {
        wd.get ("https://bash.im/");
        wd.findElement(By.cssSelector("div #search #text")).sendKeys("Енот");        // ввод в строке поиска
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();                                // сабмит
    }

    @AfterTest
    public void stop() {
        wd.quit();
        wd = null;
    }


}
