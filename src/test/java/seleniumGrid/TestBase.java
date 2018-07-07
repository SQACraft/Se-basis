package seleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeClass
    public void start() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        DesiredCapabilities capabilities = DesiredCapabilities.chrome() ;
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setPlatform(Platform.LINUX);
        wd = new RemoteWebDriver(new URL("http://192.168.1.36:4444/wd/hub"), capabilities);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
    }

    @AfterClass
    public void stop() {        // закрываем сессию браузера
        wd.quit();
    }

}