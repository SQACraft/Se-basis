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
import java.util.concurrent.TimeUnit;

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
        wait = new WebDriverWait(driver, 1);


    }

    @Test
    public void  search() {

        driver.get ("https://bash.im/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.name("text")).sendKeys("котик");
        driver.findElement(By.xpath(".//*[@id='search']/button")).click();
}

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}
