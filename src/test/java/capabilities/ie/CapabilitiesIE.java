package capabilities.ie;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class CapabilitiesIE {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true); // устанавливаем зум всегда в 100%
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); // игнорируем настройки зон безопасности
        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true); // очистка кеша, кук, истории, сохранённых данных форм

        driver = new InternetExplorerDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities()); // вывод всех capabilities после запуска браузера
        wait = new WebDriverWait (driver, 10);

        // Cookies
        driver.manage().addCookie(new Cookie("test", "test"));
        Cookie testCookie = driver.manage().getCookieNamed("test");
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.manage().deleteCookieNamed("test");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void  search() throws InterruptedException {
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
