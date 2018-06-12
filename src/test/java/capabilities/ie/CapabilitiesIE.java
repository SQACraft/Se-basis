package capabilities.ie;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CapabilitiesIE {

    private WebDriver wd;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true); // устанавливаем зум всегда в 100%
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); // игнорируем настройки зон безопасности
        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true); // очистка кеша, кук, истории, сохранённых данных форм

        wd = new InternetExplorerDriver(caps);
        System.out.println(((HasCapabilities) wd).getCapabilities()); // вывод всех capabilities после запуска браузера
        wait = new WebDriverWait(wd, 1);


    }

    @Test
    public void  search() {

        wd.get ("https://bash.im/");
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.findElement(By.name("text")).sendKeys("котик");
        wd.findElement(By.xpath(".//*[@id='search']/button")).click();
}

    @AfterTest
    public void stop() {
        wd.quit();
        wd = null;
    }

}
