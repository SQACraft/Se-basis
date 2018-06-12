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

    private WebDriver wd;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        FirefoxBinary bin = new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")); // прописали путь к бинарнику FF Nightly
        FirefoxOptions options = new FirefoxOptions().setBinary(bin);                                                             //.setLegacy(true); - с легаси не работает, закомментировано
        options.setCapability("acceptInsecureCerts", true);                                              // устанавливаем нужные Capabilities
        wd = new FirefoxDriver(options);

        System.out.println(((HasCapabilities) wd).getCapabilities());                                                           // список всех Capabilities
        wait = new WebDriverWait(wd, 10);
    }

    @Test
    public void search() {
        wd.get("https://bash.im/");
        wd.findElement(By.cssSelector("div #search #text")).sendKeys("Енот");        // ввод в строке поиска
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();                                // сабмит
    }

    @AfterTest
    public void stop() {
        wd.quit();
        wd = null;
    }


}
