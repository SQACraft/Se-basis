package elementsPresence;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
         wd.get("https://bash.im/");                                     // заходим на главнуюfccc
    }

    @AfterSuite

    void stop() {        // закрываем сессию браузера
        wd.quit();
    }

/**
     Методы для проверки наличия элемента
*/

    public boolean isElementPresent (By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean areElementsPresent (By locator) {
        return wd.findElements(locator).size() > 0;
    }

}


