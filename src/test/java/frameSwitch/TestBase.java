package frameSwitch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeClass
    public void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new ChromeDriver(options);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("http://jsbin.com/kitaqaf/edit?html,output"); // страница с фреймами
    }

    @AfterClass
    public void stop() {        // закрываем сессию браузера
        wd.quit();
    }

}