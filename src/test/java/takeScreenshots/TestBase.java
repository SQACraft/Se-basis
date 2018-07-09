package takeScreenshots;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public EventFiringWebDriver wd;
    public WebDriverWait wait;

    public static class MyListener extends AbstractWebDriverEventListener {

        public MyListener() {

        }

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver wd) {
            System.out.println(by+ "\tTODO: поиск по данному локатору");
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver wd) {
            System.out.println(by+ "\tSUCCESS: локатор найден");
        }

        @Override
        public void onException(Throwable throwable, WebDriver wd) {
            System.out.println(throwable);
            File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);                  // снимаем скриншот при выбросе исключения ( у нас неверный локатор)
            File screen = new File("screen-" + System.currentTimeMillis()+ ".png");
            try {
                Files.copy(tmp, screen);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(screen);
        }
    }

    @BeforeClass
    public void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new EventFiringWebDriver(new ChromeDriver(options));

        wd.register(new MyListener());

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("http://localhost/litecart");
    }

    @AfterClass
    public void stop() {        // закрываем сессию браузера
        wd.quit();
    }


}