package browserLogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeSuite
    void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();   //  info:  https://sites.google.com/a/chomium.org/chromedriver/logging/performance-log
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        wd = new ChromeDriver(caps);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("https://selenium2.ru");
    }

    @AfterSuite
    void stop() {        // закрываем сессию браузера
        wd.quit();
    }
}
