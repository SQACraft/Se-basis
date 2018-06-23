package elementPresence;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeSuite

    void start() {
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wait = new WebDriverWait(wd, 10);               //  настройка для явного ожидания

        wd.get("https://bash.im/");                                     // заходим на главную
    }

    @AfterSuite
    void stop() {        // закрываем сессию браузера
        wd.quit();
    }

    /**
     * Методы для проверки наличия элемента
     */

    boolean isElementPresent(By locator) {
        try {
            wait.until((WebDriver d) -> d.findElement(locator)); // явное (Explicit) ожидание
            wd.findElement(locator);
            return true;
        } catch (TimeoutException ex) {  // исключение при  явном ожидании, если не дождались
            return false;
        } catch (InvalidSelectorException ex) { //подкласс NoSuchElementException, здесь не должен подавляться
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    boolean areElementsPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

}


