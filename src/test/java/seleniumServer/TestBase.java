package seleniumServer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        options.addArguments("start-fullscreen");
        wd = new RemoteWebDriver(new URL("http://10.0.2.15:4444/wd/hub"), DesiredCapabilities.chrome());

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("http://localhost/litecart");
    }

    @AfterClass
    public void stop() {        // закрываем сессию браузера
        wd.quit();
    }


}