package eventFiringWD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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