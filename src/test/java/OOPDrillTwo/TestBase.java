package OOPDrillTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public  class TestBase {


    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeSuite
    void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new ChromeDriver(options);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("http://localhost/litecart");
    }
     //Methods m = new Methods(wd);


    @BeforeMethod
    void goToSquareOne() {                                 //  переход на главную
        wd.findElement(By.cssSelector("img[title='My Store']")).click();
    }


    @AfterSuite
    void stop() {        // закрываем сессию браузера
        wd.quit();
    }


}
