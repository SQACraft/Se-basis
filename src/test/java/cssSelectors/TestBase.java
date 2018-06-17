package cssSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeSuite

    public void start() {
        wd = new ChromeDriver();
        wait = new WebDriverWait(wd, 10);
        wd.get("https://bash.im/");                                     // заходим на главную
    }

    @AfterMethod
    void goHome() {
        wd.findElement(By.cssSelector("#header a")).click(); // после каждого  теста - возврат на главную по клику баннера в хедере
    }

    @AfterSuite
    void stop() {        // закрываем сессию браузера
        wd.quit();
    }

}


